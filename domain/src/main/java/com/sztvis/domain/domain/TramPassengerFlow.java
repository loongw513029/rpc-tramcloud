package com.sztvis.domain.domain;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/3/29 上午11:16
 */
public class TramPassengerFlow implements Serializable {
    private long id;
    private String deviceCode;
    private long deviceId;
    private int type;
    private int klNumber1;
    private int klNumber2;

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

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getKlNumber1() {
        return klNumber1;
    }

    public void setKlNumber1(int klNumber1) {
        this.klNumber1 = klNumber1;
    }

    public int getKlNumber2() {
        return klNumber2;
    }

    public void setKlNumber2(int klNumber2) {
        this.klNumber2 = klNumber2;
    }
}
