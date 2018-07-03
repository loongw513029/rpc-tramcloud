package com.sztvis.domain.dto;


import com.sztvis.domain.domain.TramDriverInfo;

import java.io.Serializable;

public class DriverViewModel extends TramDriverInfo  implements Serializable {
    private String departmentname;

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }
}
