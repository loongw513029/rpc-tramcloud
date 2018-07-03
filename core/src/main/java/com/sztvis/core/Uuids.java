package com.sztvis.core;
import java.util.UUID;

public class Uuids {
    /**
     * 获得UUID方法
     * @return
     */
    public static String getUUID(){
        return  UUID.randomUUID().toString().replaceAll("-","");
    }


}
