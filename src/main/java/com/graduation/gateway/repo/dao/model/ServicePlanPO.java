package com.graduation.gateway.repo.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author: mmy
 * @date: 2018/12/12
 * @description:
 */
@Entity
@Table(name = "zuul_service_plan")
public class ServicePlanPO  extends GatewayPO{

  @Id
  @Column(name = "service_plan_id")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  protected String servicePlanId;


  @Column(name = "name",nullable = false)
  protected String name;

  @Column(name = "version")
  protected String version;

  @Column(name = "description")
  protected String description;

  @Column(name = "status")
  protected String status;

  @Column(name = "service_quality_id")
  protected String serviceQualityId;

  @Column(name = "is_need_review")
  protected boolean isNeedReview;

  @Column(name = "security")
  protected String security;

  @Column(name = "img_src")
  protected String imgSrc;

  @Column(name = "enable")
  protected boolean enable;

  @Column(name = "commit_by")
  protected String commitBy;

  @Column(name = "commit_time")
  @DateTimeFormat(pattern = "yyyy-MM-dd:HH:mm:ss")
  protected Date commitTime;



  @Column(name = "domain_id")
  protected String domainId;

  @Column(name = "domain_code")
  protected String domainCode;

  @Column(name = "state_id")
  protected String stateId;

  @Column(name = "auth_type")
  protected String auth_type;


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

  public String getAuth_type() {
    return auth_type;
  }

  public void setAuth_type(String auth_type) {
    this.auth_type = auth_type;
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
    ServicePlanPO that = (ServicePlanPO) o;
    return isNeedReview == that.isNeedReview &&
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
        Objects.equals(domainId, that.domainId) &&
        Objects.equals(domainCode, that.domainCode) &&
        Objects.equals(stateId, that.stateId) &&
        Objects.equals(auth_type, that.auth_type);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(super.hashCode(), servicePlanId, name, version, description, status, serviceQualityId,
            isNeedReview, security, imgSrc, enable, commitBy, commitTime, domainId, domainCode,
            stateId, auth_type);
  }
}
