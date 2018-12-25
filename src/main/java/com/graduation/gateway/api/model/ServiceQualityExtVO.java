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
public class ServiceQualityExtVO {

  protected String serviceQualityExtId;

  protected String serviceQualityId;

  protected String displayName;

  protected String description;

  protected String extKey;

  protected String extValue;

  protected String maxValue;

  protected String minValue;

  protected String timeUnits;

  public String getServiceQualityExtId() {
    return serviceQualityExtId;
  }

  public void setServiceQualityExtId(String serviceQualityExtId) {
    this.serviceQualityExtId = serviceQualityExtId;
  }

  public String getServiceQualityId() {
    return serviceQualityId;
  }

  public void setServiceQualityId(String serviceQualityId) {
    this.serviceQualityId = serviceQualityId;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getExtKey() {
    return extKey;
  }

  public void setExtKey(String extKey) {
    this.extKey = extKey;
  }

  public String getExtValue() {
    return extValue;
  }

  public void setExtValue(String extValue) {
    this.extValue = extValue;
  }

  public String getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(String maxValue) {
    this.maxValue = maxValue;
  }

  public String getMinValue() {
    return minValue;
  }

  public void setMinValue(String minValue) {
    this.minValue = minValue;
  }

  public String getTimeUnits() {
    return timeUnits;
  }

  public void setTimeUnits(String timeUnits) {
    this.timeUnits = timeUnits;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceQualityExtVO that = (ServiceQualityExtVO) o;
    return Objects.equals(serviceQualityExtId, that.serviceQualityExtId) &&
        Objects.equals(serviceQualityId, that.serviceQualityId) &&
        Objects.equals(displayName, that.displayName) &&
        Objects.equals(description, that.description) &&
        Objects.equals(extKey, that.extKey) &&
        Objects.equals(extValue, that.extValue) &&
        Objects.equals(maxValue, that.maxValue) &&
        Objects.equals(minValue, that.minValue) &&
        Objects.equals(timeUnits, that.timeUnits);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(serviceQualityExtId, serviceQualityId, displayName, description, extKey, extValue,
            maxValue, minValue, timeUnits);
  }
}
