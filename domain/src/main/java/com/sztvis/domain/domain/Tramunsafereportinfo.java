package com.sztvis.domain.domain;

import java.io.Serializable;

public class Tramunsafereportinfo implements Serializable {
  private Long id;
  private Long deviceid;
  private String devicecode;
  private java.sql.Timestamp updatetime;
  public Long carunstopingthenopendoor;
  public Long cargoingthenunclosedoor;
  public Long neutralandtravel;
  public Long reversingspeeding;
  public Long travelatnight;
  public Long starttravelspeeding;
  public Long enginestalledtravel;
  public Long revvingup;
  public Long quickslowdown;
  public Long emergencybrake;
  public Long uncivilizedwhistle;
  public Long zebracrossinguncomity;
  public Long speedingtravel;
  public java.sql.Timestamp createtime;

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

  public Long getCarunstopingthenopendoor() {
    return carunstopingthenopendoor;
  }

  public void setCarunstopingthenopendoor(Long carunstopingthenopendoor) {
    this.carunstopingthenopendoor = carunstopingthenopendoor;
  }

  public Long getCargoingthenunclosedoor() {
    return cargoingthenunclosedoor;
  }

  public void setCargoingthenunclosedoor(Long cargoingthenunclosedoor) {
    this.cargoingthenunclosedoor = cargoingthenunclosedoor;
  }

  public Long getNeutralandtravel() {
    return neutralandtravel;
  }

  public void setNeutralandtravel(Long neutralandtravel) {
    this.neutralandtravel = neutralandtravel;
  }

  public Long getReversingspeeding() {
    return reversingspeeding;
  }

  public void setReversingspeeding(Long reversingspeeding) {
    this.reversingspeeding = reversingspeeding;
  }

  public Long getTravelatnight() {
    return travelatnight;
  }

  public void setTravelatnight(Long travelatnight) {
    this.travelatnight = travelatnight;
  }

  public Long getStarttravelspeeding() {
    return starttravelspeeding;
  }

  public void setStarttravelspeeding(Long starttravelspeeding) {
    this.starttravelspeeding = starttravelspeeding;
  }

  public Long getEnginestalledtravel() {
    return enginestalledtravel;
  }

  public void setEnginestalledtravel(Long enginestalledtravel) {
    this.enginestalledtravel = enginestalledtravel;
  }

  public Long getRevvingup() {
    return revvingup;
  }

  public void setRevvingup(Long revvingup) {
    this.revvingup = revvingup;
  }

  public Long getQuickslowdown() {
    return quickslowdown;
  }

  public void setQuickslowdown(Long quickslowdown) {
    this.quickslowdown = quickslowdown;
  }

  public Long getEmergencybrake() {
    return emergencybrake;
  }

  public void setEmergencybrake(Long emergencybrake) {
    this.emergencybrake = emergencybrake;
  }

  public Long getUncivilizedwhistle() {
    return uncivilizedwhistle;
  }

  public void setUncivilizedwhistle(Long uncivilizedwhistle) {
    this.uncivilizedwhistle = uncivilizedwhistle;
  }

  public Long getZebracrossinguncomity() {
    return zebracrossinguncomity;
  }

  public void setZebracrossinguncomity(Long zebracrossinguncomity) {
    this.zebracrossinguncomity = zebracrossinguncomity;
  }

  public Long getSpeedingtravel() {
    return speedingtravel;
  }

  public void setSpeedingtravel(Long speedingtravel) {
    this.speedingtravel = speedingtravel;
  }

  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }
}
