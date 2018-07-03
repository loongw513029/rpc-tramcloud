package com.sztvis.domain.domain;

import java.io.Serializable;

public class Tramreparinfo implements Serializable {
  private Long id;
  private String number;
  private Long reparuserid;
  private String realname;
  private Long reaprstatus;
  private String remark;
  private String image;
  private java.sql.Timestamp createtime;

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

  public Long getReparuserid() {
    return reparuserid;
  }

  public void setReparuserid(Long reparuserid) {
    this.reparuserid = reparuserid;
  }

  public String getRealname() {
    return realname;
  }

  public void setRealname(String realname) {
    this.realname = realname;
  }

  public Long getReaprstatus() {
    return reaprstatus;
  }

  public void setReaprstatus(Long reaprstatus) {
    this.reaprstatus = reaprstatus;
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

  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }
}
