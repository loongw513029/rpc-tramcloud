package com.sztvis.domain.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document(collection = "TramDeviceStatusInfo")
public class TramDeviceStatusInfo implements Serializable {

  private String guid;
  private Long deviceid;
  private String devicecode;
  private String updatetime;
  //1:录像状态 2：视频状态 3:硬盘状态 4:SD卡状态 5:硬盘空间 6:SD卡空间 7:时间校准 8:CPU使用率 9:Cpu温度 10：内存使用率 11：硬盘温度
  private Long type;
  private String value1;
  private String value2;
  private String createtime;


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

  public Long getType() {
    return type;
  }

  public void setType(Long type) {
    this.type = type;
  }

  public String getValue1() {
    return value1;
  }

  public void setValue1(String value1) {
    this.value1 = value1;
  }

  public String getValue2() {
    return value2;
  }

  public void setValue2(String value2) {
    this.value2 = value2;
  }

  public String getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(String updatetime) {
    this.updatetime = updatetime;
  }

  public String getCreatetime() {
    return createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }
}
