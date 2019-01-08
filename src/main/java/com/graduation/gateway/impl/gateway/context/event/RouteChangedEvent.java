package com.graduation.gateway.impl.gateway.context.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author: mmy
 * @date: 2019/01/08
 * @description:
 */
public class RouteChangedEvent extends ApplicationEvent {

  private Operation operation;

  public Operation getOperation() {
    return operation;
  }

  public void setOperation(Operation operation) {
    this.operation = operation;
  }

  public RouteChangedEvent(Object source, Operation operation) {
    super(source);
    this.operation = operation;
  }

  /*

   */
  public enum Operation {
    CREATE, UPDATE, REMOVE,
  }

}
