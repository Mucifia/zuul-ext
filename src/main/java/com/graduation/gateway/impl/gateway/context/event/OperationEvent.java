package com.graduation.gateway.impl.gateway.context.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author: mmy
 * @date: 2019/01/09
 * @description:
 */
public class OperationEvent extends ApplicationEvent {

  public OperationEvent(Object source) {
    super(source);
  }
}
