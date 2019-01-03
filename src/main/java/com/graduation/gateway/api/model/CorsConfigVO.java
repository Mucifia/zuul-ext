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
public class CorsConfigVO{

  protected String corsId;

  protected int seq;

  protected String messageType;

  protected String style;

  protected String action;

  protected String code;

  protected String value;

  public String getCorsId() {
    return corsId;
  }

  public void setCorsId(String corsId) {
    this.corsId = corsId;
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
    CorsConfigVO that = (CorsConfigVO) o;
    return seq == that.seq &&
        Objects.equals(corsId, that.corsId) &&
        Objects.equals(messageType, that.messageType) &&
        Objects.equals(style, that.style) &&
        Objects.equals(action, that.action) &&
        Objects.equals(code, that.code) &&
        Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(corsId, seq, messageType, style, action, code, value);
  }

  @Override
  public String toString() {
    return "CorsConfigVO{" +
        "corsId='" + corsId + '\'' +
        ", seq=" + seq +
        ", messageType='" + messageType + '\'' +
        ", style='" + style + '\'' +
        ", action='" + action + '\'' +
        ", code='" + code + '\'' +
        ", value='" + value + '\'' +
        '}';
  }
}
