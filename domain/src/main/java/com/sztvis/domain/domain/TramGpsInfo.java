package com.sztvis.domain.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Map;

@Document(collection = "TramGpsInfo")
public class TramGpsInfo implements Serializable {
  private Long deviceid;
  private String devicecode;
  private String updatetime;
  private String longitude;
  private String latitude;
  private Double speed;
  private Double direction;
  private String locationmode;
  private double altitude;
  private Map<Integer,Double> signal;
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

  public String getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(String updatetime) {
    this.updatetime = updatetime;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public Double getSpeed() {
    return speed;
  }

  public void setSpeed(Double speed) {
    this.speed = speed;
  }

  public Double getDirection() {
    return direction;
  }

  public void setDirection(Double direction) {
    this.direction = direction;
  }

  public String getLocationmode() {
    return locationmode;
  }

  public void setLocationmode(String locationmode) {
    this.locationmode = locationmode;
  }

  public double getAltitude() {
    return altitude;
  }

  public void setAltitude(double altitude) {
    this.altitude = altitude;
  }

  public Map<Integer, Double> getSignal() {
    return signal;
  }

  public void setSignal(Map<Integer, Double> signal) {
    this.signal = signal;
  }
}
