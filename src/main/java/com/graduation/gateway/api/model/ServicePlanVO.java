package com.graduation.gateway.api.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author: mmy
 * @date: 2018/12/12
 * @description:
 */
public class ServicePlanVO{

  protected String servicePlanId;

  protected String appSysId;

  protected String name;

  protected String version;

  protected String description;

  protected String status;

  protected String serviceQualityId;

  protected boolean isNeedReview;

  protected String security;

  protected String imgSrc;

  protected boolean enable;

  protected String commitBy;

  protected Date commitTime;

  protected String appSysCode;

  protected String domainId;

  protected String domainCode;

  protected String stateId;

  protected String authType;

  protected Set<ApiBaseVO> apiBaseVOSet = new HashSet<>();

  public Set<ApiBaseVO> getApiBaseVOSet() {
    return apiBaseVOSet;
  }

  public void setApiBaseVOSet(Set<ApiBaseVO> apiBaseVOSet) {
    this.apiBaseVOSet = apiBaseVOSet;
  }

  public String getServicePlanId() {
    return servicePlanId;
  }

  public void setServicePlanId(String servicePlanId) {
    this.servicePlanId = servicePlanId;
  }

  public String getAppSysId() {
    return appSysId;
  }

  public void setAppSysId(String appSysId) {
    this.appSysId = appSysId;
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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getServiceQualityId() {
    return serviceQualityId;
  }

  public void setServiceQualityId(String serviceQualityId) {
    this.serviceQualityId = serviceQualityId;
  }

  public boolean isNeedReview() {
    return isNeedReview;
  }

  public void setNeedReview(boolean needReview) {
    isNeedReview = needReview;
  }

  public String getSecurity() {
    return security;
  }

  public void setSecurity(String security) {
    this.security = security;
  }

  public String getImgSrc() {
    return imgSrc;
  }

  public void setImgSrc(String imgSrc) {
    this.imgSrc = imgSrc;
  }

  public boolean isEnable() {
    return enable;
  }

  public void setEnable(boolean enable) {
    this.enable = enable;
  }

  public String getCommitBy() {
    return commitBy;
  }

  public void setCommitBy(String commitBy) {
    this.commitBy = commitBy;
  }

  public Date getCommitTime() {
    return commitTime;
  }

  public void setCommitTime(Date commitTime) {
    this.commitTime = commitTime;
  }

  public String getAppSysCode() {
    return appSysCode;
  }

  public void setAppSysCode(String appSysCode) {
    this.appSysCode = appSysCode;
  }

  public String getDomainId() {
    return domainId;
  }

  public void setDomainId(String domainId) {
    this.domainId = domainId;
  }

  public String getDomainCode() {
    return domainCode;
  }

  public void setDomainCode(String domainCode) {
    this.domainCode = domainCode;
  }

  public String getStateId() {
    return stateId;
  }

  public void setStateId(String stateId) {
    this.stateId = stateId;
  }

  public String getAuthType() {
    return authType;
  }

  public void setAuthType(String authType) {
    this.authType = authType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServicePlanVO that = (ServicePlanVO) o;
    return isNeedReview == that.isNeedReview &&
        enable == that.enable &&
        Objects.equals(servicePlanId, that.servicePlanId) &&
        Objects.equals(appSysId, that.appSysId) &&
        Objects.equals(name, that.name) &&
        Objects.equals(version, that.version) &&
        Objects.equals(description, that.description) &&
        Objects.equals(status, that.status) &&
        Objects.equals(serviceQualityId, that.serviceQualityId) &&
        Objects.equals(security, that.security) &&
        Objects.equals(imgSrc, that.imgSrc) &&
        Objects.equals(commitBy, that.commitBy) &&
        Objects.equals(commitTime, that.commitTime) &&
        Objects.equals(appSysCode, that.appSysCode) &&
        Objects.equals(domainId, that.domainId) &&
        Objects.equals(domainCode, that.domainCode) &&
        Objects.equals(stateId, that.stateId) &&
        Objects.equals(authType, that.authType) &&
        Objects.equals(apiBaseVOSet, that.apiBaseVOSet);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(servicePlanId, appSysId, name, version, description, status, serviceQualityId,
            isNeedReview, security, imgSrc, enable, commitBy, commitTime, appSysCode, domainId,
            domainCode, stateId, authType, apiBaseVOSet);
  }
}
