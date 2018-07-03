package com.sztvis.dubbo.prodiver.mapper;

import com.sztvis.domain.dto.MaintenanceInfo;
import com.sztvis.dubbo.prodiver.mapper.provider.MaintenanceProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceMapper {

    @Insert("insert into MaintenanceInfo(DeviceId,MtDate,MtMileage,Project,NextDate,NextMileage,Description,CreateTime)values(#{DeviceId},#{MtDate},#{MtMileage},#{Project},#{NextDate},#{NextMileage},#{Description},#{CreateTime})")
    void AddMaintenanceInfo(MaintenanceInfo maintenanceInfo);

    @Select("select a.Id,a.DeviceId,a.MtDate,a.MtMileage,a.Project,a.NextDate,a.NextMileage,a.Description,a.CreateTime,b.DeviceCode from MaintenanceInfo a left join TramDeviceInfo b on a.DeviceId=b.Id where a.deviceId in (#{deviceIds}) order by a.createtime desc")
    List<MaintenanceInfo> GetCurrentAccountsMaintenanceList(String deviceIds);

    @SelectProvider(type = MaintenanceProvider.class,method = "GetMaintenance")
    List<MaintenanceInfo> GetMaintenance(@Param("Code") String Code, @Param("DepartmentId") long DepartmentId, @Param("lineId") long lineId, @Param("statr") String statr, @Param("end") String end);

    @Select("select a.*,b.DeviceCode from MaintenanceInfo a left join TramDeviceInfo b on a.deviceId=b.Id order by a.MtDate desc limit 0,8")
    List<MaintenanceInfo> getTop6List();
}
