package com.sztvis.domain.dto.api;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/25 上午11:52
 */
public class RealTimeModel implements Serializable {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    private boolean online;

}
