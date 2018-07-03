package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.core.DateUtil;
import com.sztvis.core.TramException;
import com.sztvis.core.helper.NetworkHelper;
import com.sztvis.core.helper.SecureHelper;
import com.sztvis.core.helper.StringHelper;
import com.sztvis.domain.domain.TramDepartmentInfo;
import com.sztvis.domain.domain.TramLogInfo;
import com.sztvis.domain.domain.TramMemberInfo;
import com.sztvis.domain.dto.AppRoleModel;
import com.sztvis.domain.dto.CurrentUserInfo;
import com.sztvis.domain.dto.LoginParams;
import com.sztvis.domain.dto.MemberViewModel;
import com.sztvis.dubbo.IBasicService;
import com.sztvis.dubbo.IDepartmentService;
import com.sztvis.dubbo.IMemberService;
import com.sztvis.dubbo.prodiver.mapper.DepartmentMapper;
import com.sztvis.dubbo.prodiver.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author longweiqian
 * @company tvis
 * @date 2017/12/28 下午4:55
 */
@Service(version = "1.0.0")
public class MemberService implements IMemberService {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    @Reference(version = "1.0.0")
    private IDepartmentService iDepartmentService;

    @Reference(version = "1.0.0")
    private IBasicService basicService;

    /**
     * 登录
     * @param loginParams
     * @return
     */
    @Override
    public CurrentUserInfo Login(LoginParams loginParams, HttpServletRequest request) {
        System.out.println(loginParams.getPassword());
        if(StringHelper.isEmpty(loginParams.getUsername())||StringHelper.isEmpty(loginParams.getPassword())){
            throw new TramException("参数不完整！");
        }
        if(loginParams.getLogintype()==3){
            if(StringHelper.isEmpty(loginParams.getVerifycode()))
                throw new TramException("验证码不能为空！");
            String verifycode = request.getSession().getAttribute("rand").toString();
            if(!verifycode.equals(loginParams.getVerifycode().toLowerCase()))
                throw new TramException("验证码不正确！");
        }
        TramMemberInfo memberInfo = memberMapper.getMemberByUsername(loginParams.getUsername());
        if(memberInfo == null){
            throw new TramException("不存在当前用户名！");
        }
        String Password = SecureHelper.encryptToMD5(loginParams.getPassword()+memberInfo.getPasswordsalt());
        String ip = NetworkHelper.getIpAddr(request);
        TramLogInfo lastlogInfo = this.getLastLogInfoByUid(memberInfo.getId());
        if(lastlogInfo != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long hour = 0;
            try {
                hour = (new Date().getTime() - sdf.parse(lastlogInfo.getLogTime()).getTime()) / (1000 * 60 * 10);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (memberInfo.getStatus() == 2 && hour >= 2) {
                this.memberMapper.updateMemberStatus(memberInfo.getId(), 1);
                memberInfo.setStatus(1L);
            }
        }
        if(memberInfo.getStatus()==2)
            throw new TramException("该账号已被禁用！");
        int loginErrorCount = this.getLoginErrorCount(memberInfo.getId(),ip);
        if(loginErrorCount>=5) {
            this.memberMapper.updateMemberStatus(memberInfo.getId(),2);
            throw new TramException("该账号密码错误已超过5次，系统将禁用该账号登录两小时！");
        }
        TramLogInfo logInfo = new TramLogInfo(memberInfo.getId(), DateUtil.getCurrentTime(),ip,!Password.equals(memberInfo.getPassword())?0:1,"");
        if(!Password.equals(memberInfo.getPassword())){
            throw new TramException("密码错误！");
        }
        this.insertTramLogInfo(logInfo);
        CurrentUserInfo currentUserInfo = memberMapper.GetCurrentUserInfo(memberInfo.getId());
        TramDepartmentInfo departmentinfo = departmentMapper.GetDepartmentInfo(currentUserInfo.getDepartmentId());
        currentUserInfo.setDepartmentName(departmentinfo.getDepartmentname());
        currentUserInfo.setDeviceScopes(basicService.GetDeviceScopeByUserId(currentUserInfo.getId()));
        if(departmentinfo.getParentid()!=0){
            departmentinfo=departmentMapper.GetDepartmentInfo(departmentinfo.getParentid());
        }
        AppRoleModel roleModel =new AppRoleModel();
        roleModel.setAppName(departmentinfo.getAppname());
        roleModel.setHaveCan(departmentinfo.getIslookcan()==1);
        roleModel.setHaveGps(true);
        roleModel.setHaveVedio(departmentinfo.getIshavevedio()==1);
        currentUserInfo.setAppConf(roleModel);
        //Tramloginlogfo logInfo = new Tramloginlogfo();
        //logInfo.setAccesstoken();
        return currentUserInfo;
    }
    @Override
    public CurrentUserInfo Logins(LoginParams loginParams){
        TramMemberInfo memberInfo = memberMapper.getMemberByUsername(loginParams.getUsername());
        System.out.println(loginParams.getPassword());
//        Object Md5 = new SimpleHash("MD5",loginParams.getPassword(),null,1024);
//        Subject currentUser = SecurityUtils.getSubject();
//        if (currentUser.isAuthenticated()==false){
//            System.out.println(Md5.toString());
//            UsernamePasswordToken token = new UsernamePasswordToken(loginParams.getUsername(), Md5.toString()); // 获取当前的Subject
//            //token.setRememberMe(true);
//            //System.out.println(token.getPassword());
//            try{
//                currentUser.login(token);
//                Session session = currentUser.getSession();
//                session.setAttribute("username",loginParams.getUsername());
//                System.out.println("验证完毕!!!!!!!!!!!!");
//            }
//            catch (IncorrectCredentialsException e){
//                throw new ResultMapException("密码错误");
//            }
//            catch (AuthenticationException e){
//                System.out.println(e.getMessage().toString());
//                throw new ResultMapException("其他错误");
//            }
//
//        }
        CurrentUserInfo currentUserInfo = memberMapper.GetCurrentUserInfo(memberInfo.getId());
        TramDepartmentInfo departmentinfo = departmentMapper.GetDepartmentInfo(currentUserInfo.getDepartmentId());
        currentUserInfo.setDepartmentName(departmentinfo.getDepartmentname());
        currentUserInfo.setDeviceScopes(basicService.GetDeviceScopeByUserId(currentUserInfo.getId()));
        if(departmentinfo.getParentid()!=0){
            departmentinfo=departmentMapper.GetDepartmentInfo(departmentinfo.getParentid());
        }
        AppRoleModel roleModel =new AppRoleModel();
        roleModel.setAppName(departmentinfo.getAppname());
        roleModel.setHaveCan(departmentinfo.getIslookcan()==1);
        roleModel.setHaveGps(true);
        roleModel.setHaveVedio(departmentinfo.getIshavevedio()==1);
        currentUserInfo.setAppConf(roleModel);
        //Tramloginlogfo logInfo = new Tramloginlogfo();
        //logInfo.setAccesstoken();
        return currentUserInfo;
    }

    @Override
    public String getpwd(String username){
        TramMemberInfo info = memberMapper.getMemberByUsername(username);
        return info.getPassword();
    }

    @Override
    public TramMemberInfo getMemberInfoByUserName(String username) {
        return this.memberMapper.getMemberByUsername(username);
    }

    @Override
    public TramLogInfo getLastLogInfoByUid(long uid) {
        return this.memberMapper.getLastLogInfo(uid);
    }

    @Override
    public void insertTramLogInfo(TramLogInfo logInfo) {
        this.memberMapper.insertLogInfo(logInfo);
    }

    @Override
    public int getLoginErrorCount(long uid,String contentIp) {
        String end = DateUtil.getCurrentTime();
        String start = DateUtil.addMinute(end,-10);
        return this.memberMapper.getErrorLoginCount(start,end,uid,contentIp,0);
    }

    @Override
    public TramMemberInfo getMemberInfo(long userId) {
        return this.memberMapper.getMemberById(userId);
    }

    @Override
    public List<MemberViewModel> getMemberList(long userId, String seldepartmentIds, String keywords) {
        List<Long> departments = this.iDepartmentService.GetDepartmentIdsByUserId(userId);
        return  this.memberMapper.getUserList(seldepartmentIds,departments,keywords);
    }

    @Override
    public void saveAndUpdateMember(TramMemberInfo memberInfo) {
        if (memberInfo.getId() == 0) {
            int count = this.memberMapper.getCountByUsername(memberInfo.getUsername());
            if(count>1){
                throw new TramException("已经存在该用户名!");
            }
            String passwordSalt = UUID.randomUUID().toString().replace("-", "");
            memberInfo.setPasswordsalt(passwordSalt);
            String newPwd = SecureHelper.encryptToMD5("123456" + passwordSalt);
            memberInfo.setPassword(newPwd);
            this.memberMapper.Insert(memberInfo);
        } else {
            this.memberMapper.Update(memberInfo);
        }
    }

    @Override
    public void removeUser(String userIds) {
        this.memberMapper.remove(userIds);
    }

    @Override
    public void ChangePassWord(long userId, String oldPwd, String newPwd)
    {
        TramMemberInfo memberInfo = this.memberMapper.getMemberById(userId);
        String oldPwdStr=SecureHelper.encryptToMD5(oldPwd.concat(memberInfo.getPasswordsalt()));
        if (oldPwdStr!=memberInfo.getPassword())
            throw new TramException("旧密码不正确");
        this.ChangePassWord(userId,newPwd);
    }

    public void ChangePassWord(long userId, String newPwd)
    {
        TramMemberInfo memberInfo = this.memberMapper.getMemberById(userId);
        String PassWord= SecureHelper.encryptToMD5(newPwd.concat(memberInfo.getPasswordsalt()));
        this.memberMapper.ChangePassWord(userId,PassWord);
    }

    public void ModifyUserPhoto(long userId, String filePath)
    {
        this.memberMapper.ModifyUserPhoto(userId,filePath);
    }

    @Override
    public List<String> getMemberUUIDbyDepartmentId(List<Long> departmentIds) {
        return this.memberMapper.getMemberUUIDbyDepartmentId(departmentIds);
    }

    @Override
    public List<String> getMemberUUIDByDeviceCode(String deviceCode) {
        List<Long> departments = this.iDepartmentService.getDepartmentInfoBydeviceCode(deviceCode,true);
        return this.getMemberUUIDbyDepartmentId(departments);
    }

}
