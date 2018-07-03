package com.sztvis.domain;

import java.io.Serializable;

public class DataAlarmConfigViewModel implements Serializable {
    public int Id;
    public String DataName;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDataName() {
        return DataName;
    }

    public void setDataName(String dataName) {
        DataName = dataName;
    }

    public Boolean getTurn() {
        return Turn;
    }

    public void setTurn(Boolean turn) {
        Turn = turn;
    }

    public String getFirstFiter() {
        return FirstFiter;
    }

    public void setFirstFiter(String firstFiter) {
        FirstFiter = firstFiter;
    }

    public Object getValue() {
        return Value;
    }

    public void setValue(Object value) {
        Value = value;
    }

    public Boolean Turn;
    public String FirstFiter;
    public Object Value;
}
