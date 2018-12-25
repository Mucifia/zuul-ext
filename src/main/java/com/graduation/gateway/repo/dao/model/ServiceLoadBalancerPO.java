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
@Table(name = "zuul_service_load_balancer")
public class ServiceLoadBalancerPO extends GatewayPO{

  @Id
  @Column(name = "load_balancer_id")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  protected String loadBalancerId;

  @Column(name = "name",nullable = false)
  protected String name;

  @Column(name = "class_name")
  protected String className;

  @Column(name = "description")
  protected String description;

  @Column(name = "service_quality_id")
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
    if (!super.equals(o)) {
      return false;
    }
    ServiceLoadBalancerPO that = (ServiceLoadBalancerPO) o;
    return Objects.equals(loadBalancerId, that.loadBalancerId) &&
        Objects.equals(name, that.name) &&
        Objects.equals(className, that.className) &&
        Objects.equals(description, that.description) &&
        Objects.equals(serviceQualityId, that.serviceQualityId);
  }

  @Override
  public int hashCode() {

    return Objects
        .hash(super.hashCode(), loadBalancerId, name, className, description, serviceQualityId);
  }
}
