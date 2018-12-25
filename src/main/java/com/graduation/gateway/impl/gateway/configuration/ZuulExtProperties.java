package com.graduation.gateway.impl.gateway.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: mmy
 * @date: 2018/12/25
 * @description:
 */
@ConfigurationProperties("zuul-ext")
public class ZuulExtProperties {

  private boolean redisEnable;

  public boolean isRedisEnable() {
    return redisEnable;
  }

  public void setRedisEnable(boolean redisEnable) {
    this.redisEnable = redisEnable;
  }
}
