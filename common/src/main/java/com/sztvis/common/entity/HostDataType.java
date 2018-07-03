package com.sztvis.common.entity;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/11 下午5:04
 */
public enum HostDataType {
    HEALTH(0),
    GPS(1),
    CAN(2),
    DISPATCH(3),
    ALARM(4),
    HVNVR(5),
    RADAR(6),
    HARDWARESTATE(8),
    REALTIMEDVRSTATE(9),
    KL(10),
    INSPECT(11),
    PAY_TERMINAL(12),
    BUILDFACE(13),
    SCHOOLBUS(14);
    private HostDataType(int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    private int value;

}
