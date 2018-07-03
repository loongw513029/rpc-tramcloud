package com.sztvis.domain.domain;

import java.io.Serializable;

public class Tramrolemenurelinfo implements Serializable {
  private Long id;
  private Long roleid;
  private String menuids;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getRoleid() {
    return roleid;
  }

  public void setRoleid(Long roleid) {
    this.roleid = roleid;
  }

  public String getMenuids() {
    return menuids;
  }

  public void setMenuids(String menuids) {
    this.menuids = menuids;
  }
}
