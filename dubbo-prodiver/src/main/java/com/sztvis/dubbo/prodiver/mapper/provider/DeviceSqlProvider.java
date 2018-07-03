package com.sztvis.dubbo.prodiver.mapper.provider;


import com.sztvis.core.DateUtil;
import com.sztvis.core.helper.StringHelper;
import com.sztvis.domain.dto.CurrentUserInfo;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SelectBuilder.*;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/16 下午4:15
 */
public class DeviceSqlProvider {
    private static String TABLE_NAME = "TramDeviceInfo";

    public String getAllSql(){
        BEGIN();
        SELECT("*");
        FROM(TABLE_NAME);
        return SQL();
    }

    public String getDeviceCodesByLineIds(Map<String,Object> map) {
        List<Long> lineIds = (List<Long>)map.get("lineIds");
        StringBuilder sb = new StringBuilder();
        sb.append("select deviceCode from TramDeviceInfo where lineId in (");
        for (int i = 0;i<lineIds.size();i++){
            sb.append(lineIds.get(i));
            if (i + 1<lineIds.size())
                sb.append(",");
        }
        sb.append(")");
        return sb.toString();
    }

    public String getDeviceViewModel(Map<String,Object> map){
        long id = (Long) map.get("id");
        StringBuilder sb = new StringBuilder();
        sb.append("select a.id,e.bustype,a.devicecode,a.devicename,a.dchannel,a.carriageChannel,b.departmentname,c.linename,d.drivername,e.busnumber,a.clientIp,a.hostSoftType,a.deviceMode,a.videoSupport,a.can,a.radar,a.aerialView,a.supportBehavior,a.supportAdas,a.deviceStatus,a.lastOnlineTime");
        sb.append(" from TramDeviceInfo a left join TramDepartmentInfo b on a.departmentId=b.Id");
        sb.append(" left join TramBusInfo e on a.busId=e.Id");
        sb.append(" left join TramLineInfo c on a.lineId=c.Id");
        sb.append(" left join TramDriverInfo d on e.driverId=d.Id");
        sb.append(" where a.id="+id);
        return sb.toString();
    }
    public String getWebListSQL(Map<String,Object> map){
        String departments = StringHelper.listToString(((List<Long>)map.get("departments")),',');
        int deviceType = (Integer)map.get("devicetype");
        Long departmentId = (Long)map.get("departmentId");
        Long lineId = (Long)map.get("lineId");
        int status = (Integer)map.get("status");
        String keywords = (String)map.get("keywords");
        StringBuilder sb = new StringBuilder();
        sb.append("select a.id,a.devicecode,a.devicename,b.departmentname,c.linename,d.drivername,e.busnumber,a.clientIp,a.hostSoftType,a.deviceMode,a.videoSupport,a.can,a.radar,a.aerialView,a.supportBehavior,a.supportAdas,a.deviceStatus,a.lastOnlineTime");
        sb.append(" from TramDeviceInfo a left join TramDepartmentInfo b on a.departmentId=b.Id");
        sb.append(" left join TramBusInfo e on a.busId=e.Id");
        sb.append(" left join TramLineInfo c on a.lineId=c.Id");
        sb.append(" left join TramDriverInfo d on e.driverId=d.Id");
        sb.append(" where a.departmentId in ("+departments+")");
        if(deviceType>0){
            sb.append(" and a.hostSoftType="+deviceType);
        }
        if(departmentId>0){
            sb.append(" and a.departmentId="+departmentId);
        }
        if(lineId>0){
            sb.append(" and a.lineId="+lineId);
        }
        if(status!=-100){
            sb.append(" and a.deviceStatus="+status);
        }
        if(!StringHelper.isEmpty(keywords)){
            sb.append(" and (a.devicecode like '%"+keywords+"%' or a.devicename like '%"+keywords+"%' or b.busNumber like '%"+keywords+"%')");
        }
        return sb.toString();
    }

    public String updateRealtimeInspectSQL(Map<String,Object> map){
        String field = (String)map.get("field");
        Object value = map.get("value");
        String devicecode = (String)map.get("deviceCode");
        int fieldtype = (Integer)map.get("fieldtype");
        String sql ="update tramdevicestateinspectrealtimeinfo set "+field;
        switch (fieldtype){
            case 1:
                sql+="='"+(String)value+"'";
                break;
            case 2:
                sql+="="+(Double)value;
                break;
            case 3:
                sql+="="+((Boolean)value?1:0);
                break;
            case 4:
                sql+="="+(Integer)value;
                break;
        }
        sql+=" where devicecode='"+devicecode+"'";
        return sql;
    }

