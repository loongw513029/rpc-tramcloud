package com.sztvis.domain.dto;

import java.io.Serializable;

public class SiteSettingsInfo implements Serializable {
    public long Id;
    /// <summary>
    /// 视频播放默认时间
    /// </summary>
    public int VideoPlayTime;
    /// <summary>
    /// 故障划分
    /// </summary>
    public String FaultAlarms;
    public String ServerIp;
    public String Port;
    public double FlceRecognition;
    public int MapSpeedUse;
    public String ApkUrl;

    public double getFlceRecognition() {
        return FlceRecognition;
    }

    public void setFlceRecognition(double flceRecognition) {
        FlceRecognition = flceRecognition;
    }

    /// <summary>
    /// App版本说明
    /// </summary>
    public String VerNotice;
    public String Key;
    public String Value;
    public int Type;
    public int IndexUnit;

    public int AlarmTurn;
    public int AlarmTipTime;
    public int ADASTime;
    public int AutoPlay;

    public int AlarmRelTime;
    /// <summary>
    /// 短信接收号码
    /// </summary>
    public String SMSReceiver;
    public String AppVer;

    public void setServerIp(String serverIp) {
        ServerIp = serverIp;
    }

    public String getPort() {
        return Port;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public int getVideoPlayTime() {
        return VideoPlayTime;
    }

    public void setVideoPlayTime(int videoPlayTime) {
        VideoPlayTime = videoPlayTime;
    }

    public String getFaultAlarms() {
        return FaultAlarms;
    }

    public void setFaultAlarms(String faultAlarms) {
        FaultAlarms = faultAlarms;
    }

    public String getServerIp() {
        return ServerIp;
    }

    public void setPort(String port) {
        Port = port;
    }

    public int getMapSpeedUse() {
        return MapSpeedUse;
    }

    public void setMapSpeedUse(int mapSpeedUse) {
        MapSpeedUse = mapSpeedUse;
    }

    public String getSMSReceiver() {
        return SMSReceiver;
    }

    public void setSMSReceiver(String SMSReceiver) {
        this.SMSReceiver = SMSReceiver;
    }

    public String getAppVer() {
        return AppVer;
    }

    public void setAppVer(String appVer) {
        AppVer = appVer;
    }

    public String getApkUrl() {
        return ApkUrl;
    }

    public void setApkUrl(String apkUrl) {
        ApkUrl = apkUrl;
    }

    public String getVerNotice() {
        return VerNotice;
    }

    public void setVerNotice(String verNotice) {
        VerNotice = verNotice;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public int getIndexUnit() {
        return IndexUnit;
    }

    public void setIndexUnit(int indexUnit) {
        IndexUnit = indexUnit;
    }

    public int getAlarmTurn() {
        return AlarmTurn;
    }

    public void setAlarmTurn(int alarmTurn) {
        AlarmTurn = alarmTurn;
    }

    public int getAlarmTipTime() {
        return AlarmTipTime;
    }

    public void setAlarmTipTime(int alarmTipTime) {
        AlarmTipTime = alarmTipTime;
    }

    public int getADASTime() {
        return ADASTime;
    }

    public void setADASTime(int ADASTime) {
        this.ADASTime = ADASTime;
    }

    public int getAutoPlay() {
        return AutoPlay;
    }

    public void setAutoPlay(int autoPlay) {
        AutoPlay = autoPlay;
    }

    public int getAlarmRelTime() {
        return AlarmRelTime;
    }

    public void setAlarmRelTime(int alarmRelTime) {
        AlarmRelTime = alarmRelTime;
    }

}
