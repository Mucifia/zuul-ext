package com.graduation.gateway.api.util;

/**
 * @author: mmy
 * @date: 2019/01/28
 * @description:
 */
public interface InterfaceConstrants {

    // parent path
    String PARENT_PATH_SERVICE_PLAN = "/serviceplan";
    String PARENT_PATH_SERVICE_PLAN_QUALITY = "/serviceplanquality";
    String PARENT_PATH_SP_API_RELATION = "/spAPIRelation";
    String PARENT_PATH_API = "/api";
    String PARENT_PATH_API_RESOURCE = "/apiresource";
    String PARENT_PATH_API_SSO = "/apisso";

    // path var name
    String PATH_VAR_NAME_SERVICE_PLAN_ID = "servicePlanId";
    String PATH_VAR_NAME_APP_SYS_ID = "appSysId";
    String PATH_VAR_NAME_API_ID = "apiId";
    String PATH_VAR_NAME_API_RESOURCE_ID = "apiResourceId";
    String PATH_VAR_NAME_ROUTE_ID = "routeId";

    // operatonTYPE
    String OPERATION_TYPE_DELETE = "/delete";
    String OPERATION_SAVE = "/save";
    String OPERATION_UPDATE = "/update";
    String OPERATION_GET = "/get";

    //service plan
    String PATH_SERVICE_PLAN = PARENT_PATH_SERVICE_PLAN + "/{servicePlanId}";
    String PATH_SERVICE_PLAN_APP_SYS = PARENT_PATH_SERVICE_PLAN + "/" + PATH_VAR_NAME_APP_SYS_ID + "/{appSysId}";
    String PATH_SERVICE_PLAN_DELETE = PARENT_PATH_SERVICE_PLAN + OPERATION_TYPE_DELETE + "/{servicePlanId}";
    String PATH_SERVICE_PLAN_SAVE = PARENT_PATH_SERVICE_PLAN + OPERATION_SAVE;
    String PATH_SERVICE_PLAN_UPDATE = PARENT_PATH_SERVICE_PLAN + OPERATION_UPDATE;
    String PATH_SP_API_RELATION_SAVE = PARENT_PATH_SP_API_RELATION + OPERATION_SAVE;
    String PATH_SP_API_RELATION_GET = PARENT_PATH_SP_API_RELATION + "/" + PATH_VAR_NAME_SERVICE_PLAN_ID
        + "/{servicePlanId}";

    String PATH_SERVICE_PLAN_QUALITY_INFO = PARENT_PATH_SERVICE_PLAN_QUALITY + "/{servicePlanId}";
    String PATH_SERVICE_PLAN_QUALITY_INFO_SAVE = PARENT_PATH_SERVICE_PLAN_QUALITY + OPERATION_SAVE;
    String PATH_SERVICE_PLAN_QUALITY_INFO_UPDATE = PARENT_PATH_SERVICE_PLAN_QUALITY + OPERATION_UPDATE;

    //api
    String PATH_API_INFO = PARENT_PATH_API + "/{apiId}";
    String PATH_API_INFO_DELETE = PARENT_PATH_API + OPERATION_TYPE_DELETE + "/{apiId}";
    String PATH_API_INFO_SAVE = PARENT_PATH_API + OPERATION_SAVE;
    String PATH_API_INFOS = PARENT_PATH_API + "/all";
    String PATH_API_INFO_UPDATE = PARENT_PATH_API + OPERATION_UPDATE;
    String PATH_API_BY_SYSTEM_GET = PARENT_PATH_API + "/" + PATH_VAR_NAME_APP_SYS_ID + "/{appSysId}";

    //api sso
    String PATH_API_INFO_SAVE_SSO = PARENT_PATH_API_SSO + OPERATION_SAVE;
    String PATH_API_INFO_SSO = PARENT_PATH_API_SSO + "/{routeId}";
    String PATH_API_INFO_SSO_ALL = PARENT_PATH_API_SSO + "/" + PATH_VAR_NAME_APP_SYS_ID + "/{appSysId}";
    String PATH_API_INFO_DELETE_SSO = PARENT_PATH_API_SSO + OPERATION_TYPE_DELETE + "/{routeId}";
    String PATH_API_INFO_UPDATE_SSO = PARENT_PATH_API_SSO + OPERATION_UPDATE;

    String PATH_API_RESOURCE_INFO = PARENT_PATH_API_RESOURCE + "/{apiResourceId}";
    String PATH_API_RESOURCE_INFO_DELETE = PARENT_PATH_API_RESOURCE + OPERATION_TYPE_DELETE + "/{apiResourceId}";
    String PATH_API_RESOURCE_INFO_SAVE = PARENT_PATH_API_RESOURCE + OPERATION_SAVE;
    String PATH_API_RESOURCE_INFO_UPDATE = PARENT_PATH_API_RESOURCE + OPERATION_UPDATE;

    // service plan status
    String SERVICE_PLAN_STATUS_DRAFT = "draft";
    String SERVICE_PLAN_STATUS_AUDIT = "audit";
    String SERVICE_PLAN_STATUS_RUNNING = "running";
    String SERVICE_PLAN_STATUS_RETIRED = "retired";

  }
