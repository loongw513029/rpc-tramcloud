package com.sztvis.domain.domain;

import java.io.Serializable;

public class Tramadasreportinfo  implements Serializable {
  private Long id;
  private Long deviceid;
  private String devicecode;
  private java.sql.Timestamp updatetime;
  public Long cardistanceremind;
  public Long dangerdistance;
  public Long rollleftroad;
  public Long roolrightroad;
  public Long lowspeedbump;
  public Long facebumpalarm;
  public Long bumpperson;
  public java.sql.Timestamp createtime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getDeviceid() {
    return deviceid;
  }

  public void setDeviceid(Long deviceid) {
    this.deviceid = deviceid;
  }

  public String getDevicecode() {
    return devicecode;
  }

  public void setDevicecode(String devicecode) {
    this.devicecode = devicecode;
  }

  public java.sql.Timestamp getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(java.sql.Timestamp updatetime) {
    this.updatetime = updatetime;
  }

  public Long getCardistanceremind() {
    return cardistanceremind;
  }

  public void setCardistanceremind(Long cardistanceremind) {
    this.cardistanceremind = cardistanceremind;
  }

  public Long getDangerdistance() {
    return dangerdistance;
  }

  public void setDangerdistance(Long dangerdistance) {
    this.dangerdistance = dangerdistance;
  }

  public Long getRollleftroad() {
    return rollleftroad;
  }

  public void setRollleftroad(Long rollleftroad) {
    this.rollleftroad = rollleftroad;
  }

  public Long getRoolrightroad() {
    return roolrightroad;
  }

  public void setRoolrightroad(Long roolrightroad) {
    this.roolrightroad = roolrightroad;
  }

  public Long getLowspeedbump() {
    return lowspeedbump;
  }

  public void setLowspeedbump(Long lowspeedbump) {
    this.lowspeedbump = lowspeedbump;
  }

  public Long getFacebumpalarm() {
    return facebumpalarm;
  }

  public void setFacebumpalarm(Long facebumpalarm) {
    this.facebumpalarm = facebumpalarm;
  }

  public Long getBumpperson() {
    return bumpperson;
  }

  public void setBumpperson(Long bumpperson) {
    this.bumpperson = bumpperson;
  }

  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }
}
