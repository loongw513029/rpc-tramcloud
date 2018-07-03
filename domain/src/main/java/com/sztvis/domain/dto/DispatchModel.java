package com.sztvis.domain.dto;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/2/1 下午2:07
 */
public class DispatchModel  implements Serializable {
    //当前站点
    private String currentsite;
    //下一站点
    private String nextsite;
    //进出站 0：进站 1：出站
    private int inoroutsite;
    //
    private int inoroutsitetype;

    //0 起始站 1终点站 2中途站
    private int sitetype;

    public String getCurrentsite() {
        return currentsite;
    }

    public void setCurrentsite(String currentsite) {
        this.currentsite = currentsite;
    }

    public String getNextsite() {
        return nextsite;
    }

    public void setNextsite(String nextsite) {
        this.nextsite = nextsite;
    }

    public int getInoroutsite() {
        return inoroutsite;
    }

    public void setInoroutsite(int inoroutsite) {
        this.inoroutsite = inoroutsite;
    }

    public int getInoroutsitetype() {
        return inoroutsitetype;
    }

    public void setInoroutsitetype(int inoroutsitetype) {
        this.inoroutsitetype = inoroutsitetype;
    }

    public int getSitetype() {
        return sitetype;
    }

    public void setSitetype(int sitetype) {
        this.sitetype = sitetype;
    }
}

