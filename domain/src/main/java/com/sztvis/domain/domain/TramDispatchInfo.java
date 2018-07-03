package com.sztvis.domain.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "TramDispatchInfo")
public class TramDispatchInfo implements Serializable {

  private String guid;
  private Long deviceid;
  private String devicecode;
  private String updatetime;
  private Long dispatchno;
  private String dispatchname;
  private Long dispatchtype;
  private Long drivingdirection;
  private Long analytical;
  private Long failtype;
  private String image;
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


  public Long getDispatchno() {
    return dispatchno;
  }

  public void setDispatchno(Long dispatchno) {
    this.dispatchno = dispatchno;
  }

  public String getDispatchname() {
    return dispatchname;
  }

  public void setDispatchname(String dispatchname) {
    this.dispatchname = dispatchname;
  }

  public Long getDispatchtype() {
    return dispatchtype;
  }

  public void setDispatchtype(Long dispatchtype) {
    this.dispatchtype = dispatchtype;
  }

  public Long getDrivingdirection() {
    return drivingdirection;
  }

  public void setDrivingdirection(Long drivingdirection) {
    this.drivingdirection = drivingdirection;
  }

  public Long getAnalytical() {
    return analytical;
  }

  public void setAnalytical(Long analytical) {
    this.analytical = analytical;
  }

  public Long getFailtype() {
    return failtype;
  }

  public void setFailtype(Long failtype) {
    this.failtype = failtype;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
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
