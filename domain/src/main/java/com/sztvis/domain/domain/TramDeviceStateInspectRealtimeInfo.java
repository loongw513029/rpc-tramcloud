package com.sztvis.domain.domain;

import java.io.Serializable;

public class TramDeviceStateInspectRealtimeInfo implements Serializable {
  private Long id;
  private Long deviceid;
  private boolean videotape;
  private boolean video;
  private boolean harddisk;
  private boolean sdcard;
  private String cpuuserate;
  private String cputemp;
  private String mermoryuserate;
  private String disktemp;
  private boolean gpsstate;
  private boolean canstate;
  private boolean internetstate;
  private boolean gpssignelstate;
  private Double simbalance;
  private boolean gpsinspectstate;
  private boolean caninspectstate;
  private boolean behaviorinspectstate;
  private boolean radarinspectstate;
  private boolean adasinspectstate;
  private boolean timingstate;
  private String deviceCode;
  private String surplusSdcardSize;
  private String surplusDiskSize;

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

  public String getCpuuserate() {
    return cpuuserate;
  }

  public void setCpuuserate(String cpuuserate) {
    this.cpuuserate = cpuuserate;
  }

  public String getCputemp() {
    return cputemp;
  }

  public void setCputemp(String cputemp) {
    this.cputemp = cputemp;
  }

  public String getMermoryuserate() {
    return mermoryuserate;
  }

  public void setMermoryuserate(String mermoryuserate) {
    this.mermoryuserate = mermoryuserate;
  }

  public String getDisktemp() {
    return disktemp;
  }

  public void setDisktemp(String disktemp) {
    this.disktemp = disktemp;
  }

  public boolean isGpsstate() {
    return gpsstate;
  }

  public void setGpsstate(boolean gpsstate) {
    this.gpsstate = gpsstate;
  }

  public boolean isCanstate() {
    return canstate;
  }

  public void setCanstate(boolean canstate) {
    this.canstate = canstate;
  }

  public boolean isInternetstate() {
    return internetstate;
  }

  public void setInternetstate(boolean internetstate) {
    this.internetstate = internetstate;
  }

  public boolean isGpssignelstate() {
    return gpssignelstate;
  }

  public void setGpssignelstate(boolean gpssignelstate) {
    this.gpssignelstate = gpssignelstate;
  }

  public Double getSimbalance() {
    return simbalance;
  }

  public void setSimbalance(Double simbalance) {
    this.simbalance = simbalance;
  }

  public boolean isGpsinspectstate() {
    return gpsinspectstate;
  }

  public void setGpsinspectstate(boolean gpsinspectstate) {
    this.gpsinspectstate = gpsinspectstate;
  }

  public boolean isCaninspectstate() {
    return caninspectstate;
  }

  public void setCaninspectstate(boolean caninspectstate) {
    this.caninspectstate = caninspectstate;
  }

  public boolean isBehaviorinspectstate() {
    return behaviorinspectstate;
  }

  public void setBehaviorinspectstate(boolean behaviorinspectstate) {
    this.behaviorinspectstate = behaviorinspectstate;
  }

  public boolean isRadarinspectstate() {
    return radarinspectstate;
  }

  public void setRadarinspectstate(boolean radarinspectstate) {
    this.radarinspectstate = radarinspectstate;
  }

  public boolean isAdasinspectstate() {
    return adasinspectstate;
  }

  public void setAdasinspectstate(boolean adasinspectstate) {
    this.adasinspectstate = adasinspectstate;
  }

  public boolean isTimingstate() {
    return timingstate;
  }

  public void setTimingstate(boolean timingstate) {
    this.timingstate = timingstate;
  }

  public String getDeviceCode() {
    return deviceCode;
  }

  public void setDeviceCode(String deviceCode) {
    this.deviceCode = deviceCode;
  }

  public boolean isOnlineState() {
    return onlineState;
  }

  public void setOnlineState(boolean onlineState) {
    this.onlineState = onlineState;
  }

  private boolean onlineState;

  public String getSurplusSdcardSize() {
    return surplusSdcardSize;
  }

  public void setSurplusSdcardSize(String surplusSdcardSize) {
    this.surplusSdcardSize = surplusSdcardSize;
  }

  public String getSurplusDiskSize() {
    return surplusDiskSize;
  }

  public void setSurplusDiskSize(String surplusDiskSize) {
    this.surplusDiskSize = surplusDiskSize;
  }

  public boolean isVideotape() {
    return videotape;
  }

  public void setVideotape(boolean videotape) {
    this.videotape = videotape;
  }

  public boolean isVideo() {
    return video;
  }

  public void setVideo(boolean video) {
    this.video = video;
  }

  public boolean isHarddisk() {
    return harddisk;
  }

  public void setHarddisk(boolean harddisk) {
    this.harddisk = harddisk;
  }

  public boolean isSdcard() {
    return sdcard;
  }

  public void setSdcard(boolean sdcard) {
    this.sdcard = sdcard;
  }
}
