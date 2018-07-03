package com.sztvis.domain.dto.api;

import java.io.Serializable;
import java.util.Map;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/12 上午10:59
 */
public class CanModel implements Serializable {
    private String Code;
    private String UpdateTime;

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


    private Map<Integer,Double> Value;

    public Map<Integer, Double> getValue() {
        return Value;
    }

    public void setValue(Map<Integer, Double> value) {
        Value = value;
    }
}
