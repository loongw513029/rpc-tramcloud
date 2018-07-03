package com.sztvis.domain.amap;

public class GeofenceFrom {
    private String name;
    private String center;
    private String radius;
    private String points;
    private boolean enable;
    private String valid_time;
    private String repeat = "Mon,Tues,Wed,Thur,Fri,Sat,Sun";
    private String time = "00:00-23:59";
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getValid_time() {
        return valid_time;
    }

    public void setValid_time(String valid_time) {
        this.valid_time = valid_time;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAlert_condition() {
        return alert_condition;
    }

    public void setAlert_condition(String alert_condition) {
        this.alert_condition = alert_condition;
    }

    private String alert_condition;

    public GeofenceFrom(String name, String center, String radius, String points, boolean enable, String valid_time, String desc, String alert_condition) {
        this.name = name;
        this.center = center;
        this.radius = radius;
        this.points = points;
        this.enable = enable;
        this.valid_time = valid_time;
        this.desc = desc;
        this.alert_condition = alert_condition;
    }
}
