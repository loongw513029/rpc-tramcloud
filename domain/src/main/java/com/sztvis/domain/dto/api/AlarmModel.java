package com.sztvis.domain.dto.api;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/23 下午4:18
 */
public class AlarmModel implements Serializable {
    private String Code;
    private String UpdateTime;
    private int Type;
    private Object Value1;
    private Object Value2;
    private String Path;
    private String path2;

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

    public Object getValue1() {
        return Value1;
    }

    public void setValue1(Object value1) {
        Value1 = value1;
    }

    public Object getValue2() {
        return Value2;
    }

    public void setValue2(Object value2) {
        Value2 = value2;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public String getPath2() {
        return path2;
    }

    public void setPath2(String path2) {
        this.path2 = path2;
    }
}
