package com.sztvis.domain.dto;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/2/27 上午9:08
 */
public class HomeAlarmViewModel  implements Serializable {

    private long id;
    private String alarmName;
    private String updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
