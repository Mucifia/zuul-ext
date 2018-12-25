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
public class RouteVO {

  protected String routeId;

  protected String path;

  protected String targetUri;

  protected String targetServiceId;

  protected boolean qualityEnabled;

  protected boolean stripPrefix;

  protected String servicePlanId;

  protected String routeType;

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
    RouteVO routeVO = (RouteVO) o;
    return qualityEnabled == routeVO.qualityEnabled &&
        stripPrefix == routeVO.stripPrefix &&
        preferURL == routeVO.preferURL &&
        Objects.equals(routeId, routeVO.routeId) &&
        Objects.equals(path, routeVO.path) &&
        Objects.equals(targetUri, routeVO.targetUri) &&
        Objects.equals(targetServiceId, routeVO.targetServiceId) &&
        Objects.equals(servicePlanId, routeVO.servicePlanId) &&
        Objects.equals(routeType, routeVO.routeType);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(routeId, path, targetUri, targetServiceId, qualityEnabled, stripPrefix, servicePlanId,
            routeType, preferURL);
  }
}
