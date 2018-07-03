package com.sztvis.domain.dto;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/23 下午3:34
 */
public class AlarmViewModel implements Serializable {
    private long id;
    private long deviceid;
    private String devicecode;
    private String departmentname;
    private String busnumber;
    private String linename;
    private String alarmname;
    private String updatetime;
    private String location;
    private double speed;
    private double distance;
    private boolean isbrake;
    private String value;
    private String path;
    private int parentalarmtype;
    private String alarmvideopath;
    public CurrentCanModel can;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(long deviceid) {
        this.deviceid = deviceid;
    }

    public String getDevicecode() {
        return devicecode;
    }

    public void setDevicecode(String devicecode) {
        this.devicecode = devicecode;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getBusnumber() {
        return busnumber;
    }

    public void setBusnumber(String busnumber) {
        this.busnumber = busnumber;
    }

    public String getLinename() {
        return linename;
    }

    public void setLinename(String linename) {
        this.linename = linename;
    }

    public String getAlarmname() {
        return alarmname;
    }

    public void setAlarmname(String alarmname) {
        this.alarmname = alarmname;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public boolean isIsbrake() {
        return isbrake;
    }

    public void setIsbrake(boolean isbrake) {
        this.isbrake = isbrake;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getParentalarmtype() {
        return parentalarmtype;
    }

    public void setParentalarmtype(int parentalarmtype) {
        this.parentalarmtype = parentalarmtype;
    }

    public String getAlarmvideopath() {
        return alarmvideopath;
    }

    public void setAlarmvideopath(String alarmvideopath) {
        this.alarmvideopath = alarmvideopath;
    }

    public CurrentCanModel getCan() {
        return can;
    }

    public void setCan(CurrentCanModel can) {
        this.can = can;
    }

    public static class CurrentCanModel
    {
        /// <summary>
        /// 车速
        /// </summary>
        public String speed;
        /// <summary>
        /// 是否踩刹车
        /// </summary>
        public Boolean isBreak;
        /// <summary>
        /// 距离
        /// </summary>
        public double distance;

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }

        public Boolean getBreak() {
            return isBreak;
        }

        public void setBreak(Boolean aBreak) {
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

