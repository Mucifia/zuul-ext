package com.graduation.gateway.api.model;

import java.util.List;
import java.util.Objects;

/**
 * @author: mmy
 * @date: 2018/12/12
 * @description:
 */
public class ServiceQualityVO {

  private String name;

  private String version;

  private String description;

  private String serviceQualityId;

  private String requestLimit;

  private int requestTimeout;

  private String maxConcurrency;

  private boolean cbEnable;

  private int cbRecoverTime;

  private String cbErrorPercentage;

  private String cbRequestVolumeThreshold;

  private String requestLimitQuota;

  private String requestLimitType;

  private String refreshInterval;

  private List<ApiBaseVO> apiBaseVOS;

  private List<ServicePlanVO> servicePlanVOS;

  private String key;

  private int apibindNo;

  private int servicePlanNo;


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

  public List<ApiBaseVO> getApiBaseVOS() {
    return apiBaseVOS;
  }

  public void setApiBaseVOS(List<ApiBaseVO> apiBaseVOS) {
    this.apiBaseVOS = apiBaseVOS;
  }

  public List<ServicePlanVO> getServicePlanVOS() {
    return servicePlanVOS;
  }

  public void setServicePlanVOS(
      List<ServicePlanVO> servicePlanVOS) {
    this.servicePlanVOS = servicePlanVOS;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public int getApibindNo() {
    return apibindNo;
  }

  public void setApibindNo(int apibindNo) {
    this.apibindNo = apibindNo;
  }

  public int getServicePlanNo() {
    return servicePlanNo;
  }

  public void setServicePlanNo(int servicePlanNo) {
    this.servicePlanNo = servicePlanNo;
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
        Objects.equals(name, that.name) &&
        Objects.equals(version, that.version) &&
        Objects.equals(description, that.description) &&
        Objects.equals(serviceQualityId, that.serviceQualityId) &&
        Objects.equals(requestLimit, that.requestLimit) &&
        Objects.equals(maxConcurrency, that.maxConcurrency) &&
        Objects.equals(cbErrorPercentage, that.cbErrorPercentage) &&
        Objects.equals(cbRequestVolumeThreshold, that.cbRequestVolumeThreshold) &&
        Objects.equals(requestLimitQuota, that.requestLimitQuota) &&
        Objects.equals(requestLimitType, that.requestLimitType) &&
        Objects.equals(refreshInterval, that.refreshInterval) &&
        Objects.equals(apiBaseVOS, that.apiBaseVOS) &&
        Objects.equals(servicePlanVOS, that.servicePlanVOS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, version, description, serviceQualityId, requestLimit, requestTimeout,
        maxConcurrency, cbEnable, cbRecoverTime, cbErrorPercentage, cbRequestVolumeThreshold,
        requestLimitQuota, requestLimitType, refreshInterval, apiBaseVOS, servicePlanVOS);
  }

  @Override
  public String toString() {
    return "ServiceQualityVO{" +
        "name='" + name + '\'' +
        ", version='" + version + '\'' +
        ", description='" + description + '\'' +
        ", serviceQualityId='" + serviceQualityId + '\'' +
        ", requestLimit='" + requestLimit + '\'' +
        ", requestTimeout=" + requestTimeout +
        ", maxConcurrency='" + maxConcurrency + '\'' +
        ", cbEnable=" + cbEnable +
        ", cbRecoverTime=" + cbRecoverTime +
        ", cbErrorPercentage='" + cbErrorPercentage + '\'' +
        ", cbRequestVolumeThreshold='" + cbRequestVolumeThreshold + '\'' +
        ", requestLimitQuota='" + requestLimitQuota + '\'' +
        ", requestLimitType='" + requestLimitType + '\'' +
        ", refreshInterval='" + refreshInterval + '\'' +
        ", apiBaseVOS=" + apiBaseVOS +
        ", servicePlanVOS=" + servicePlanVOS +
        '}';
  }
}
