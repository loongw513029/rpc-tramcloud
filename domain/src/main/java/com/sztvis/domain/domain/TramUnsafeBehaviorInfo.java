package com.sztvis.domain.domain;

import java.io.Serializable;

public class TramUnsafeBehaviorInfo implements Serializable {
  private Long id;
  private Long deviceid;
  private String devicecode;
  private Long unsafetype;
  private Long unsafetime;
  private Double speed;
  private Long ratespeed;
  private java.sql.Timestamp applytime;
  private String location;
  private java.sql.Timestamp createtime;

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

  public Long getUnsafetype() {
    return unsafetype;
  }

  public void setUnsafetype(Long unsafetype) {
    this.unsafetype = unsafetype;
  }

  public Long getUnsafetime() {
    return unsafetime;
  }

  public void setUnsafetime(Long unsafetime) {
    this.unsafetime = unsafetime;
  }

  public Double getSpeed() {
    return speed;
  }

  public void setSpeed(Double speed) {
    this.speed = speed;
  }

  public Long getRatespeed() {
    return ratespeed;
  }

  public void setRatespeed(Long ratespeed) {
    this.ratespeed = ratespeed;
  }

  public java.sql.Timestamp getApplytime() {
    return applytime;
  }

  public void setApplytime(java.sql.Timestamp applytime) {
    this.applytime = applytime;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }
}
