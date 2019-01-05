package com.graduation.gateway.impl.gateway.ratelimit;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.impl.gateway.redis.RedisRepository;
import com.graduation.gateway.impl.service.ServiceQualityService;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: mmy
 * @date: 2019/01/03
 * @description:
 */
public class IRateLimitProperties extends RateLimitProperties {

  @Autowired
  RedisRepository redisRepository;


  @Override
  public List<Policy> getPolicies(String key) {
    List<Policy> policies = new ArrayList<>();
    RouteVO routeVO = (RouteVO)redisRepository.getRouteByRouteId(key);
    ServiceQualityVO serviceQualityVO  = (ServiceQualityVO) redisRepository.getRouteByRouteId(routeVO.getRouteId());
    if (Objects.nonNull(serviceQualityVO)){
      Policy policy = covertToPolicy(serviceQualityVO);
      policies.add(policy);
    }
    return policies;
  }



  public Policy covertToPolicy(ServiceQualityVO serviceQualityVO){
    ServiceQualityService serviceQualityService = new ServiceQualityService();
    return serviceQualityService.getRateLimitPolicy(serviceQualityVO);
  }

}
