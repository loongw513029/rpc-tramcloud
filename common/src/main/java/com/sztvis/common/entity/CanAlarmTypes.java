package com.sztvis.common.entity;

public enum  CanAlarmTypes {
    ElectricTemperature(1),
    BatteryTemperature(2),
    HybridPowerSystem(3),
    Gsensor(14),
    Videotape(95),
    Vedio(96),
    HDD(97),
    SDCard(98),
    LevelOneFatigue(99),
    LevelTwoFatigue(100),
    Smoking(101),
    Calling(102),
    StaredDown(103),
    Yawn(104),
    GazedAround(105),
    Chating(106),
    LeavePost(107),
    Occlusion(108),
    Radar(109),
    CPUUserRate(110),
    CPUTemp(111),
    MemoryUseRate(112),
    DiskTemp(113),
    ADAS(114),
    SerialPortLose(117),
    CarDistanceRemind(118),
    DangerDistance(119),
    RollLeftRoad(120),
    RoolRightRoad(121),
    LowSpeedBump(122),
    FaceBumpAlarm(123),
    BumpPerson(124),
    RapidAcceleration(125),
    RapidDeceleration(126),
    SharpTurn(127),
    DischargeElectric(183),
    Leakage(184),
    WaterAlarm1(185),
    WaterAlarm2(186);
    private int value;
    private String explian;

    CanAlarmTypes(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }

}
