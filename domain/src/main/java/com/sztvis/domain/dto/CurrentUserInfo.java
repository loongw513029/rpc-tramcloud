package com.sztvis.domain.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2017/12/28 下午4:56
 */
public class CurrentUserInfo implements Serializable{
    private Long Id;
    private String uuid;
    private String UserName;
    private String RealName;
    private Integer RoleId;
    private String RoleName;
    private String Phone;
    private String Photo;
    private Long DepartmentId;
    private Integer DepartmentType;
    private Integer RoleLV;
    private String ManageScope;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String realName) {
        RealName = realName;
    }

    public Integer getRoleId() {
        return RoleId;
    }

    public void setRoleId(Integer roleId) {
        RoleId = roleId;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public Long getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(Long departmentId) {
        DepartmentId = departmentId;
    }

    public Integer getDepartmentType() {
        return DepartmentType;
    }

    public void setDepartmentType(Integer departmentType) {
        DepartmentType = departmentType;
    }

    public Integer getRoleLV() {
        return RoleLV;
    }

    public void setRoleLV(Integer roleLV) {
        RoleLV = roleLV;
    }

    public String getManageScope() {
        return ManageScope;
    }

    public void setManageScope(String manageScope) {
        ManageScope = manageScope;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }

    public String getRefreshToken() {
        return RefreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        RefreshToken = refreshToken;
    }

    public Boolean getTram() {
        return IsTram;
    }

    public void setTram(Boolean tram) {
        IsTram = tram;
    }

    public List<String> getDeviceScopes() {
        return DeviceScopes;
    }

    public void setDeviceScopes(List<String> deviceScopes) {
        DeviceScopes = deviceScopes;
    }

    public AppRoleModel getAppConf() {
        return AppConf;
    }

    public void setAppConf(AppRoleModel appConf) {
        AppConf = appConf;
    }

    private String DepartmentName;
    private String AccessToken;
    private String RefreshToken;
    private Boolean IsTram;
    private List<String> DeviceScopes;
    private AppRoleModel AppConf;

}
