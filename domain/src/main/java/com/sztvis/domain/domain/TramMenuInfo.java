package com.sztvis.domain.domain;

import java.io.Serializable;

public class TramMenuInfo implements Serializable {
  private Long id;
  private String menuname;
  private String icon;
  private Long orderby;
  private Long parentid;
  private String controller;
  private String action;
  private Long level;
  private java.sql.Timestamp createtime;
  private String Url;
  private String Cls;
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMenuname() {
    return menuname;
  }

  public void setMenuname(String menuname) {
    this.menuname = menuname;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public Long getOrderby() {
    return orderby;
  }

  public void setOrderby(Long orderby) {
    this.orderby = orderby;
  }

  public Long getParentid() {
    return parentid;
  }

  public void setParentid(Long parentid) {
    this.parentid = parentid;
  }

  public String getController() {
    return controller;
  }

  public void setController(String controller) {
    this.controller = controller;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public Long getLevel() {
    return level;
  }

  public void setLevel(Long level) {
    this.level = level;
  }

  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }

  public String getUrl() {
    return Url;
  }

  public void setUrl(String url) {
    Url = url;
  }

  public String getCls() {
    return Cls;
  }

  public void setCls(String cls) {
    Cls = cls;
  }
}
