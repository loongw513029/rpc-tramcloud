package com.sztvis.dubbo.prodiver.mapper;

import com.sztvis.common.ComboTreeModel;
import com.sztvis.domain.domain.TramDriverInfo;
import com.sztvis.domain.dto.DriverViewModel;
import com.sztvis.dubbo.prodiver.mapper.provider.DriverProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/23 上午9:04
 */
@Repository
public interface DriverMapper {


    @Select("select id,DriverName,Gender,DepartmentId,Status from TramDriverInfo where status=1")
    List<TramDriverInfo> getDrivers();

    @Select("select a.deviceCode from TramDeviceInfo a left join TramBusInfo b on a.BusId=b.Id where b.DriverId =#{driverId}")
    List<String> GetDeviceCodeByDriverId(long driverId);

    @Select("select id,drivername as text from tramDriverInfo where departmentid=#{departmentid}")
    List<ComboTreeModel> getDriverComboList(long departmentid);

    @SelectProvider(type = DriverProvider.class,method = "getDriverListSQL")
    List<DriverViewModel> getDriverList(@Param("keywords") String keywords, @Param("departmentId") long departmentId, @Param("offset") int offset, @Param("limit") int limit);

    @SelectProvider(type = DriverProvider.class,method = "getDriverListCountSQL")
    int getDriverListCount(@Param("keywords") String keywords, @Param("departmentId") long departmentId);

    @Select("select * from TramDriverInfo where id=#{Id}")
    TramDriverInfo getDriverInfo(long Id);

    @Insert("insert into TramDriverInfo(guid,drivername,gender,contactphone,departmentid,status,driverheaderimg)values(#{guid},#{drivername},#{gender},#{contactphone},#{departmentid},#{status},#{driverheaderimg})")
    void InsertDriverInfo(TramDriverInfo info);

    @Update("update TramDriverInfo set drivername=#{drivername},gender=#{gender},contactphone=#{contactphone},departmentid=#{departmentid},driverheaderimg=#{driverheaderimg} where id=#{id}")
    void UpdateDriverInfo(TramDriverInfo info);

    @DeleteProvider(type = DriverProvider.class,method = "DeleteDriverSQL")
    void RemoveDrivers(@Param("ids") List<String> ids);
}
