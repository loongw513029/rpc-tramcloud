package com.sztvis.domain.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "TramCanInfo")
public class TramCanInfo implements Serializable{
  private String guid;
  private Long deviceid;
  private String devicecode;
  private String updatetime;
  private String batteryvoltage;
  private String batterycurrent;
  private String busstall;
  private String baterysoc;
  private String motorspeed;
  private String enginefuelrae;
  private String gasusetotal;
  private String totalmileage;
  private String shortmileage;
  private String fueleconomy;
  private String fuelusespeed;
  private String oilpressure;
  private String pressure1;
  private String pressure2;
  private String remainingoil;
  private String speed;
  private String watertemperature;
  private String rotationalspeed;
  private String totaloilconsumption;
  private String voltage;
  private String tirelayoutnumber;
  private String tirenumber1;
  private String tirepressure1;
  private String tirepressure2;
  private String tirenumber2;
  private String outcartemperature;
  private String incartemperature;
  private String createtime;
  private ElectricCanInfo electricCanInfo;
  private List<TramCanActinfo> acts;

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

  public String getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(String updatetime) {
    this.updatetime = updatetime;
  }

  public String getBatteryvoltage() {
    return batteryvoltage;
  }

  public void setBatteryvoltage(String batteryvoltage) {
    this.batteryvoltage = batteryvoltage;
  }

  public String getBatterycurrent() {
    return batterycurrent;
  }

  public void setBatterycurrent(String batterycurrent) {
    this.batterycurrent = batterycurrent;
  }

  public String getBusstall() {
    return busstall;
  }

  public void setBusstall(String busstall) {
    this.busstall = busstall;
  }

  public String getBaterysoc() {
    return baterysoc;
  }

  public void setBaterysoc(String baterysoc) {
    this.baterysoc = baterysoc;
  }

  public String getMotorspeed() {
    return motorspeed;
  }

  public void setMotorspeed(String motorspeed) {
    this.motorspeed = motorspeed;
  }

  public String getEnginefuelrae() {
    return enginefuelrae;
  }

  public void setEnginefuelrae(String enginefuelrae) {
    this.enginefuelrae = enginefuelrae;
  }

  public String getGasusetotal() {
    return gasusetotal;
  }

  public void setGasusetotal(String gasusetotal) {
    this.gasusetotal = gasusetotal;
  }

  public String getTotalmileage() {
    return totalmileage;
  }

  public void setTotalmileage(String totalmileage) {
    this.totalmileage = totalmileage;
  }

  public String getShortmileage() {
    return shortmileage;
  }

  public void setShortmileage(String shortmileage) {
    this.shortmileage = shortmileage;
  }

  public String getFueleconomy() {
    return fueleconomy;
  }

  public void setFueleconomy(String fueleconomy) {
    this.fueleconomy = fueleconomy;
  }

  public String getFuelusespeed() {
    return fuelusespeed;
  }

  public void setFuelusespeed(String fuelusespeed) {
    this.fuelusespeed = fuelusespeed;
  }

  public String getOilpressure() {
    return oilpressure;
  }

  public void setOilpressure(String oilpressure) {
    this.oilpressure = oilpressure;
  }

  public String getPressure1() {
    return pressure1;
  }

  public void setPressure1(String pressure1) {
    this.pressure1 = pressure1;
  }

  public String getPressure2() {
    return pressure2;
  }

  public void setPressure2(String pressure2) {
    this.pressure2 = pressure2;
  }

  public String getRemainingoil() {
    return remainingoil;
  }

  public void setRemainingoil(String remainingoil) {
    this.remainingoil = remainingoil;
  }

  public String getSpeed() {
    return speed;
  }

  public void setSpeed(String speed) {
    this.speed = speed;
  }

  public String getWatertemperature() {
    return watertemperature;
  }

  public void setWatertemperature(String watertemperature) {
    this.watertemperature = watertemperature;
  }

  public String getRotationalspeed() {
    return rotationalspeed;
  }

  public void setRotationalspeed(String rotationalspeed) {
    this.rotationalspeed = rotationalspeed;
  }

  public String getTotaloilconsumption() {
    return totaloilconsumption;
  }

  public void setTotaloilconsumption(String totaloilconsumption) {
    this.totaloilconsumption = totaloilconsumption;
  }

  public String getVoltage() {
    return voltage;
  }

  public void setVoltage(String voltage) {
    this.voltage = voltage;
  }

  public String getTirelayoutnumber() {
    return tirelayoutnumber;
  }

  public void setTirelayoutnumber(String tirelayoutnumber) {
    this.tirelayoutnumber = tirelayoutnumber;
  }

  public String getTirenumber1() {
    return tirenumber1;
  }

  public void setTirenumber1(String tirenumber1) {
    this.tirenumber1 = tirenumber1;
  }

  public String getTirepressure1() {
    return tirepressure1;
  }

  public void setTirepressure1(String tirepressure1) {
    this.tirepressure1 = tirepressure1;
  }

  public String getTirepressure2() {
    return tirepressure2;
  }

  public void setTirepressure2(String tirepressure2) {
    this.tirepressure2 = tirepressure2;
  }

  public String getTirenumber2() {
    return tirenumber2;
  }

  public void setTirenumber2(String tirenumber2) {
    this.tirenumber2 = tirenumber2;
  }

  public String getOutcartemperature() {
    return outcartemperature;
  }

  public void setOutcartemperature(String outcartemperature) {
    this.outcartemperature = outcartemperature;
  }

  public String getIncartemperature() {
    return incartemperature;
  }

  public void setIncartemperature(String incartemperature) {
    this.incartemperature = incartemperature;
  }

  public String getCreatetime() {
    return createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }

  public ElectricCanInfo getElectricCanInfo() {
    return electricCanInfo;
  }

  public void setElectricCanInfo(ElectricCanInfo electricCanInfo) {
    this.electricCanInfo = electricCanInfo;
  }

  public List<TramCanActinfo> getActs() {
    return acts;
  }

  public void setActs(List<TramCanActinfo> acts) {
    this.acts = acts;
  }
}
