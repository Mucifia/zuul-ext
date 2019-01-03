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
public class ApiParamVO{


  protected String apiParamId;

  protected String apiResourceDetailId;

  protected String name;

  protected String style;

  protected String paramsType;

  protected String value;

  protected boolean required;

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
    ApiParamVO that = (ApiParamVO) o;
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
        .hash(apiParamId, apiResourceDetailId, name, style, paramsType, value, required,
            description);
  }

  @Override
  public String toString() {
    return "ApiParamVO{" +
        "apiParamId='" + apiParamId + '\'' +
        ", apiResourceDetailId='" + apiResourceDetailId + '\'' +
        ", name='" + name + '\'' +
        ", style='" + style + '\'' +
        ", paramsType='" + paramsType + '\'' +
        ", value='" + value + '\'' +
        ", required=" + required +
        ", description='" + description + '\'' +
        '}';
  }
}
