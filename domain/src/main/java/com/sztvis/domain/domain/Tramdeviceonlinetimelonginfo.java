package com.sztvis.domain.domain;

import java.io.Serializable;

public class Tramdeviceonlinetimelonginfo  implements Serializable {
  private Long id;
  private String devicecode;
  private java.sql.Timestamp onlinetime;
  private java.sql.Timestamp offlinetime;
  private Long totaltime;
  private java.sql.Timestamp createtime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDevicecode() {
    return devicecode;
  }

  public void setDevicecode(String devicecode) {
    this.devicecode = devicecode;
  }

  public java.sql.Timestamp getOnlinetime() {
    return onlinetime;
  }

  public void setOnlinetime(java.sql.Timestamp onlinetime) {
    this.onlinetime = onlinetime;
  }

  public java.sql.Timestamp getOfflinetime() {
    return offlinetime;
  }

  public void setOfflinetime(java.sql.Timestamp offlinetime) {
    this.offlinetime = offlinetime;
  }

  public Long getTotaltime() {
    return totaltime;
  }

  public void setTotaltime(Long totaltime) {
    this.totaltime = totaltime;
  }

  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }
}
