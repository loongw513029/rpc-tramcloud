package com.sztvis.domain.dto;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/3/29 上午11:03
 */
public class InspectView implements Serializable {
    private String devicecode;
    private String updatetime;
    private String[] carimage;

    public String getDevicecode() {
        return devicecode;
    }

    public void setDevicecode(String devicecode) {
        this.devicecode = devicecode;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String[] getCarimage() {
        return carimage;
    }

    public void setCarimage(String[] carimage) {
        this.carimage = carimage;
    }
}