    public String getDeviceInspectSQL(Map<String,Object> map){
        List<Long> departments = (List<Long>)map.get("departments");
        long departmentid = (Long)map.get("departmentid");
        long lineid = (Long)map.get("lineid");
        int type = (Integer) map.get("type");
        String keywords = (String)map.get("keywords");
        StringBuilder sb = new StringBuilder();
        sb.append("select a.deviceid,a.videotape,a.video,a.harddisk,a.sdcard,a.cpuuserate,a.cputemp,a.mermoryuserate,a.disktemp,a.gpsstate,a.canstate,a.internetstate,a.gpssignelstate,a.onlinestate,a.simbalance,a.gpsinspectstate,a.caninspectstate,a.behaviorinspectstate,a.radarinspectstate,a.adasinspectstate,a.timingstate,a.deviceCode,a.surplusDiskSize,a.surplusSdcardSize,b.id as departmentid,b.departmentname,c.id as lineid,c.linename");
        sb.append(" from tramdevicestateinspectrealtimeinfo a left join tramdeviceinfo f on a.deviceid=f.id left join tramdepartmentinfo b on f.departmentid=b.id left join tramlineinfo c on c.id=f.lineid");
        sb.append(" where f.departmentid in ("+StringHelper.listToString(departments,',')+")");
        if(departmentid != 0)
            sb.append(" and f.departmentid="+departmentid);
        if(lineid != 0)
            sb.append(" and f.lineid="+lineid);
        if(!StringHelper.isEmpty(keywords))
            sb.append(" and a.devicecode like '%"+keywords+"%'");
        return sb.toString();
    }

    public String getMapDeviceListSQL(Map<String,Object> map){
        String devices = (String)map.get("devices");
        String sql="select a.id,a.devicecode,b.departmentname,c.linename,e.busnumber from tramdeviceinfo a left join trambusinfo e on a.busid=e.id left join tramdepartmentinfo b on a.departmentid=b.id left join tramlineinfo c on a.lineid=c.id where a.id in("+devices+")";
        return sql;
    }

    public String getDeviceIdByDepartmentIds(Map<String,Object> map){
        List<Long> departmens = (List<Long>) map.get("departments");
        String sql = "select id from TramDeviceInfo where departmentId in ("+StringHelper.listToString(departmens,',')+")";
        return sql;
    }

    public String getDeviceCountSQL(Map<String,Object> map){
        int state = (Integer)map.get("state");
        List<Long> departmens = (List<Long>)map.get("departments");
        SQL sql = new SQL();
        sql.SELECT("count(Id)");
        sql.FROM("TramDeviceInfo");
        if(state==0)
            sql.WHERE("departmentId in ("+StringHelper.listToString(departmens,',')+")");
        else
            sql.WHERE("departmentId in ("+StringHelper.listToString(departmens,',')+") and deviceStatus="+state);
        return sql.toString();
        //select count(Id) from TramDeviceInfo where deviceStatus=#{state} and departmentId in #{departments}
    }

    public String getOnlineCountSQL(Map<String,Object> map){
        List<Long> departmens = (List<Long>)map.get("departments");
        SQL sql = new SQL();
        sql.SELECT("count(Id)");
        sql.FROM("tramdevicestateinspectrealtimeinfo");
        sql.WHERE("deviceId in ("+StringHelper.listToString(departmens,',')+") and onlineState=1");
        return sql.toString();
    }
    public String getOnlinePrecentSQL(Map<String,Object> map){
        List<Long> departments = (List<Long>)map.get("departments");
        String startTime = (String)map.get("startTime");
        SQL sql = new SQL();
        sql.SELECT("COUNT(distinct(a.deviceCode))");
        sql.FROM("DeviceOnlineRecords as a left join TramDeviceInfo as b on a.DeviceCOde = b.DeviceCode left join TramDepartmentInfo c on b.DepartmentId = c.Id");
        sql.WHERE("c.Id in ("+StringHelper.listToString(departments,',')+") and updateTime>='"+startTime+"' and updateTime<='"+ DateUtil.getCurrentTime()+"'");
        return sql.toString();
    }

    public String getUnSafeCountSQL(Map<String,Object> map){
        List<Long> departments = (List<Long>)map.get("departments");
        String startTime = (String)map.get("startTime");
        SQL sql = new SQL();
        sql.SELECT("count(Id)");
        sql.FROM("tramunsafebehaviorinfo");
        sql.WHERE("deviceId in ("+StringHelper.listToString(departments,',')+") and ApplyTime>='"+startTime+"'");
        return sql.toString();
    }

