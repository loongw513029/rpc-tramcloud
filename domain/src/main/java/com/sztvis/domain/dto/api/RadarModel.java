package com.sztvis.domain.dto.api;

import java.io.Serializable;
import java.util.Map;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/25 上午11:23
 */
public class RadarModel implements Serializable {
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

    public Map<Integer, Integer> getValue() {
        return Value;
    }

    public void setValue(Map<Integer, Integer> value) {
        Value = value;
    }

    private Map<Integer,Integer> Value;

}
