package com.sztvis.domain.dto.service;

import java.io.Serializable;
import java.util.List;

public class ChartViewModel implements Serializable {
    private int TotalDeviceCount;
    private int OnLineDeviceCount;
    private int TotalLineCount;
    private int TotalUnsafeCount;
    private int TotalAlarmCount;
    private List<ChartListViewModel> ChartList;

    public int getTotalDeviceCount() {
        return TotalDeviceCount;
    }

    public void setTotalDeviceCount(int totalDeviceCount) {
        TotalDeviceCount = totalDeviceCount;
    }

    public int getOnLineDeviceCount() {
        return OnLineDeviceCount;
    }

    public void setOnLineDeviceCount(int onLineDeviceCount) {
        OnLineDeviceCount = onLineDeviceCount;
    }

    public int getTotalLineCount() {
        return TotalLineCount;
    }

    public void setTotalLineCount(int totalLineCount) {
        TotalLineCount = totalLineCount;
    }

    public int getTotalUnsafeCount() {
        return TotalUnsafeCount;
    }

    public void setTotalUnsafeCount(int totalUnsafeCount) {
        TotalUnsafeCount = totalUnsafeCount;
    }

    public int getTotalAlarmCount() {
        return TotalAlarmCount;
    }

    public void setTotalAlarmCount(int totalAlarmCount) {
        TotalAlarmCount = totalAlarmCount;
    }

    public List<ChartListViewModel> getChartList() {
        return ChartList;
    }

    public void setChartList(List<ChartListViewModel> chartList) {
        ChartList = chartList;
    }
    public static class ChartListViewModel
    {
        private String ChartName;

        public String getChartName() {
            return ChartName;
        }

        public void setChartName(String chartName) {
            ChartName = chartName;
        }

        public List<ChartData> getData() {
            return Data;
        }

        public void setData(List<ChartData> data) {
            Data = data;
        }

        private List<ChartData> Data;
    }
    public static class ChartData
    {
        private String AxisName;
        private double AxisValue;

        public String getAxisName() {
            return AxisName;
        }

        public void setAxisName(String axisName) {
            AxisName = axisName;
        }

        public double getAxisValue() {
            return AxisValue;
        }

        public void setAxisValue(double axisValue) {
            AxisValue = axisValue;
        }
    }
}



