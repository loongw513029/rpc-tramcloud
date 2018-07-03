package com.sztvis.domain.domain;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/2/7 下午4:03
 */
public class V3TokenInfo implements Serializable {
    private long id;
    private String departmentcode;
    private String accesstoken;
    private String refreshtoken;
    private int expiresin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentcode() {
        return departmentcode;
    }

    public void setDepartmentcode(String departmentcode) {
        this.departmentcode = departmentcode;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public String getRefreshtoken() {
        return refreshtoken;
    }

    public void setRefreshtoken(String refreshtoken) {
        this.refreshtoken = refreshtoken;
    }

    public int getExpiresin() {
        return expiresin;
    }

    public void setExpiresin(int expiresin) {
        this.expiresin = expiresin;
    }
}
