package com.sztvis.domain.domain;

import java.io.Serializable;

public class TramElectronicFenceInfo implements Serializable {
  private Long id;
  private String lng;
  private String lat;
  private Long radius;
  private boolean inTrun;
  private boolean outTrun;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLng() {
    return lng;
  }

  public void setLng(String lng) {
    this.lng = lng;
  }

  public String getLat() {
    return lat;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public Long getRadius() {
    return radius;
  }

  public void setRadius(Long radius) {
    this.radius = radius;
  }

  public boolean isInTrun() {
    return inTrun;
  }

  public void setInTrun(boolean inTrun) {
    this.inTrun = inTrun;
  }

  public boolean isOutTrun() {
    return outTrun;
  }

  public void setOutTrun(boolean outTrun) {
    this.outTrun = outTrun;
  }
}
