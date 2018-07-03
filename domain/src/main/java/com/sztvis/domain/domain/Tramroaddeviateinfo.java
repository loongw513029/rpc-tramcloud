package com.sztvis.domain.domain;

import java.io.Serializable;

public class Tramroaddeviateinfo implements Serializable {
  private Long id;
  private Long lineid;
  private String roadname;
  private Long bustype;
  private String startstation;
  private String endstation;
  private String poliys;
  private Long speed;
  private java.sql.Timestamp createtime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getLineid() {
    return lineid;
  }

  public void setLineid(Long lineid) {
    this.lineid = lineid;
  }

  public String getRoadname() {
    return roadname;
  }

  public void setRoadname(String roadname) {
    this.roadname = roadname;
  }

  public Long getBustype() {
    return bustype;
  }

  public void setBustype(Long bustype) {
    this.bustype = bustype;
  }

  public String getStartstation() {
    return startstation;
  }

  public void setStartstation(String startstation) {
    this.startstation = startstation;
  }

  public String getEndstation() {
    return endstation;
  }

  public void setEndstation(String endstation) {
    this.endstation = endstation;
  }

  public String getPoliys() {
    return poliys;
  }

  public void setPoliys(String poliys) {
    this.poliys = poliys;
  }

  public Long getSpeed() {
    return speed;
  }

  public void setSpeed(Long speed) {
    this.speed = speed;
  }

  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }
}
