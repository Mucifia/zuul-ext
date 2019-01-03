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

public class ApiModelDetailVO{


  protected String apiModelDetailId;

  protected String apiModelId;

  protected String name;

  protected String modelDetailType;

  protected String description;

  protected boolean requried;

  public String getApiModelDetailId() {
    return apiModelDetailId;
  }

  public void setApiModelDetailId(String apiModelDetailId) {
    this.apiModelDetailId = apiModelDetailId;
  }

  public String getApiModelId() {
    return apiModelId;
  }

  public void setApiModelId(String apiModelId) {
    this.apiModelId = apiModelId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getModelDetailType() {
    return modelDetailType;
  }

  public void setModelDetailType(String modelDetailType) {
    this.modelDetailType = modelDetailType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isRequried() {
    return requried;
  }

  public void setRequried(boolean requried) {
    this.requried = requried;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiModelDetailVO that = (ApiModelDetailVO) o;
    return requried == that.requried &&
        Objects.equals(apiModelDetailId, that.apiModelDetailId) &&
        Objects.equals(apiModelId, that.apiModelId) &&
        Objects.equals(name, that.name) &&
        Objects.equals(modelDetailType, that.modelDetailType) &&
        Objects.equals(description, that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiModelDetailId, apiModelId, name, modelDetailType, description, requried);
  }

  @Override
  public String toString() {
    return "ApiModelDetailVO{" +
        "apiModelDetailId='" + apiModelDetailId + '\'' +
        ", apiModelId='" + apiModelId + '\'' +
        ", name='" + name + '\'' +
        ", modelDetailType='" + modelDetailType + '\'' +
        ", description='" + description + '\'' +
        ", requried=" + requried +
        '}';
  }
}
