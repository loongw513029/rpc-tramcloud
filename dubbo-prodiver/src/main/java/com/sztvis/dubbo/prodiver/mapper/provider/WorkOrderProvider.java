package com.sztvis.dubbo.prodiver.mapper.provider;


import com.sztvis.core.helper.StringHelper;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class WorkOrderProvider {
    public String GetWorkOrdersSQL(Map<String,Object> map)
    {
        String code = (String)map.get("code");
        String start = (String)map.get("start");
        String end = (String)map.get("end");
        SQL sql=new SQL();
        sql.SELECT("a.Id,a.Title,a.Number,b.deviceCode,a.remark,a.deviceId,a.FaultType,a.Audit,a.ReparUserId,c.realName,a.LimitTime,a.ApplyTime,a.HandleTime,a.State");
        sql.FROM("TramWorkOrderInfo a left join TramDeviceInfo b on a.deviceId = b.Id left join TramReparInfo c on a.Number = c.Number");
        sql.WHERE("Type = 1");
        if (StringHelper.isNotEmpty(start))
            sql.AND().WHERE("a.ApplyTime>=" + start);
        if (StringHelper.isNotEmpty(end))
            sql.AND().WHERE("a.ApplyTime=<"+ end);
        if (StringHelper.isNotEmpty(code))
            sql.AND().WHERE("b.DeviceCode like '%"+ code +"%'");
        sql.ORDER_BY("a.ApplyTime desc");
        return sql.toString();
    }
}
