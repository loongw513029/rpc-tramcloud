package com.sztvis.domain.dto;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/25 上午8:31
 */
public class GpsViewModel  implements Serializable {
    private boolean GpsOnLine;
    private boolean IsOnline;
    private String Location;
    private long deviceId;
    private long Id;
    private String Code;
    private String Speed;
    private String ClientIp;
    private int Channel;
    private Double Rotate;
    private String UpdateTime;
    private String deviceNumber;
    private String iconclass;
    private int state;
    private String dispatch;
    private String Address;
    private String UpTime;

    public boolean isGpsOnLine() {
        return GpsOnLine;
    }

    public void setGpsOnLine(boolean gpsOnLine) {
        GpsOnLine = gpsOnLine;
    }

    public boolean isOnline() {
        return IsOnline;
    }

    public void setOnline(boolean online) {
        IsOnline = online;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getSpeed() {
        return Speed;
    }

    public void setSpeed(String speed) {
        Speed = speed;
    }

    public String getClientIp() {
        return ClientIp;
    }

    public void setClientIp(String clientIp) {
        ClientIp = clientIp;
    }

    public int getChannel() {
        return Channel;
    }

    public void setChannel(int channel) {
        Channel = channel;
    }

    public Double getRotate() {
        return Rotate;
    }

    public void setRotate(Double rotate) {
        Rotate = rotate;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getIconclass() {
        String iconClass = "";
        switch (state){
            case 1:
                iconClass = "Normal";
                break;
            case 2:
                iconClass = "NormalAndStop";
                break;
            case 3:
                iconClass = "NormalAndAlarmAndRun";
                break;
            case 4:
                iconClass = "NormalAndAlarmAndStop";
                break;
            case 5:
                iconClass = "NormalAndGpsFault";
                break;
            case 6:
                iconClass = "NormalAndAlarmAndGpsFault";
                break;
            case 7:
                iconClass = "Offline2";
                break;
            default:
                break;
        }
        return iconClass;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDispatch() {
        return dispatch;
    }

    public void setDispatch(String dispatch) {
        this.dispatch = dispatch;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getUpTime() {
        return UpTime;
    }

    public void setUpTime(String upTime) {
        UpTime = upTime;
    }

    public DispatchViewModel getDispatchInfo() {
        return DispatchInfo;
    }

    public void setDispatchInfo(DispatchViewModel dispatchInfo) {
        DispatchInfo = dispatchInfo;
    }

    private DispatchViewModel DispatchInfo;


}
