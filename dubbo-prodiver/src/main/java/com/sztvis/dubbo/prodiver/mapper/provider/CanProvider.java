package com.sztvis.dubbo.prodiver.mapper.provider;

import com.sztvis.core.helper.StringHelper;
import com.sztvis.domain.domain.CanHistoryEveryDayInfo;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/3/14 上午10:45
 */
public class CanProvider {
    public String CalcDeviceCanHistorysSQL(Map<String,Object> map){
        String type = (String)map.get("type");
        SQL sql = new SQL();
        if (type=="sql"){
            CanHistoryEveryDayInfo info= (CanHistoryEveryDayInfo)map.get("info");
            sql.INSERT_INTO("CanHistoryEveryDayInfo").INTO_COLUMNS("DeviceId,UpdateTime,TotalMileage,GasOnlieAvg,ElectricAvg,GasAvg,TotalFaultNumber,TotalCarFaultNumber,FaultThreeLv,FaultSecondLv,FaultOneLv,UnSafeNumber,UnSafeDriver,RunTimeLong,SpeedingTotal")
                    .INTO_VALUES(info.getDeviceid().toString(),info.getUpdatetime(),info.getTotalmileage().toString(),info.getGasonlieavg().toString(),info.getElectricavg().toString(),
                            info.getGasavg().toString(),info.getTotalfaultnumber().toString(),info.getTotalcarfaultnumber().toString(),info.getFaultthreelv().toString(),info.getFaultsecondlv().toString(),
                            info.getFaultonelv().toString(),info.getUnsafedriver().toString(),info.getRuntimelong().toString(),info.getSpeedingtotal().toString());
        }
        if (type=="timelongsql"){
            String devicecode = (String)map.get("devicecode");
            String start = (String)map.get("start");
            String end = (String)map.get("end");
            sql.SELECT("sum(TotalTime)").FROM("TramDeviceOnLineTimeLongInfo")
            .WHERE("devicecode='"+ devicecode +"'")
            .AND().WHERE("CreateTime>='"+ start +"'")
            .AND().WHERE("CreateTime<='"+ end +"'");
        }
        else {
            if (type=="faultSql2"){
                long deviceId = (long)map.get("deviceId");
                int level = (int)map.get("level");
                String start = (String)map.get("start");
                String end = (String)map.get("end");
                sql.SELECT("count(a.Id)").FROM("TramAlarmInfo a left join TramBasicInfo b on a.AlarmType=b.Id")
                .WHERE(" a.deviceId="+ deviceId +" and a.UpdateTime>='"+ start +"' and a.UpdateTime<='"+ end +"' and b.Level="+ level +" and a.state=0 and a.isshow=1");
            }
            else{
                sql.SELECT("count(Id)");
                if (type=="faultSql"||type=="undriversql") {
                    long deviceId = (long)map.get("deviceId");
                    String start = (String)map.get("start");
                    String end = (String)map.get("end");
                    sql.FROM("TramAlarmInfo")
                            .WHERE("deviceId="+ deviceId +" and UpdateTime>='"+ start +"' and UpdateTime<='"+ end +"' and state=0 and isshow=1");
                    if (type=="undriversql"){
                        int[] arr = (int[])map.get("arr");
                        sql.AND().WHERE("AlarmType in ("+ StringHelper.listToString(StringHelper.IntegersToStrings(arr),',') +")");
                    }
                }
                if (type=="isexitsql"){
                    long deviceId = (long)map.get("deviceId");
                    String start = (String)map.get("start");
                    String end = (String)map.get("end");
                    sql.FROM("CanHistoryEveryDayInfo").WHERE("deviceId="+ deviceId +" and updateTime='"+ start +"'");
                }
                if  (type=="unsafeSql"||type=="speedingSQL"){
                    long deviceId = (long)map.get("deviceId");
                    String start = (String)map.get("start");
                    String end = (String)map.get("end");
                    sql.FROM("TramUnSafeBehaviorInfo").WHERE("deviceId="+ deviceId)
                    .AND().WHERE("ApplyTime>='"+ start +"'")
                    .AND().WHERE("ApplyTime<='"+ end +"'");
                    if (type=="speedingSQL")
                        sql.AND().WHERE("UnSafeType=13");
                }
            }
        }
        return sql.toString();
    }

    public String GetAlarmChartList(Map<String,Object> map){
        String code = (String)map.get("code");
        long lineId = (long)map.get("lineId");
        int type = (int)map.get("type");
        String type2 = (String) map.get("type1");
        String start = (String) map.get("start");
        String end = (String)map.get("end");
        long DepartmentId = (long)map.get("departmentId");
        SQL sql = new SQL();
        sql.SELECT("count(Id)").FROM("TramAlarmInfo");
        if (type!=0) {
            if (!type2.equals("0"))
                sql.AND().WHERE("AlarmType in (select customId from tramBasicInfo where Id=" + type2 + ") and ParentAlarmType="+type);
            else
                sql.AND().WHERE("AlarmType in (select customId from tramBasicInfo where parentId=" + type + ")");
        }
        if (!StringHelper.isEmpty(code)&&!code.equals("undefined"))
            sql.AND().WHERE("devicecode like '%"+ code +"%'");
        else{
            if (DepartmentId!=0){
                if (lineId!=0)
                    sql.AND().WHERE("devicecode in(select devicecode from TramDeviceInfo where LineId=" + lineId + " and DepartmentId=" + DepartmentId + ")");
                else
                    sql.AND().WHERE("DepartmentId=" + DepartmentId);
            }
        }
        sql.AND().WHERE(" UpdateTime>='"+ start +"'");
        sql.AND().WHERE(" UpdateTime<='"+ end +"'");
        return sql.toString();
    }

}
