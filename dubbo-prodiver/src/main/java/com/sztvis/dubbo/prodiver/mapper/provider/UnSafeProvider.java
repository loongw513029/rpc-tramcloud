package com.sztvis.dubbo.prodiver.mapper.provider;

import com.sztvis.core.DayTypes;
import com.sztvis.core.helper.StringHelper;
import com.sztvis.domain.UnSafeQuery;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class UnSafeProvider {
    public String GetUnsafeListSQL(Map<String, Object> map) {
        UnSafeQuery query = (UnSafeQuery) map.get("query");
        List<Long> deviceIds = (List<Long>) map.get("deviceIds");
        DayTypes types = (DayTypes) map.get("type");
        SQL sql = new SQL();
        sql.SELECT("a.Id,a.DeviceCode as Code,a.DeviceId,b.LineId,c.LineName,b.DepartmentId,d.DepartmentName,a.UnSafeType,a.ApplyTime as Time,a.Location");
        sql.FROM("TramUnSafeBehaviorInfo a left join TramDeviceInfo b on a.DeviceId = b.Id left join TramLineInfo c on b.LineId = c.Id left join TramDepartmentInfo d on b.DepartmentId = d.id");
        if (query.getLineId() == 0)
            sql.WHERE("1=1");
        else
            sql.WHERE("b.LineId=" + query.getLineId());
        if (deviceIds != null)
            sql.AND().WHERE("a.deviceId in(" + deviceIds + ")");
        sql.AND().WHERE("a.ApplyTime>='" + types.getStartTime() + "' and a.ApplyTime<='" + types.getEndTime() + "'");
        if (StringHelper.isNotEmpty(query.getDeviceCode()))
            sql.AND().WHERE("a.DeviceCode like '%" + query.getDeviceCode() + "%'");
        if (query.getUnSafeType() != 0)
            sql.AND().WHERE(" a.UnSafeType=" + query.getUnSafeType());
        sql.ORDER_BY("a.ApplyTime desc");
        return sql.toString();
    }

    public String GetCanExtrasSQL(Map<String, Object> map){
        List<String> codes = (List<String>)map.get("codes");
        List<String> key = StringHelper.IntegersToStrings((int[])map.get("key"));
        String start = (String)map.get("start");
        String end = (String)map.get("end");
        SQL sql = new SQL();
        sql.SELECT("Extras")
        .FROM("TramAlarmInfo")
        .WHERE("deviceCode in ('"+StringHelper.listToString(codes,"','")+"')")
        .AND().WHERE("AlarmType in ("+ StringHelper.listToString(key,',') +")")
        .AND().WHERE("UpdateTime>='"+ start +"'")
        .AND().WHERE("UpdateTime<='"+ end +"'");
        return sql.toString();
    }

    public String GetUnSafeBehaviorIdSQL(Map<String, Object> map){
        List<String> codes = (List<String>)map.get("codes");
        String start = (String)map.get("start");
        String end = (String)map.get("end");
        SQL sql = new SQL();
        sql.SELECT("count(Id)")
                .FROM("TramUnSafeBehaviorInfo")
                .WHERE("deviceCode in ('"+StringHelper.listToString(codes,"','")+"')")
                .AND().WHERE("UnSafeType=13")
                .AND().WHERE("Speed>=60")
                .AND().WHERE("CreateTime>='"+ start +"'")
                .AND().WHERE("CreateTime<='"+ end +"'");
        return sql.toString();
    }
}
