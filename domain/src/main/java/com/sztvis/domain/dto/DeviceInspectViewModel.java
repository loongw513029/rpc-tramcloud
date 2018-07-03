package com.sztvis.domain.dto;


import com.sztvis.domain.domain.TramDeviceStateInspectRealtimeInfo;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/31 下午3:45
 */
public class DeviceInspectViewModel extends TramDeviceStateInspectRealtimeInfo  implements Serializable {
    private long departmentid;
    private String departmentname;
    private long lineid;
    private String linename;

    public long getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(long departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public long getLineid() {
        return lineid;
    }

    public void setLineid(long lineid) {
        this.lineid = lineid;
    }

    public String getLinename() {
        return linename;
    }

    public void setLinename(String linename) {
        this.linename = linename;
    }
}
