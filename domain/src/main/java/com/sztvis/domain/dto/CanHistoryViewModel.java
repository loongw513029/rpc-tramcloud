package com.sztvis.domain.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/3/6 上午11:17
 */
public class CanHistoryViewModel implements Serializable {
    private long lineId;
    private int totalNumber;
    private int operaterNumber;
    private double totalMileage;
    private double fuelEconomy;
    private double elecEconomy;
    private double gasEconomy;
    private int faultNumber;
    private int faultBus;
    private double carBusLongTime;
    private int speeding;
    private int f1;
    private int f2;
    private int f3;
    private List<String> categories;
    private List<String> xlias;
    private List<String> faultXalias;
    private List<String> unsafeXalias;
    private List<List<Integer>> faults;
    private List<List<Integer>> unsafes;

    public long getLineId() {
        return lineId;
    }

    public void setLineId(long lineId) {
        this.lineId = lineId;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getOperaterNumber() {
        return operaterNumber;
    }

    public void setOperaterNumber(int operaterNumber) {
        this.operaterNumber = operaterNumber;
    }

    public double getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(double totalMileage) {
        this.totalMileage = totalMileage;
    }

    public double getFuelEconomy() {
        return fuelEconomy;
    }

    public void setFuelEconomy(double fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }

    public double getElecEconomy() {
        return elecEconomy;
    }

    public void setElecEconomy(double elecEconomy) {
        this.elecEconomy = elecEconomy;
    }

    public double getGasEconomy() {
        return gasEconomy;
    }

    public void setGasEconomy(double gasEconomy) {
        this.gasEconomy = gasEconomy;
    }

    public int getFaultNumber() {
        return faultNumber;
    }

    public void setFaultNumber(int faultNumber) {
        this.faultNumber = faultNumber;
    }

    public int getFaultBus() {
        return faultBus;
    }

    public void setFaultBus(int faultBus) {
        this.faultBus = faultBus;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<List<Integer>> getFaults() {
        return faults;
    }

    public void setFaults(List<List<Integer>> faults) {
        this.faults = faults;
    }

    public List<List<Integer>> getUnsafes() {
        return unsafes;
    }

    public void setUnsafes(List<List<Integer>> unsafes) {
        this.unsafes = unsafes;
    }

    public double getCarBusLongTime() {
        return carBusLongTime;
    }

    public void setCarBusLongTime(double carBusLongTime) {
        this.carBusLongTime = carBusLongTime;
    }

    public int getSpeeding() {
        return speeding;
    }

    public void setSpeeding(int speeding) {
        this.speeding = speeding;
    }

    public int getF1() {
        return f1;
    }

    public void setF1(int f1) {
        this.f1 = f1;
    }

    public int getF2() {
        return f2;
    }

    public void setF2(int f2) {
        this.f2 = f2;
    }

    public int getF3() {
        return f3;
    }

    public void setF3(int f3) {
        this.f3 = f3;
    }

    public List<String> getFaultXalias() {
        return faultXalias;
    }

    public void setFaultXalias(List<String> faultXalias) {
        this.faultXalias = faultXalias;
    }

    public List<String> getUnsafeXalias() {
        return unsafeXalias;
    }

    public void setUnsafeXalias(List<String> unsafeXalias) {
        this.unsafeXalias = unsafeXalias;
    }

    public List<String> getXlias() {
        return xlias;
    }

    public void setXlias(List<String> xlias) {
        this.xlias = xlias;
    }
}
