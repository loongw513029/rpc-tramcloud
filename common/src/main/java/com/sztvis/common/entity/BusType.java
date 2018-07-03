package com.sztvis.common.entity;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/10 下午1:50
 */
public enum BusType {
    //传统车,油电混合车，气电混合车，纯电动车,BMS双路电动车
    NormalBus(1),OilAndElecBus(2),GasAndElecBus(3),PureElectricBus(4),DoubleBMSBus(5);
    private int value;
    private BusType(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
