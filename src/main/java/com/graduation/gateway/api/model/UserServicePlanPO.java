package com.graduation.gateway.api.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author: mmy
 * @date: 2018/12/12
 * @description:
 */
public class UserServicePlanPO{

  protected String userServicePlanId;

  protected String userId;

  protected String servicePlanId;

  protected String servicePlanName;

  protected String servicePlanVersion;

  protected String accessScope;

  protected String status;

  protected String clientId;

  public String getUserServicePlanId() {
    return userServicePlanId;
  }

  public void setUserServicePlanId(String userServicePlanId) {
    this.userServicePlanId = userServicePlanId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getServicePlanId() {
    return servicePlanId;
  }

  public void setServicePlanId(String servicePlanId) {
    this.servicePlanId = servicePlanId;
  }

  public String getServicePlanName() {
    return servicePlanName;
  }

  public void setServicePlanName(String servicePlanName) {
    this.servicePlanName = servicePlanName;
  }

  public String getServicePlanVersion() {
    return servicePlanVersion;
  }

  public void setServicePlanVersion(String servicePlanVersion) {
    this.servicePlanVersion = servicePlanVersion;
  }

  public String getAccessScope() {
    return accessScope;
  }

  public void setAccessScope(String accessScope) {
    this.accessScope = accessScope;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserServicePlanPO that = (UserServicePlanPO) o;
    return Objects.equals(userServicePlanId, that.userServicePlanId) &&
        Objects.equals(userId, that.userId) &&
        Objects.equals(servicePlanId, that.servicePlanId) &&
        Objects.equals(servicePlanName, that.servicePlanName) &&
        Objects.equals(servicePlanVersion, that.servicePlanVersion) &&
        Objects.equals(accessScope, that.accessScope) &&
        Objects.equals(status, that.status) &&
        Objects.equals(clientId, that.clientId);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(userServicePlanId, userId, servicePlanId, servicePlanName, servicePlanVersion,
            accessScope, status, clientId);
  }
}
