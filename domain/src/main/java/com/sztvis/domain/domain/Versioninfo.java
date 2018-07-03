package com.sztvis.domain.domain;

import java.io.Serializable;

public class Versioninfo implements Serializable {
  private Long id;
  private String appid;
  private String version;
  private String note;
  private String iosurl;
  private String androidurl;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getIosurl() {
    return iosurl;
  }

  public void setIosurl(String iosurl) {
    this.iosurl = iosurl;
  }

  public String getAndroidurl() {
    return androidurl;
  }

  public void setAndroidurl(String androidurl) {
    this.androidurl = androidurl;
  }
}
