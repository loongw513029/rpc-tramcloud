package com.sztvis.domain.domain;

import java.io.Serializable;

public class Tramloginlogfo implements Serializable {
  private Long id;
  private Long userid;
  private java.sql.Timestamp logintime;
  private Long logintype;
  private String clientid;
  private String clientip;
  private String accesstoken;
  private String refreshtoken;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserid() {
    return userid;
  }

  public void setUserid(Long userid) {
    this.userid = userid;
  }

  public java.sql.Timestamp getLogintime() {
    return logintime;
  }

  public void setLogintime(java.sql.Timestamp logintime) {
    this.logintime = logintime;
  }

  public Long getLogintype() {
    return logintype;
  }

  public void setLogintype(Long logintype) {
    this.logintype = logintype;
  }

  public String getClientid() {
    return clientid;
  }

  public void setClientid(String clientid) {
    this.clientid = clientid;
  }

  public String getClientip() {
    return clientip;
  }

  public void setClientip(String clientip) {
    this.clientip = clientip;
  }

  public String getAccesstoken() {
    return accesstoken;
  }

  public void setAccesstoken(String accesstoken) {
    this.accesstoken = accesstoken;
  }

  public String getRefreshtoken() {
    return refreshtoken;
  }

  public void setRefreshtoken(String refreshtoken) {
    this.refreshtoken = refreshtoken;
  }
}
