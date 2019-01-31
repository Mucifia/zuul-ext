package com.graduation.gateway.api.model;

import java.util.Objects;

/**
 * @author: mmy
 * @date: 2018/12/12
 * @description:
 */
public class ApiParamVO {


  private String apiParamId;

  private String apiResourceDetailId;

  private String name;

  private String paramsType;

  private String value;

  private String paramLocation;

  private String description;

  private String key;

  public String getApiParamId() {
    return apiParamId;
  }

  public void setApiParamId(String apiParamId) {
    this.apiParamId = apiParamId;
  }

  public String getApiResourceDetailId() {
    return apiResourceDetailId;
  }

  public void setApiResourceDetailId(String apiResourceDetailId) {
    this.apiResourceDetailId = apiResourceDetailId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getParamsType() {
    return paramsType;
  }

  public void setParamsType(String paramsType) {
    this.paramsType = paramsType;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getParamLocation() {
    return paramLocation;
  }

  public void setParamLocation(String paramLocation) {
    this.paramLocation = paramLocation;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiParamVO that = (ApiParamVO) o;
    return Objects.equals(apiParamId, that.apiParamId) &&
        Objects.equals(apiResourceDetailId, that.apiResourceDetailId) &&
        Objects.equals(name, that.name) &&
        Objects.equals(paramsType, that.paramsType) &&
        Objects.equals(value, that.value) &&
        Objects.equals(paramLocation, that.paramLocation) &&
        Objects.equals(description, that.description);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(apiParamId, apiResourceDetailId, name, paramsType, value, paramLocation, description);
  }

  @Override
  public String toString() {
    return "ApiParamVO{" +
        "apiParamId='" + apiParamId + '\'' +
        ", apiResourceDetailId='" + apiResourceDetailId + '\'' +
        ", name='" + name + '\'' +
        ", paramsType='" + paramsType + '\'' +
        ", value='" + value + '\'' +
        ", paramLocation='" + paramLocation + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
