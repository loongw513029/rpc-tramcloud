package com.sztvis.domain.domain;

import java.io.Serializable;

public class TramLogInfo implements Serializable {
    private long id;
    private long uid;
    private String logTime;
    private String contentIp;
    private int login_status;
    private String action;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getContentIp() {
        return contentIp;
    }

    public void setContentIp(String contentIp) {
        this.contentIp = contentIp;
    }

    public int getLogin_status() {
        return login_status;
    }

    public void setLogin_status(int login_status) {
        this.login_status = login_status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public TramLogInfo() {
    }

    public TramLogInfo(long uid, String logTime, String contentIp, int login_status, String action) {
        this.uid = uid;
        this.logTime = logTime;
        this.contentIp = contentIp;
        this.login_status = login_status;
        this.action = action;
    }
}
