package com.sztvis.common.entity;

public enum NewHostDataType {
    HEALTH(0),
    GPS(1),
    CAN(2),
    DISPATCH(3),
    ALARM(4),
    HVNVR(5),
    RADAR(6),
    KL(7),
    PAY_TERMINAL(8),
    BUILDFACE(9),
    SCHOOLBUS(10),
    UPLOADIMAGE(100);
    private NewHostDataType(int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    private int value;
}
