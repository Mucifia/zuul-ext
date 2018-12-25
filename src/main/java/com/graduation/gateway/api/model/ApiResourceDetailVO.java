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

public class ApiResourceDetailVO{


  protected String apiResourceDetailId;

  protected String apiResourceId;

  protected String method;

  protected String operationId;

  protected String inboundType;

  protected String outboundType;

  protected String serviceID;

  protected String url;

  protected boolean stripPrefix;

  protected boolean perserveHost;

  protected boolean retryable;

  protected String sensitiveHeaders;

  protected String ignoredHeaders;

  protected int maxAutoRetries;

  protected int connectionTimeout;

  protected int readTimeout;

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

  public String getOperationId() {
    return operationId;
  }

  public void setOperationId(String operationId) {
    this.operationId = operationId;
  }

  public String getInboundType() {
    return inboundType;
  }

  public void setInboundType(String inboundType) {
    this.inboundType = inboundType;
  }

  public String getOutboundType() {
    return outboundType;
  }

  public void setOutboundType(String outboundType) {
    this.outboundType = outboundType;
  }

  public String getServiceID() {
    return serviceID;
  }

  public void setServiceID(String serviceID) {
    this.serviceID = serviceID;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
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
        Objects.equals(operationId, that.operationId) &&
        Objects.equals(inboundType, that.inboundType) &&
        Objects.equals(outboundType, that.outboundType) &&
        Objects.equals(serviceID, that.serviceID) &&
        Objects.equals(url, that.url) &&
        Objects.equals(sensitiveHeaders, that.sensitiveHeaders) &&
        Objects.equals(ignoredHeaders, that.ignoredHeaders);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(apiResourceDetailId, apiResourceId, method, operationId, inboundType, outboundType,
            serviceID, url, stripPrefix, perserveHost, retryable, sensitiveHeaders, ignoredHeaders,
            maxAutoRetries, connectionTimeout, readTimeout);
  }
}
