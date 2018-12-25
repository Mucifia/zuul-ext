package com.graduation.gateway.impl.gateway.configuration;

import com.graduation.gateway.impl.gateway.locator.ZuulRouteLocator;
import com.graduation.gateway.impl.gateway.locator.ZuulRouteLocatorWithRedis;
import com.graduation.gateway.impl.service.RedisService;
import com.graduation.gateway.impl.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: mmy
 * @date: 2018/12/25
 * @description:
 */
@Configuration
@EnableConfigurationProperties({ZuulExtProperties.class})
public class ZuulConfiguration {

  @Autowired
  ServerProperties serverProperties;

  @Autowired
  ZuulExtProperties zuulExtProperties;

  @Bean
  public ZuulRouteLocator zuulRouteLocator(ZuulProperties zuulProperties, RouteService routeService, RedisService redisService) {
    if (this.zuulExtProperties.isRedisEnable()) {
      return new ZuulRouteLocatorWithRedis(this.serverProperties.getServletPath(),zuulProperties,routeService,redisService);
    } else {
      return new ZuulRouteLocator(this.serverProperties.getServletPath(), zuulProperties,
          routeService);
    }
  }
}
