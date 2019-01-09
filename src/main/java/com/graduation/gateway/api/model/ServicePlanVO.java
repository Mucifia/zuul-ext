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

  protected String name;

  protected String version;

  protected String description;

  protected String status;

  protected String serviceQualityId;

  protected boolean NeedReview;

  protected String security;

  protected String imgSrc;

  protected boolean enable;

  protected String commitBy;

  protected Date commitTime;

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
    return NeedReview;
  }

  public void setNeedReview(boolean needReview) {
    NeedReview = needReview;
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
    return NeedReview == that.NeedReview &&
        enable == that.enable &&
        Objects.equals(servicePlanId, that.servicePlanId) &&
        Objects.equals(name, that.name) &&
        Objects.equals(version, that.version) &&
        Objects.equals(description, that.description) &&
        Objects.equals(status, that.status) &&
        Objects.equals(serviceQualityId, that.serviceQualityId) &&
        Objects.equals(security, that.security) &&
        Objects.equals(imgSrc, that.imgSrc) &&
        Objects.equals(commitBy, that.commitBy) &&
        Objects.equals(commitTime, that.commitTime) &&
        Objects.equals(stateId, that.stateId) &&
        Objects.equals(authType, that.authType) &&
        Objects.equals(apiBaseVOSet, that.apiBaseVOSet);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(servicePlanId, name, version, description, status, serviceQualityId,
            NeedReview, security, imgSrc, enable, commitBy, commitTime, stateId, authType,
            apiBaseVOSet);
  }

  @Override
  public String toString() {
    return "ServicePlanVO{" +
        "servicePlanId='" + servicePlanId + '\'' +
        ", name='" + name + '\'' +
        ", version='" + version + '\'' +
        ", description='" + description + '\'' +
        ", status='" + status + '\'' +
        ", serviceQualityId='" + serviceQualityId + '\'' +
        ", NeedReview=" + NeedReview +
        ", security='" + security + '\'' +
        ", imgSrc='" + imgSrc + '\'' +
        ", enable=" + enable +
        ", commitBy='" + commitBy + '\'' +
        ", commitTime=" + commitTime +
        ", stateId='" + stateId + '\'' +
        ", authType='" + authType + '\'' +
        ", apiBaseVOSet=" + apiBaseVOSet +
        '}';
  }
}
