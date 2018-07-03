package com.sztvis.domain.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class TramAlarmInfo  implements Serializable {
  private Long id;
  private Long deviceId;
  private String deviceCode;
  private long departmentId;
  private Timestamp updateTime;
  private long parentAlarmType;
  private long alarmType;
  private String value;
  private double speed;
  private double distance;
  private boolean isBrake;
  private String alarmVideoPath;
  private String location;
  private String path;
  private int state;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(Long deviceId) {
    this.deviceId = deviceId;
  }

  public String getDeviceCode() {
    return deviceCode;
  }

  public void setDeviceCode(String deviceCode) {
    this.deviceCode = deviceCode;
  }

  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime = updateTime;
  }

  public long getParentAlarmType() {
    return parentAlarmType;
  }

  public void setParentAlarmType(long parentAlarmType) {
    this.parentAlarmType = parentAlarmType;
  }

  public long getAlarmType() {
    return alarmType;
  }

  public void setAlarmType(long alarmType) {
    this.alarmType = alarmType;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public double getDistance() {
    return distance;
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }

  public boolean isBrake() {
    return isBrake;
  }

  public void setBrake(boolean brake) {
    isBrake = brake;
  }

  public String getAlarmVideoPath() {
    return alarmVideoPath;
  }

  public void setAlarmVideoPath(String alarmVideoPath) {
    this.alarmVideoPath = alarmVideoPath;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public Timestamp getSystemInsertTime() {
    return systemInsertTime;
  }

  public void setSystemInsertTime(Timestamp systemInsertTime) {
    this.systemInsertTime = systemInsertTime;
  }

  private Timestamp systemInsertTime;

  public long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(long departmentId) {
    this.departmentId = departmentId;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}
