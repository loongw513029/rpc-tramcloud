package com.sztvis.dubbo.prodiver.mapper;

import com.sztvis.common.ComboTreeModel;
import com.sztvis.domain.domain.TramChannelInfo;
import com.sztvis.domain.domain.TramLineInfo;
import com.sztvis.domain.domain.TramMemberInfo;
import com.sztvis.domain.dto.LineViewModel;
import com.sztvis.domain.dto.SelectViewModel;
import com.sztvis.dubbo.prodiver.mapper.provider.LineProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/4 下午6:23
 */
@Repository
public interface LineMapper {

    @Select("select * from TramLineInfo where departmentId=#{departmentId} order by sort asc")
    List<TramLineInfo> GetLinesByDepartmentId(long departmentId);

    @SelectProvider(type = LineProvider.class,method = "getLineIdsByDepartmentIdsSQL")
    Integer GetLineIdsByDepartmentIds(@Param("departmentId") List<Long> departmentId);

    @SelectProvider(type = LineProvider.class,method = "getListSQL")
    List<LineViewModel> getList(@Param("departments") List<Long> departments, @Param("linename") String lineName, @Param("departmentId") long departmentId);

    @Select("select * from TramLineInfo where id=#{id}")
    TramLineInfo getLineInfo(long id);

    @SelectProvider(type = LineProvider.class,method = "getLineTreeSQL")
    List<ComboTreeModel> getLineTreeList(@Param("departments") List<Long> departments);

    @Insert("insert into TramLineInfo(guid,linecode,linename,departmentid,lineupmileage,linedownmileage,upsitenum,downsitenum)values(#{guid},#{linecode},#{linename},#{departmentid},#{lineupmileage},#{linedownmileage},#{upsitenum},#{downsitenum})")
    void saveLine(TramLineInfo lineInfo);

    @Update("update TramLineInfo set linecode=#{linecode},linename=#{linename},departmentid=#{departmentid},lineupmileage=#{lineupmileage},linedownmileage=#{linedownmileage},upsitenum=#{upsitenum},downsitenum=#{downsitenum} where id=#{id}")
    void updateLine(TramLineInfo lineInfo);

    @Delete("delete from TramLineInfo where id in (#{lineIds})")
    void removeLine(String lineIds);

    @Select("select count(Id) from TramDeviceInfo where LineId=(#{lineId}) and DeviceStatus!=0")
    int carNum(long lineId);

    @Select("select count(Id) from TramDeviceInfo where LineId=(#{lineId}) and DeviceStatus=1")
    int onlineNum(long lineId);

    @Select("select count(Id) from TramUnSafeBehaviorInfo where DeviceId in(select Id from TramDeviceInfo where LineId= #{lineId}) and datediff(#{Nowtime},ApplyTime)>=0")
    int unsafeNum(@Param("lineId") Long lineId, @Param("Nowtime") String Nowtime);

    @SelectProvider(type = LineProvider.class,method = "getDropDownLineSQL")
    List<SelectViewModel> GetDropDownLine(TramMemberInfo user, int type, List<Long> arr, String msg);

    @Select("select Id from TramLineInfo where DepartmentId in(select Id from TramDepartmentInfo where Id=#{OwnershipId} or ParentId=#{OwnershipId})")
    List<Long> LineId(Long OwnershipId);

    @Select("select * from TramChannelInfo where Id=#{deviceId} order by No asc")
    List<TramChannelInfo> GetChannlsByDeviceId(Long deviceId);

}
