package com.sztvis.dubbo;


import com.sztvis.domain.domain.TramLogInfo;
import com.sztvis.domain.domain.TramMemberInfo;
import com.sztvis.domain.dto.CurrentUserInfo;
import com.sztvis.domain.dto.LoginParams;
import com.sztvis.domain.dto.MemberViewModel;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/4 下午2:17
 */
public interface IMemberService {
    CurrentUserInfo Login(LoginParams loginParams, HttpServletRequest request) throws ParseException;

    TramMemberInfo getMemberInfo(long userId);

    List<MemberViewModel> getMemberList(long userId, String seldepartmentIds, String keywords);

    void saveAndUpdateMember(TramMemberInfo memberInfo);

    void removeUser(String userIds);

    void ChangePassWord(long userId, String oldPwd, String newPwd);

    void ModifyUserPhoto(long userId, String filePath);

    List<String> getMemberUUIDbyDepartmentId(List<Long> departmentIds);

    List<String> getMemberUUIDByDeviceCode(String deviceCode);

    CurrentUserInfo Logins(LoginParams loginParams);

    String getpwd(String username);

    TramMemberInfo getMemberInfoByUserName(String username);

    TramLogInfo getLastLogInfoByUid(long uid);

    void insertTramLogInfo(TramLogInfo logInfo);

    int getLoginErrorCount(long uid, String contentIp);
}
