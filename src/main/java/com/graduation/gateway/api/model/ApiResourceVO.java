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
public class ApiResourceVO{


  private String apiResourceId;

  private String apiId;

  private String pathName;

  private String description;

  private String targetUri;

  private String serviceId;

  private ApiResourceDetailVO apiResourceDetailVO;

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

  public ApiResourceDetailVO getApiResourceDetailVO() {
    return apiResourceDetailVO;
  }

  public void setApiResourceDetailVO(
      ApiResourceDetailVO apiResourceDetailVO) {
    this.apiResourceDetailVO = apiResourceDetailVO;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiResourceVO that = (ApiResourceVO) o;
    return Objects.equals(apiResourceId, that.apiResourceId) &&
        Objects.equals(apiId, that.apiId) &&
        Objects.equals(pathName, that.pathName) &&
        Objects.equals(description, that.description) &&
        Objects.equals(targetUri, that.targetUri) &&
        Objects.equals(serviceId, that.serviceId) &&
        Objects.equals(apiResourceDetailVO, that.apiResourceDetailVO);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(apiResourceId, apiId, pathName, description, targetUri, serviceId,
            apiResourceDetailVO);
  }

  @Override
  public String toString() {
    return "ApiResourceVO{" +
        "apiResourceId='" + apiResourceId + '\'' +
        ", apiId='" + apiId + '\'' +
        ", pathName='" + pathName + '\'' +
        ", description='" + description + '\'' +
        ", targetUri='" + targetUri + '\'' +
        ", serviceId='" + serviceId + '\'' +
        ", apiResourceDetailVO=" + apiResourceDetailVO +
        '}';
  }
}
