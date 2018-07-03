package com.sztvis.domain.domain;

import java.io.Serializable;

public class TramRoleInfo implements Serializable {
  private Long id;
  private String rolename;
  private String remark;
  private Long parentid;
  private Long departmentid;
  private Long lv;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRolename() {
    return rolename;
  }

  public void setRolename(String rolename) {
    this.rolename = rolename;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Long getParentid() {
    return parentid;
  }

  public void setParentid(Long parentid) {
    this.parentid = parentid;
  }

  public Long getDepartmentid() {
    return departmentid;
  }

  public void setDepartmentid(Long departmentid) {
    this.departmentid = departmentid;
  }

  public Long getLv() {
    return lv;
  }

  public void setLv(Long lv) {
    this.lv = lv;
  }
}
