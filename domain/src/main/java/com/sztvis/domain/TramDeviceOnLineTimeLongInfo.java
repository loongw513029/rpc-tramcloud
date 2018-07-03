package com.sztvis.domain;

import java.io.Serializable;

public class TramDeviceOnLineTimeLongInfo implements Serializable {
    public long Id ;
    public String DeviceCode ;
    public String OnLineTime ;
    public String OffLineTime ;
    public int TotalTime ;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getDeviceCode() {
        return DeviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        DeviceCode = deviceCode;
    }

    public String getOnLineTime() {
        return OnLineTime;
    }

    public void setOnLineTime(String onLineTime) {
        OnLineTime = onLineTime;
    }

    public String getOffLineTime() {
        return OffLineTime;
    }

    public void setOffLineTime(String offLineTime) {
        OffLineTime = offLineTime;
    }

    public int getTotalTime() {
        return TotalTime;
    }

    public void setTotalTime(int totalTime) {
        TotalTime = totalTime;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String CreateTime ;
}
