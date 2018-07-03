package com.sztvis.domain.dto.api;

import java.io.Serializable;

public class BuildFaceModel implements Serializable {

    private String deviceCode;//设备编码
    private String image;//base64编码图片
    private String updateTime;//数据时间
    private int channel;//拍摄通道，哪个摄像头拍摄的

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }
}
