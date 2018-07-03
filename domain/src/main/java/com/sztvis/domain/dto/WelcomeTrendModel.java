package com.sztvis.domain.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/9 上午9:45
 */
public class WelcomeTrendModel implements Serializable {

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

    private List<List<Integer>> faults;

    private List<List<Integer>> unsafes;

    private List<String> xalias;
    private List<String> faultXalias;
    private List<String> unsafeXalias;

    public List<String> getXalias() {
        return xalias;
    }

    public void setXalias(List<String> xalias) {
        this.xalias = xalias;
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
}
