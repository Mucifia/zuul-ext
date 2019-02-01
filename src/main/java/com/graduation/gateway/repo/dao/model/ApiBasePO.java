package com.graduation.gateway.repo.dao.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author: mmy
 * @date: 2018/12/12
 * @description:
 */
@Entity
@Table(name = "zuul_api_base")
public class ApiBasePO extends GatewayPO {

  @Id
  @Column(name = "api_id")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  protected String apiId;

  @Column(name = "name",nullable = false)
  protected String name;

  @Column(name = "base_uri")
  protected String baseUri;

  @Column(name = "host")
  protected String host;

  @Column(name = "version")
  protected String version;

  @Column(name = "description")
  protected String description;

  @Column(name = "protocal")
  protected String protocal;

  @Column(name = "inbound_type")
  protected String inboundType;

  @Column(name = "outbound_type")
  protected String outboundType;

  @Column(name = "cors_id")
  protected String corsId;

  @Column(name = "security")
  protected String security;

  @Column(name = "enable")
  protected boolean enable;

  @Column(name = "state_id")
  protected String stateId;

  @Column(name = "serviceQualityId")
  private String serviceQualityId;

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
    if (!super.equals(o)) {
      return false;
    }
    ApiBasePO apiBasePO = (ApiBasePO) o;
    return enable == apiBasePO.enable &&
        Objects.equals(apiId, apiBasePO.apiId) &&
        Objects.equals(name, apiBasePO.name) &&
        Objects.equals(baseUri, apiBasePO.baseUri) &&
        Objects.equals(host, apiBasePO.host) &&
        Objects.equals(version, apiBasePO.version) &&
        Objects.equals(description, apiBasePO.description) &&
        Objects.equals(protocal, apiBasePO.protocal) &&
        Objects.equals(inboundType, apiBasePO.inboundType) &&
        Objects.equals(outboundType, apiBasePO.outboundType) &&
        Objects.equals(corsId, apiBasePO.corsId) &&
        Objects.equals(security, apiBasePO.security) &&
        Objects.equals(stateId, apiBasePO.stateId);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(super.hashCode(), apiId, name, baseUri, host, version, description, protocal,
            inboundType, outboundType, corsId, security, enable, stateId);
  }
}
