package com.sztvis.domain.domain;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/3/29 上午10:49
 */
public class PayTerminalRecords  implements Serializable {
    private long id;
    private long deviceId;
    private String deviceCode;
    private String updateTime;
    private String payCardNo;
    private String payTime;
    private String location;
    private String siteName;
    private String passengerImage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getPayCardNo() {
        return payCardNo;
    }

    public void setPayCardNo(String payCardNo) {
        this.payCardNo = payCardNo;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getPassengerImage() {
        return passengerImage;
    }

    public void setPassengerImage(String passengerImage) {
        this.passengerImage = passengerImage;
    }
}
