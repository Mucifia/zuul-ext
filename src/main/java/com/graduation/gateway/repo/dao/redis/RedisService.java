package com.graduation.gateway.repo.dao.redis;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.repo.dao.model.RoutePO;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: mmy
 * @date: 2018/12/20
 * @description: 分布式缓存服务类，Redis交互相关
 */
@Service
public class RedisService {

  @Autowired
  RedisTemplate<String, Object> redisTemplate;

  @Resource(name = "redisTemplate")
  private HashOperations<String, String, Object> hashDict;


  /**
   * 操作事务，保存路由信息到db和redis sso模式下，新增一条路由，要同时保存到Route表和redis中
   */
  @Transactional
  public void saveSSORoute(RouteVO routeVO, ServiceQualityVO serviceQualityVO){

    //save route
    //save servicequality
    // save redis
  }

  /**
   * 批量保存路由到DB和redis中 场景：API模式下，发布serviceplan时，要把该plan下的所有路由保存到route表和redis中
   */
  public void saveRouteBatch(List<RouteVO> lstRoutes, ServiceQualityVO serviceQualityVO){
    if ((lstRoutes == null) || (lstRoutes.size() < 1)) {
      return;
    }
    }

  /**
   * sso模式下，更新路由，db和redis
   *
   */
  public void updateSSORoute(RouteVO route, ServiceQualityVO quality) {
  }

  /**
   * sso模式下，删除一条路由
   *
   */
  public void deleteSSORoute(RouteVO routeVO, ServiceQualityVO serviceQualityVO){
  }

  /**
   * 批量删除
   *
   */
  public void deleteRouteBatch(List<RouteVO> lstRoutes, ServiceQualityVO serviceQualityVO){
  }

  /**
   * 批量保存route和quality到redis中
   *
   * @param routes
   * @param qos
   * @return
   */
  public int batchPutRoutes(List<RouteVO> routes, ServiceQualityVO qos) {
    return 0;
  }

  /**
   * 批量删除route，下线时批量删除
   *
   * @param routes
   * @param qos
   * @return
   */
  @Transactional
  public int batchDeleteRoutes(List<RouteVO> routes, ServiceQualityVO qos) {
    return 0;
  }

  public void putRoute(RouteVO route) {
  }

  public Long deleteRoute(String routeId) {
    return 0L;
  }

  public void putQoS(String routePath, ServiceQualityVO serviceQualityVO) {
  }

  public Long deleteQoS(String routePath) {
    return 0L;
  }

  public Object getRoute(String routeId) {
    return null;
  }

  /**
   * 在一个事务中操作redis
   */
  private void saveRedisWithTransction(RouteVO routeVO, ServiceQualityVO serviceQualityVO) {

  }

  private void updateRedisWithTransction(RouteVO route, ServiceQualityVO serviceQualityVO) {
  }


  private void deleteRedisWithTransction(RoutePO routePO) {
  }

}
