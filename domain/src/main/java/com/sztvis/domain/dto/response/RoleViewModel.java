package com.sztvis.domain.dto.response;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/18 上午11:02
 */
public class RoleViewModel implements Serializable{
    private long id=0;
    private String rolename;
    private String remark;
    private String roleIds;
    private long parentId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
