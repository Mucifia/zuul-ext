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
@Table(name = "zuul_service_publish_request")
public class ServicePublishRequestPO extends GatewayPO {

  @Id
  @Column(name = "service_publish_request_id")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  protected String servicePublishRequestId;

  @Column(name = "service_plan_id")
  protected String servicePlanId;

  @Column(name = "service_plan_name")
  protected String servicePlanName;

  @Column(name="service_plan_version")
  protected String servicePlanVersion;

  @Column(name="service_plan_status")
  protected String servicePlanStatus;

  @Column(name="status")
  protected String status;

  public String getServicePublishRequestId() {
    return servicePublishRequestId;
  }

  public void setServicePublishRequestId(String servicePublishRequestId) {
    this.servicePublishRequestId = servicePublishRequestId;
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

  public String getServicePlanStatus() {
    return servicePlanStatus;
  }

  public void setServicePlanStatus(String servicePlanStatus) {
    this.servicePlanStatus = servicePlanStatus;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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
    ServicePublishRequestPO that = (ServicePublishRequestPO) o;
    return Objects.equals(servicePublishRequestId, that.servicePublishRequestId) &&
        Objects.equals(servicePlanId, that.servicePlanId) &&
        Objects.equals(servicePlanName, that.servicePlanName) &&
        Objects.equals(servicePlanVersion, that.servicePlanVersion) &&
        Objects.equals(servicePlanStatus, that.servicePlanStatus) &&
        Objects.equals(status, that.status);
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), servicePublishRequestId, servicePlanId, servicePlanName,
        servicePlanVersion, servicePlanStatus, status);
  }
}
