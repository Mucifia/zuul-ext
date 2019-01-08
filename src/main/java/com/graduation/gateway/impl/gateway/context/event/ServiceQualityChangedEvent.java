package com.graduation.gateway.impl.gateway.context.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author: mmy
 * @date: 2019/01/08
 * @description:
 */
public class ServiceQualityChangedEvent extends ApplicationEvent {

  public ServiceQualityChangedEvent(Object source) {
    super(source);
  }
}
