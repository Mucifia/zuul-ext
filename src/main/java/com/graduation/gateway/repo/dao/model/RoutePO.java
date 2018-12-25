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
@Table(name = "zuul_route")
public class RoutePO extends GatewayPO{

  @Id
  @Column(name = "route_id")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  protected String routeId;

  @Column(name="path")
  protected String path;

  @Column(name="target_uri")
  protected String targetUri;

  @Column(name = "targetServiceId")
  protected String targetServiceId;

  @Column(name="quality_enabled")
  protected boolean qualityEnabled;

  @Column(name = "strip_prefix")
  protected boolean stripPrefix;

  @Column(name = "service_plan_id")
  protected String servicePlanId;

  @Column(name="route_type")
  protected String routeType;

  @Column(name = "prefer_url")
  protected boolean preferURL;

  public String getRouteId() {
    return routeId;
  }

  public void setRouteId(String routeId) {
    this.routeId = routeId;
  }


  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getTargetUri() {
    return targetUri;
  }

  public void setTargetUri(String targetUri) {
    this.targetUri = targetUri;
  }

  public String getTargetServiceId() {
    return targetServiceId;
  }

  public void setTargetServiceId(String targetServiceId) {
    this.targetServiceId = targetServiceId;
  }

  public boolean isQualityEnabled() {
    return qualityEnabled;
  }

  public void setQualityEnabled(boolean qualityEnabled) {
    this.qualityEnabled = qualityEnabled;
  }

  public boolean isStripPrefix() {
    return stripPrefix;
  }

  public void setStripPrefix(boolean stripPrefix) {
    this.stripPrefix = stripPrefix;
  }

  public String getServicePlanId() {
    return servicePlanId;
  }

  public void setServicePlanId(String servicePlanId) {
    this.servicePlanId = servicePlanId;
  }

  public String getRouteType() {
    return routeType;
  }

  public void setRouteType(String routeType) {
    this.routeType = routeType;
  }

  public boolean isPreferURL() {
    return preferURL;
  }

  public void setPreferURL(boolean preferURL) {
    this.preferURL = preferURL;
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
    RoutePO routePO = (RoutePO) o;
    return qualityEnabled == routePO.qualityEnabled &&
        stripPrefix == routePO.stripPrefix &&
        preferURL == routePO.preferURL &&
        Objects.equals(routeId, routePO.routeId) &&
        Objects.equals(path, routePO.path) &&
        Objects.equals(targetUri, routePO.targetUri) &&
        Objects.equals(targetServiceId, routePO.targetServiceId) &&
        Objects.equals(servicePlanId, routePO.servicePlanId) &&
        Objects.equals(routeType, routePO.routeType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), routeId, path, targetUri, targetServiceId, qualityEnabled,
        stripPrefix, servicePlanId, routeType, preferURL);
  }
}
