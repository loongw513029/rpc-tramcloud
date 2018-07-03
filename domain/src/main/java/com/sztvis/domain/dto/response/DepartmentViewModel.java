package com.sztvis.domain.dto.response;

import java.io.Serializable;
import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/16 下午5:43
 */
public class DepartmentViewModel implements Serializable {
    private int id;
    private String code;
    private String departmentname;
    private String contactname;
    private long parentid;
    private List<DepartmentViewModel> children;
    private String contactphone;
    private int islookcan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone;
    }

    public int getIslookcan() {
        return islookcan;
    }

    public void setIslookcan(int islookcan) {
        this.islookcan = islookcan;
    }

    public int getIshavevedio() {
        return ishavevedio;
    }

    public void setIshavevedio(int ishavevedio) {
        this.ishavevedio = ishavevedio;
    }

    private int ishavevedio;

    public List<DepartmentViewModel> getChildren() {
        return children;
    }

    public void setChildren(List<DepartmentViewModel> children) {
        this.children = children;
    }

    public long getParentid() {
        return parentid;
    }

    public void setParentid(long parentid) {
        this.parentid = parentid;
    }
}
