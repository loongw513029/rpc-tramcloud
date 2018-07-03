package com.sztvis.domain.domain;

import java.io.Serializable;

public class Trambehaviorreportinfo  implements Serializable {
  private Long id;
  private Long deviceid;
  private String devicecode;
  private java.sql.Timestamp updatetime;
  public Long levelonefatigue;
  public Long leveltwofatigue;
  public Long smoking;
  public Long calling;
  public Long stareddown;
  public Long yawn;
  public Long gazedaround;
  public Long chating;
  public Long leavepost;
  public Long occlusion;
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

  public Long getLevelonefatigue() {
    return levelonefatigue;
  }

  public void setLevelonefatigue(Long levelonefatigue) {
    this.levelonefatigue = levelonefatigue;
  }

  public Long getLeveltwofatigue() {
    return leveltwofatigue;
  }

  public void setLeveltwofatigue(Long leveltwofatigue) {
    this.leveltwofatigue = leveltwofatigue;
  }

  public Long getSmoking() {
    return smoking;
  }

  public void setSmoking(Long smoking) {
    this.smoking = smoking;
  }

  public Long getCalling() {
    return calling;
  }

  public void setCalling(Long calling) {
    this.calling = calling;
  }

  public Long getStareddown() {
    return stareddown;
  }

  public void setStareddown(Long stareddown) {
    this.stareddown = stareddown;
  }

  public Long getYawn() {
    return yawn;
  }

  public void setYawn(Long yawn) {
    this.yawn = yawn;
  }

  public Long getGazedaround() {
    return gazedaround;
  }

  public void setGazedaround(Long gazedaround) {
    this.gazedaround = gazedaround;
  }

  public Long getChating() {
    return chating;
  }

  public void setChating(Long chating) {
    this.chating = chating;
  }

  public Long getLeavepost() {
    return leavepost;
  }

  public void setLeavepost(Long leavepost) {
    this.leavepost = leavepost;
  }

  public Long getOcclusion() {
    return occlusion;
  }

  public void setOcclusion(Long occlusion) {
    this.occlusion = occlusion;
  }

  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }
}
