package com.sztvis.domain.dto;


import java.io.Serializable;
import java.util.List;

public class DeviceStatusModelcs  implements Serializable {
    public long Id;
    public String Code;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public int getDeviceStatus() {
        return DeviceStatus;
    }

    public void setDeviceStatus(int deviceStatus) {
        DeviceStatus = deviceStatus;
    }

    public Boolean getOnline() {
        return IsOnline;
    }

    public void setOnline(Boolean online) {
        IsOnline = online;
    }

    public Boolean getGpsState() {
        return GpsState;
    }

    public void setGpsState(Boolean gpsState) {
        GpsState = gpsState;
    }

    public Boolean getCanState() {
        return CanState;
    }

    public void setCanState(Boolean canState) {
        CanState = canState;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public int getHostSoftType() {
        return HostSoftType;
    }

    public void setHostSoftType(int hostSoftType) {
        HostSoftType = hostSoftType;
    }

    public List<Integer> getStatus() {
        return Status;
    }

    public void setStatus(List<Integer> status) {
        Status = status;
    }

    public int DeviceStatus;
    public Boolean IsOnline;
    public Boolean GpsState;
    public Boolean CanState;
    public String DriverName;
    public int HostSoftType;
    public List<Integer> Status;
}
