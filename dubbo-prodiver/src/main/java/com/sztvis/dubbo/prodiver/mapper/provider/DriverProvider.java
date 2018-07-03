package com.sztvis.dubbo.prodiver.mapper.provider;

import com.sztvis.core.helper.StringHelper;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class DriverProvider {

    public String getDriverListSQL(Map<String,Object> map){
        String keywords = (String)map.get("keywords");
        long departmentId = (Long)map.get("departmentId");
        int offset = (Integer)map.get("offset");
        int limit = (Integer)map.get("limit");
        SQL sql = new SQL();
        sql.SELECT("a.*,b.departmentname");
        sql.FROM("TramDriverInfo a left join TramDepartmentInfo b on a.departmentId=b.id");
        String where = "1=1";
        if(!StringHelper.isEmpty(keywords)){
            where +=" and drivername like '%"+keywords+"%'";
        }
        if(departmentId!=0) {
            where += " and departmentid="+departmentId;
        }
        sql.WHERE(where);
        sql.ORDER_BY("id desc");
        String sql2 = sql.toString()+" limit "+(offset-1)*limit+","+limit;
        return sql2;
    }

    public String getDriverListCountSQL(Map<String,Object> map){
        String keywords = (String)map.get("keywords");
        long departmentId = (Long)map.get("departmentId");
        SQL sql = new SQL();
        sql.SELECT("count(a.id)");
        sql.FROM("TramDriverInfo a left join TramDepartmentInfo b on a.departmentId=b.id");
        String where = "1=1";
        if(!StringHelper.isEmpty(keywords)){
            where +=" and drivername like '%"+keywords+"%'";
        }
        if(departmentId!=0) {
            where += " and departmentid="+departmentId;
        }
        sql.WHERE(where);
        String sql2 = sql.toString();
        return sql2;
    }

    public String DeleteDriverSQL(Map<String,Object> map){
        List<Long> ids = (List<Long>)map.get("ids");
        String sql =" delete from TramDriverInfo where id in ("+StringHelper.listToString(ids,',')+")";
        return  sql;
    }
}
