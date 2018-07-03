package com.sztvis.dubbo.prodiver.mapper;

import com.sztvis.common.ComboTreeModel;
import com.sztvis.domain.domain.TramBasicInfo;
import com.sztvis.domain.domain.TramMenuInfo;
import com.sztvis.domain.domain.TramRoleInfo;
import com.sztvis.domain.dto.BasicViewModel;
import com.sztvis.domain.dto.response.RoleViewModel;
import com.sztvis.dubbo.prodiver.mapper.provider.BasicProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2017/12/28 下午5:32
 */

@Repository
public interface BasicMapper {

    @Select("select * from TramBasicInfo where id=#{Id}")
    TramBasicInfo getBasicInfoById(long Id);

    @Select("select customId from TramBasicInfo where type=#{type} and parentId>0 and customId<>''")
    List<Integer> getCustomIdsByType(int type);

    @Select("select * from TramBasicInfo where customId=#{customId} and parentId>0 and customId<>''")
    TramBasicInfo getBasicInfoByCustomId(int customId);

    @Select("select * from TramRoleInfo where parentId=#{parentId}")
    List<TramRoleInfo> getRoleList(long parentId);

    @Select("select * from TramMenuInfo where parentId=#{parentId} order by orderBy asc")
    List<TramMenuInfo> getMenuList(long parentId);

    @Select("select a.id,a.rolename,a.remark,a.parentId,b.MenuIds as roleIds from TramRoleInfo a left join tramrolemenurelinfo b on a.id=b.RoleId where a.Id=#{id}")
    RoleViewModel getRoleInfo(long id);

    @Insert("insert into TramRoleInfo(rolename,remark,parentid,departmentId,lv)values(#{rolename},#{remark},#{parentid},1,1)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertRoleInfo(TramRoleInfo roleInfo);

    @Update("update TramRoleInfo set rolename=#{rolename},remark=#{remark},parentid=#{parentid} where id=#{id}")
    void updateRoleInfo(TramRoleInfo roleInfo);

    @Insert("insert into tramrolemenurelinfo(roleId,menuids)values(#{roleId},#{roleIds})")
    void insertRoleRelInfo(@Param("roleId") long roleId, @Param("roleIds") String roleIds);

    @Delete("delete from tramrolemenurelinfo where roleId=#{roleId}")
    void deleteRoelRelInfo(long roleId);

    @Select("select id,alarmname as text from TramBasicInfo where parentid=#{parentId} and type=0 and isEnable=1")
    List<ComboTreeModel> getAlarmTypeListByParentId(long parentId);

    @SelectProvider(type = BasicProvider.class,method = "getBasicList")
    List<BasicViewModel> getBasicList(@Param("type") int type, @Param("keywords") String keywords, @Param("page") int page, @Param("size") int size);
    @SelectProvider(type = BasicProvider.class,method = "getBasicListCount")
    int getBasicListCount(@Param("type") int type, @Param("keywords") String keywords);

    @Update("update TramBasicInfo set alarmname=#{alarmName},level=#{level},fixe=#{fixe},turn=#{turn},isPush=#{isPush},customId=#{customId},isEnable=#{isEnable},threShold=#{threShold} where id=#{id}")
    void updateAlarmConfig(TramBasicInfo basicInfo);

    @Insert("insert into TramBasicInfo(alarmName,level,type,fixe,turn,isPush,threShold,customId,isEnable)values(#{alarmName},#{level},#{type},#{fixe},#{turn},#{isPush},#{threShold},#{customId},#{isEnable})")
    void insertAlarmConfig(TramBasicInfo basicInfo);

    @Select("select * from TramBasicInfo where parentId=#{parentId} and fixe=1")
    List<TramBasicInfo> getAlarmTypes(long parentId);

    @SelectProvider(type = BasicProvider.class,method = "GetAlarmKeysByUserIdSQL")
    List<Long> GetAlarmKeysByUserId(@Param("userId") Long userId, @Param("RoleLv") Long RoleLv);

    @Select("select Id,Name from TramBasicInfo where Fixe=1 and Type=1")
    List<TramBasicInfo> Types();

    @Select("select AlarmName from TramBasicInfo where Id=#{Id}")
    String BasicName(int Id);

    @Select("select * from TramBasicInfo")
    List<TramBasicInfo> GetAlarmBasicList();

    @Insert("insert into TramAlarmTypeInfo(TypeName,ParentId)values(#{TypeName},#{ParentId})")
    void InsertAlarmType(@Param("TypeName") String TypeName, @Param("ParentId") Long ParentId);

    @Update("update TramAlarmTypeInfo set TypeName={TypeName} where Id={Id}")
    void UpdateAlarmType(@Param("TypeName") String TypeName, @Param("Id") Long Id);
}
