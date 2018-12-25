package com.graduation.gateway.repo.dao.model;

import com.graduation.gateway.repo.util.IGatewayConstant;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author: mmy
 * @date: 2018/12/12
 * @description: basic attributes for all tables
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class GatewayPO {

  @Column(name = IGatewayConstant.CREATE_BY)
  @CreatedBy
  protected String createBy;

  @Column(name = IGatewayConstant.CREATE_TIME)
  @DateTimeFormat(pattern = "yyyy-MM-dd:HH:mm:ss")
  @CreatedDate
  protected Date createTime;

  @Column(name = IGatewayConstant.UPDATE_BY)
  @LastModifiedBy
  protected String updateBy;

  @Column(name = IGatewayConstant.UPDATE_TIME)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @LastModifiedDate
  protected Date updateTime;

  @Column(name = IGatewayConstant.DELETE_FLAG)
  protected boolean delFlag;

  public String getCreateBy() {
    return createBy;
  }

  public void setCreateBy(String createBy) {
    this.createBy = createBy;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(String updateBy) {
    this.updateBy = updateBy;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public boolean isDelFlag() {
    return delFlag;
  }

  public void setDelFlag(boolean delFlag) {
    this.delFlag = delFlag;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GatewayPO gatewayPO = (GatewayPO) o;
    return delFlag == gatewayPO.delFlag &&
        Objects.equals(createBy, gatewayPO.createBy) &&
        Objects.equals(createTime, gatewayPO.createTime) &&
        Objects.equals(updateBy, gatewayPO.updateBy) &&
        Objects.equals(updateTime, gatewayPO.updateTime);
  }

  @Override
  public int hashCode() {

    return Objects.hash(createBy, createTime, updateBy, updateTime, delFlag);
  }
}
