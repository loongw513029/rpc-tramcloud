package com.sztvis.domain;

import java.io.Serializable;
import java.util.List;

public class HomealramViewModel  implements Serializable {
    public long Id;
    public String Code;
    public int AlarmKey;
    public String AlarmName;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public int getAlarmKey() {
        return AlarmKey;
    }

    public void setAlarmKey(int alarmKey) {
        AlarmKey = alarmKey;
    }

    public String getAlarmName() {
        return AlarmName;
    }

    public void setAlarmName(String alarmName) {
        AlarmName = alarmName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String updateTime;
    public String Time;
    public static class ViewModel
    {
       public List<HomealramViewModel> View;

        public List<HomealramViewModel> getView() {
            return View;
        }

        public void setView(List<HomealramViewModel> view) {
            View = view;
        }

        public int getCount() {
            return Count;
        }

        public void setCount(int count) {
            Count = count;
        }

        public int Count;
    }
}
