package com.sztvis.domain.dto;

import java.io.Serializable;
import java.util.List;

public class BicycleViewModel implements Serializable {
    public List<String> AxisValues;

    public List<String> getAxisValues() {
        return AxisValues;
    }

    public void setAxisValues(List<String> axisValues) {
        AxisValues = axisValues;
    }

    public List<BicycleUnSafeStatisModel> getItems() {
        return Items;
    }

    public void setItems(List<BicycleUnSafeStatisModel> items) {
        Items = items;
    }

    public List<BicycleUnSafeStatisModel> Items;
    public static class BicycleUnSafeStatisModel
    {
        public String AxisName;

        public String getAxisName() {
            return AxisName;
        }

        public void setAxisName(String axisName) {
            AxisName = axisName;
        }

        public List<Double> getAxisyValues() {
            return AxisyValues;
        }

        public void setAxisyValues(List<Double> axisyValues) {
            AxisyValues = axisyValues;
        }

        public List<Double> AxisyValues;
    }
}
