package com.sztvis.domain.dto;


import com.sztvis.domain.domain.ElectricCanInfo;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/2/1 上午11:59
 */
public class CanModel implements Serializable {
    //车速
    private String speed;
    //转速，或者左电机转速（如果是纯电车）
    private String ratespeed;
    //右电机转速
    private String ratespped2;
    //左气囊气压
    private String leftpress;
    //右气囊气压
    private String rightpress;
    //剩余油量
    private String oilmass;
    //油门开度
    private String oilopenings;
    //刹车开度
    private String brakeopenings;
    //电池总电压
    private String totalbatteryvoltage;
    //电池总电流
    private String totalbatterygenerator;
    //前气压
    private String beforepressure;
    //后气压
    private String afterpressure;
    //SOC
    private String soc;
    //水温
    private String watertemp;
    //水温2
    private String watertemp2;
    //小计里程
    private String shortmileage;
    //总里程
    private String totalmileage;
    //油耗
    private String oilconsumption;
    //电耗
    private String elecconsumption;
    private String remainingoil;
    //发动机状态
    private String enginestat;
    //电机状态
    private String electricalstat;
    //电机转速
    private String electricalratespeed;
    //当前坐标
    private String location;
    //角度
    private String roate;
    //车外温度
    private String outcartemp;
    //车内温度
    private String incartemp;
    //电车其他can数据
    private ElectricCanInfo elec;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getRatespeed() {
        return ratespeed;
    }

    public void setRatespeed(String ratespeed) {
        this.ratespeed = ratespeed;
    }

    public String getRatespped2() {
        return ratespped2;
    }

    public void setRatespped2(String ratespped2) {
        this.ratespped2 = ratespped2;
    }

    public String getLeftpress() {
        return leftpress;
    }

    public void setLeftpress(String leftpress) {
        this.leftpress = leftpress;
    }

    public String getRightpress() {
        return rightpress;
    }

    public void setRightpress(String rightpress) {
        this.rightpress = rightpress;
    }

    public String getOilmass() {
        return oilmass;
    }

    public void setOilmass(String oilmass) {
        this.oilmass = oilmass;
    }

    public String getOilopenings() {
        return oilopenings;
    }

    public void setOilopenings(String oilopenings) {
        this.oilopenings = oilopenings;
    }

    public String getBrakeopenings() {
        return brakeopenings;
    }

    public void setBrakeopenings(String brakeopenings) {
        this.brakeopenings = brakeopenings;
    }

    public String getTotalbatteryvoltage() {
        return totalbatteryvoltage;
    }

    public void setTotalbatteryvoltage(String totalbatteryvoltage) {
        this.totalbatteryvoltage = totalbatteryvoltage;
    }

    public String getTotalbatterygenerator() {
        return totalbatterygenerator;
    }

    public void setTotalbatterygenerator(String totalbatterygenerator) {
        this.totalbatterygenerator = totalbatterygenerator;
    }

    public String getBeforepressure() {
        return beforepressure;
    }

    public void setBeforepressure(String beforepressure) {
        this.beforepressure = beforepressure;
    }

    public String getAfterpressure() {
        return afterpressure;
    }

    public void setAfterpressure(String afterpressure) {
        this.afterpressure = afterpressure;
    }

    public String getSoc() {
        return soc;
    }

    public void setSoc(String soc) {
        this.soc = soc;
    }

    public String getWatertemp() {
        return watertemp;
    }

    public void setWatertemp(String watertemp) {
        this.watertemp = watertemp;
    }

    public String getWatertemp2() {
        return watertemp2;
    }

    public void setWatertemp2(String watertemp2) {
        this.watertemp2 = watertemp2;
    }

    public String getShortmileage() {
        return shortmileage;
    }

    public void setShortmileage(String shortmileage) {
        this.shortmileage = shortmileage;
    }

    public String getTotalmileage() {
        return totalmileage;
    }

    public void setTotalmileage(String totalmileage) {
        this.totalmileage = totalmileage;
    }

    public String getOilconsumption() {
        return oilconsumption;
    }

    public void setOilconsumption(String oilconsumption) {
        this.oilconsumption = oilconsumption;
    }

    public String getElecconsumption() {
        return elecconsumption;
    }

    public void setElecconsumption(String elecconsumption) {
        this.elecconsumption = elecconsumption;
    }

    public String getRemainingoil() {
        return remainingoil;
    }

    public void setRemainingoil(String remainingoil) {
        this.remainingoil = remainingoil;
    }

    public String getEnginestat() {
        return enginestat;
    }

    public void setEnginestat(String enginestat) {
        this.enginestat = enginestat;
    }

    public String getElectricalstat() {
        return electricalstat;
    }

    public void setElectricalstat(String electricalstat) {
        this.electricalstat = electricalstat;
    }

    public String getElectricalratespeed() {
        return electricalratespeed;
    }

    public void setElectricalratespeed(String electricalratespeed) {
        this.electricalratespeed = electricalratespeed;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRoate() {
        return roate;
    }

    public void setRoate(String roate) {
        this.roate = roate;
    }

    public String getOutcartemp() {
        return outcartemp;
    }

    public void setOutcartemp(String outcartemp) {
        this.outcartemp = outcartemp;
    }

    public String getIncartemp() {
        return incartemp;
    }

    public void setIncartemp(String incartemp) {
        this.incartemp = incartemp;
    }

    public ElectricCanInfo getElec() {
        return elec;
    }

    public void setElec(ElectricCanInfo elec) {
        this.elec = elec;
    }
}
