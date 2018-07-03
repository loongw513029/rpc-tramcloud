package com.sztvis.domain.dto;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/3/1 下午4:32
 */
public class DeviceStatusPushModel implements Serializable {
    private long id;
    private String code;
    private boolean isOnline;
    private boolean gpsState;
    private boolean canState;
    private String driverName;
    private int hostSoftType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public boolean isGpsState() {
        return gpsState;
    }

    public void setGpsState(boolean gpsState) {
        this.gpsState = gpsState;
    }

    public boolean isCanState() {
        return canState;
    }

    public void setCanState(boolean canState) {
        this.canState = canState;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getHostSoftType() {
        return hostSoftType;
    }

    public void setHostSoftType(int hostSoftType) {
        this.hostSoftType = hostSoftType;
    }
}
