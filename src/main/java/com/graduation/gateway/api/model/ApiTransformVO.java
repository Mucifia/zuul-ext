package com.graduation.gateway.api.model;

import java.util.Objects;

/**
 * @author: mmy
 * @date: 2018/12/12
 * @description:
 */
public class ApiTransformVO{

  protected String apiTransformId;

  protected String apiResourceDetailId;

  protected int seq;

  protected String messageType;

  protected String style;

  protected String action;

  protected String code;

  protected String value;

  public String getApiTransformId() {
    return apiTransformId;
  }

  public void setApiTransformId(String apiTransformId) {
    this.apiTransformId = apiTransformId;
  }

  public String getApiResourceDetailId() {
    return apiResourceDetailId;
  }

  public void setApiResourceDetailId(String apiResourceDetailId) {
    this.apiResourceDetailId = apiResourceDetailId;
  }

  public int getSeq() {
    return seq;
  }

  public void setSeq(int seq) {
    this.seq = seq;
  }

  public String getMessageType() {
    return messageType;
  }

  public void setMessageType(String messageType) {
    this.messageType = messageType;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiTransformVO that = (ApiTransformVO) o;
    return seq == that.seq &&
        Objects.equals(apiTransformId, that.apiTransformId) &&
        Objects.equals(apiResourceDetailId, that.apiResourceDetailId) &&
        Objects.equals(messageType, that.messageType) &&
        Objects.equals(style, that.style) &&
        Objects.equals(action, that.action) &&
        Objects.equals(code, that.code) &&
        Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(apiTransformId, apiResourceDetailId, seq, messageType, style, action, code, value);
  }
}
