package com.sztvis.domain.domain;

import java.io.Serializable;

public class TramBusInfo  implements Serializable {
  private Long id;
  private String guid;
  private String busplate;
  private Long departmentid;
  private Long lineid;
  private Long bustype;
  private String busmode;
  private String busnumber;
  private String busframenumber;
  private Long driverid;
  private Long busstatus;
  private java.sql.Timestamp createtime;

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

  public String getBusplate() {
    return busplate;
  }

  public void setBusplate(String busplate) {
    this.busplate = busplate;
  }

  public Long getDepartmentid() {
    return departmentid;
  }

  public void setDepartmentid(Long departmentid) {
    this.departmentid = departmentid;
  }

  public Long getLineid() {
    return lineid;
  }

  public void setLineid(Long lineid) {
    this.lineid = lineid;
  }

  public Long getBustype() {
    return bustype;
  }

  public void setBustype(Long bustype) {
    this.bustype = bustype;
  }

  public String getBusmode() {
    return busmode;
  }

  public void setBusmode(String busmode) {
    this.busmode = busmode;
  }

  public String getBusnumber() {
    return busnumber;
  }

  public void setBusnumber(String busnumber) {
    this.busnumber = busnumber;
  }

  public String getBusframenumber() {
    return busframenumber;
  }

  public void setBusframenumber(String busframenumber) {
    this.busframenumber = busframenumber;
  }

  public Long getDriverid() {
    return driverid;
  }

  public void setDriverid(Long driverid) {
    this.driverid = driverid;
  }

  public Long getBusstatus() {
    return busstatus;
  }

  public void setBusstatus(Long busstatus) {
    this.busstatus = busstatus;
  }

  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }
}
