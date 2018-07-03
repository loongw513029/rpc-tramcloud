package com.sztvis.domain.dto;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.Serializable;

public class AppSelectViewModel implements Serializable{
    private long Id ;
    private String Name ;

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

    public boolean isOnline() {
        return IsOnline;
    }

    public void setOnline(boolean online) {
        IsOnline = online;
    }

    public AppNumViewModel getNumData() {
        return NumData;
    }

    public void setNumData(AppNumViewModel numData) {
        NumData = numData;
    }

    private boolean IsOnline = true;
    private AppNumViewModel NumData;
}
