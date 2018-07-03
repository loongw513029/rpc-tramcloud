package com.sztvis.domain.dto.api;

import java.io.Serializable;
import java.util.List;

public class AppAlarmChartModel implements Serializable {
    public List<String> getxVals() {
        return xVals;
    }

    public void setxVals(List<String> xVals) {
        this.xVals = xVals;
    }

    public List<yVal> getyVals() {
        return yVals;
    }

    public void setyVals(List<yVal> yVals) {
        this.yVals = yVals;
    }

    public List<TypeModel3> getModes() {
        return modes;
    }

    public void setModes(List<TypeModel3> modes) {
        this.modes = modes;
    }

    public List<String> xVals;
    public List<yVal> yVals;
    public List<TypeModel3>modes;
    public static class xVal
    {
        public long getId() {
            return Id;
        }

        public void setId(long id) {
            Id = id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public long Id;
        public String Name;
    }
    public static class yVal
    {
        public List<Integer> getVal() {
            return Val;
        }

        public void setVal(List<Integer> val) {
            Val = val;
        }

        public String getTime() {
            return Time;
        }

        public void setTime(String time) {
            Time = time;
        }

        public long getId() {
            return Id;
        }

        public void setId(long id) {
            Id = id;
        }

        public List<Integer> Val;
        public String Time;
        public long Id;
    }
    public static class TypeModel3
    {
        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public List<TypeModel4> getList() {
            return list;
        }

        public void setList(List<TypeModel4> list) {
            this.list = list;
        }

        public String Title;
        public List<TypeModel4> list;
    }
    public static class TypeModel4
    {
        public long getId() {
            return Id;
        }

        public void setId(long id) {
            Id = id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public int getCount() {
            return Count;
        }

        public void setCount(int count) {
            Count = count;
        }

        public long Id;
        public String Name;
        public int Count;
    }
}
