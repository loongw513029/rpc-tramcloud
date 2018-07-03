package com.sztvis.domain.dto.response;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2017/12/29 上午11:59
 */
public class ApiResult implements Serializable{
    private String code;
    private boolean success;
    private String info;
    private Object result;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
