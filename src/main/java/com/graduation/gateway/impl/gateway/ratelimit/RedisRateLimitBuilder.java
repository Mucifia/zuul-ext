package com.graduation.gateway.impl.gateway.ratelimit;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.impl.service.ServiceQualityService;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties.Policy;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: mmy
 * @date: 2019/01/08
 * @description:
 */
public class RedisRateLimitBuilder extends IRateLimitBuilder {

  @Override
  public Map<String, Policy> getPolicies(String routeId) {
    Map<String,Policy> policies = new HashMap<>();
    RouteVO routeVO = (RouteVO) redisRepository.getRouteByRouteId(routeId);
    if (Objects.nonNull(routeVO)) {
      ServiceQualityVO serviceQualityVO = (ServiceQualityVO) redisRepository
          .getRouteByRouteId(routeVO.getRouteId());
      if (Objects.nonNull(serviceQualityVO)) {
        Policy policy = new ServiceQualityService().getRateLimitPolicy(serviceQualityVO);
        policies.put(routeId,policy);
      }
    }
    return policies;
  }

  @Override
  public Map<String, Policy> getPolicies(List<String> routeIds) {
    Map<String,Policy> policies = new HashMap<>();
    List<Object> objects = redisRepository.getRouteByRouteId(routeIds);
    objects.stream().filter(Objects::nonNull).forEach(o -> {
          RouteVO routeVO = (RouteVO) o;
          ServiceQualityVO serviceQualityVO = (ServiceQualityVO) redisRepository
              .getRouteByRouteId(routeVO.getRouteId());
          if (Objects.nonNull(serviceQualityVO)) {
            Policy policy = new ServiceQualityService().getRateLimitPolicy(serviceQualityVO);
            policies.put(routeVO.getRouteId(),policy);
          }
        }
    );
    return policies;
  }

  @Override
  public Map<String, Policy> getAllPolicies() {
    Collection<Object> objects  = redisRepository.getAllRoutes().values();
    List<String> routeIds  = objects.stream().map(o->{
      RouteVO routeVO = (RouteVO) o;
      return routeVO.getRouteId();
    }).collect(Collectors.toList());
    return getPolicies(routeIds);
  }

}
