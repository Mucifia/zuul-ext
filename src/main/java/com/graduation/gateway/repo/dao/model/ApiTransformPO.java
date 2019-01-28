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
@Table(name = "zuul_api_transform")
@Entity
public class ApiTransformPO extends GatewayPO{

  @Id
  @Column(name = "api_transform_id")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  protected String apiTransformId;

  @Column(name = "api_resource_detail_id")
  protected String apiResourceDetailId;

  @Column(name = "name")
  protected String name;

  @Column(name = "paramlocation")
  protected String paramLocation;

  @Column(name = "incomeparamName")
  protected String incomeParamName;

  @Column(name = "incomeParamLocation")
  protected String incomeParamLocation;


  @Column(name ="type")
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
    ApiTransformPO that = (ApiTransformPO) o;
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
    return Objects.hash(super.hashCode(), apiTransformId, apiResourceDetailId, name, paramLocation,
        incomeParamName, incomeParamLocation, type);
  }
}
