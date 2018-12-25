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
@Table(name = "zuul_api_model_detail")
public class ApiModelDetailPO extends GatewayPO{

  @Id
  @Column(name = "api_model_detail_id")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  protected String apiModelDetailId;

  @Column(name = "api_model_id")
  protected String apiModelId;

  @Column(name = "name",nullable = false)
  protected String name;

  @Column(name = "model_detail_type")
  protected String modelDetailType;

  @Column(name = "ref_model_id")
  protected String refModelId;

  @Column(name = "description")
  protected String description;

  @Column(name = "requried")
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

  public String getRefModelId() {
    return refModelId;
  }

  public void setRefModelId(String refModelId) {
    this.refModelId = refModelId;
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
    ApiModelDetailPO that = (ApiModelDetailPO) o;
    return requried == that.requried &&
        Objects.equals(apiModelDetailId, that.apiModelDetailId) &&
        Objects.equals(apiModelId, that.apiModelId) &&
        Objects.equals(name, that.name) &&
        Objects.equals(modelDetailType, that.modelDetailType) &&
        Objects.equals(refModelId, that.refModelId) &&
        Objects.equals(description, that.description);
  }

  @Override
  public int hashCode() {

    return Objects
        .hash(apiModelDetailId, apiModelId, name, modelDetailType, refModelId, description,
            requried);
  }
}
