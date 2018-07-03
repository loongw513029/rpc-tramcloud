package com.sztvis.domain.domain;

import java.io.Serializable;
import java.util.UUID;

public class TramLineInfo implements Serializable {
  private Long id = 0L;
  private String guid = UUID.randomUUID().toString().replace("-","");
  private String linecode;
  private String linename;
  private Long departmentid =0L;
  private Double lineupmileage = 0D;
  private Double linedownmileage = 0D;
  private Long upsitenum = 0L;
  private Long downsitenum = 0L;
  private java.sql.Timestamp upstarttime;
  private java.sql.Timestamp downstarttime;
  private java.sql.Timestamp upendtime;
  private java.sql.Timestamp downendtime;
  private Double onstepprice;
  private Double totalprice;
  private String remark;
  private String lats;
  private String longs;
  private String lats2;
  private String longs2;
  private Long sort;
  private Long distance;

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

  public String getLinecode() {
    return linecode;
  }

  public void setLinecode(String linecode) {
    this.linecode = linecode;
  }

  public String getLinename() {
    return linename;
  }

  public void setLinename(String linename) {
    this.linename = linename;
  }

  public Long getDepartmentid() {
    return departmentid;
  }

  public void setDepartmentid(Long departmentid) {
    this.departmentid = departmentid;
  }

  public Double getLineupmileage() {
    return lineupmileage;
  }

  public void setLineupmileage(Double lineupmileage) {
    this.lineupmileage = lineupmileage;
  }

  public Double getLinedownmileage() {
    return linedownmileage;
  }

  public void setLinedownmileage(Double linedownmileage) {
    this.linedownmileage = linedownmileage;
  }

  public Long getUpsitenum() {
    return upsitenum;
  }

  public void setUpsitenum(Long upsitenum) {
    this.upsitenum = upsitenum;
  }

  public Long getDownsitenum() {
    return downsitenum;
  }

  public void setDownsitenum(Long downsitenum) {
    this.downsitenum = downsitenum;
  }

  public java.sql.Timestamp getUpstarttime() {
    return upstarttime;
  }

  public void setUpstarttime(java.sql.Timestamp upstarttime) {
    this.upstarttime = upstarttime;
  }

  public java.sql.Timestamp getDownstarttime() {
    return downstarttime;
  }

  public void setDownstarttime(java.sql.Timestamp downstarttime) {
    this.downstarttime = downstarttime;
  }

  public java.sql.Timestamp getUpendtime() {
    return upendtime;
  }

  public void setUpendtime(java.sql.Timestamp upendtime) {
    this.upendtime = upendtime;
  }

  public java.sql.Timestamp getDownendtime() {
    return downendtime;
  }

  public void setDownendtime(java.sql.Timestamp downendtime) {
    this.downendtime = downendtime;
  }

  public Double getOnstepprice() {
    return onstepprice;
  }

  public void setOnstepprice(Double onstepprice) {
    this.onstepprice = onstepprice;
  }

  public Double getTotalprice() {
    return totalprice;
  }

  public void setTotalprice(Double totalprice) {
    this.totalprice = totalprice;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getLats() {
    return lats;
  }

  public void setLats(String lats) {
    this.lats = lats;
  }

  public String getLongs() {
    return longs;
  }

  public void setLongs(String longs) {
    this.longs = longs;
  }

  public String getLats2() {
    return lats2;
  }

  public void setLats2(String lats2) {
    this.lats2 = lats2;
  }

  public String getLongs2() {
    return longs2;
  }

  public void setLongs2(String longs2) {
    this.longs2 = longs2;
  }

  public Long getSort() {
    return sort;
  }

  public void setSort(Long sort) {
    this.sort = sort;
  }

  public Long getDistance() {
    return distance;
  }

  public void setDistance(Long distance) {
    this.distance = distance;
  }
}
