package com.sztvis.domain.domain;

import java.io.Serializable;
import java.util.UUID;

public class TramDriverInfo implements Serializable {
  private Long id=0L;
  private String guid = UUID.randomUUID().toString();
  private String drivername="";
  private Long gender = 1L;
  private Long departmentid = 1L;
  private String contactphone = "";
  private Long status = 1L;
  private String driverheaderimg = "";
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

  public String getDrivername() {
    return drivername;
  }

  public void setDrivername(String drivername) {
    this.drivername = drivername;
  }

  public Long getGender() {
    return gender;
  }

  public void setGender(Long gender) {
    this.gender = gender;
  }

  public Long getDepartmentid() {
    return departmentid;
  }

  public void setDepartmentid(Long departmentid) {
    this.departmentid = departmentid;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

  public String getDriverheaderimg() {
    return driverheaderimg;
  }

  public void setDriverheaderimg(String driverheaderimg) {
    this.driverheaderimg = driverheaderimg;
  }

  public String getContactphone() {
    return contactphone;
  }

  public void setContactphone(String contactphone) {
    this.contactphone = contactphone;
  }
}
