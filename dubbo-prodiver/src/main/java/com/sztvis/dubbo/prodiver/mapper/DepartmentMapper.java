package com.sztvis.dubbo.prodiver.mapper;

import com.sztvis.domain.domain.TramDepartmentInfo;
import com.sztvis.domain.dto.response.DepartmentViewModel;
import com.sztvis.dubbo.prodiver.mapper.provider.DepartmentProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2017/12/28 下午5:21
 */
@Repository
public interface DepartmentMapper {

    /**
     * Get DepartmentInfo by Id
     * @param Id
     * @return
     */
    @Select("select Id,Guid,Code,DepartmentName,DepartmentType,ParentId,ContactPhone,Sort,IsLookCan,IsHaveVedio,OrgType,AppName,Remark,CreateTime from TramDepartmentInfo where Id=#{Id}")
    TramDepartmentInfo GetDepartmentInfo(Long Id);

    @Select("select Id,Guid,Code,DepartmentName,DepartmentType,ParentId,ContactPhone,Sort,IsLookCan,IsHaveVedio,OrgType,AppName,Remark,CreateTime from TramDepartmentInfo where parentId=0")
    List<TramDepartmentInfo> getDepartmentListMapper();

    /**
     *
     * @param departmentIds
     * @return
     */
    @SelectProvider(type = DepartmentProvider.class,method = "GetListByDepartmentsSQL")
    List<TramDepartmentInfo> GetDepartmentList(List<Long> departmentIds);

    /**
     *
     * @param userId
     * @return
     */
    @Select("select * from TramDepartmentInfo a left join TramMemberInfo b on a.Id=b.OwnershipId where b.id=#{userId}")
    TramDepartmentInfo GetDepartmentIdsByUserId(long userId);

    /**
     * 根据父Id获得机构列表
     * @param parentId
     * @return
     */
    @Select("select * from TramDepartmentInfo where parentId=#{parentId}")
    List<TramDepartmentInfo> GetDepartmentsByParentId(long parentId);

    @Select("select * from TramDepartmentInfo where Id=#{Id}")
    TramDepartmentInfo GetDepartmentsById(Long Id);

    /**
     *
     * @param departmentId
     * @return
     */
    @Select("select Id from TramDepartmentInfo where Id=#{departmentId} or parentId=#{departmentId}")
    List<Long> GetPartmentIdsByDepartmentId(long departmentId);

    @Select("select Id from TramDepartmentInfo")
    List<Long> getAllDepartmentIds();
    /**
     *
     * @param text
     * @return
     */
    @SelectProvider(type = DepartmentProvider.class,method = "GetDepartmentListSQL")
    List<DepartmentViewModel> GetList(@Param("text") String text, @Param("departments") List<Long> departments);

    @Insert("insert into TramDepartmentInfo(id,guid,code,departmentname,departmenttype,parentid,contactname,contactphone,sort,islookcan,ishavevedio,orgtype,appname,remark,createtime)values(#{id},#{guid},#{code},#{departmentname},#{departmenttype},#{parentid},#{contactname},#{contactphone},#{sort},#{islookcan},#{ishavevedio},#{orgtype},#{appname},#{remark},#{createtime})")
    void insertDepartment(TramDepartmentInfo info);

    @Delete("delete from TramDepartmentInfo where id in(#{departmentIds})")
    void removeDepartment(String departmentIds);

    @Update("update TramDepartmentInfo set code=#{code},departmentname=#{departmentname},departmenttype=#{departmenttype},parentid=#{parentid},contactname=#{contactname},contactphone=#{contactphone},sort=#{sort},islookcan=#{islookcan},ishavevedio=#{ishavevedio},appname=#{appname},remark=#{remark} where id=#{id}")
    void updateDepartment(TramDepartmentInfo departmentInfo);

    @Select("select * from TramDepartmentInfo where departmentcode=#{departmentCode}")
    TramDepartmentInfo getDepartmentInfoByCode(String departmentCode);

    @Select("select * from TramDepartmentInfo where id=#{parentDepartmentId} or parentid=#{parentDepartmentId}")
    List<TramDepartmentInfo> getDepartmentListByParentId(long parentDepartmentId);

    @Select("select * from TramDepartmentInfo where id=(select departmentId from TramDeviceInfo where deviceCode=#{deviceCode})")
    TramDepartmentInfo getDepartmentInfoByDeviceCode(String deviceCode);

}
