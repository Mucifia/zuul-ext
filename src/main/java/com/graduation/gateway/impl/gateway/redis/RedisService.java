package com.graduation.gateway.impl.gateway.redis;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.impl.service.RouteService;
import com.graduation.gateway.impl.service.ServiceQualityService;
import com.graduation.gateway.repo.util.IGatewayConstant;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author: mmy
 * @date: 2018/12/20
 * @description: 分布式缓存服务类，Redis交互相关
 */
@Service
public class RedisService {

  @Autowired
  RedisTemplate<String, Object> redisTemplate;

  @Autowired
  RouteService routeService;

  @Autowired
  ServiceQualityService serviceQualityService;

  @Autowired
  DataSourceTransactionManager transactionManager;

  @Autowired
  RedisRepository redisRepository;

  @Resource(name = "redisTemplate")
  private HashOperations<String, String, Object> hashDict;


  public Map<String, Object> getAllRoutes(){
    return redisRepository.getAllRoutes();
  }

  public void initRedis(){
    try {
      redisRepository.initializeRedis();
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }




  /**
   * 操作事务，保存路由信息到db和redis sso模式下，新增一条路由，要同时保存到Route表和redis中
   * @param routeVO
   * @param serviceQualityVO
   */
  @Transactional
  public void saveSSORoute(RouteVO routeVO, ServiceQualityVO serviceQualityVO){

    DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
    defaultTransactionDefinition.setName("saveSSORoute");
    defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    TransactionStatus transactionStatus = transactionManager.getTransaction(defaultTransactionDefinition);
    try {
      //save route
      routeService.saveSSORoute(routeVO);
      //save servicequality
      serviceQualityService.save(serviceQualityVO);
      // save redis
      saveRedisWithTransaction(routeVO,serviceQualityVO);
    }catch (Exception ex){
      transactionManager.rollback(transactionStatus);
      throw ex;
    }

  }

  /**
   * 批量保存路由到DB和redis中 场景：API模式下，发布serviceplan时，要把该plan下的所有路由保存到route表和redis中
   * @param lstRoutes
   * @param serviceQualityVO
   */
  @Transactional
  public void saveRouteBatch(List<RouteVO> lstRoutes, ServiceQualityVO serviceQualityVO){
    if ((lstRoutes == null) || (lstRoutes.size() < 1)) {
      return;
    }
    DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
    defaultTransactionDefinition.setName("saveRouteBatch");
    defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    TransactionStatus transactionStatus = transactionManager.getTransaction(defaultTransactionDefinition);
    try {
      routeService.saveRouteBatch(lstRoutes);
      serviceQualityService.save(serviceQualityVO);
      batchPutRoutes(lstRoutes,serviceQualityVO);
    }catch (Exception ex){
      transactionManager.rollback(transactionStatus);
      throw ex;
    }

    }

  /**
   * sso模式下，更新路由，db和redis
   * @param route
   * @param quality
   */
  @Transactional
  public void updateSSORoute(RouteVO route, ServiceQualityVO quality) {
    DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
    defaultTransactionDefinition.setName("updateSSORoute");
    defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    TransactionStatus transactionStatus = transactionManager.getTransaction(defaultTransactionDefinition);
    try {
      routeService.saveSSORoute(route);
      serviceQualityService.save(quality);
      updateRedisWithTransaction(route,quality);
    }catch (Exception ex){
      transactionManager.rollback(transactionStatus);
      throw ex;
    }
  }

  /**
   * sso模式下，删除一条路由
   * @param routeVO
   * @param serviceQualityVO
   */
  @Transactional
  public void deleteSSORoute(RouteVO routeVO, ServiceQualityVO serviceQualityVO){
    DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
    defaultTransactionDefinition.setName("deleteSSORoute");
    defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    TransactionStatus transactionStatus = transactionManager.getTransaction(defaultTransactionDefinition);
    try {
      routeService.deleteSSORoute(routeVO);
      serviceQualityService.delete(serviceQualityVO);
      deleteRedisWithTransaction(routeVO);
    }catch (Exception ex){
      transactionManager.rollback(transactionStatus);
      throw ex;
    }
  }

  /**
   * 批量删除
   * @param lstRoutes
   * @param serviceQualityVO
   */
  @Transactional
  public void deleteRouteBatch(List<RouteVO> lstRoutes, ServiceQualityVO serviceQualityVO){
    DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
    defaultTransactionDefinition.setName("deleteRouteBatch");
    defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    TransactionStatus transactionStatus = transactionManager.getTransaction(defaultTransactionDefinition);
    try {
      routeService.deleteRouteBatch(lstRoutes);
      serviceQualityService.delete(serviceQualityVO);
      batchDeleteRoutes(lstRoutes,serviceQualityVO);
    }catch (Exception ex){
      transactionManager.rollback(transactionStatus);
      throw ex;
    }
  }

  /**
   * 批量保存route和quality到redis中
   *
   * @param routes
   * @param qos
   * @return
   */
  public int batchPutRoutes(List<RouteVO> routes, ServiceQualityVO qos) {
    int result = redisTemplate.execute(new RedisCallback<Integer>() {
      @Override
      public Integer doInRedis(RedisConnection connection) throws DataAccessException {

        RedisSerializer<String> serializerKey = redisTemplate.getStringSerializer();
        RedisSerializer<String> serializerHashKey = (RedisSerializer<String>) redisTemplate
            .getHashKeySerializer();
        RedisSerializer<Object> serializerHashValue = (RedisSerializer<Object>) redisTemplate
            .getHashValueSerializer();

        connection.openPipeline();
        for (RouteVO route : routes) {
          connection.hSet(serializerKey.serialize(IGatewayConstant.MAP_NAME_ROUTE),
              serializerHashKey.serialize(route.getRouteId()), serializerHashValue.serialize(route));
          connection.hSet(serializerKey.serialize(IGatewayConstant.MAP_NAME_QOS),
              serializerHashKey.serialize(route.getPath()), serializerHashValue.serialize(qos));
        }
        List<Object> lstResults = connection.closePipeline();
        return lstResults.size();
      }
    },true);
    return result;
  }

  /**
   * 批量删除route，下线时批量删除
   *
   * @param routes
   * @param qos
   * @return
   */
  public int batchDeleteRoutes(List<RouteVO> routes, ServiceQualityVO qos) {
    int result = redisTemplate.execute(new RedisCallback<Integer>() {
      @Override
      public Integer doInRedis(RedisConnection connection) throws DataAccessException {

        RedisSerializer<String> serializerKey = redisTemplate.getStringSerializer();
        RedisSerializer<String> serializerHashKey = (RedisSerializer<String>) redisTemplate
            .getHashKeySerializer();

        connection.openPipeline();
        for (RouteVO route : routes) {
          connection.hDel(serializerKey.serialize(IGatewayConstant.MAP_NAME_ROUTE),
              serializerHashKey.serialize(route.getRouteId()));
          connection.hDel(serializerKey.serialize(IGatewayConstant.MAP_NAME_QOS),
              serializerHashKey.serialize(route.getPath()));
        }
        List<Object> lstResults = connection.closePipeline();
        return lstResults.size();
      }
    },true);
    return result;
  }

  public void putRoute(RouteVO route) {
    hashDict.put(IGatewayConstant.MAP_NAME_ROUTE,route.getRouteId(),route);
  }

  public Long deleteRoute(String routeId) {
    return hashDict.delete(IGatewayConstant.MAP_NAME_ROUTE,routeId);
  }

  public void putQoS(String routePath, ServiceQualityVO serviceQualityVO) {
    hashDict.put(IGatewayConstant.MAP_NAME_QOS,routePath,serviceQualityVO);
  }

  public Long deleteQoS(String routePath) {
    return hashDict.delete(IGatewayConstant.MAP_NAME_QOS,routePath);
  }

  public Object getRoute(String routeId) {
    return hashDict.get(IGatewayConstant.MAP_NAME_ROUTE,routeId);
  }

  /**
   * redis with transaction
   * @param routeVO
   * @param serviceQualityVO
   */
  private void saveRedisWithTransaction(RouteVO routeVO, ServiceQualityVO serviceQualityVO) {


    SessionCallback sessionCallback = new SessionCallback() {
      @Override
      public Object execute(RedisOperations operations) throws DataAccessException {
        operations.multi();
        operations.opsForHash().put(IGatewayConstant.MAP_NAME_ROUTE,routeVO.getRouteId(),routeVO);
        operations.opsForHash().put(IGatewayConstant.MAP_NAME_QOS,routeVO.getPath(),serviceQualityVO);
        return operations.exec();
      }
    };
    redisTemplate.execute(sessionCallback);

  }

  private void updateRedisWithTransaction(RouteVO routeVO, ServiceQualityVO serviceQualityVO) {
    SessionCallback sessionCallback = new SessionCallback() {
      @Override
      public Object execute(RedisOperations operations) throws DataAccessException {
        operations.multi();
        RouteVO oldRoute = (RouteVO) operations.opsForHash().get(IGatewayConstant.MAP_NAME_ROUTE,routeVO.getRouteId());
        operations.opsForHash().delete(IGatewayConstant.MAP_NAME_ROUTE,oldRoute.getRouteId());
        operations.opsForHash().put(IGatewayConstant.MAP_NAME_ROUTE,routeVO.getRouteId(),routeVO);
        operations.opsForHash().put(IGatewayConstant.MAP_NAME_QOS,routeVO.getPath(),serviceQualityVO);
        return operations.exec();
      }
    };
    redisTemplate.execute(sessionCallback);
  }


  private void deleteRedisWithTransaction(RouteVO routeVO) {
    SessionCallback sessionCallback = new SessionCallback() {
      @Override
      public Object execute(RedisOperations operations) throws DataAccessException {
        operations.multi();
        operations.opsForHash().delete(IGatewayConstant.MAP_NAME_ROUTE,routeVO.getRouteId());
        operations.opsForHash().delete(IGatewayConstant.MAP_NAME_QOS,routeVO.getRouteId());
        return operations.exec();
      }
    };
    redisTemplate.execute(sessionCallback);
  }

}
