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
@Table(name = "zuul_cors_config")
public class CorsConfigPO extends GatewayPO{

  @Id
  @Column(name = "cors_id")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  protected String corsId;

  @Column(name = "seq")
  protected int seq;

  @Column(name = "message_type")
  protected String messageType;

  @Column(name = "style")
  protected String style;

  @Column(name = "action")
  protected String action;

  @Column(name = "code")
  protected String code;

  @Column(name = "value")
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
    CorsConfigPO that = (CorsConfigPO) o;
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
}
