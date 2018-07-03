package com.sztvis.dubbo.prodiver.mapper.provider;

import com.sztvis.core.DateStyle;
import com.sztvis.core.DateUtil;
import com.sztvis.core.DayTypes;
import com.sztvis.core.helper.StringHelper;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/23 下午3:42
 */
public class AlarmProvider {

    public String getAlarmTableListSQL(Map<String,Object> map){
        String departments = StringHelper.listToString((List<Long>)map.get("departments"),',');
        long departmentId = (Long)map.get("departmentId");
        long lineId = (Long)map.get("lineId");
        long type1 = (Long)map.get("type1");
        long type2 = (Long)map.get("type2");
        String date1 = (String)map.get("date1");
        String date2 = (String)map.get("date2");
        String keywords = (String)map.get("keywords");
        int offset = (Integer)map.get("offset");
        int limit = (Integer)map.get("limit");
        StringBuilder sb = new StringBuilder();
        sb.append("select a.id,a.deviceid,a.AlarmVideoPath,a.path,a.devicecode,b.busnumber,c.linename,d.departmentname,e.alarmname,a.updatetime,a.location,a.speed,a.distance,a.isbrake,a.value");
        sb.append(" from TramAlarmInfo a left join TramDeviceInfo g on a.deviceid = g.id left join TramBusInfo b on g.busid = b.id");
        sb.append(" left join TramLineInfo c on g.lineid = c.id left join TramDepartmentInfo d on g.departmentid = d.id left join TramBasicInfo e on a.alarmType=e.customId");
        sb.append(" where a.departmentId in ("+departments+")");
        if(departmentId != 0)
            sb.append(" and a.departmentId="+departmentId);
        if(lineId != 0)
            sb.append(" and c.id="+lineId);
        if(type1 != 0)
            sb.append(" and a.ParentAlarmType="+type1);
        if(type2 != 0)
            sb.append(" and e.id="+type2);
        if(!StringHelper.isEmpty(date1))
            sb.append(" and a.updatetime>='"+date1+"'");
        if(!StringHelper.isEmpty(date2))
            sb.append(" and a.updatetime<='"+date2+"'");
        if(!StringHelper.isEmpty(keywords))
            sb.append(" and (a.devicecode like '%"+keywords+"%' or b.busnumber like '%"+keywords+"%')");
        sb.append(" order by a.updatetime desc limit "+(offset-1)*limit+","+limit);
        return  sb.toString();
    }
    public String getAlarmTableListSQLCount(Map<String,Object> map){
        String departments = StringHelper.listToString((List<Long>)map.get("departments"),',');
        long departmentId = (Long)map.get("departmentId");
        long lineId = (Long)map.get("lineId");
        long type1 = (Long)map.get("type1");
        long type2 = (Long)map.get("type2");
        String date1 = (String)map.get("date1");
        String date2 = (String)map.get("date2");
        String keywords = (String)map.get("keywords");
        StringBuilder sb = new StringBuilder();
        sb.append("select count(a.id)");
        sb.append(" from TramAlarmInfo a left join TramDeviceInfo g on a.deviceid = g.id left join TramBusInfo b on g.busid = b.id");
        sb.append(" left join TramLineInfo c on g.lineid = c.id left join TramDepartmentInfo d on g.departmentid = d.id left join TramBasicInfo e on a.alarmType=e.customId");
        sb.append(" where a.departmentId in ("+departments+")");
        if(departmentId != 0)
            sb.append(" and a.departmentId="+departmentId);
        if(lineId != 0)
            sb.append(" and c.id="+lineId);
        if(type1 != 0)
            sb.append(" and a.ParentAlarmType="+type1);
        if(type2 != 0)
            sb.append(" and e.id="+type2);
        if(!StringHelper.isEmpty(date1))
            sb.append(" and a.updatetime>='"+date1+"'");
        if(!StringHelper.isEmpty(date2))
            sb.append(" and a.updatetime<='"+date2+"'");
        if(!StringHelper.isEmpty(keywords))
            sb.append(" and (a.devicecode like '%"+keywords+"%' or b.busnumber like '%"+keywords+"%')");
        return  sb.toString();
    }

