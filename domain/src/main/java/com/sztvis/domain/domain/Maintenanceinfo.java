package com.sztvis.domain.domain;

import java.io.Serializable;

public class Maintenanceinfo  implements Serializable {
  private Long id;
  private Long deviceid;
  private String mtdate;
  private Double mtmileage;
  private String project;
  private String nextdate;
  private Double nextmileage;
  private String description;
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

  public String getMtdate() {
    return mtdate;
  }

  public void setMtdate(String mtdate) {
    this.mtdate = mtdate;
  }

  public Double getMtmileage() {
    return mtmileage;
  }

  public void setMtmileage(Double mtmileage) {
    this.mtmileage = mtmileage;
  }

  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }

  public String getNextdate() {
    return nextdate;
  }

  public void setNextdate(String nextdate) {
    this.nextdate = nextdate;
  }

  public Double getNextmileage() {
    return nextmileage;
  }

  public void setNextmileage(Double nextmileage) {
    this.nextmileage = nextmileage;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }
}
