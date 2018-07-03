package com.sztvis.domain.dto;


import java.io.Serializable;

public class AppDropDownModel implements Serializable {
    public long Id;
    public String Name;

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

    public Boolean getOnline() {
        return IsOnline;
    }

    public void setOnline(Boolean online) {
        IsOnline = online;
    }

    public Boolean IsOnline;
}
