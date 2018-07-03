package com.sztvis.domain.dto;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/19 上午9:51
 */
public class DeviceViewModel implements Serializable{

    private long id;
    private String deviceCode;
    private String deviceName;
    private String busNumber;
    private String lineName;
    private String departmentName;
    private String driverName;
    private String clientIp;
    private String hostSoftType;
    private String deviceMode;
    private boolean videoSupport;
    private boolean can;
    private boolean radar;
    private boolean aerialView;
    private boolean supportBehavior;
    private boolean supportAdas;
    private int deviceStatus;
    private int bustype;
    private int dChannel;
    private int carriageChannel;
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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getHostSoftType() {
        return hostSoftType;
    }

    public void setHostSoftType(String hostSoftType) {
        this.hostSoftType = hostSoftType;
    }

    public String getDeviceMode() {
        return deviceMode;
    }

    public void setDeviceMode(String deviceMode) {
        this.deviceMode = deviceMode;
    }

    public boolean isVideoSupport() {
        return videoSupport;
    }

    public void setVideoSupport(boolean videoSupport) {
        this.videoSupport = videoSupport;
    }

    public boolean isCan() {
        return can;
    }

    public void setCan(boolean can) {
        this.can = can;
    }

    public boolean isRadar() {
        return radar;
    }

    public void setRadar(boolean radar) {
        this.radar = radar;
    }

    public boolean isAerialView() {
        return aerialView;
    }

    public void setAerialView(boolean aerialView) {
        this.aerialView = aerialView;
    }

    public boolean isSupportBehavior() {
        return supportBehavior;
    }

    public void setSupportBehavior(boolean supportBehavior) {
        this.supportBehavior = supportBehavior;
    }

    public boolean isSupportAdas() {
        return supportAdas;
    }

    public void setSupportAdas(boolean supportAdas) {
        this.supportAdas = supportAdas;
    }

    public int getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(int deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getLastOnlineTime() {
        return lastOnlineTime;
    }

    public void setLastOnlineTime(String lastOnlineTime) {
        this.lastOnlineTime = lastOnlineTime;
    }

    private String lastOnlineTime;

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public int getBustype() {
        return bustype;
    }

    public void setBustype(int bustype) {
        this.bustype = bustype;
    }

    public int getdChannel() {
        return dChannel;
    }

    public void setdChannel(int dChannel) {
        this.dChannel = dChannel;
    }

    public int getCarrieryChannel() {
        return carriageChannel;
    }

    public void setCarrieryChannel(int carrieryChannel) {
        this.carriageChannel = carrieryChannel;
    }
}
