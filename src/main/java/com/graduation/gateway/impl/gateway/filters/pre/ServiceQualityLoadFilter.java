package com.graduation.gateway.impl.gateway.filters.pre;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.api.model.ServiceQualityVO;
import com.graduation.gateway.impl.gateway.redis.RedisRepository;
import com.graduation.gateway.impl.gateway.redis.RedisService;
import com.graduation.gateway.impl.service.RouteService;
import com.graduation.gateway.impl.service.ServiceQualityService;
import com.graduation.gateway.impl.utils.GatewayImplConstants;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @author: mmy
 * @date: 2019/01/05
 * @description:
 */
public class ServiceQualityLoadFilter  extends ZuulFilter {


  @Autowired
  RedisRepository redisRepository;

  @Override
  public String filterType() {
    return FilterConstants.PRE_TYPE;
  }

  @Override
  public int filterOrder() {
    return FilterConstants.PRE_DECORATION_FILTER_ORDER+1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext context = RequestContext.getCurrentContext();
    String serviceId = (String) context.get(FilterConstants.SERVICE_ID_KEY);

    //set url
    ServiceQualityVO serviceQualityVO = (ServiceQualityVO) redisRepository.getQoSByRouteId(serviceId);
    RouteVO routeVO = (RouteVO) redisRepository.getRouteByRouteId(serviceId);
    context.set(GatewayImplConstants.SERVICEQUALITY,serviceQualityVO);
    String serverList = routeVO.getTargetUri();
    context.set(GatewayImplConstants.SERVERLIST,serverList);

    return null;
  }
}
