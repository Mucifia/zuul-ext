package com.graduation.gateway.impl.gateway.redis;

/**
 * @author: mmy
 * @date: 2018/12/26
 * @description:
 */
import java.io.Serializable;

public class RedisManagement implements Serializable{
  private static final long serialVersionUID = 8069835320208314052L;
  private String initializerIP;
  private String initializerPort;
  private long beginInitializeTime;
  private long endTime;

  public String getInitializerIP() {
    return initializerIP;
  }

  public void setInitializerIP(String initializerIP) {
    this.initializerIP = initializerIP;
  }

  public String getInitializerPort() {
    return initializerPort;
  }

  public void setInitializerPort(String initializerPort) {
    this.initializerPort = initializerPort;
  }

  public long getBeginInitializeTime() {
    return beginInitializeTime;
  }

  public void setBeginInitializeTime(long beginInitializeTime) {
    this.beginInitializeTime = beginInitializeTime;
  }

  public long getEndTime() {
    return endTime;
  }

  public void setEndTime(long endTime) {
    this.endTime = endTime;
  }

}
