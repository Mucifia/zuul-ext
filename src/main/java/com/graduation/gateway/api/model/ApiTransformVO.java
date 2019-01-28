package com.graduation.gateway.api.model;


import java.util.Objects;

/**
 * @author: mmy
 * @date: 2018/12/12
 * @description:
 */
public class ApiTransformVO{


  protected String apiTransformId;

  protected String apiResourceDetailId;

  protected String name;

  protected String paramLocation;

  protected String incomeParamName;

  protected String incomeParamLocation;

  protected String type;

  public String getApiTransformId() {
    return apiTransformId;
  }

  public void setApiTransformId(String apiTransformId) {
    this.apiTransformId = apiTransformId;
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

  public String getParamLocation() {
    return paramLocation;
  }

  public void setParamLocation(String paramLocation) {
    this.paramLocation = paramLocation;
  }

  public String getIncomeParamName() {
    return incomeParamName;
  }

  public void setIncomeParamName(String incomeParamName) {
    this.incomeParamName = incomeParamName;
  }

  public String getIncomeParamLocation() {
    return incomeParamLocation;
  }

  public void setIncomeParamLocation(String incomeParamLocation) {
    this.incomeParamLocation = incomeParamLocation;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "ApiTransformVO{" +
        "apiTransformId='" + apiTransformId + '\'' +
        ", apiResourceDetailId='" + apiResourceDetailId + '\'' +
        ", name='" + name + '\'' +
        ", paramLocation='" + paramLocation + '\'' +
        ", incomeParamName='" + incomeParamName + '\'' +
        ", incomeParamLocation='" + incomeParamLocation + '\'' +
        ", type='" + type + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiTransformVO that = (ApiTransformVO) o;
    return Objects.equals(apiTransformId, that.apiTransformId) &&
        Objects.equals(apiResourceDetailId, that.apiResourceDetailId) &&
        Objects.equals(name, that.name) &&
        Objects.equals(paramLocation, that.paramLocation) &&
        Objects.equals(incomeParamName, that.incomeParamName) &&
        Objects.equals(incomeParamLocation, that.incomeParamLocation) &&
        Objects.equals(type, that.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiTransformId, apiResourceDetailId, name, paramLocation, incomeParamName,
        incomeParamLocation, type);
  }
}
