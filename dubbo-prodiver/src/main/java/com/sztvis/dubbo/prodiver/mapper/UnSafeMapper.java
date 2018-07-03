package com.sztvis.dubbo.prodiver.mapper;

import com.sztvis.core.DayTypes;
import com.sztvis.domain.IndexModel;
import com.sztvis.domain.UnSafeListViewModel;
import com.sztvis.domain.UnSafeQuery;
import com.sztvis.domain.domain.Tramadasreportinfo;
import com.sztvis.domain.domain.Trambehaviorreportinfo;
import com.sztvis.domain.domain.Tramunsafereportinfo;
import com.sztvis.dubbo.prodiver.mapper.provider.UnSafeProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnSafeMapper {
    @SelectProvider(type = UnSafeProvider.class,method = "GetUnsafeListSQL")
    List<UnSafeListViewModel> GetUnsafeList(@Param("query") UnSafeQuery query, @Param("deviceIds") List<Long> deviceIds, @Param("types") DayTypes types);

    @Select("select count(Id) from TramUnSafeBehaviorInfo where deviceId=#{deviceId} and UnSafeType=#{UnSafeType} and ApplyTime>=#{start} and ApplyTime<=#{end}")
    int Countunsafe(@Param("deviceId") long deviceId, @Param("UnSafeType") String UnSafeType, @Param("start") String start, @Param("end") String end);

    @Select("select count(Id) from TramUnSafeReportInfo where deviceId=#{deviceId} and UpdateTime>=#{start} and UpdateTime<=#{end}")
    int CountTramUnSafeReportInfo(@Param("deviceId") long deviceId, @Param("start") String start, @Param("end") String end);

    @Select("select count(Id) from TramAlarmInfo where deviceId=#{deviceId} and AlarmType=#{key} and UpdateTime>=#{start} and UpdateTime<=#{end}")
    int CountCanAlarm(@Param("deviceId") long deviceId, @Param("key") int key, @Param("start") String start, @Param("end") String end);

    @Insert("insert into TramUnSafeReportInfo(DeviceId,DeviceCode,UpdateTime,CarUnStopingThenOpenDoor,CarGoingThenUnCloseDoor,NeutralAndTravel,ReversingSpeeding,TravelAtNight, StartTravelSpeeding, EngineStalledTravel, RevvingUp, QuickSlowDown, EmergencyBrake, UncivilizedWhistle, ZebraCrossingUnComity, SpeedingTravel, CreateTime) values(#{deviceid},#{devicecode},#{updatetime},#{carunstopingthenopendoor},#{cargoingthenunclosedoor},#{neutralandtravel},#{reversingspeeding},#{travelatnight},#{starttravelspeeding},#{enginestalledtravel},#{revvingup},#{quickslowdown},#{emergencybrake},#{uncivilizedwhistle},#{zebracrossinguncomity},#{speedingtravel},#{createtime})")
    void InsertReportInfo(Tramunsafereportinfo info);

    @Select("select count(Id) from TramBehaviorReportInfo where deviceId=#{deviceId} and UpdateTime>=#{start} and UpdateTime<=#{end}")
    int CountBehavior(@Param("deviceId") long deviceId, @Param("start") String start, @Param("end") String end);

    @Select("select count(Id) from TramAdasReportInfo where deviceId=#{deviceId} and UpdateTime>=#{start} and UpdateTime<=#{end}")
    int CountAdas(@Param("deviceId") long deviceId, @Param("start") String start, @Param("end") String end);

    @Insert("insert into TramBehaviorReportInfo(DeviceId,DeviceCode,UpdateTime,LevelOneFatigue,LevelTwoFatigue,Smoking,Calling,StaredDown,Yawn,GazedAround,Chating,LeavePost,Occlusion,CreateTime)values(#{deviceid},#{devicecode},#{updatetime},#{levelonefatigue},#{leveltwofatigue},#{smoking},#{calling},#{stareddown},#{yawn},#{gazedaround},#{chating},#{leavepost},#{occlusion},#{createtime})")
    void InsertBehavior(Trambehaviorreportinfo behaviorInfo);

    @Insert("insert into TramAdasReportInfo(DeviceId,DeviceCode,UpdateTime,CarDistanceRemind,DangerDistance,RollLeftRoad,RoolRightRoad,LowSpeedBump,FaceBumpAlarm,BumpPerson,CreateTime)values(#{deviceid}, #{devicecode}, #{updatetime}, #{cardistanceremind}, #{dangerdistance}, #{rollleftroad}, #{roolrightroad}, #{lowspeedbump}, #{facebumpalarm}, #{bumpperson}, #{createtime})")
    void InsertAdas(Tramadasreportinfo adas);

    @Select("select updateTime from TramUnSafeIndexInfo where driverId=#{driverId} order by updatetime desc limit 1")
    String GetlastTime(long driverId);

    @SelectProvider(type = UnSafeProvider.class,method = "GetCanExtrasSQL")
    List<IndexModel> GetCanExtras(@Param("codes") List<String> codes, @Param("key") int[] key, @Param("start") String start, @Param("end") String end);

    @SelectProvider(type = UnSafeProvider.class,method = "GetUnSafeBehaviorIdSQL")
    int GetUnSafeBehaviorId(@Param("codes") List<String> codes, @Param("start") String start, @Param("end") String end);

    @Insert("insert into TramUnSafeIndexInfo(DriverId,F8,F7,F6,L8,L7,P,H8,H7,T,Result,UpdateTime)values(#{DriverId},#{F8},#{F7},#{F6},#{L8},#{L7},#{P},#{H8},#{H7},#{T},#{result},#{time})")
    void InsertUnSafeIndexInfo(@Param("DriverId") long DriverId, @Param("F8") int F8, @Param("F7") int F7, @Param("F6") int F6, @Param("L8") int L8, @Param("L7") int L7, @Param("P") int P, @Param("H8") int H8, @Param("H7") int H7, @Param("T") int T, @Param("result") double result, @Param("time") String time);
}
