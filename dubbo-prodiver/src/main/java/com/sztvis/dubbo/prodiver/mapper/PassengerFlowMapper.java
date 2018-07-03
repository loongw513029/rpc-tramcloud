package com.sztvis.dubbo.prodiver.mapper;

import com.sztvis.domain.domain.TramPassengerFlow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/3/29 上午11:21
 */
@Repository
public interface PassengerFlowMapper {

    @Insert("insert into TramPassengerFlow(deviceCode,deviceId,updateTime,type,klNumber1,klNumber2)values(#{deviceCode},#{deviceId},#{updateTime},#{type},#{klNumber1},#{klNumber2})")
    void insertPassengerFlow(TramPassengerFlow passengerFlow);

    @Select("selec * from TramPassengerFlow where deviceCode=#{code} and updateTime<=#{time} order by updateTime desc limit 1")
    TramPassengerFlow Getinfo(@Param("code") String code, @Param("time") String time);
}
