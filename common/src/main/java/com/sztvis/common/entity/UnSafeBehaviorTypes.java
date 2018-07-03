package com.sztvis.common.entity;

public enum UnSafeBehaviorTypes {
    CarUnStopingThenOpenDoor(1),
    CarGoingThenUnCloseDoor(2),
    NeutralAndTravel(3),
    ReversingSpeeding(4),
    TravelAtNight(5),
    StartTravelSpeeding(6),
    EngineStalledTravel(7),
    RevvingUp(8),
    QuickSlowDown(9),
    EmergencyBrake(10),
    UncivilizedWhistle(11),
    ZebraCrossingUnComity(12),
    SpeedingTravel(13);

    private int value;

    UnSafeBehaviorTypes(int value) {
        this.value=value;
    }

    public int getValue() {
        return value;
    }

}
