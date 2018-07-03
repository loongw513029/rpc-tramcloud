package com.sztvis.domain.domain;

import java.io.Serializable;

public class Trambusactioninfo  implements Serializable {
  private Long id;
  private String guid;
  private Long deviceid;
  private String devicecode;
  private java.sql.Timestamp updatetime;
  private Long year;
  private Long month;
  private Long day;
  private Long hour;
  private Long minute;
  private Long second;
  private Long actionkey;
  private Long actionvalue;
  private String createtime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
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

  public Long getYear() {
    return year;
  }

  public void setYear(Long year) {
    this.year = year;
  }

  public Long getMonth() {
    return month;
  }

  public void setMonth(Long month) {
    this.month = month;
  }

  public Long getDay() {
    return day;
  }

  public void setDay(Long day) {
    this.day = day;
  }

  public Long getHour() {
    return hour;
  }

  public void setHour(Long hour) {
    this.hour = hour;
  }

  public Long getMinute() {
    return minute;
  }

  public void setMinute(Long minute) {
    this.minute = minute;
  }

  public Long getSecond() {
    return second;
  }

  public void setSecond(Long second) {
    this.second = second;
  }

  public Long getActionkey() {
    return actionkey;
  }

  public void setActionkey(Long actionkey) {
    this.actionkey = actionkey;
  }

  public Long getActionvalue() {
    return actionvalue;
  }

  public void setActionvalue(Long actionvalue) {
    this.actionvalue = actionvalue;
  }

  public String getCreatetime() {
    return createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }
}
