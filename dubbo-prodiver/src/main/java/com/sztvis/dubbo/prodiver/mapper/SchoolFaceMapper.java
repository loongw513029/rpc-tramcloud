package com.sztvis.dubbo.prodiver.mapper;

import com.sztvis.domain.domain.TramDriverSimilarRecord;
import com.sztvis.domain.dto.SchoolFaceViewModel;
import com.sztvis.dubbo.prodiver.mapper.provider.SchoolFaceProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolFaceMapper {

    @Insert("insert into TramDriverSimilarRecord(deviceId,deviceCode,fingerPrintPass,drunkDrive,faceCompairison,similar,driverPics,updateTime)values(#{deviceId},#{deviceCode},#{fingerPrintPass},#{drunkDrive},#{faceCompairison},#{similar},#{driverPics},#{updateTime})")
    void insertDriverSimilarRecord(TramDriverSimilarRecord record);

    @SelectProvider(type = SchoolFaceProvider.class,method = "getSchoolFaceListSQL")
    List<SchoolFaceViewModel> getSchoolFaceList(@Param("name") String name, @Param("page") int page, @Param("rows") int rows);

    @SelectProvider(type = SchoolFaceProvider.class,method = "getSchoolFaceListCountSQL")
    int getSchoolFaceCount(@Param("name") String name);

    @Update("update TramDriverSimilarRecord set driverPics=#{image} where deviceCode=#{deviceCode} and updateTime=#{updateTime}")
    void updateSchoolFaceImage(@Param("image") String image, @Param("deviceCode") String deviceCode, @Param("updateTime") String updateTime);

}
