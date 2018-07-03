package com.sztvis.dubbo.prodiver.mapper;

import com.sztvis.domain.domain.CanHistoryEveryDayInfo;
import com.sztvis.domain.domain.TramCanInfo;
import com.sztvis.domain.domain.TramUnsafeBehaviorInfo;
import com.sztvis.dubbo.prodiver.mapper.provider.CanProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/3/1 下午3:19
 */
@Repository
public interface CanMapper {

    @Insert("insert into TramUnsafeBehaviorInfo(deviceid,devicecode,unsafetype,unsafetime,speed,ratespeed,applytime,location,createtime)values(#{deviceid},#{devicecode},#{unsafetype},#{unsafetime},#{speed},#{ratespeed},#{applytime},#{location},#{createtime})")
    void insertUnsafeInfo(TramUnsafeBehaviorInfo unsafeBehaviorInfo);

    @Select("select a.* from canhistoryeverydayinfo a left join tramdeviceinfo b on a.DeviceId=b.Id where b.LineId=#{lineId} and a.updateTime>=#{startTime} and a.updateTime<#{endTime}")
    List<CanHistoryEveryDayInfo> getCanHistoryDayInfo(@Param("lineId") long lineId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    @Select("select count(a.Id) from TramAlarmInfo a left join TramDeviceInfo b on a.deviceId=b.Id left join TramBasicInfo c on a.alarmType=c.customid where b.lineId=#{lineId} and a.updateTime>=#{startTime} and a.updateTime<=#{endTime} and c.id=#{type}")
    int getAlarmTrendsCountByLineId(@Param("lineId") long lineId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("type") int type);

    @Select("select count(a.Id) from TramAlarmInfo a left join TramBasicInfo b on a.alarmType=b.customId where a.deviceId=#{deviceId} and a.updateTime>=#{startTime} and a.updateTime<=#{endTime} and b.id=#{type}")
    int getAlarmTrendsCountByDeviceId(@Param("deviceId") long deviceId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("type") int type);

    @Select("select * from TramCanInfo where DeviceId=#{code} and updateTime<=#{time} order by updatetime desc limit 1")
    TramCanInfo GetCanInfoByLastTime(@Param("code") Long code, @Param("time") String time);

    @Select("select count(Id) from TramCanInfo where DeviceCode=#{devicecode} and UpdateTime>=#{startTime} and UpdateTime<=#{endTime}")
    int GetCanInfoBy10sTime(@Param("devicecode") String DeviceCode, @Param("startTime") String StartTime, @Param("endTime") String EndTime);

    @Select("select count(Id) from TramAlarmInfo where UpdateTime>=#{date1} and UpdateTime<=#{date2} and IsShow=1 and state=0 and DeviceId in(#{DeviceIds}) and AlarmKey in (#{AlarmKeys})")
    int GetTotal(@Param("date1") String date1, @Param("date2") String date2, @Param("DeviceIds") String DeviceIds, @Param("AlarmKeys") String AlarmKeys);

    @SelectProvider(type = CanProvider.class,method = "CalcDeviceCanHistorysSQL")
    Long GetTop1CanInfo(@Param("type") String type, @Param("deviceId") long deviceId, @Param("start") String start, @Param("end") String end);
    Long GetTop1CanInfo(@Param("type") String type, @Param("deviceId") long deviceId, @Param("start") String start, @Param("end") String end, @Param("level") int level);
    Double GetTop1CanInfo(@Param("type") String type, @Param("devicecode") String devicecode, @Param("start") String start, @Param("end") String end);
    Long GetTop1CanInfo(@Param("type") String type, @Param("deviceId") long deviceId, @Param("start") String start, @Param("end") String end, @Param("arr") int[] arr);
    void GetTop1CanInfo(@Param("type") String type, @Param("info") CanHistoryEveryDayInfo info);

    @SelectProvider(type = CanProvider.class,method = "GetAlarmChartList")
    int GetAlarmChartList(@Param("code") String code, @Param("lineId") long lineId, @Param("type") int type, @Param("type1") String type1, @Param("start") String start, @Param("end") String end, @Param("departmentId") long departmentId);

    @Select("select alarmName from tramBasicInfo where Id=#{Id}")
    String GetAlarmChartList2(int Id);

    @Select("select count(Id) from TramAlarmInfo where deviceId=#{deviceId} and alarmType=#{key} and updateTime=#{updateTime}")
    int getAlarmCountByKeyAndUpdateTime(@Param("deviceId") long deviceId, @Param("key") int key, @Param("updateTime") String updateTime);

    @Select("select * from CanHistoryEveryDayInfo where deviceId=#{deviceId} and updatetime>=#{start} and updatetime<=#{end}")
    List<CanHistoryEveryDayInfo> getCanHistoryBus(@Param("deviceId") long device, @Param("start") String start, @Param("end") String end);

    @Select("select count(a.Id) from TramAlarmInfo a left join tramBasicInfo b on a.alarmType = b.customId where a.deviceId=#{deviceId} and a.updatetime>=#{start} and a.updatetime<=#{end} and b.id=#{type}")
    int getAlarmTrendsCountBydevice(@Param("deviceId") long deviceId, @Param("start") String startTime, @Param("end") String endTime, @Param("type") int type);

}
