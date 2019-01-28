package com.graduation.gateway.api.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author: mmy
 * @date: 2018/12/12
 * @description:
 */
public class ApiBaseVO {

  private String apiId;

  private String name;

  private String baseUri;

  private String host;

  private String version;

  private String description;

  private String protocal;

  private String inboundType;

  private String outboundType;

  private String security;

  private ApiResourceVO apiResourceVO;

  public String getApiId() {
    return apiId;
  }

  public void setApiId(String apiId) {
    this.apiId = apiId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBaseUri() {
    return baseUri;
  }

  public void setBaseUri(String baseUri) {
    this.baseUri = baseUri;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getProtocal() {
    return protocal;
  }

  public void setProtocal(String protocal) {
    this.protocal = protocal;
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

  public String getSecurity() {
    return security;
  }

  public void setSecurity(String security) {
    this.security = security;
  }

  public ApiResourceVO getApiResourceVO() {
    return apiResourceVO;
  }

  public void setApiResourceVO(ApiResourceVO apiResourceVO) {
    this.apiResourceVO = apiResourceVO;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiBaseVO apiBaseVO = (ApiBaseVO) o;
    return Objects.equals(apiId, apiBaseVO.apiId) &&
        Objects.equals(name, apiBaseVO.name) &&
        Objects.equals(baseUri, apiBaseVO.baseUri) &&
        Objects.equals(host, apiBaseVO.host) &&
        Objects.equals(version, apiBaseVO.version) &&
        Objects.equals(description, apiBaseVO.description) &&
        Objects.equals(protocal, apiBaseVO.protocal) &&
        Objects.equals(inboundType, apiBaseVO.inboundType) &&
        Objects.equals(outboundType, apiBaseVO.outboundType) &&
        Objects.equals(security, apiBaseVO.security) &&
        Objects.equals(apiResourceVO, apiBaseVO.apiResourceVO);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(apiId, name, baseUri, host, version, description, protocal, inboundType, outboundType,
            security, apiResourceVO);
  }

  @Override
  public String toString() {
    return "ApiBaseVO{" +
        "apiId='" + apiId + '\'' +
        ", name='" + name + '\'' +
        ", baseUri='" + baseUri + '\'' +
        ", host='" + host + '\'' +
        ", version='" + version + '\'' +
        ", description='" + description + '\'' +
        ", protocal='" + protocal + '\'' +
        ", inboundType='" + inboundType + '\'' +
        ", outboundType='" + outboundType + '\'' +
        ", security='" + security + '\'' +
        ", apiResourceVO=" + apiResourceVO +
        '}';
  }
}
