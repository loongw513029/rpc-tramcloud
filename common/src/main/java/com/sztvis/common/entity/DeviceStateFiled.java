package com.sztvis.common.entity;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/11 下午6:01
 */
public enum  DeviceStateFiled {
    Videotape("Videotape"),Video("Video"),HardDisk("HardDisk"),SDCard("SDCard"),
    CPUUseRate("CPUUseRate"),CPUTemp("CPUTemp"),MemoryUseRate("MermoryUseRate"),DiskTemp("DiskTemp"),GpsState("GpsState"),
    CanState("CanState"),InternetState("InternetState"),GpsSignalState("GpsSignalState"),SIMBalance("SIMBalance"),
    GpsInspectState("GpsInspectState"),CanInspectState("CanInspectState"),BehaviorInspectState("BehaviorInspectState"),
    RadarInspectState("RadarInspectState"),AdasInspectState("AdasInspectState"),TimingState("TimingState"),OnlineState("OnlineState"),
    SurplusDiskSize("SurplusDiskSize"),SurplusSdcardSize("SurplusSdcardSize"),SIMCardNo("SimCardNo"),IsCanIntegrity("IsCanIntegrity"),
    SSDTemp("SSDTemp"),BoxTemp("BoxTemp"),ExtendTemp1("ExtendTemp1"),ExtendTemp2("ExtendTemp2"),ExtendTemp3("ExtendTemp3"),ExtendTemp4("ExtendTemp4"),
    FiveGModeType("FiveGModeType"),Voltage1("Voltage1"),Voltage2("Voltage2"),GpsSignal("GpsSignal"),InternetSignal("InternetSignal"),
    SIMOperator("SIMOperator");
    private DeviceStateFiled(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private String value;

}
