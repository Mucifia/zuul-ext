package com.graduation.gateway.impl.gateway.redis;

import com.graduation.gateway.api.model.RouteVO;
import com.graduation.gateway.api.model.ServiceQualityVO;
import java.util.Map;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author: mmy
 * @date: 2019/01/07
 * @description:
 */
public class RedisTemplateUtil {

  private  JedisConnectionFactory jedisConnectionFactory;

  private RedisTemplate<String, Map<String,RedisManagement>> mngRedisTemplate;

  private RedisTemplate<String, Map<String, RouteVO>> routeRedisTemplate;

  private RedisTemplate<String, Map<String, ServiceQualityVO>> sqRedisTemplate;

  public RedisTemplateUtil(JedisConnectionFactory jedisConnectionFactory) {
    mngRedisTemplate= new RedisTemplate<>();
    mngRedisTemplate.setConnectionFactory(jedisConnectionFactory);
    mngRedisTemplate.setKeySerializer(mngRedisTemplate.getStringSerializer());
    mngRedisTemplate.setHashKeySerializer(mngRedisTemplate.getStringSerializer());
    mngRedisTemplate
        .setHashValueSerializer(new Jackson2JsonRedisSerializer<RedisManagement>(
            RedisManagement.class));
    mngRedisTemplate.afterPropertiesSet();
    routeRedisTemplate= new RedisTemplate<>();
    routeRedisTemplate.setConnectionFactory(jedisConnectionFactory);
    routeRedisTemplate.setKeySerializer(routeRedisTemplate.getStringSerializer());
    routeRedisTemplate.setHashKeySerializer(routeRedisTemplate.getStringSerializer());
    routeRedisTemplate
        .setHashValueSerializer(new Jackson2JsonRedisSerializer<RouteVO>(
            RouteVO.class));
    routeRedisTemplate.afterPropertiesSet();
    sqRedisTemplate= new RedisTemplate<>();
    sqRedisTemplate.setConnectionFactory(jedisConnectionFactory);
    sqRedisTemplate.setKeySerializer(sqRedisTemplate.getStringSerializer());
    sqRedisTemplate.setHashKeySerializer(sqRedisTemplate.getStringSerializer());
    sqRedisTemplate
        .setHashValueSerializer(new Jackson2JsonRedisSerializer<ServiceQualityVO>(
            ServiceQualityVO.class));
    sqRedisTemplate.afterPropertiesSet();
  }

  public RedisTemplate<String, Map<String, RedisManagement>> getMngRedisTemplate() {
    return mngRedisTemplate;
  }


  public RedisTemplate<String, Map<String, RouteVO>> getRouteRedisTemplate() {
    return routeRedisTemplate;
  }


  public RedisTemplate<String, Map<String, ServiceQualityVO>> getSqRedisTemplate() {
    return sqRedisTemplate;
  }


}
