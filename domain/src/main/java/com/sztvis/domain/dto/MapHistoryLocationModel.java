package com.sztvis.domain.dto;


import com.sztvis.core.DateStyle;
import com.sztvis.core.DateUtil;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/3/14 下午5:30
 */
public class MapHistoryLocationModel implements Serializable {
    private long id;
    private String updateTime;
    private String longitude;
    private String latitude;
    private double speed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUpdateTime() {
        return DateUtil.StringToString(updateTime, DateStyle.HH_MM_SS);
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
