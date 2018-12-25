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
@Table(name = "zuul_api_model")
public class ApiModelPO extends GatewayPO{

  @Id
  @Column(name = "api_model_id")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  protected String apiModelId;

  @Column(name = "name",nullable = false)
  protected String name;

  public String getApiModelId() {
    return apiModelId;
  }

  public void setApiModelId(String apiModelId) {
    this.apiModelId = apiModelId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiModelPO that = (ApiModelPO) o;
    return Objects.equals(apiModelId, that.apiModelId) &&
        Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {

    return Objects.hash(apiModelId, name);
  }
}