    public String getMapAlarmListSQL(Map<String,Object> map){
        String devices = (String)map.get("devices");
        String starttime = (String)map.get("starttime");
        int page = (Integer)map.get("page");
        int limit = (Integer)map.get("limit");
        StringBuilder sb = new StringBuilder();
        sb.append("select a.id,a.deviceid,a.AlarmVideoPath,a.path,a.devicecode,b.busnumber,c.linename,d.departmentname,e.alarmname,a.updatetime,a.location,a.speed,a.distance,a.isbrake,a.value");
        sb.append(" from TramAlarmInfo a left join TramDeviceInfo g on a.deviceid = g.id left join TramBusInfo b on g.busid = b.id");
        sb.append(" left join TramLineInfo c on g.lineid = c.id left join TramDepartmentInfo d on g.departmentid = d.id left join TramBasicInfo e on a.alarmType=e.customId");
        sb.append(" where 1=1");
        if(!StringHelper.isEmpty(devices)){
            sb.append(" and a.deviceid in ("+devices+")");
        }
        if(!StringHelper.isEmpty(starttime))
            sb.append(" and a.updatetime>='"+starttime+"'");
        sb.append(" order by updateTime desc");
        return sb.toString()+" limit "+(page-1)*limit+","+limit;
    }

    public String getMapAlarmListCountSQL(Map<String,Object> map){
        String devices = (String)map.get("devices");
        String starttime = (String)map.get("starttime");
        StringBuilder sb = new StringBuilder();
        sb.append("select count(a.id)");
        sb.append(" from TramAlarmInfo a left join TramDeviceInfo g on a.deviceid = g.id left join TramBusInfo b on g.busid = b.id");
        sb.append(" left join TramLineInfo c on g.lineid = c.id left join TramDepartmentInfo d on g.departmentid = d.id left join TramBasicInfo e on a.alarmType=e.customId");
        sb.append(" where 1=1");
        if(!StringHelper.isEmpty(devices)){
            sb.append(" and a.deviceid in ("+devices+")");
        }
        if(!StringHelper.isEmpty(starttime))
            sb.append(" and a.updatetime>='"+starttime+"'");
        return sb.toString();
    }
    public String getAlarmViewModelSQL(Map<String,Object> map){
        long id = (Long)map.get("id");
        StringBuilder sb = new StringBuilder();
        sb.append("select a.id,a.deviceid,a.AlarmVideoPath,a.path,a.parentalarmtype,a.devicecode,b.busnumber,c.linename,d.departmentname,e.alarmname,a.updatetime,a.location,a.speed,a.distance,a.isbrake,a.value");
        sb.append(" from TramAlarmInfo a left join TramDeviceInfo g on a.deviceid = g.id left join TramBusInfo b on g.busid = b.id");
        sb.append(" left join TramLineInfo c on g.lineid = c.id left join TramDepartmentInfo d on g.departmentid = d.id left join TramBasicInfo e on a.alarmType=e.customId");
        sb.append(" where a.id="+id);
        return sb.toString();
    }

    public String getTop6AlarmSQL(Map<String,Object> map){
        List<Long> devices = (List<Long>)map.get("devices");
        StringBuilder sb = new StringBuilder();
        sb.append("select a.id,b.alarmname,a.updatetime");
        sb.append(" from TramAlarmInfo a left join TramBasicInfo b on a.alarmType=b.customId ");
        sb.append(" where a.deviceid in ("+StringHelper.listToString(devices,',')+") order by updateTime desc limit 0,6");
        return sb.toString();
    }

    public String getAlarmCountByUserId(Map<String,Object> map){
        List<Long> devices = (List<Long>)map.get("devices");
        String startTime = (String)map.get("startTime");
        String endTime = (String)map.get("endTime");
        int type = (Integer) map.get("type");
        SQL sql = new SQL();
        sql.SELECT("count(Id)");
        sql.FROM("TramAlarmInfo");
        sql.WHERE("deviceId in ("+ StringHelper.listToString(devices,',')+") and updateTime>='"+startTime+"' and updateTime<='"+endTime+"' and alarmType="+type);
        return sql.toString();
    }

