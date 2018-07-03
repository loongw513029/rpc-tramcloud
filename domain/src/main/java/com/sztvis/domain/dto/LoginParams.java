package com.sztvis.domain.dto;

import java.io.Serializable;

public class LoginParams  implements Serializable {
    private String username;
    private String password;
    private String clientid;
    private String verifycode;
    /**
     * 登录类型 1：安卓 2：IOS 3：Web
     */
    private Integer logintype;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getClientId() {
        return clientid;
    }

    public void setClientId(String clientid) {
        this.clientid = clientid;
    }

    public Integer getLogintype() {
        return logintype;
    }

    public void setLogintype(Integer logintype) {
        this.logintype = logintype;
    }

    public String getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(String verifycode) {
        this.verifycode = verifycode;
    }
}
