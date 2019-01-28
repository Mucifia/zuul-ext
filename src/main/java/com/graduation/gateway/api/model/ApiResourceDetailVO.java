package com.graduation.gateway.api.model;

import java.util.List;
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

public class ApiResourceDetailVO{


  private String apiResourceDetailId;

  private String apiResourceId;

  private String method;

  private String bprotocal;

  private String bmethod;

  private boolean stripPrefix;

  private boolean perserveHost;

  private boolean retryable;

  private String sensitiveHeaders;

  private String ignoredHeaders;

  private int maxAutoRetries;

  private int connectionTimeout;

  private int readTimeout;

  private List<ApiParamVO> apiParamVOS;

  private List<ApiTransformVO> apiTransformVOS;

  private List<ApiResponseVO> apiResponseVOS;


  public String getApiResourceDetailId() {
    return apiResourceDetailId;
  }

  public void setApiResourceDetailId(String apiResourceDetailId) {
    this.apiResourceDetailId = apiResourceDetailId;
  }

  public String getApiResourceId() {
    return apiResourceId;
  }

  public void setApiResourceId(String apiResourceId) {
    this.apiResourceId = apiResourceId;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public boolean isStripPrefix() {
    return stripPrefix;
  }

  public void setStripPrefix(boolean stripPrefix) {
    this.stripPrefix = stripPrefix;
  }

  public boolean isPerserveHost() {
    return perserveHost;
  }

  public void setPerserveHost(boolean perserveHost) {
    this.perserveHost = perserveHost;
  }

  public boolean isRetryable() {
    return retryable;
  }

  public void setRetryable(boolean retryable) {
    this.retryable = retryable;
  }

  public String getSensitiveHeaders() {
    return sensitiveHeaders;
  }

  public void setSensitiveHeaders(String sensitiveHeaders) {
    this.sensitiveHeaders = sensitiveHeaders;
  }

  public String getIgnoredHeaders() {
    return ignoredHeaders;
  }

  public void setIgnoredHeaders(String ignoredHeaders) {
    this.ignoredHeaders = ignoredHeaders;
  }

  public int getMaxAutoRetries() {
    return maxAutoRetries;
  }

  public void setMaxAutoRetries(int maxAutoRetries) {
    this.maxAutoRetries = maxAutoRetries;
  }

  public int getConnectionTimeout() {
    return connectionTimeout;
  }

  public void setConnectionTimeout(int connectionTimeout) {
    this.connectionTimeout = connectionTimeout;
  }

  public int getReadTimeout() {
    return readTimeout;
  }

  public void setReadTimeout(int readTimeout) {
    this.readTimeout = readTimeout;
  }

  public String getBprotocal() {
    return bprotocal;
  }

  public void setBprotocal(String bprotocal) {
    this.bprotocal = bprotocal;
  }

  public List<ApiParamVO> getApiParamVOS() {
    return apiParamVOS;
  }

  public void setApiParamVOS(List<ApiParamVO> apiParamVOS) {
    this.apiParamVOS = apiParamVOS;
  }

  public List<ApiTransformVO> getApiTransformVOS() {
    return apiTransformVOS;
  }

  public void setApiTransformVOS(
      List<ApiTransformVO> apiTransformVOS) {
    this.apiTransformVOS = apiTransformVOS;
  }

  public List<ApiResponseVO> getApiResponseVOS() {
    return apiResponseVOS;
  }

  public void setApiResponseVOS(
      List<ApiResponseVO> apiResponseVOS) {
    this.apiResponseVOS = apiResponseVOS;
  }

  public String getBmethod() {
    return bmethod;
  }

  public void setBmethod(String bmethod) {
    this.bmethod = bmethod;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiResourceDetailVO that = (ApiResourceDetailVO) o;
    return stripPrefix == that.stripPrefix &&
        perserveHost == that.perserveHost &&
        retryable == that.retryable &&
        maxAutoRetries == that.maxAutoRetries &&
        connectionTimeout == that.connectionTimeout &&
        readTimeout == that.readTimeout &&
        Objects.equals(apiResourceDetailId, that.apiResourceDetailId) &&
        Objects.equals(apiResourceId, that.apiResourceId) &&
        Objects.equals(method, that.method) &&
        Objects.equals(bprotocal, that.bprotocal) &&
        Objects.equals(bmethod, that.bmethod) &&
        Objects.equals(sensitiveHeaders, that.sensitiveHeaders) &&
        Objects.equals(ignoredHeaders, that.ignoredHeaders) &&
        Objects.equals(apiParamVOS, that.apiParamVOS) &&
        Objects.equals(apiTransformVOS, that.apiTransformVOS) &&
        Objects.equals(apiResponseVOS, that.apiResponseVOS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiResourceDetailId, apiResourceId, method, bprotocal, bmethod, stripPrefix,
        perserveHost, retryable, sensitiveHeaders, ignoredHeaders, maxAutoRetries,
        connectionTimeout,
        readTimeout, apiParamVOS, apiTransformVOS, apiResponseVOS);
  }

  @Override
  public String toString() {
    return "ApiResourceDetailVO{" +
        "apiResourceDetailId='" + apiResourceDetailId + '\'' +
        ", apiResourceId='" + apiResourceId + '\'' +
        ", method='" + method + '\'' +
        ", bprotocal='" + bprotocal + '\'' +
        ", bmethod='" + bmethod + '\'' +
        ", stripPrefix=" + stripPrefix +
        ", perserveHost=" + perserveHost +
        ", retryable=" + retryable +
        ", sensitiveHeaders='" + sensitiveHeaders + '\'' +
        ", ignoredHeaders='" + ignoredHeaders + '\'' +
        ", maxAutoRetries=" + maxAutoRetries +
        ", connectionTimeout=" + connectionTimeout +
        ", readTimeout=" + readTimeout +
        ", apiParamVOS=" + apiParamVOS +
        ", apiTransformVOS=" + apiTransformVOS +
        ", apiResponseVOS=" + apiResponseVOS +
        '}';
  }
}
