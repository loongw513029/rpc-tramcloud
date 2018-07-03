package com.sztvis.domain.dto.service;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/11 下午2:54
 */
public class SaveAlarmQuery implements Serializable {
    private String alarmTime;
    private long deviceId;
    private String deviceCode;
    private String value;
    private int alarmType;
    private double speed;
    private double distance;
    private boolean isBrake;
    private String path;
    private String path2;
    public String getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime;
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

    public int getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(int alarmType) {
        this.alarmType = alarmType;
    }



    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isBrake() {
        return isBrake;
    }

    public void setBrake(boolean brake) {
        isBrake = brake;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPath2() {
        return path2;
    }

    public void setPath2(String path2) {
        this.path2 = path2;
    }
}
