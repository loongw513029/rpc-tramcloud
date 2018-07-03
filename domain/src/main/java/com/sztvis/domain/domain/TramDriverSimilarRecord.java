package com.sztvis.domain.domain;

import java.io.Serializable;

public class TramDriverSimilarRecord implements Serializable {
    private long id=0;
    private long deviceId;
    private String deviceCode;
    private boolean fingerPrintPass = false;//指纹通过
    private boolean drunkDrive = false;//酒驾？默认false
    private boolean faceCompairison;
    private double similar;
    private String driverPics;
    private String updateTime;

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

    public boolean isFingerPrintPass() {
        return fingerPrintPass;
    }

    public void setFingerPrintPass(boolean fingerPrintPass) {
        this.fingerPrintPass = fingerPrintPass;
    }

    public boolean isDrunkDrive() {
        return drunkDrive;
    }

    public void setDrunkDrive(boolean drunkDrive) {
        this.drunkDrive = drunkDrive;
    }

    public boolean isFaceCompairison() {
        return faceCompairison;
    }

    public void setFaceCompairison(boolean faceCompairison) {
        this.faceCompairison = faceCompairison;
    }

    public double getSimilar() {
        return similar;
    }

    public void setSimilar(double similar) {
        this.similar = similar;
    }

    public String getDriverPics() {
        return driverPics;
    }

    public void setDriverPics(String driverPics) {
        this.driverPics = driverPics;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public TramDriverSimilarRecord(long deviceId, String deviceCode, boolean fingerPrintPass, boolean drunkDrive, boolean faceCompairison, double similar, String driverPics, String updateTime) {
        this.deviceId = deviceId;
        this.deviceCode = deviceCode;
        this.fingerPrintPass = fingerPrintPass;
        this.drunkDrive = drunkDrive;
        this.faceCompairison = faceCompairison;
        this.similar = similar;
        this.driverPics = driverPics;
        this.updateTime = updateTime;
    }
}
