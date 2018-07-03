package com.sztvis.domain.dto.api;

import java.io.Serializable;

public class SchoolFaceFrom implements Serializable {
    private String deviceCode;
    private String updateTime;
    //指纹通过?
    private boolean fingerPrint;
    //酒驾？
    private boolean drunkDrive;
    //人脸通过？
    private boolean faceCompair;
    //相似度
    private double similar;

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(boolean fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public boolean isDrunkDrive() {
        return drunkDrive;
    }

    public void setDrunkDrive(boolean drunkDrive) {
        this.drunkDrive = drunkDrive;
    }

    public boolean isFaceCompair() {
        return faceCompair;
    }

    public void setFaceCompair(boolean faceCompair) {
        this.faceCompair = faceCompair;
    }

    public double getSimilar() {
        return similar;
    }

    public void setSimilar(double similar) {
        this.similar = similar;
    }
}
