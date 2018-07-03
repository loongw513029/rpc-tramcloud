package com.sztvis.domain;

import java.io.Serializable;

public class UnSafeListViewModel implements Serializable {
    public long DeviceId;
    public long LineId;
    public long DepartmentId;

    public long getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(long deviceId) {
        DeviceId = deviceId;
    }

    public long getLineId() {
        return LineId;
    }

    public void setLineId(long lineId) {
        LineId = lineId;
    }

    public long getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(long departmentId) {
        DepartmentId = departmentId;
    }

    public int getUnSafeType() {
        return UnSafeType;
    }

    public void setUnSafeType(int unSafeType) {
        UnSafeType = unSafeType;
    }

    public int UnSafeType;
}
