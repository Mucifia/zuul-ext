package com.graduation.gateway.repo.dao.model;

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
@Entity
@Table(name = "zuul_service_user_request")
public class ServiceUserRequestPO extends GatewayPO{

  @Id
  @Column(name = "service_user_request_id")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  protected String servicePlanUserRequestId;

  @Column(name = "user_id")
  protected String userId;

  @Column(name = "access_scope")
  protected String accessScope;

  @Column(name = "status")
  protected String status;

  @Column(name = "service_plan_id")
  protected String servicePlanId;

  @Column(name = "service_plan_name")
  protected String servicePlanName;

  @Column(name = "service_plan_version")
  protected String servicePlanVersion;


  public String getServicePlanUserRequestId() {
    return servicePlanUserRequestId;
  }

  public void setServicePlanUserRequestId(String servicePlanUserRequestId) {
    this.servicePlanUserRequestId = servicePlanUserRequestId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    ServiceUserRequestPO that = (ServiceUserRequestPO) o;
    return Objects.equals(servicePlanUserRequestId, that.servicePlanUserRequestId) &&
        Objects.equals(userId, that.userId) &&
        Objects.equals(accessScope, that.accessScope) &&
        Objects.equals(status, that.status) &&
        Objects.equals(servicePlanId, that.servicePlanId) &&
        Objects.equals(servicePlanName, that.servicePlanName) &&
        Objects.equals(servicePlanVersion, that.servicePlanVersion);
  }

  @Override
  public int hashCode() {

    return Objects
        .hash(super.hashCode(), servicePlanUserRequestId, userId, accessScope, status,
            servicePlanId,
            servicePlanName, servicePlanVersion);
  }
}
