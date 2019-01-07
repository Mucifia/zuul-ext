package com.graduation.gateway.impl.gateway;

import com.graduation.gateway.impl.gateway.ZuulRouteLocator;
import com.graduation.gateway.impl.gateway.redis.RedisObjectSerializer;
import com.graduation.gateway.impl.gateway.redis.RedisService;
import com.graduation.gateway.impl.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author: mmy
 * @date: 2018/12/25
 * @description:
 */
@Configuration
public class ZuulConfiguration {

  @Autowired
  ServerProperties serverProperties;

  @Bean
  public ZuulRouteLocator zuulRouteLocator(ZuulProperties zuulProperties, RouteService routeService,
      RedisService redisService) {
      return new ZuulRouteLocator(this.serverProperties.getServletPath(), zuulProperties,
          routeService,redisService);
  }

  @Bean
  public JedisConnectionFactory jedisConnectionFactory(){
    return new JedisConnectionFactory();
  }


  @Bean
  public RedisTemplate<String,Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory){
    final RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(jedisConnectionFactory);
    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }



}
