package com.sztvis.domain.dto;

import java.io.Serializable;
import java.util.List;

public class AppNumViewModel implements Serializable {
    /// <summary>
    /// 车辆台数
    /// </summary>
    private int CarNum;
    /// <summary>
    /// 在线台数
    /// </summary>
    private int OnLineNum;
    /// <summary>
    /// 线路条数
    /// </summary>
    private int LineNum;
    /// <summary>
    /// 行为异常

    public int getCarNum() {
        return CarNum;
    }

    public void setCarNum(int carNum) {
        CarNum = carNum;
    }

    public int getOnLineNum() {
        return OnLineNum;
    }

    public void setOnLineNum(int onLineNum) {
        OnLineNum = onLineNum;
    }

    public int getLineNum() {
        return LineNum;
    }

    public void setLineNum(int lineNum) {
        LineNum = lineNum;
    }

    public int getUnSafeNum() {
        return UnSafeNum;
    }

    public void setUnSafeNum(int unSafeNum) {
        UnSafeNum = unSafeNum;
    }

    /// </summary>
    private int UnSafeNum;
}

