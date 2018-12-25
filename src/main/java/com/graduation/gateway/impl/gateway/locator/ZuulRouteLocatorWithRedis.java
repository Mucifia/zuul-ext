package com.graduation.gateway.impl.gateway.locator;

import com.graduation.gateway.impl.service.RedisService;
import com.graduation.gateway.impl.service.RouteService;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

/**
 * @author: mmy
 * @date: 2018/12/25
 * @description:
 */
public class ZuulRouteLocatorWithRedis extends ZuulRouteLocator {

  private RedisService redisService;

  public ZuulRouteLocatorWithRedis(String servletPath,
      ZuulProperties properties,
      RouteService routeService,RedisService redisService) {
    super(servletPath, properties, routeService);
    this.redisService = redisService;
  }
}
