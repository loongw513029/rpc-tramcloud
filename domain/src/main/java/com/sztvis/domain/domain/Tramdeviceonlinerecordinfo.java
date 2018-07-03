package com.sztvis.domain.domain;

import java.io.Serializable;

public class Tramdeviceonlinerecordinfo implements Serializable {
  private Long id;
  private String devicecode;
  private String online;
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

  public String getOnline() {
    return online;
  }

  public void setOnline(String online) {
    this.online = online;
  }

  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }
}
