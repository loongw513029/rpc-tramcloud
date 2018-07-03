package com.sztvis.dubbo.prodiver.mapper.provider;

import com.sztvis.core.helper.StringHelper;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class SchoolFaceProvider {

    public String getSchoolFaceListSQL(Map<String,Object> map){
        String name = (String)map.get("name");
        int page = (Integer)map.get("page");
        int rows = (Integer)map.get("rows");
        SQL sql = new SQL();
        sql.SELECT("a.*,b.drivername");
        sql.FROM("TramDriverSimilarRecord a left join TramDeviceInfo a1 on a.deviceId=a1.Id left join TramBusInfo a2 on a1.BusId = a2.Id left join TramDriverInfo b on a2.driverId = b.id");
        if(!StringHelper.isEmpty(name))
            sql.WHERE(" b.drivername like '%"+name+"%'");
        String sql2 = sql.toString()+" limit "+(page-1)*rows+","+rows;
        return sql2;
    }

    public String getSchoolFaceListCountSQL(Map<String,Object> map){
        String name = (String)map.get("name");
        SQL sql = new SQL();
        sql.SELECT("count(a.Id)");
        sql.FROM("TramDriverSimilarRecord a left join TramDeviceInfo a1 on a.deviceId=a1.Id left join TramBusInfo a2 on a1.BusId = a2.Id left join TramDriverInfo b on a2.driverId = b.id");
        if(!StringHelper.isEmpty(name))
            sql.WHERE(" b.drivername like '%"+name+"%'");
        return sql.toString();
    }

}
