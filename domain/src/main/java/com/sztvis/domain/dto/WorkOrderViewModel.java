package com.sztvis.domain.dto;

import java.io.Serializable;
import java.util.Date;

public class WorkOrderViewModel implements Serializable {
    public long Id;
    public String Number;
    public String Title;
    public String DeviceCode;
    public long DeviceId;
    public String FaultType;
    public int Audit;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDeviceCode() {
        return DeviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        DeviceCode = deviceCode;
    }

    public long getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(long deviceId) {
        DeviceId = deviceId;
    }

    public String getFaultType() {
        return FaultType;
    }

    public void setFaultType(String faultType) {
        FaultType = faultType;
    }

    public int getAudit() {
        return Audit;
    }

    public void setAudit(int audit) {
        Audit = audit;
    }

    public long getReparUserId() {
        return ReparUserId;
    }

    public void setReparUserId(long reparUserId) {
        ReparUserId = reparUserId;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String realName) {
        RealName = realName;
    }

    public int getLimitTime() {
        return LimitTime;
    }

    public void setLimitTime(int limitTime) {
        LimitTime = limitTime;
    }

    public Date getApplyTime() {
        return ApplyTime;
    }

    public void setApplyTime(Date applyTime) {
        ApplyTime = applyTime;
    }

    public Date getHandleTime() {
        return HandleTime;
    }

    public void setHandleTime(Date handleTime) {
        HandleTime = handleTime;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public long ReparUserId;
    public String RealName;
    public int LimitTime;
    public Date ApplyTime;
    public Date HandleTime;
    public int State;
    public String Remark;
}
