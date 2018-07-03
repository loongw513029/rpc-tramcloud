package com.sztvis.domain.domain;

import java.io.Serializable;

public class Tramalarmtypeinfo  implements Serializable {
  private Long id;
  private String typename;
  private Long parentid;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTypename() {
    return typename;
  }

  public void setTypename(String typename) {
    this.typename = typename;
  }

  public Long getParentid() {
    return parentid;
  }

  public void setParentid(Long parentid) {
    this.parentid = parentid;
  }
}
