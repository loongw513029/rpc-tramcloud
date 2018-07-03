package com.sztvis.dubbo.prodiver.mapper;

import com.sztvis.domain.domain.TramLogInfo;
import com.sztvis.domain.domain.TramMemberInfo;
import com.sztvis.domain.domain.TramRoleInfo;
import com.sztvis.domain.domain.Tramloginlogfo;
import com.sztvis.domain.dto.CurrentUserInfo;
import com.sztvis.domain.dto.MemberViewModel;
import com.sztvis.dubbo.prodiver.mapper.provider.MemberProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2017/12/27 下午6:17
 */
@Repository
public interface MemberMapper {

    /**
     * get memebrinfo poco by username
     * @param username
     * @return
     */
    @Select("select * from tramMemberInfo where username=#{username}")
    TramMemberInfo getMemberByUsername(String username);

    /**
     * get memberinfo poco by id
     * @param Id
     * @return
     */
    @Select("select * from tramMemberInfo where Id=#{Id}")
    TramMemberInfo getMemberById(Long Id);

    /**
     * insert one rows memberinfo data
     * @param memberInfo
     */
    @Insert("insert into tramMemberInfo(Guid,UserName,PassWord,PassWordSalt,OwnershipId,RoleId,RoleLv,ManageScope,Status,RealName,Code,Phone,Photo,CreateTime)values(#{guid},#{username},#{password},#{passwordsalt},#{ownershipid},#{roleid},#{rolelv},#{managescope},#{status},#{realname},#{code},#{phone},#{photo},#{createtime})")
    void Insert(TramMemberInfo memberInfo);

    /**
     * edit memberinfo
     * @param trammemberinfo
     */
    @Update("update trammemberinfo set UserName=#{username}, OwnershipId=#{ownershipid}, RoleId=#{roleid}, RoleLv=#{rolelv}, ManageScope=#{managescope}, Status=#{status}, RealName=#{realname}, Code=#{code}, Phone=#{phone},Photo=#{photo} where Id=#{id}")
    void Update(TramMemberInfo trammemberinfo);

    /**
     * modify memberpwd by Id
     * @param newpwd
     * @param Id
     */
    @Update("update trammemberinfo set Password=#{newpwd} where Id=#{Id}")
    void ModifyPwd(String newpwd, Long Id);

    /**
     * get CurrentUserInfo by ID
     * @param Id
     * @return
     */
    @Select("select a.Id,a.guid as uuid,a.UserName,a.RoleId,b.RoleName,a.Phone,a.Photo,a.RealName,a.OwnershipId as DepartmentId,c.DepartmentType,a.RoleLv,a.ManageScope from TramMemberInfo as a left join TramRoleInfo as b on a.RoleId=b.Id left join TramDepartmentInfo as c on b.DepartmentId = c.Id where a.Id=#{Id}")
    CurrentUserInfo GetCurrentUserInfo(Long Id);

    /**
     * insert one login records
     * @param loginLogInfo
     */
    @Insert("insert into TramLoginLogInfo(UserId,LoginTime,LoginType,ClientId,ClientIp,AccessToken,RefreshToken)values(#{UserId},#{LoginTime},#{LoginType},#{ClientId},#{ClientIp},#{AccessToken},#{RefreshToken})")
    void InsertLoginLog(Tramloginlogfo loginLogInfo);

    /**
     *
     * @param departmentIds
     * @param departments
     * @param username
     * @return
     */
    @SelectProvider(type = MemberProvider.class,method = "getUserListSQL")
    List<MemberViewModel> getUserList(@Param("departmentIds") String departmentIds, @Param("departments") List<Long> departments, @Param("username") String username);

    @Delete("delete from TramMemberInfo where id in (#{userIds})")
    void remove(String userIds);

    @Select("select count(Id) from TramMemberInfo where username=#{username}")
    int getCountByUsername(String username);

    @Select("select * from TramRoleInfo where Id=#{Id}")
    TramRoleInfo GetRoleInfo(Long Id);

    @Update("update TramMemberInfo set PassWord=#{newPwd} where Id=#{userId}")
    void ChangePassWord(@Param("userId") long userId, @Param("newPwd") String newPwd);

    @Update("update TramMemberInfo set Photo=#{filePath} where Id=#{userId}")
    void ModifyUserPhoto(@Param("userId") long userId, @Param("filePath") String filePath);

    @SelectProvider(type = MemberProvider.class,method = "getMemberGuidByDepartmentIds")
    List<String> getMemberUUIDbyDepartmentId(@Param("departments") List<Long> departments);

    @Insert("insert into TramLogInfo(uid,logTime,contentIp,login_status,action)values(#{uid},#{logTime},#{contentIp},#{login_status},#{action})")
    void insertLogInfo(TramLogInfo logInfo);

    @Select("select id,uid,logTime,contentIp,login_status,action from TramLogInfo where uid=#{uid} order by logTime desc limit 0,1")
    TramLogInfo getLastLogInfo(long uid);

    @Select("select count(id) from TramLogInfo where uid=#{uid} and contentIp=#{contentIp} and login_status=#{login_status} and logTime between #{start} and #{end}")
    int getErrorLoginCount(@Param("start") String start, @Param("end") String end, @Param("uid") long uid, @Param("contentIp") String contentIp, @Param("login_status") int login_status);

    @Update("update TramMemberInfo set status=#{status} where id=#{id}")
    void updateMemberStatus(long id, int status);


}
