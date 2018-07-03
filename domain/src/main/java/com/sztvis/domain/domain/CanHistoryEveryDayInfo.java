package com.sztvis.domain.domain;

import java.io.Serializable;

public class CanHistoryEveryDayInfo implements Serializable {
  private Long id;
  private Long deviceid;
  private String updatetime;
  private Double totalmileage = 0D;
  private Double gasonlieavg = 0D;
  private Double electricavg = 0D;
  private Double gasavg = 0D;
  private Long totalfaultnumber = 0L;
  private Long totalcarfaultnumber = 0L;
  private Long faultthreelv = 0L;
  private Long faultsecondlv = 0L;
  private Long faultonelv = 0L;
  private Long unsafenumber = 0L;
  private Long unsafedriver = 0L;
  private Long speedingtotal = 0L;
  private Double runtimelong = 0D;

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

  public String getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(String updatetime) {
    this.updatetime = updatetime;
  }

  public Double getTotalmileage() {
    return totalmileage;
  }

  public void setTotalmileage(Double totalmileage) {
    this.totalmileage = totalmileage;
  }

  public Double getGasonlieavg() {
    return gasonlieavg;
  }

  public void setGasonlieavg(Double gasonlieavg) {
    this.gasonlieavg = gasonlieavg;
  }

  public Double getElectricavg() {
    return electricavg;
  }

  public void setElectricavg(Double electricavg) {
    this.electricavg = electricavg;
  }

  public Double getGasavg() {
    return gasavg;
  }

  public void setGasavg(Double gasavg) {
    this.gasavg = gasavg;
  }

  public Long getTotalfaultnumber() {
    return totalfaultnumber;
  }

  public void setTotalfaultnumber(Long totalfaultnumber) {
    this.totalfaultnumber = totalfaultnumber;
  }

  public Long getTotalcarfaultnumber() {
    return totalcarfaultnumber;
  }

  public void setTotalcarfaultnumber(Long totalcarfaultnumber) {
    this.totalcarfaultnumber = totalcarfaultnumber;
  }

  public Long getFaultthreelv() {
    return faultthreelv;
  }

  public void setFaultthreelv(Long faultthreelv) {
    this.faultthreelv = faultthreelv;
  }

  public Long getFaultsecondlv() {
    return faultsecondlv;
  }

  public void setFaultsecondlv(Long faultsecondlv) {
    this.faultsecondlv = faultsecondlv;
  }

  public Long getFaultonelv() {
    return faultonelv;
  }

  public void setFaultonelv(Long faultonelv) {
    this.faultonelv = faultonelv;
  }

  public Long getUnsafenumber() {
    return unsafenumber;
  }

  public void setUnsafenumber(Long unsafenumber) {
    this.unsafenumber = unsafenumber;
  }

  public Long getUnsafedriver() {
    return unsafedriver;
  }

  public void setUnsafedriver(Long unsafedriver) {
    this.unsafedriver = unsafedriver;
  }

  public Long getSpeedingtotal() {
    return speedingtotal;
  }

  public void setSpeedingtotal(Long speedingtotal) {
    this.speedingtotal = speedingtotal;
  }

  public Double getRuntimelong() {
    return runtimelong;
  }

  public void setRuntimelong(Double runtimelong) {
    this.runtimelong = runtimelong;
  }
}
