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
public class ServiceLoadBalancerVO{

  protected String loadBalancerId;

  protected String name;

  protected String className;

  protected String description;

  protected String serviceQualityId;

  public String getLoadBalancerId() {
    return loadBalancerId;
  }

  public void setLoadBalancerId(String loadBalancerId) {
    this.loadBalancerId = loadBalancerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getServiceQualityId() {
    return serviceQualityId;
  }

  public void setServiceQualityId(String serviceQualityId) {
    this.serviceQualityId = serviceQualityId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceLoadBalancerVO that = (ServiceLoadBalancerVO) o;
    return Objects.equals(loadBalancerId, that.loadBalancerId) &&
        Objects.equals(name, that.name) &&
        Objects.equals(className, that.className) &&
        Objects.equals(description, that.description) &&
        Objects.equals(serviceQualityId, that.serviceQualityId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(loadBalancerId, name, className, description, serviceQualityId);
  }

  @Override
  public String toString() {
    return "ServiceLoadBalancerVO{" +
        "loadBalancerId='" + loadBalancerId + '\'' +
        ", name='" + name + '\'' +
        ", className='" + className + '\'' +
        ", description='" + description + '\'' +
        ", serviceQualityId='" + serviceQualityId + '\'' +
        '}';
  }
}