    public String GetListSQL(Map<String,Object> map){
        List<Long> DeviceIds=(List<Long>)map.get("DeviceIds");
        List<Long> AlarmKeys=(List<Long>)map.get("AlarmKeys");
        int dayType=(int)map.get("dayType");
        Long typeId=(Long)map.get("typeId");
        Long alarmType=(Long)map.get("alarmType");
        String code=(String)map.get("code");
        Long lineId=(Long)map.get("lineId");
        String device=DeviceIds.size()==0?"":StringHelper.listToString(DeviceIds,',');
        String alarmkey=AlarmKeys.size()==0?"":StringHelper.listToString(AlarmKeys,',');
        SQL sql = new SQL();
        sql.SELECT("a.Id,b.DeviceCode,a.Extras,b.Id as DeviceId,c.BusNumber" +
                ",d.LineName,e.DepartmentName,f.AlarmName,f.Level,a.UpdateTime,a.AlarmValue,a.AlarmKey,a.AlarmType,a.AlarmVideoPath as path");
        sql.FROM("TramAlarmInfo a left join TramDeviceInfo b on a.DeviceId = b.Id left join TramBusInfo c on " +
                "b.BusId = c.Id left join TramLineInfo d on b.LineId = d.Id left join TramDepartmentInfo e on " +
                "b.DepartmentId = e.Id left join TramBasicInfo f on a.AlarmType = f.Id");
        sql.WHERE("a.IsShow=1 and a.deviceId in("+device+") and AlarmType in("+alarmkey+")");
        if (String.valueOf(dayType)!=null&&dayType!=0)
        {
            DayTypes types = DayTypes.getDayByType(dayType);
            sql.AND().WHERE("and datediff(dd,'"+ types.getStartTime() +"',a.UpdateTime)>=0  and datediff(dd,'"+ types.getEndTime() +"',a.UpdateTime)<=0");
        }
        if (String.valueOf(typeId)!=null&&typeId!=0)
            sql.AND().WHERE("and a.AlarmType in (select Id from TramBasicInfo where AlarmType="+ typeId +"");
        if (String.valueOf(alarmType)!=null&&alarmType!=0)
            sql.AND().WHERE("and a.AlarmType="+ alarmType +"");
        if (code!=null&&code!="")
            sql.AND().WHERE("and (b.DeviceCode like '%"+ code +"%' or c.BusNumber like '"+ code +"%')");
        if (String.valueOf(lineId)!=null&&lineId!=0)
            sql.AND().WHERE("and d.Id="+ lineId +"");
        sql.ORDER_BY("a.UpdateTime desc");
        return sql.toString();
    }

    public String GetAppAlarmChartsSQL(Map<String,Object> map)
    {
        Long Id=(Long)map.get("Id");
        int type=(int)map.get("type");
        String startTime=(String)map.get("startTime");
        String endTime=(String)map.get("endTime");
        Long lineId=(Long)map.get("lineId");
        List<Long> deviceIds=(List<Long>)map.get("deviceIds");
        SQL sql=new SQL();
        sql.SELECT("count(Id)");
        sql.FROM("TramAlarmInfo");
        if (type==1)
            sql.WHERE("AlarmType in (select Id from TramBasicInfo where AlarmType="+ Id +") and CreateTime>='"+ startTime +"' and CreateTime<='"+ endTime +"' and isShow=1 and deviceId in ("+ deviceIds +")");
        else
            sql.WHERE("AlarmType in(select Id from TramBasicInfo where AlarmType in (select id from TramAlarmTypeInfo where parentId="+ Id +")) and CreateTime>='"+ startTime +"' and CreateTime<='"+ endTime +"' and isShow=1 and deviceId in ("+ deviceIds +")");
        if (StringHelper.isNotEmpty(lineId))
            sql.AND().WHERE("DeviceId in(select Id from TramDeviceInfo where LineId=" + lineId + ")");
        return sql.toString();
    }

    public String xValCharsSQL(Map<String,Object> map)
    {
        Long Id=(Long)map.get("Id");
        Long roleLv=(Long)map.get("roleLv");
        int type=(int)map.get("type");
        SQL sql=new SQL();
        sql.SELECT("id,TypeName as Name");
        sql.FROM("TramAlarmTypeInfo");
        if (type==1) {
            sql.WHERE("parentId=0");
            if (roleLv>0)
            {
                int k = roleLv == 1 ? 1 : roleLv == 2 ? 2 : 9;
                sql.AND().WHERE("Id="+k);
            }
        }
        else
            sql.WHERE("parentId="+Id);
        return sql.toString();
    }

