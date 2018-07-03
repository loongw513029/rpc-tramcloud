package com.sztvis.domain.dto.api;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/25 上午11:45
 */
public class HardWareModel implements Serializable {
    private String Code;
    private String UpdateTime;
    private int Type;
    private double Value;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public double getValue() {
        return Value;
    }

    public void setValue(double value) {
        Value = value;
    }
}
