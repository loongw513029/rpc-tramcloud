package com.sztvis.core.helper;


import com.sztvis.common.entity.CanAlarmTypes;

import java.lang.reflect.Array;
import java.util.EnumMap;
import java.util.Map;

public class EnumHelper {

    public static String getName(int value) {
        String Name = null;
        for (CanAlarmTypes type : CanAlarmTypes.values()) {
            if (value == type.getValue()) {
                Name = type.name().toString();
            }
        }
        return Name;
    }
}
