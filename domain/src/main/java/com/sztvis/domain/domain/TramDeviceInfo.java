package com.sztvis.domain.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class TramDeviceInfo  implements Serializable {
  private Long id;
  private String guid;
  private Long busid;
  private Long departmentid;
  private Long lineid;
  private String devicecode;
  private String devicename;
  private String clientip;
  private String machine;
  private boolean ispositive;
  private boolean videosupport;
  private Long videochannel;
  private Long dchannel;
  private Long carriagechannel;
  private Long devicetypeid;
  private Long canbustypeid;
  private String devicemode;
  private Long hostsofttype;
  private Long disksize;
  private Long sdcardsize;
  private Long devicestatus;
  private boolean aerialview;
  private Long aerialchannel;
  private boolean barrier;
  private boolean can;
  private boolean radar;
  private boolean supportbehavior;
  private boolean supportadas;
  private boolean passengerflow;
  private Long speeduse;
  private Timestamp createtime;
  private Timestamp lastonlinetime;

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

  public Long getBusid() {
    return busid;
  }

  public void setBusid(Long busid) {
    this.busid = busid;
  }

  public Long getDepartmentid() {
    return departmentid;
  }

  public void setDepartmentid(Long departmentid) {
    this.departmentid = departmentid;
  }

  public Long getLineid() {
    return lineid;
  }

  public void setLineid(Long lineid) {
    this.lineid = lineid;
  }

  public String getDevicecode() {
    return devicecode;
  }

  public void setDevicecode(String devicecode) {
    this.devicecode = devicecode;
  }

  public String getDevicename() {
    return devicename;
  }

  public void setDevicename(String devicename) {
    this.devicename = devicename;
  }

  public String getClientip() {
    return clientip;
  }

  public void setClientip(String clientip) {
    this.clientip = clientip;
  }

  public String getMachine() {
    return machine;
  }

  public void setMachine(String machine) {
    this.machine = machine;
  }

  public boolean IsPositive() {
    return ispositive;
  }

  public void setIspositive(boolean ispositive) {
    this.ispositive = ispositive;
  }

  public boolean isVideosupport() {
    return videosupport;
  }

  public void setVideosupport(boolean videosupport) {
    this.videosupport = videosupport;
  }

  public Long getVideochannel() {
    return videochannel;
  }

  public void setVideochannel(Long videochannel) {
    this.videochannel = videochannel;
  }

  public Long getDchannel() {
    return dchannel;
  }

  public void setDchannel(Long dchannel) {
    this.dchannel = dchannel;
  }

  public Long getCarriagechannel() {
    return carriagechannel;
  }

  public void setCarriagechannel(Long carriagechannel) {
    this.carriagechannel = carriagechannel;
  }

  public Long getDevicetypeid() {
    return devicetypeid;
  }

  public void setDevicetypeid(Long devicetypeid) {
    this.devicetypeid = devicetypeid;
  }

  public Long getCanbustypeid() {
    return canbustypeid;
  }

  public void setCanbustypeid(Long canbustypeid) {
    this.canbustypeid = canbustypeid;
  }

  public String getDevicemode() {
    return devicemode;
  }

  public void setDevicemode(String devicemode) {
    this.devicemode = devicemode;
  }

  public Long getHostsofttype() {
    return hostsofttype;
  }

  public void setHostsofttype(Long hostsofttype) {
    this.hostsofttype = hostsofttype;
  }

  public Long getDisksize() {
    return disksize;
  }

  public void setDisksize(Long disksize) {
    this.disksize = disksize;
  }

  public Long getSdcardsize() {
    return sdcardsize;
  }

  public void setSdcardsize(Long sdcardsize) {
    this.sdcardsize = sdcardsize;
  }

  public Long getDevicestatus() {
    return devicestatus;
  }

  public void setDevicestatus(Long devicestatus) {
    this.devicestatus = devicestatus;
  }

  public boolean isAerialview() {
    return aerialview;
  }

  public void setAerialview(boolean aerialview) {
    this.aerialview = aerialview;
  }

  public Long getAerialchannel() {
    return aerialchannel;
  }

  public void setAerialchannel(Long aerialchannel) {
    this.aerialchannel = aerialchannel;
  }

  public boolean isBarrier() {
    return barrier;
  }

  public void setBarrier(boolean barrier) {
    this.barrier = barrier;
  }

  public boolean isCan() {
    return can;
  }

  public void setCan(boolean can) {
    this.can = can;
  }

  public boolean isRadar() {
    return radar;
  }

  public void setRadar(boolean radar) {
    this.radar = radar;
  }

  public boolean isSupportbehavior() {
    return supportbehavior;
  }

  public void setSupportbehavior(boolean supportbehavior) {
    this.supportbehavior = supportbehavior;
  }

  public boolean isSupportadas() {
    return supportadas;
  }

  public void setSupportadas(boolean supportadas) {
    this.supportadas = supportadas;
  }

  public Long getSpeeduse() {
    return speeduse;
  }

  public void setSpeeduse(Long speeduse) {
    this.speeduse = speeduse;
  }

  public Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Timestamp createtime) {
    this.createtime = createtime;
  }

  public Timestamp getLastonlinetime() {
    return lastonlinetime;
  }

  public void setLastonlinetime(Timestamp lastonlinetime) {
    this.lastonlinetime = lastonlinetime;
  }

  public boolean isIspositive() {
    return ispositive;
  }

  public boolean isPassengerflow() {
    return passengerflow;
  }

  public void setPassengerflow(boolean passengerflow) {
    this.passengerflow = passengerflow;
  }
}
