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
@Table(name = "zuul_api_param")
public class ApiParamPO extends GatewayPO{

  @Id
  @Column(name = "api_param_id")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  protected String apiParamId;

  @Column(name = "api_resource_detail_id")
  protected String apiResourceDetailId;

  @Column(name = "name",nullable = false)
  protected String name;

  @Column(name = "style")
  protected String style;

  @Column(name = "params_type")
  protected String paramsType;

  @Column(name = "value")
  protected String value;

  @Column(name = "required")
  protected boolean required;

  @Column(name = "description")
  protected String description;

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

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
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

  public boolean isRequired() {
    return required;
  }

  public void setRequired(boolean required) {
    this.required = required;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiParamPO that = (ApiParamPO) o;
    return required == that.required &&
        Objects.equals(apiParamId, that.apiParamId) &&
        Objects.equals(apiResourceDetailId, that.apiResourceDetailId) &&
        Objects.equals(name, that.name) &&
        Objects.equals(style, that.style) &&
        Objects.equals(paramsType, that.paramsType) &&
        Objects.equals(value, that.value) &&
        Objects.equals(description, that.description);
  }

  @Override
  public int hashCode() {

    return Objects
        .hash(apiParamId, apiResourceDetailId, name, style, paramsType,  value, required,
            description);
  }
}
