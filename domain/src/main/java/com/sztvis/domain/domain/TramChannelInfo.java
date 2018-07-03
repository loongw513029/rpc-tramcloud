package com.sztvis.domain.domain;

import java.io.Serializable;

public class TramChannelInfo implements Serializable {
  private Long id;
  private Long deviceid;
  private int no;
  private String channelname;
  private boolean supportptz;

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

  public String getChannelname() {
    return channelname;
  }

  public void setChannelname(String channelname) {
    this.channelname = channelname;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public boolean isSupportptz() {
    return supportptz;
  }

  public void setSupportptz(boolean supportptz) {
    this.supportptz = supportptz;
  }
}

