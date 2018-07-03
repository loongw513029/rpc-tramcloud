package com.sztvis.domain;

import java.io.Serializable;

public class IndexModel implements Serializable {
    public String Extras;
    public double Speed;

    public String getExtras() {
        return Extras;
    }

    public void setExtras(String extras) {
        Extras = extras;
    }

    public double getSpeed() {
        return Speed;
    }

    public void setSpeed(double speed) {
        Speed = speed;
    }
}
