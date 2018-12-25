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


  public ServicePlanApiRelationPO(){

  }
  public ServicePlanApiRelationPO(String apiId,String serviceId){
    this.apiId=apiId;
    this.serviceId=serviceId;
  }


  @Id
  @Column(name = "serviceplan_relation_id")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  protected String servicePlanRelationId;

  @Column(name = "api_id")
  protected String apiId;

  @Column(name = "service_plan_id")
  protected String serviceId;

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

  public String getServiceId() {
    return serviceId;
  }

  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
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
        Objects.equals(serviceId, that.serviceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), servicePlanRelationId, apiId, serviceId);
  }
}