    public String GetAppAlarmListSQL(Map<String,Object> map){
        List<Long> departments = (List<Long>)map.get("departments");
        int dayType = (Integer)map.get("dayType");
        long lineId = (Long)map.get("lineId");
        int type = (Integer)map.get("type");
        String code = (String)map.get("code");
        int page = (Integer)map.get("page");
        int limit = (Integer)map.get("limit");
        SQL sql = new SQL();
        sql.SELECT("a.id,a.deviceCode,b.busNumber,c.lineName,d.departmentName,a.AlarmType as AlarmKey,e.alarmName,e.level,a.updateTime,a.Value as AlarmValue,a.location,a.speed,a.distance,a.isBrake");
        String condition = "a.departmentId in ("+StringHelper.listToString(departments,",")+")";
        if (String.valueOf(dayType)!=null&&dayType!=0)
        {
            DayTypes types = DayTypes.getDayByType(dayType);
            sql.AND().WHERE("and datediff(dd,'"+ types.getStartTime() +"',a.UpdateTime)>=0  and datediff(dd,'"+ types.getEndTime() +"',a.UpdateTime)<=0");
        }
        if (String.valueOf(type)!=null&&type!=0)
            sql.AND().WHERE("and a.AlarmType="+ type +"");
        if (code!=null&&code!="")
            sql.AND().WHERE("and (b.DeviceCode like '%"+ code +"%' or b.BusNumber like '"+ code +"%')");
        if (String.valueOf(lineId)!=null&&lineId!=0)
            sql.AND().WHERE("and c.Id="+ lineId +"");
        sql.WHERE(condition);
        sql.FROM("TramAlarmInfo a left join TramDeviceInfo g on a.deviceId = g.Id left join TramBusInfo b on g.busId = b.id left join TramLineInfo c on g.lineId = c.id left join TramDepartmentInfo d on a.departmentId = d.id");
        sql.ORDER_BY("a.updateTime desc");
        String where = sql.toString() + " limit "+(page-1)*limit+","+limit;
        return where;
    }

    public String GetAppAlarmListCountSQL(Map<String,Object> map){
        List<Long> departments = (List<Long>)map.get("departments");
        int dayType = (Integer)map.get("dayType");
        long lineId = (Long)map.get("lineId");
        int type = (Integer)map.get("type");
        String code = (String)map.get("code");
        SQL sql = new SQL();
        sql.SELECT("count(a.id)");
        String condition = "a.departmentId in ("+StringHelper.listToString(departments,",")+")";
        if (String.valueOf(dayType)!=null&&dayType!=0)
        {
            DayTypes types = DayTypes.getDayByType(dayType);
            sql.AND().WHERE("and datediff(dd,'"+ types.getStartTime() +"',a.UpdateTime)>=0  and datediff(dd,'"+ types.getEndTime() +"',a.UpdateTime)<=0");
        }
        if (String.valueOf(type)!=null&&type!=0)
            sql.AND().WHERE("and a.AlarmType="+ type +"");
        if (code!=null&&code!="")
            sql.AND().WHERE("and (b.DeviceCode like '%"+ code +"%' or b.BusNumber like '"+ code +"%')");
        if (String.valueOf(lineId)!=null&&lineId!=0)
            sql.AND().WHERE("and c.Id="+ lineId +"");
        sql.WHERE(condition);
        sql.FROM("TramAlarmInfo a left join TramDeviceInfo g on a.deviceId = g.Id left join TramBusInfo b on g.busId = b.id left join TramLineInfo c on g.lineId = c.id left join TramDepartmentInfo d on a.departmentId = d.id");
        return sql.toString();
    }

    public String getTodayAlarmCountSQL(Map<String,Object> map){
        List<Long> devices = (List<Long>)map.get("devices");
        String deviceStr = StringHelper.listToString(devices,',');
        String endTime = DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD);
        String sql  = "select count(Id) from TramAlarmInfo where deviceId in ("+deviceStr+") and updateTime>='"+endTime+"'";
        return sql;
    }
}
