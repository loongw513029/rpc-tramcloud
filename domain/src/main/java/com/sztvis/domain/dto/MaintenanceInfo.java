package com.sztvis.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class MaintenanceInfo  implements Serializable {
    public long Id;
    public long DeviceId;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

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

    public String getMtDate() {
        return MtDate;
    }

    public void setMtDate(String mtDate) {
        MtDate = mtDate;
    }

    public BigDecimal getMtMileage() {
        return MtMileage;
    }

    public void setMtMileage(BigDecimal mtMileage) {
        MtMileage = mtMileage;
    }

    public String getProject() {
        return Project;
    }

    public void setProject(String project) {
        Project = project;
    }

    public String getNextDate() {
        return NextDate;
    }

    public void setNextDate(String nextDate) {
        NextDate = nextDate;
    }

    public BigDecimal getNextMileage() {
        return NextMileage;
    }

    public void setNextMileage(BigDecimal nextMileage) {
        NextMileage = nextMileage;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String DeviceCode;
    /// <summary>
    /// 维保时间
    /// </summary>
    public String MtDate;
    /// <summary>
    /// 维保里程
    /// </summary>
    public BigDecimal MtMileage;
    /// <summary>
    /// 维保项目
    /// </summary>
    public String Project;
    /// <summary>
    /// 下次维保时间
    /// </summary>
    public String NextDate;
    /// <summary>
    /// 下次维保里程
    /// </summary>
    public BigDecimal NextMileage;
    /// <summary>
    /// 备注
    /// </summary>
    public String Description;
    public String CreateTime;
}
