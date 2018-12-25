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

  protected String apiId;

  protected String name;

  protected String baseUri;

  protected String host;

  protected String version;

  protected String description;

  protected String protocal;

  protected String inboundType;

  protected String outboundType;

  protected String corsId;

  protected String security;

  protected boolean enable;

  protected String stateId;

  protected Set<ServicePlanVO> servicePlanVOSet = new HashSet<>();

  public Set<ServicePlanVO> getServicePlanVOSet() {
    return servicePlanVOSet;
  }

  public void setServicePlanVOSet(
      Set<ServicePlanVO> servicePlanVOSet) {
    this.servicePlanVOSet = servicePlanVOSet;
  }

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

  public String getCorsId() {
    return corsId;
  }

  public void setCorsId(String corsId) {
    this.corsId = corsId;
  }

  public String getSecurity() {
    return security;
  }

  public void setSecurity(String security) {
    this.security = security;
  }

  public boolean isEnable() {
    return enable;
  }

  public void setEnable(boolean enable) {
    this.enable = enable;
  }

  public String getStateId() {
    return stateId;
  }

  public void setStateId(String stateId) {
    this.stateId = stateId;
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
    return enable == apiBaseVO.enable &&
        Objects.equals(apiId, apiBaseVO.apiId) &&
        Objects.equals(name, apiBaseVO.name) &&
        Objects.equals(baseUri, apiBaseVO.baseUri) &&
        Objects.equals(host, apiBaseVO.host) &&
        Objects.equals(version, apiBaseVO.version) &&
        Objects.equals(description, apiBaseVO.description) &&
        Objects.equals(protocal, apiBaseVO.protocal) &&
        Objects.equals(inboundType, apiBaseVO.inboundType) &&
        Objects.equals(outboundType, apiBaseVO.outboundType) &&
        Objects.equals(corsId, apiBaseVO.corsId) &&
        Objects.equals(security, apiBaseVO.security) &&
        Objects.equals(stateId, apiBaseVO.stateId) &&
        Objects.equals(servicePlanVOSet, apiBaseVO.servicePlanVOSet);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(apiId, name, baseUri, host, version, description, protocal, inboundType, outboundType,
            corsId, security, enable, stateId, servicePlanVOSet);
  }
}
