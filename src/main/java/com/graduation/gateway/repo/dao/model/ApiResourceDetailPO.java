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
@Table(name = "zuul_api_resource_detail")
public class ApiResourceDetailPO extends GatewayPO {

  @Id
  @Column(name = "api_resource_detail_id")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  protected String apiResourceDetailId;

  @Column(name = "api_resource_id")
  protected String apiResourceId;

  @Column(name = "method")
  protected String method;

  @Column(name = "operation_id")
  protected String operationId;

  @Column(name = "inbound_type")
  protected String inboundType;

  @Column(name = "outbound_type")
  protected String outboundType;

  @Column(name = "service_id")
  protected String serviceID;

  @Column(name = "url")
  protected String url;

  @Column(name = "strip_prefix")
  protected boolean stripPrefix;

  @Column(name = "perserve_host")
  protected boolean perserveHost;

  @Column(name = "retryable")
  protected boolean retryable;

  @Column(name = "sensitive_headers")
  protected String sensitiveHeaders;

  @Column(name = "ignored_headers")
  protected String ignoredHeaders;

  @Column(name = "max_auto_retries")
  protected int maxAutoRetries;

  @Column(name = "connection_timeout")
  protected int connectionTimeout;

  @Column(name = "read_timeout")
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
    ApiResourceDetailPO that = (ApiResourceDetailPO) o;
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
