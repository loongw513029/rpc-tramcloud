package com.sztvis.domain.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "TramRadarInfo")
public class TramRadarInfo implements Serializable {
  private String guid;
  private Long deviceid;
  private String devicecode;
  private java.sql.Timestamp updatetime;
  private Long radar1;
  private Long radar2;
  private Long radar3;
  private Long radar4;
  private Long radar5;
  private Long radar6;
  private Long radar7;
  private Long radar8;
  private Long radar9;
  private Long radar10;
  private Long radar11;
  private Long radar12;
  private Long radar13;
  private Long radar14;
  private Long radar15;
  private Long radar16;
  private java.sql.Timestamp createtime;


  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  public Long getDeviceid() {
    return deviceid;
  }

  public void setDeviceid(Long deviceid) {
    this.deviceid = deviceid;
  }

  public String getDevicecode() {
    return devicecode;
  }

  public void setDevicecode(String devicecode) {
    this.devicecode = devicecode;
  }

  public java.sql.Timestamp getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(java.sql.Timestamp updatetime) {
    this.updatetime = updatetime;
  }

  public Long getRadar1() {
    return radar1;
  }

  public void setRadar1(Long radar1) {
    this.radar1 = radar1;
  }

  public Long getRadar2() {
    return radar2;
  }

  public void setRadar2(Long radar2) {
    this.radar2 = radar2;
  }

  public Long getRadar3() {
    return radar3;
  }

  public void setRadar3(Long radar3) {
    this.radar3 = radar3;
  }

  public Long getRadar4() {
    return radar4;
  }

  public void setRadar4(Long radar4) {
    this.radar4 = radar4;
  }

  public Long getRadar5() {
    return radar5;
  }

  public void setRadar5(Long radar5) {
    this.radar5 = radar5;
  }

  public Long getRadar6() {
    return radar6;
  }

  public void setRadar6(Long radar6) {
    this.radar6 = radar6;
  }

  public Long getRadar7() {
    return radar7;
  }

  public void setRadar7(Long radar7) {
    this.radar7 = radar7;
  }

  public Long getRadar8() {
    return radar8;
  }

  public void setRadar8(Long radar8) {
    this.radar8 = radar8;
  }

  public Long getRadar9() {
    return radar9;
  }

  public void setRadar9(Long radar9) {
    this.radar9 = radar9;
  }

  public Long getRadar10() {
    return radar10;
  }

  public void setRadar10(Long radar10) {
    this.radar10 = radar10;
  }

  public Long getRadar11() {
    return radar11;
  }

  public void setRadar11(Long radar11) {
    this.radar11 = radar11;
  }

  public Long getRadar12() {
    return radar12;
  }

  public void setRadar12(Long radar12) {
    this.radar12 = radar12;
  }

  public Long getRadar13() {
    return radar13;
  }

  public void setRadar13(Long radar13) {
    this.radar13 = radar13;
  }

  public Long getRadar14() {
    return radar14;
  }

  public void setRadar14(Long radar14) {
    this.radar14 = radar14;
  }

  public Long getRadar15() {
    return radar15;
  }

  public void setRadar15(Long radar15) {
    this.radar15 = radar15;
  }

  public Long getRadar16() {
    return radar16;
  }

  public void setRadar16(Long radar16) {
    this.radar16 = radar16;
  }

  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }
}
