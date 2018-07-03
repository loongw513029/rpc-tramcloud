package com.sztvis.dubbo.prodiver.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowMapper {

    @Select("select Path from TramAlarmInfo where deviceCode=#{code} and updateTime>=#{start} and updateTime<#{end}")
    List<String> GetCanPath(@Param("code") String code, @Param("start") String start, @Param("end") String end);

    @Update("update TramHostFlowCensus set alarmVideo=#{size} where deviceId=#{deviceId} and updateTime=#{time}")
    void UpdateHostFlowCensus(@Param("size") long size, @Param("deviceId") long deviceId, @Param("time") String time);

}
