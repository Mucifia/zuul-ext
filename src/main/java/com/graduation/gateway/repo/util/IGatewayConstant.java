package com.graduation.gateway.repo.util;

/**
 * @author: mmy
 * @date: 2018/12/13
 * @description:
 */
public interface IGatewayConstant {

  public static final String CREATE_BY = "create_by";
  public static final String CREATE_TIME = "create_time";
  public static final String UPDATE_BY = "update_by";
  public static final String UPDATE_TIME = "update_time";
  public static final String DELETE_FLAG = "del_flag";

  public static final String MAP_NAME_ROUTE = "ROUTE";
  public static final String MAP_NAME_QOS = "QOS";
  public static final int REDIS_SYN_TIME_LIMIT = 60000;

  public static final String AUTH_TYPE_SSO = "auth_sso";
  public static final String AUTH_TYPE_API = "auth_api";

}
