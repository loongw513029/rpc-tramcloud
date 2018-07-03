package com.sztvis.domain.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

public class TramDepartmentInfo implements Serializable {
  private Long id=0L;
  private String guid = UUID.randomUUID().toString();
  private String code;
  private String departmentname;
  private Long departmenttype=1L;
  private Long parentid;
  private String contactname;
  private String contactphone;
  private Long sort=1L;
  private Long islookcan;
  private Long ishavevedio;
  private Long orgtype=1L;
  private String appname;
  private String remark;
  private Timestamp createtime = new Timestamp(System.currentTimeMillis());

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

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDepartmentname() {
    return departmentname;
  }

  public void setDepartmentname(String departmentname) {
    this.departmentname = departmentname;
  }

  public Long getDepartmenttype() {
    return departmenttype;
  }

  public void setDepartmenttype(Long departmenttype) {
    this.departmenttype = departmenttype;
  }

  public Long getParentid() {
    return parentid;
  }

  public void setParentid(Long parentid) {
    this.parentid = parentid;
  }

  public String getContactname() {
    return contactname;
  }

  public void setContactname(String contactname) {
    this.contactname = contactname;
  }

  public String getContactphone() {
    return contactphone;
  }

  public void setContactphone(String contactphone) {
    this.contactphone = contactphone;
  }

  public Long getSort() {
    return sort;
  }

  public void setSort(Long sort) {
    this.sort = sort;
  }

  public Long getIslookcan() {
    return islookcan;
  }

  public void setIslookcan(Long islookcan) {
    this.islookcan = islookcan;
  }

  public Long getIshavevedio() {
    return ishavevedio;
  }

  public void setIshavevedio(Long ishavevedio) {
    this.ishavevedio = ishavevedio;
  }

  public Long getOrgtype() {
    return orgtype;
  }

  public void setOrgtype(Long orgtype) {
    this.orgtype = orgtype;
  }

  public String getAppname() {
    return appname;
  }

  public void setAppname(String appname) {
    this.appname = appname;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Timestamp createtime) {
    this.createtime = createtime;
  }
}
