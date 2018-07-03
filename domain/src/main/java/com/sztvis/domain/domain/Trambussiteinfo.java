package com.sztvis.domain.domain;

import java.io.Serializable;

public class Trambussiteinfo  implements Serializable {
  private Long id;
  private Long lineid;
  private String location;
  private String sitename;
  private Long sequence;
  private String uplink;
  private java.sql.Timestamp createtime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getLineid() {
    return lineid;
  }

  public void setLineid(Long lineid) {
    this.lineid = lineid;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getSitename() {
    return sitename;
  }

  public void setSitename(String sitename) {
    this.sitename = sitename;
  }

  public Long getSequence() {
    return sequence;
  }

  public void setSequence(Long sequence) {
    this.sequence = sequence;
  }

  public String getUplink() {
    return uplink;
  }

  public void setUplink(String uplink) {
    this.uplink = uplink;
  }

  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }
}
