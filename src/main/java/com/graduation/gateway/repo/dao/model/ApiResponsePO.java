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
@Table(name = "zuul_api_response")
public class ApiResponsePO extends GatewayPO{

  @Id
  @Column(name = "api_response_id")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  protected String apiResponseId;

  @Column(name = "status")
  protected int status;

  @Column(name = "response_type")
  protected String responseType;

  @Column(name = "value")
  protected String value;

  @Column(name = "description")
  protected String description;

  @Column(name = "api_resource_detail_id")
  protected String apiResourceDetailId;

  public String getApiResponseId() {
    return apiResponseId;
  }

  public void setApiResponseId(String apiResponseId) {
    this.apiResponseId = apiResponseId;
  }


  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getResponseType() {
    return responseType;
  }

  public void setResponseType(String responseType) {
    this.responseType = responseType;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getApiResourceDetailId() {
    return apiResourceDetailId;
  }

  public void setApiResourceDetailId(String apiResourceDetailId) {
    this.apiResourceDetailId = apiResourceDetailId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiResponsePO that = (ApiResponsePO) o;
    return status == that.status &&
        Objects.equals(apiResponseId, that.apiResponseId) &&
        Objects.equals(responseType, that.responseType) &&
        Objects.equals(value, that.value) &&
        Objects.equals(description, that.description) &&
        Objects.equals(apiResourceDetailId, that.apiResourceDetailId);
  }

  @Override
  public int hashCode() {

    return Objects.hash(apiResponseId,  status, responseType,value,
        description, apiResourceDetailId);
  }
}
