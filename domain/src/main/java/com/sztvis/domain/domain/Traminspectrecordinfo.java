package com.sztvis.domain.domain;

import java.io.Serializable;

public class Traminspectrecordinfo implements Serializable {
  private Long id;
  private Long deviceid;
  private String devicecode;
  private Long reparid;
  private Long devicestatetype;
  private String devicestatevalue;
  private java.sql.Timestamp updatetime;

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

  public Long getReparid() {
    return reparid;
  }

  public void setReparid(Long reparid) {
    this.reparid = reparid;
  }

  public Long getDevicestatetype() {
    return devicestatetype;
  }

  public void setDevicestatetype(Long devicestatetype) {
    this.devicestatetype = devicestatetype;
  }

  public String getDevicestatevalue() {
    return devicestatevalue;
  }

  public void setDevicestatevalue(String devicestatevalue) {
    this.devicestatevalue = devicestatevalue;
  }

  public java.sql.Timestamp getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(java.sql.Timestamp updatetime) {
    this.updatetime = updatetime;
  }
}
