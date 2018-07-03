package com.sztvis.domain.dto.push;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/4/2 上午10:51
 */
public class PushAlarmModel {
    private long id;
    private String deviceCode;
    private int alarmType;
    private String time;
    private String alarmName;
    private String busNumber;
    private String path;
    private String extras;
    private String images;
    private int customId;
    private String longitude;
    private String latitude;

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

    public int getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(int alarmType) {
        this.alarmType = alarmType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getCustomId() {
        return customId;
    }

    public void setCustomId(int customId) {
        this.customId = customId;
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

    public PushAlarmModel(long id, String deviceCode, int alarmType, String time, String alarmName, String busNumber, String path, String extras, String images, int customId) {
        this.id = id;
        this.deviceCode = deviceCode;
        this.alarmType = alarmType;
        this.customId = customId;
        this.time = time;
        this.alarmName = alarmName;
        this.busNumber = busNumber;
        this.path = path;
        this.extras = extras;
        this.images = images;
    }
}
