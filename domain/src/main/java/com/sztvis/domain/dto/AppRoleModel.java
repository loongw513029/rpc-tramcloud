package com.sztvis.domain.dto;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2017/12/28 下午5:01
 */
public class AppRoleModel implements Serializable{
    private String AppName;
    private Integer OrgType;
    private Boolean IsHaveCan;
    private Boolean IsHaveVedio;

    public String getAppName() {
        return AppName;
    }

    public void setAppName(String appName) {
        AppName = appName;
    }

    public Integer getOrgType() {
        return OrgType;
    }

    public void setOrgType(Integer orgType) {
        OrgType = orgType;
    }

    public Boolean getHaveCan() {
        return IsHaveCan;
    }

    public void setHaveCan(Boolean haveCan) {
        IsHaveCan = haveCan;
    }

    public Boolean getHaveVedio() {
        return IsHaveVedio;
    }

    public void setHaveVedio(Boolean haveVedio) {
        IsHaveVedio = haveVedio;
    }

    public Boolean getHaveGps() {
        return IsHaveGps;
    }

    public void setHaveGps(Boolean haveGps) {
        IsHaveGps = haveGps;
    }

    private Boolean IsHaveGps;

}
