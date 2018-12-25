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
@Table(name = "zuul_api_resource")
public class ApiResourcePO extends GatewayPO{

  @Id
  @Column(name = "api_resource_id")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  protected String apiResourceId;

  @Column(name = "api_id")
  protected String apiId;

  @Column(name = "pathname")
  protected String pathName;

  @Column(name = "description")
  protected String description;

  @Column(name = "target_uri")
  protected String targetUri;

  @Column(name = "service_id")
  protected String serviceId;

  public String getApiResourceId() {
    return apiResourceId;
  }

  public void setApiResourceId(String apiResourceId) {
    this.apiResourceId = apiResourceId;
  }

  public String getApiId() {
    return apiId;
  }

  public void setApiId(String apiId) {
    this.apiId = apiId;
  }

  public String getPathName() {
    return pathName;
  }

  public void setPathName(String pathName) {
    this.pathName = pathName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTargetUri() {
    return targetUri;
  }

  public void setTargetUri(String targetUri) {
    this.targetUri = targetUri;
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
    ApiResourcePO that = (ApiResourcePO) o;
    return Objects.equals(apiResourceId, that.apiResourceId) &&
        Objects.equals(apiId, that.apiId) &&
        Objects.equals(pathName, that.pathName) &&
        Objects.equals(description, that.description) &&
        Objects.equals(targetUri, that.targetUri) &&
        Objects.equals(serviceId, that.serviceId);
  }

  @Override
  public int hashCode() {

    return Objects.hash(apiResourceId, apiId, pathName, description, targetUri, serviceId);
  }
}
