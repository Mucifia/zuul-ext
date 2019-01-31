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

  @Column(name = "errorCode")
  private String errorCode;

  @Column(name = "errorinformation")
  private String errorinformation;

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

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorinformation() {
    return errorinformation;
  }

  public void setErrorinformation(String errorinformation) {
    this.errorinformation = errorinformation;
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
    if (!super.equals(o)) {
      return false;
    }
    ApiResponsePO that = (ApiResponsePO) o;
    return Objects.equals(apiResponseId, that.apiResponseId) &&
        Objects.equals(errorCode, that.errorCode) &&
        Objects.equals(errorinformation, that.errorinformation) &&
        Objects.equals(description, that.description) &&
        Objects.equals(apiResourceDetailId, that.apiResourceDetailId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), apiResponseId, errorCode, errorinformation, description,
        apiResourceDetailId);
  }
}
