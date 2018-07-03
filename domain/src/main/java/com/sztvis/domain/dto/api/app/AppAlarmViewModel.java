package com.sztvis.domain.dto.api.app;

import java.io.Serializable;

public class AppAlarmViewModel implements Serializable {
    private long id;
    private String deviceCode;
    private String busNumber;
    private String lineName;
    private String departmentName;
    private int alarmKey;
    private String alarmName;
    private int level;
    private String updateTime;
    private String alarmValue;
    private String location;
    private double speed;
    private boolean isBrake;
    private double distance;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isBrake() {
        return isBrake;
    }

    public void setBrake(boolean brake) {
        isBrake = brake;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    private CurrentCanModel can;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getAlarmKey() {
        return alarmKey;
    }

    public void setAlarmKey(int alarmKey) {
        this.alarmKey = alarmKey;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getAlarmValue() {
        return alarmValue;
    }

    public void setAlarmValue(String alarmValue) {
        this.alarmValue = alarmValue;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public CurrentCanModel getCan() {
        return can;
    }

    public void setCan(CurrentCanModel can) {
        this.can = can;
    }

    public static class CurrentCanModel{
        private String speed;
        private boolean isBreak;
        private double distance;

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }

        public boolean isBreak() {
            return isBreak;
        }

        public void setBreak(boolean aBreak) {
            isBreak = aBreak;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }
    }
}
