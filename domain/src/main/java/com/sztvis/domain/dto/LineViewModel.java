package com.sztvis.domain.dto;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/18 下午2:29
 */
public class LineViewModel implements Serializable{
    private long id;
    private String linename;
    private String departmentname;
    private long departmentid;
    private String linecode;
    private String lineupmileage;
    private String linedownmileage;
    private String upsitenum;
    private String downsitenum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLinename() {
        return linename;
    }

    public void setLinename(String linename) {
        this.linename = linename;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getLinecode() {
        return linecode;
    }

    public void setLinecode(String linecode) {
        this.linecode = linecode;
    }

    public String getLineupmileage() {
        return lineupmileage;
    }

    public void setLineupmileage(String lineupmileage) {
        this.lineupmileage = lineupmileage;
    }

    public String getLinedownmileage() {
        return linedownmileage;
    }

    public void setLinedownmileage(String linedownmileage) {
        this.linedownmileage = linedownmileage;
    }

    public String getUpsitenum() {
        return upsitenum;
    }

    public void setUpsitenum(String upsitenum) {
        this.upsitenum = upsitenum;
    }

    public String getDownsitenum() {
        return downsitenum;
    }

    public void setDownsitenum(String downsitenum) {
        this.downsitenum = downsitenum;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    private int sort;

    public long getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(long departmentid) {
        this.departmentid = departmentid;
    }
}
