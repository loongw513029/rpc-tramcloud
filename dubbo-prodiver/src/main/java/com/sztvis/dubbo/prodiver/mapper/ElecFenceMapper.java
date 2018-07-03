package com.sztvis.dubbo.prodiver.mapper;

import com.sztvis.domain.domain.TramElectronicFenceInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElecFenceMapper {

    @Select("select * from TramElectronicFenceInfo")
    List<TramElectronicFenceInfo> getElecFenceList();

    @Insert("insert into TramElectronicFenceInfo(lng,lat,radius,inTrun,outTrun)values(#{lng},#{lat},#{radius},#{inTrun},#{outTrun})")
    void insertElecFenceInfo(TramElectronicFenceInfo info);

    @Select("select * from TramElectronicFenceInfo where id=#{id}")
    TramElectronicFenceInfo getElecFenceInfo(long id);
}
