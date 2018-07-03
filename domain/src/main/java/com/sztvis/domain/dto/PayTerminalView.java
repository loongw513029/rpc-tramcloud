package com.sztvis.domain.dto;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/3/28 下午4:40
 */
public class PayTerminalView implements Serializable {

    private String devicecode;
    private String updatetime;
    private String paycardno;
    private String paytime;
    private String location;
    private String sitename;
    private String passengerimage;

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

    public String getPaycardno() {
        return paycardno;
    }

    public void setPaycardno(String paycardno) {
        this.paycardno = paycardno;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public String getPassengerimage() {
        return passengerimage;
    }

    public void setPassengerimage(String passengerimage) {
        this.passengerimage = passengerimage;
    }
}
