package com.sztvis.domain.dto;

import java.io.Serializable;

public class AppBusViewModel implements Serializable {
    /// <summary>
    /// 设备Id
    /// </summary>
    public long DeviceId;

    public long getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(long deviceId) {
        DeviceId = deviceId;
    }

    public String getDeviceCode() {
        return DeviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        DeviceCode = deviceCode;
    }

    public long getBusId() {
        return BusId;
    }

    public void setBusId(long busId) {
        BusId = busId;
    }

    public String getBusNumber() {
        return BusNumber;
    }

    public void setBusNumber(String busNumber) {
        BusNumber = busNumber;
    }

    public int getBusType() {
        return BusType;
    }

    public void setBusType(int busType) {
        BusType = busType;
    }

    public String getBusTypeName() {
        return BusTypeName;
    }

    public void setBusTypeName(String busTypeName) {
        BusTypeName = busTypeName;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public long getLineId() {
        return LineId;
    }

    public void setLineId(long lineId) {
        LineId = lineId;
    }

    public String getLineName() {
        return LineName;
    }

    public void setLineName(String lineName) {
        LineName = lineName;
    }

    public String getDrvierName() {
        return DrvierName;
    }

    public void setDrvierName(String drvierName) {
        DrvierName = drvierName;
    }

    public double getMileage() {
        return Mileage;
    }

    public void setMileage(double mileage) {
        Mileage = mileage;
    }

    public double getElectric() {
        return Electric;
    }

    public void setElectric(double electric) {
        Electric = electric;
    }

    public double getOil() {
        return Oil;
    }

    public void setOil(double oil) {
        Oil = oil;
    }

    /// <summary>
    /// 设备编码
    /// </summary>
    public String DeviceCode;
    /// <summary>
    /// 车辆Id
    /// </summary>
    public long BusId;
    /// <summary>
    /// 车牌号
    /// </summary>
    public String BusNumber;
    public int BusType;
    /// <summary>
    /// 车辆类型：混合动力
    /// </summary>
    public String BusTypeName;
    /// <summary>
    /// 设备是否在线
    /// </summary>
    public int Status;
    /// <summary>
    /// 线路Id
    /// </summary>
    public long LineId;
    /// <summary>
    /// 线路名称
    /// </summary>
    public String LineName;
    /// <summary>
    /// 司机姓名
    /// </summary>
    public String DrvierName;
    /// <summary>
    /// 短里程
    /// </summary>
    public double Mileage;
    /// <summary>
    /// 耗电
    /// </summary>
    public double Electric;
    /// <summary>
    /// 耗油
    /// </summary>
    public double Oil;
}
