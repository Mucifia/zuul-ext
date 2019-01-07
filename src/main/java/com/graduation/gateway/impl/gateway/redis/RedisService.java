package com.graduation.gateway.impl.gateway.redis;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.impl.service.RouteService;
import com.graduation.gateway.impl.service.ServiceQualityService;
import com.graduation.gateway.repo.util.IGatewayConstant;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
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
  RouteService routeService;

  @Autowired
  ServiceQualityService serviceQualityService;

  PlatformTransactionManager transactionManager;

  @Autowired
  RedisRepository redisRepository;

  RedisTemplateUtil redisTemplateUtil;


  public Map<Object, Object> getAllRoutes(){
    return redisRepository.getAllRoutes();
  }

  public void initRedis(){
    try {
      redisRepository.initializeRedis();
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }

  public RedisService(PlatformTransactionManager transactionManager, JedisConnectionFactory jedisConnectionFactory) {
    this.transactionManager=transactionManager;
    this.redisTemplateUtil=new RedisTemplateUtil(jedisConnectionFactory);
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
    int result1 = redisTemplateUtil.getRouteRedisTemplate().execute(new RedisCallback<Integer>() {
      @Override
      public Integer doInRedis(RedisConnection connection) throws DataAccessException {

        RedisSerializer<String> serializerKey = redisTemplateUtil.getRouteRedisTemplate().getStringSerializer();
        RedisSerializer<String> serializerHashKey = (RedisSerializer<String>) redisTemplateUtil.getRouteRedisTemplate()
            .getHashKeySerializer();
        RedisSerializer<Object> serializerHashValue = (RedisSerializer<Object>) redisTemplateUtil.getRouteRedisTemplate()
            .getHashValueSerializer();

        connection.openPipeline();
        for (RouteVO route : routes) {
          connection.hSet(serializerKey.serialize(IGatewayConstant.MAP_NAME_ROUTE),
              serializerHashKey.serialize(route.getRouteId()), serializerHashValue.serialize(route));
        }
        List<Object> lstResults = connection.closePipeline();
        return lstResults.size();
      }
    },true);
    int result2 = redisTemplateUtil.getSqRedisTemplate().execute(new RedisCallback<Integer>() {
      @Override
      public Integer doInRedis(RedisConnection connection) throws DataAccessException {

        RedisSerializer<String> serializerKey = redisTemplateUtil.getSqRedisTemplate().getStringSerializer();
        RedisSerializer<String> serializerHashKey = (RedisSerializer<String>) redisTemplateUtil.getSqRedisTemplate()
            .getHashKeySerializer();
        RedisSerializer<Object> serializerHashValue = (RedisSerializer<Object>) redisTemplateUtil.getSqRedisTemplate()
            .getHashValueSerializer();

        connection.openPipeline();
        for (RouteVO route : routes) {
          connection.hSet(serializerKey.serialize(IGatewayConstant.MAP_NAME_QOS),
              serializerHashKey.serialize(route.getRouteId()), serializerHashValue.serialize(qos));
        }
        List<Object> lstResults = connection.closePipeline();
        return lstResults.size();
      }
    },true);
    return result1&result2;
  }

  /**
   * 批量删除route，下线时批量删除
   *
   * @param routes
   * @param qos
   * @return
   */
  public int batchDeleteRoutes(List<RouteVO> routes, ServiceQualityVO qos) {
    int result1 = redisTemplateUtil.getRouteRedisTemplate().execute(new RedisCallback<Integer>() {
      @Override
      public Integer doInRedis(RedisConnection connection) throws DataAccessException {

        RedisSerializer<String> serializerKey = redisTemplateUtil.getRouteRedisTemplate().getStringSerializer();
        RedisSerializer<String> serializerHashKey = (RedisSerializer<String>) redisTemplateUtil.getRouteRedisTemplate()
            .getHashKeySerializer();

        connection.openPipeline();
        for (RouteVO route : routes) {
          connection.hDel(serializerKey.serialize(IGatewayConstant.MAP_NAME_ROUTE),
              serializerHashKey.serialize(route.getRouteId()));
        }
        List<Object> lstResults = connection.closePipeline();
        return lstResults.size();
      }
    },true);
    int result2 = redisTemplateUtil.getSqRedisTemplate().execute(new RedisCallback<Integer>() {
      @Override
      public Integer doInRedis(RedisConnection connection) throws DataAccessException {

        RedisSerializer<String> serializerKey = redisTemplateUtil.getSqRedisTemplate().getStringSerializer();
        RedisSerializer<String> serializerHashKey = (RedisSerializer<String>) redisTemplateUtil.getSqRedisTemplate()
            .getHashKeySerializer();

        connection.openPipeline();
        for (RouteVO route : routes) {
          connection.hDel(serializerKey.serialize(IGatewayConstant.MAP_NAME_QOS),
              serializerHashKey.serialize(route.getRouteId()));
        }
        List<Object> lstResults = connection.closePipeline();
        return lstResults.size();
      }
    },true);
    return result1&result2;
  }

  public void putRoute(RouteVO route) {
    redisTemplateUtil.getRouteRedisTemplate().opsForHash().put(IGatewayConstant.MAP_NAME_ROUTE,route.getRouteId(),route);
  }

  public Long deleteRoute(String routeId) {
    return redisTemplateUtil.getRouteRedisTemplate().opsForHash().delete(IGatewayConstant.MAP_NAME_ROUTE,routeId);
  }

  public void putQoS(String routePath, ServiceQualityVO serviceQualityVO) {
    redisTemplateUtil.getSqRedisTemplate().opsForHash().put(IGatewayConstant.MAP_NAME_QOS,routePath,serviceQualityVO);
  }

  public Long deleteQoS(String routePath) {
    return redisTemplateUtil.getSqRedisTemplate().opsForHash().delete(IGatewayConstant.MAP_NAME_QOS,routePath);
  }

  public Object getRoute(String routeId) {
    return redisTemplateUtil.getRouteRedisTemplate().opsForHash().get(IGatewayConstant.MAP_NAME_ROUTE,routeId);
  }

  /**
   * redis with transaction
   * @param routeVO
   * @param serviceQualityVO
   */
  private void saveRedisWithTransaction(RouteVO routeVO, ServiceQualityVO serviceQualityVO) {


    SessionCallback sessionCallback1 = new SessionCallback() {
      @Override
      public Object execute(RedisOperations operations) throws DataAccessException {
        operations.multi();
        operations.opsForHash().put(IGatewayConstant.MAP_NAME_ROUTE,routeVO.getRouteId(),routeVO);
        return operations.exec();
      }
    };
    redisTemplateUtil.getRouteRedisTemplate().execute(sessionCallback1);
    SessionCallback sessionCallback2 = new SessionCallback() {
      @Override
      public Object execute(RedisOperations operations) throws DataAccessException {
        operations.multi();
        operations.opsForHash().put(IGatewayConstant.MAP_NAME_QOS,routeVO.getRouteId(),serviceQualityVO);
        return operations.exec();
      }
    };
    redisTemplateUtil.getSqRedisTemplate().execute(sessionCallback2);


  }

  private void updateRedisWithTransaction(RouteVO routeVO, ServiceQualityVO serviceQualityVO) {
    SessionCallback sessionCallback1 = new SessionCallback() {
      @Override
      public Object execute(RedisOperations operations) throws DataAccessException {
        operations.multi();
        RouteVO oldRoute = (RouteVO) operations.opsForHash().get(IGatewayConstant.MAP_NAME_ROUTE,routeVO.getRouteId());
        operations.opsForHash().delete(IGatewayConstant.MAP_NAME_ROUTE,oldRoute.getRouteId());
        operations.opsForHash().put(IGatewayConstant.MAP_NAME_ROUTE,routeVO.getRouteId(),routeVO);
        return operations.exec();
      }
    };
    redisTemplateUtil.getRouteRedisTemplate().execute(sessionCallback1);
    SessionCallback sessionCallback2 = new SessionCallback() {
      @Override
      public Object execute(RedisOperations operations) throws DataAccessException {
        operations.multi();
        operations.opsForHash().put(IGatewayConstant.MAP_NAME_QOS,routeVO.getRouteId(),serviceQualityVO);
        return operations.exec();
      }
    };
    redisTemplateUtil.getSqRedisTemplate().execute(sessionCallback2);
  }


  private void deleteRedisWithTransaction(RouteVO routeVO) {
    SessionCallback sessionCallback1 = new SessionCallback() {
      @Override
      public Object execute(RedisOperations operations) throws DataAccessException {
        operations.multi();
        operations.opsForHash().delete(IGatewayConstant.MAP_NAME_ROUTE,routeVO.getRouteId());
        return operations.exec();
      }
    };
    redisTemplateUtil.getRouteRedisTemplate().execute(sessionCallback1);
    SessionCallback sessionCallback2 = new SessionCallback() {
      @Override
      public Object execute(RedisOperations operations) throws DataAccessException {
        operations.multi();
        operations.opsForHash().delete(IGatewayConstant.MAP_NAME_QOS,routeVO.getRouteId());
        return operations.exec();
      }
    };
    redisTemplateUtil.getSqRedisTemplate().execute(sessionCallback2);
  }

}
