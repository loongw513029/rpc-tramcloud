package com.sztvis.domain.domain;

import java.io.Serializable;

public class Tramworkorderinfo implements Serializable {
  private Long id;
  private String number;
  private String title;
  private Long deviceid;
  private Long type;
  private Long faulttype;
  private String remark;
  private String image;
  private Long audit;
  private String reason;
  private Long state;
  private Long runerid;
  private Long reparuserid;
  private Long limittime;
  private String noticepush;
  private String noticesms;
  private java.sql.Timestamp applytime;
  private java.sql.Timestamp handletime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Long getDeviceid() {
    return deviceid;
  }

  public void setDeviceid(Long deviceid) {
    this.deviceid = deviceid;
  }

  public Long getType() {
    return type;
  }

  public void setType(Long type) {
    this.type = type;
  }

  public Long getFaulttype() {
    return faulttype;
  }

  public void setFaulttype(Long faulttype) {
    this.faulttype = faulttype;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Long getAudit() {
    return audit;
  }

  public void setAudit(Long audit) {
    this.audit = audit;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public Long getState() {
    return state;
  }

  public void setState(Long state) {
    this.state = state;
  }

  public Long getRunerid() {
    return runerid;
  }

  public void setRunerid(Long runerid) {
    this.runerid = runerid;
  }

  public Long getReparuserid() {
    return reparuserid;
  }

  public void setReparuserid(Long reparuserid) {
    this.reparuserid = reparuserid;
  }

  public Long getLimittime() {
    return limittime;
  }

  public void setLimittime(Long limittime) {
    this.limittime = limittime;
  }

  public String getNoticepush() {
    return noticepush;
  }

  public void setNoticepush(String noticepush) {
    this.noticepush = noticepush;
  }

  public String getNoticesms() {
    return noticesms;
  }

  public void setNoticesms(String noticesms) {
    this.noticesms = noticesms;
  }

  public java.sql.Timestamp getApplytime() {
    return applytime;
  }

  public void setApplytime(java.sql.Timestamp applytime) {
    this.applytime = applytime;
  }

  public java.sql.Timestamp getHandletime() {
    return handletime;
  }

  public void setHandletime(java.sql.Timestamp handletime) {
    this.handletime = handletime;
  }
}
