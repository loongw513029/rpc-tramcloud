package com.sztvis.domain.dto;

import java.io.Serializable;

public class CanAlarmInfo implements Serializable {
    public CanAlarmInfo(){}
    /// <summary>
    ///
    /// </summary>
    public long Id;
    /// <summary>
    ///
    /// </summary>
    public String Guid;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getGuid() {
        return Guid;
    }

    public void setGuid(String guid) {
        Guid = guid;
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

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }

    public int getHour() {
        return Hour;
    }

    public void setHour(int hour) {
        Hour = hour;
    }

    public int getMinute() {
        return Minute;
    }

    public void setMinute(int minute) {
        Minute = minute;
    }

    public int getSecond() {
        return Second;
    }

    public void setSecond(int second) {
        Second = second;
    }

    public int getAlarmKey() {
        return AlarmKey;
    }

    public void setAlarmKey(int alarmKey) {
        AlarmKey = alarmKey;
    }

    public String getAlarmType() {
        return AlarmType;
    }

    public void setAlarmType(String alarmType) {
        AlarmType = alarmType;
    }

    public String getAlarmValue() {
        return AlarmValue;
    }

    public void setAlarmValue(String alarmValue) {
        AlarmValue = alarmValue;
    }

    public int getAlarmLevel() {
        return AlarmLevel;
    }

    public void setAlarmLevel(int alarmLevel) {
        AlarmLevel = alarmLevel;
    }

    public String getExtras() {
        return Extras;
    }

    public void setExtras(String extras) {
        Extras = extras;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public Boolean getShow() {
        return IsShow;
    }

    public void setShow(Boolean show) {
        IsShow = show;
    }

    /// <summary>
    ///
    /// </summary>
    public long DeviceId;
    /// <summary>
    ///
    /// </summary>
    public String DeviceCode;
    /// <summary>
    ///
    /// </summary>
    public String UpdateTime;
    /// <summary>
    ///
    /// </summary>
    public int Year;
    /// <summary>
    ///
    /// </summary>
    public int Month;
    /// <summary>
    ///
    /// </summary>
    public int Day;
    /// <summary>
    ///
    /// </summary>
    public int Hour;
    /// <summary>
    ///
    /// </summary>
    public int Minute;
    /// <summary>
    ///
    /// </summary>
    public int Second;
    /// <summary>
    /// 报警项，枚举
    /// </summary>
    public int AlarmKey;
    /// <summary>
    /// 1.几号雷达探头 2：倾斜角度 3-5:无值
    /// 6：行为识别报警类型
    ///   1：一级疲劳瞌睡
    ///   2：二级疲劳瞌睡
    ///   3：抽烟
    ///   4：打电话
    ///   5：低头
    ///   6：打哈欠
    ///   7：左顾右盼
    ///   8：聊天
    ///   9:离岗
    ///   10：遮挡
    /// </summary>
    public String AlarmType;
    /// <summary>
    /// 报警结果 Int
    /// </summary>
    public String AlarmValue;
    /// <summary>
    /// 报警等级
    /// </summary>
    public int AlarmLevel;

    public String Extras;
    /// <summary>
    ///
    /// </summary>
    public String CreateTime;

    /// <summary>
    /// 是否显示在页面上
    /// </summary>
    public Boolean IsShow;
}