    public String getDevices(Map<String,Object> map)
    {
        List<Long> deviceIds=(List<Long>)map.get("deviceIds");
        Long lineId=(Long)map.get("lineId");
        SQL sql=new SQL();
        sql.SELECT("a.*");
        sql.FROM("TramDeviceInfo a left join TramBusInfo b on a.BusId=b.Id");
        if (lineId ==0)
        {
            if (deviceIds!=null)
                sql.WHERE("a.id in ("+ StringHelper.listToString(deviceIds,',') +") and a.deviceStatus!=0");
        }
        else
            sql.WHERE(" b.LineId="+lineId+" and a.deviceStatus!=0");
        return sql.toString();
    }

    public String GetDriverInfoSQL(Map<String,Object> map)
    {
        Long Id=(Long) map.get("Id");
        String code=(String)map.get("code");
        SQL sql=new SQL();
        sql.SELECT("*");
        sql.FROM("TramDeviceInfo");
        if (String.valueOf(Id)!=null&&Id!=0) {
            sql.WHERE("Id=" + Id + "");
        }
        else {
            sql.WHERE("deviceCode='" + code + "'");
        }
        return sql.toString();
    }

    public String GetAppDeviceFilterSearchSQL(Map<String,Object> map)
    {
        String code=(String)map.get("Code");
        String sql="select a.Id as DeviceId,a.DeviceCode,b.Id as LineId,b.LineName " +
                "from TramDeviceInfo a left join TramLineInfo b on a.LineId=b.Id " +
                "where a.DeviceCode like '%"+ code +"%'";
        return sql;
    }

    public String GetDeviceIdsByDepartmentIdSQL(CurrentUserInfo user)
    {
        if (user.getUserName()=="admin")
            return "select Id from TramDeviceInfo";
        else
            return "select Id from TramDeviceInfo where DepartmentId in(select id from TramDepartmentInfo where Id="+ user.getDepartmentId() +" or parentId="+ user.getDepartmentId() +")";
    }

    public String AutoInspectDeviceADASSQL(Map<String,Object> map)
    {
        String SqlType = (String)map.get("SqlType");
        long deviceId = (long)map.get("deviceId");
        String start = (String)map.get("start");
        String end = (String)map.get("end");
        long[] Arr = (long[])map.get("adasArr");
        int type = (int)map.get("type");
        SQL sql=new SQL();
        if (SqlType=="devicesql"||SqlType=="csql"){
            if (SqlType=="devicesql")
                sql.SELECT("*").FROM("TramDeviceInfo");
            else
                sql.SELECT("*").FROM("TramDeviceStatusInfo").WHERE("deviceCode='"+ deviceId +"' and Type="+type).ORDER_BY("createtime desc limit 1");
        }
        else{
            sql.SELECT("count(Id)");
            if (SqlType=="adassql")
                sql.FROM("TramAlarmInfo").WHERE(" AlarmType in ("+ Arr +") and deviceCode='"+ deviceId +"' and updatetime>='"+ start +"' and updatetime<='"+ end +"'");
            else {
                if (SqlType=="radarSql")
                    sql.FROM("TramRadarInfo");
                if (SqlType=="canSql")
                    sql.FROM("TramCanInfo");
                if (SqlType=="gpsSql")
                    sql.FROM("TramGpsInfo");
                sql.WHERE("deviceId="+ deviceId +" and UpdateTime>='"+ start +"' and UpdateTime<='"+ end +"'");
            }
        }
        return sql.toString();
    }

    public String getPayRecordsSql(Map<String,Object> map){
        String cardno = (String)map.get("cardno");
        String date1 = (String)map.get("date1");
        String date2 = (String)map.get("date2");
        String sitename = (String)map.get("sitename");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("payterminalrecords").WHERE("1=1");
        if (StringHelper.isNotEmpty(cardno))
            sql.AND().WHERE("payCardNo like '%"+ cardno +"%'");
        if (StringHelper.isNotEmpty(date1))
            sql.AND().WHERE("payTime>='"+ date1 +"'");
        if (StringHelper.isNotEmpty(date2))
            sql.AND().WHERE("payTime>='"+ date2 +"'");
        if (StringHelper.isNotEmpty(sitename))
            sql.AND().WHERE("sitename like '%"+ sitename +"%'");
        sql.ORDER_BY("updateTime desc");
        return sql.toString();
    }
}
