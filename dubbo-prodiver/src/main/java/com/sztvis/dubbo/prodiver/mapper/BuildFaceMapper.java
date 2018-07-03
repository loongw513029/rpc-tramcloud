package com.sztvis.dubbo.prodiver.mapper;

import com.sztvis.domain.domain.TramPersonInfo;
import com.sztvis.domain.domain.TramPersonPics;
import com.sztvis.domain.dto.BuildFaceViewModel;
import com.sztvis.dubbo.prodiver.mapper.provider.BuildFaceProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildFaceMapper {

    @SelectProvider(type = BuildFaceProvider.class,method = "getBuildFaceListSQL")
    List<BuildFaceViewModel> getBuildFaceList(@Param("departments") List<Long> departments, @Param("keyword") String keyword, @Param("departmentId") long departmentId, @Param("sex") int sex, @Param("page") int page, @Param("rows") int rows);

    @SelectProvider(type = BuildFaceProvider.class,method = "getBuildFaceListCountSQL")
    int getBuildFaceCountList(@Param("departments") List<Long> departments, @Param("keyword") String keyword, @Param("departmentId") long departmentId, @Param("sex") int sex);

    @Select("select * from TramPersonInfo where id=#{id}")
    TramPersonInfo getPersonInfo(long id);

    @Select("select * from TramPersonPics where personId=#{id}")
    List<TramPersonPics> getPersonPicList(long id);

    @Insert("insert TramPersonInfo(name,departmentId,sex,birth,idCard,memo,credentialStype,degree,homeAddress,nation,oldName,stature,createTime)values(#{name},#{departmentId},#{sex},#{birth},#{idCard},#{memo},#{credentialStype},#{degree},#{homeAddress},#{nation},#{oldName},#{stature},#{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertPersonInfo(BuildFaceViewModel viewModel);

    @Update("update TramPersonInfo set name=#{name},departmentId=#{departmentId},sex=#{sex},birth=#{birth},idCard=#{idCard},memo=#{memo},credentialStype=#{credentialStype},degree=#{degree},homeAddress=#{homeAddress},nation=#{nation},oldName=#{oldName},stature=#{stature} where id=#{id}")
    void updatePersonInfo(BuildFaceViewModel viewModel);

    @Delete("delete from TramPersonInfo where id=#{id}")
    void removePersonInfo(long id);

    @Delete("delete from TramPersonPics where personId=#{personId}")
    void removeBatchPersonPics(long personId);

    @Insert("insert into TramPersonPics(filePath,personId)values(#{filePath},#{personId})")
    void insertPersonPics(TramPersonPics personPics);

}
