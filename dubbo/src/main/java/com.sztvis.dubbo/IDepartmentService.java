package com.sztvis.dubbo;


import com.sztvis.domain.domain.TramDepartmentInfo;
import com.sztvis.common.ComboTreeModel;
import com.sztvis.domain.dto.response.DepartmentViewModel;

import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/4 下午1:46
 */
public interface IDepartmentService {
    /**
     * 根据用户id获得该用户机构的顶级机构
     * @param userId
     * @return
     */
    TramDepartmentInfo GetParentPartmentIdsByUserId(long userId);

    /**
     * 获得所有顶级机构
     * @return
     */
    List<TramDepartmentInfo> getDepartmentList();

    /**
     * 获得机构列表
     * @param departmentId
     * @return
     */
    List<TramDepartmentInfo> GetParentsByParentId(long departmentId);

    /**
     * 获得机构Id
     * @param userId 用户id
     * @return
     */
    List<Long> GetDepartmentIdsByUserId(long userId);

    List<DepartmentViewModel> GetList(long userId, String text);

    /**
     * 获得机构信息
     * @param id
     * @return
     */
    TramDepartmentInfo getDepartmentInfo(long id);

    /**
     * 根据用户id获得所有机构下拉列表
     * @param userId
     * @return
     */
    List<ComboTreeModel> getComboTreeListData(long userId);

    /**
     * 增加机构信息
     * @param departmentInfo
     */
    void addDepartmentInfo(TramDepartmentInfo departmentInfo);

    /**
     * 删除机构
     * @param departmentIds
     */
    void removeDepartmentInfo(String departmentIds);

    /**
     * 根据机构编码获得机构
     * @param departmentcode
     * @return
     */
    TramDepartmentInfo getDepartmentInfoByCode(String departmentcode);

    /**
     * 根据编码获得结构列表
     * @param departmentcode
     * @return
     */
    List<TramDepartmentInfo> getDepartmentListByCode(String departmentcode);

    /**
     * 根据设备编码获得机构信息
     * @param deviceCode 设备编码
     * @param isgetparent 是否获得顶级结构信息
     * @return
     */
    List<Long> getDepartmentInfoBydeviceCode(String deviceCode, boolean isgetparent);


}
