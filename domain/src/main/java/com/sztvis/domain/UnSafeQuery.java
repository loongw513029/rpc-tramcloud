package com.sztvis.domain;

import java.io.Serializable;

public class UnSafeQuery implements Serializable {
    public int PageNo;

    public int getPageNo() {
        return PageNo;
    }

    public void setPageNo(int pageNo) {
        PageNo = pageNo;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getDayType() {
        return dayType;
    }

    public void setDayType(int dayType) {
        this.dayType = dayType;
    }

    public int getUnSafeType() {
        return unSafeType;
    }

    public void setUnSafeType(int unSafeType) {
        this.unSafeType = unSafeType;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public long getLineId() {
        return lineId;
    }

    public void setLineId(long lineId) {
        this.lineId = lineId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int PageSize;
    public int dayType;
    public int unSafeType;
    public String deviceCode;
    public long lineId;
    public long userId;

}
