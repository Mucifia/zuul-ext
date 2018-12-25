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
public class ServiceQualityVO {

  protected String serviceQualityId;

  protected String requestLimit;

  protected int requestTimeout;

  protected String maxConcurrency;

  protected boolean cbEnable;

  protected int cbRecoverTime;

  protected String cbErrorPercentage;

  protected String cbRequestVolumeThreshold;

  protected int rollingStatsTime;

  protected String requestLimitQuota;

  protected String requestLimitType;

  protected String refreshInterval;

  protected String servicePlanId;

  protected String routeId;


  public String getServiceQualityId() {
    return serviceQualityId;
  }

  public void setServiceQualityId(String serviceQualityId) {
    this.serviceQualityId = serviceQualityId;
  }

  public String getRequestLimit() {
    return requestLimit;
  }

  public void setRequestLimit(String requestLimit) {
    this.requestLimit = requestLimit;
  }

  public int getRequestTimeout() {
    return requestTimeout;
  }

  public void setRequestTimeout(int requestTimeout) {
    this.requestTimeout = requestTimeout;
  }

  public String getMaxConcurrency() {
    return maxConcurrency;
  }

  public void setMaxConcurrency(String maxConcurrency) {
    this.maxConcurrency = maxConcurrency;
  }


  public int getCbRecoverTime() {
    return cbRecoverTime;
  }

  public void setCbRecoverTime(int cbRecoverTime) {
    this.cbRecoverTime = cbRecoverTime;
  }

  public String getCbErrorPercentage() {
    return cbErrorPercentage;
  }

  public void setCbErrorPercentage(String cbErrorPercentage) {
    this.cbErrorPercentage = cbErrorPercentage;
  }

  public String getCbRequestVolumeThreshold() {
    return cbRequestVolumeThreshold;
  }

  public void setCbRequestVolumeThreshold(String cbRequestVolumeThreshold) {
    this.cbRequestVolumeThreshold = cbRequestVolumeThreshold;
  }

  public boolean isCbEnable() {
    return cbEnable;
  }

  public void setCbEnable(boolean cbEnable) {
    this.cbEnable = cbEnable;
  }

  public int getRollingStatsTime() {
    return rollingStatsTime;
  }

  public void setRollingStatsTime(int rollingStatsTime) {
    this.rollingStatsTime = rollingStatsTime;
  }

  public String getRequestLimitQuota() {
    return requestLimitQuota;
  }

  public void setRequestLimitQuota(String requestLimitQuota) {
    this.requestLimitQuota = requestLimitQuota;
  }

  public String getRequestLimitType() {
    return requestLimitType;
  }

  public void setRequestLimitType(String requestLimitType) {
    this.requestLimitType = requestLimitType;
  }

  public String getRefreshInterval() {
    return refreshInterval;
  }

  public void setRefreshInterval(String refreshInterval) {
    this.refreshInterval = refreshInterval;
  }

  public String getServicePlanId() {
    return servicePlanId;
  }

  public void setServicePlanId(String servicePlanId) {
    this.servicePlanId = servicePlanId;
  }

  public String getRouteId() {
    return routeId;
  }

  public void setRouteId(String routeId) {
    this.routeId = routeId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceQualityVO that = (ServiceQualityVO) o;
    return requestTimeout == that.requestTimeout &&
        cbEnable == that.cbEnable &&
        cbRecoverTime == that.cbRecoverTime &&
        rollingStatsTime == that.rollingStatsTime &&
        Objects.equals(serviceQualityId, that.serviceQualityId) &&
        Objects.equals(requestLimit, that.requestLimit) &&
        Objects.equals(maxConcurrency, that.maxConcurrency) &&
        Objects.equals(cbErrorPercentage, that.cbErrorPercentage) &&
        Objects.equals(cbRequestVolumeThreshold, that.cbRequestVolumeThreshold) &&
        Objects.equals(requestLimitQuota, that.requestLimitQuota) &&
        Objects.equals(requestLimitType, that.requestLimitType) &&
        Objects.equals(refreshInterval, that.refreshInterval) &&
        Objects.equals(servicePlanId, that.servicePlanId) &&
        Objects.equals(routeId, that.routeId);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(serviceQualityId, requestLimit, requestTimeout, maxConcurrency, cbEnable,
            cbRecoverTime,
            cbErrorPercentage, cbRequestVolumeThreshold, rollingStatsTime, requestLimitQuota,
            requestLimitType, refreshInterval, servicePlanId, routeId);
  }
}
