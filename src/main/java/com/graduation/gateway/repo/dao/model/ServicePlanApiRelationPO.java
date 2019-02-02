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
 * @date: 2018/12/22
 * @description:
 */
@Entity
@Table(name = "zuul_service_lan_api_realation")
public class ServicePlanApiRelationPO extends GatewayPO{

  @Id
  @Column(name = "serviceplan_relation_id")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  protected String servicePlanRelationId;

  @Column(name = "api_id")
  protected String apiId;

  @Column(name = "service_plan_id")
  protected String serviceplanId;



  public String getServicePlanRelationId() {
    return servicePlanRelationId;
  }

  public void setServicePlanRelationId(String servicePlanRelationId) {
    this.servicePlanRelationId = servicePlanRelationId;
  }

  public String getApiId() {
    return apiId;
  }

  public void setApiId(String apiId) {
    this.apiId = apiId;
  }

  public String getServiceplanId() {
    return serviceplanId;
  }

  public void setServiceplanId(String serviceplanId) {
    this.serviceplanId = serviceplanId;
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
    ServicePlanApiRelationPO that = (ServicePlanApiRelationPO) o;
    return Objects.equals(servicePlanRelationId, that.servicePlanRelationId) &&
        Objects.equals(apiId, that.apiId) &&
        Objects.equals(serviceplanId, that.serviceplanId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), servicePlanRelationId, apiId, serviceplanId);
  }
}
