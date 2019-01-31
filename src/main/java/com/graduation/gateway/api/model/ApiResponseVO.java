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
public class ApiResponseVO{


  private String apiResponseId;

  private String errorCode;

  private String errorinformation;

  private String description;

  private String apiResourceDetailId;

  private String key;

  public String getApiResponseId() {
    return apiResponseId;
  }

  public void setApiResponseId(String apiResponseId) {
    this.apiResponseId = apiResponseId;
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

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiResponseVO that = (ApiResponseVO) o;
    return Objects.equals(apiResponseId, that.apiResponseId) &&
        Objects.equals(errorCode, that.errorCode) &&
        Objects.equals(errorinformation, that.errorinformation) &&
        Objects.equals(description, that.description) &&
        Objects.equals(apiResourceDetailId, that.apiResourceDetailId) &&
        Objects.equals(key, that.key);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(apiResponseId, errorCode, errorinformation, description, apiResourceDetailId, key);
  }

  @Override
  public String toString() {
    return "ApiResponseVO{" +
        "apiResponseId='" + apiResponseId + '\'' +
        ", errorCode='" + errorCode + '\'' +
        ", errorinformation='" + errorinformation + '\'' +
        ", description='" + description + '\'' +
        ", apiResourceDetailId='" + apiResourceDetailId + '\'' +
        ", key='" + key + '\'' +
        '}';
  }
}
