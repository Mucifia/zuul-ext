package com.graduation.gateway.repo.dao.model;

import java.util.Date;
import java.util.Objects;
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
@Entity
@Table(name = "zuul_operation_history")
public class OperationHistoryPO {

  @Id
  @Column(name = "service_plan_history_id")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  protected String servicePlanHistoryId;

  @Column(name = "operation_type")
  protected String operationType;

  @Column(name = "operation_by")
  protected String operationBy;

  @Column(name = "operation_time")
  @DateTimeFormat(pattern = "yyyy-MM-dd:HH:mm:ss")
  @CreatedDate
  protected Date operationTime;

  @Column(name = "operation_target_name")
  protected String operationTargetName;

  @Column(name = "operation_field_name")
  protected String operationFieldName;

  @Column(name = "operation_pk")
  protected String operationPk;

  @Column(name = "old_value")
  protected String oldValue;

  @Column(name = "new_value")
  protected String newValue;

  public String getServicePlanHistoryId() {
    return servicePlanHistoryId;
  }

  public void setServicePlanHistoryId(String servicePlanHistoryId) {
    this.servicePlanHistoryId = servicePlanHistoryId;
  }

  public String getOperationType() {
    return operationType;
  }

  public void setOperationType(String operationType) {
    this.operationType = operationType;
  }

  public String getOperationBy() {
    return operationBy;
  }

  public void setOperationBy(String operationBy) {
    this.operationBy = operationBy;
  }

  public Date getOperationTime() {
    return operationTime;
  }

  public void setOperationTime(Date operationTime) {
    this.operationTime = operationTime;
  }

  public String getOperationTargetName() {
    return operationTargetName;
  }

  public void setOperationTargetName(String operationTargetName) {
    this.operationTargetName = operationTargetName;
  }

  public String getOperationFieldName() {
    return operationFieldName;
  }

  public void setOperationFieldName(String operationFieldName) {
    this.operationFieldName = operationFieldName;
  }

  public String getOperationPk() {
    return operationPk;
  }

  public void setOperationPk(String operationPk) {
    this.operationPk = operationPk;
  }

  public String getOldValue() {
    return oldValue;
  }

  public void setOldValue(String oldValue) {
    this.oldValue = oldValue;
  }

  public String getNewValue() {
    return newValue;
  }

  public void setNewValue(String newValue) {
    this.newValue = newValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OperationHistoryPO that = (OperationHistoryPO) o;
    return Objects.equals(servicePlanHistoryId, that.servicePlanHistoryId) &&
        Objects.equals(operationType, that.operationType) &&
        Objects.equals(operationBy, that.operationBy) &&
        Objects.equals(operationTime, that.operationTime) &&
        Objects.equals(operationTargetName, that.operationTargetName) &&
        Objects.equals(operationFieldName, that.operationFieldName) &&
        Objects.equals(operationPk, that.operationPk) &&
        Objects.equals(oldValue, that.oldValue) &&
        Objects.equals(newValue, that.newValue);
  }

  @Override
  public int hashCode() {

    return Objects
        .hash(servicePlanHistoryId, operationType, operationBy, operationTime, operationTargetName,
            operationFieldName, operationPk, oldValue, newValue);
  }
}
