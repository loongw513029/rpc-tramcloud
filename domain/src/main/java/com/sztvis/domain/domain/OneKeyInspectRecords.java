package com.sztvis.domain.domain;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/3/29 上午11:00
 */
public class OneKeyInspectRecords  implements Serializable {
    private long id;
    private long deviceId;
    private String updateTime;
    private String inspectPics;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getInspectPics() {
        return inspectPics;
    }

    public void setInspectPics(String inspectPics) {
        this.inspectPics = inspectPics;
    }
}
