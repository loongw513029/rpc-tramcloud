package com.sztvis.domain.dto;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/3/29 上午11:18
 */
public class PassengerFlowView implements Serializable {
    private String devicecode;
    private String updatetime;
    private int[] number1;
    private int[] number2;

    public String getDevicecode() {
        return devicecode;
    }

    public void setDevicecode(String devicecode) {
        this.devicecode = devicecode;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public int[] getNumber1() {
        return number1;
    }

    public void setNumber1(int[] number1) {
        this.number1 = number1;
    }

    public int[] getNumber2() {
        return number2;
    }

    public void setNumber2(int[] number2) {
        this.number2 = number2;
    }
}
