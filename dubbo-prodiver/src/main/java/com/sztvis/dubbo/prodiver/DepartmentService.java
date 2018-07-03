package com.sztvis.dubbo.prodiver;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.common.ComboTreeModel;
import com.sztvis.domain.domain.TramDepartmentInfo;
import com.sztvis.domain.domain.TramMemberInfo;
import com.sztvis.domain.dto.response.DepartmentViewModel;
import com.sztvis.dubbo.IDepartmentService;
import com.sztvis.dubbo.IMemberService;
import com.sztvis.dubbo.prodiver.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/4 下午1:47
 */
@Service(version = "1.0.0")
public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Reference(version = "1.0.0")
    private IMemberService iMemberService;

    @Override
    public TramDepartmentInfo GetParentPartmentIdsByUserId(long userId) {
        TramDepartmentInfo departmentInfo = departmentMapper.GetDepartmentIdsByUserId(userId);
        if(departmentInfo.getParentid()!=0){
            departmentInfo = departmentMapper.GetDepartmentInfo(departmentInfo.getParentid());
        }
        return departmentInfo;
    }

    @Override
    public List<TramDepartmentInfo> getDepartmentList() {
        return this.departmentMapper.getDepartmentListMapper();
    }

    @Override
    public List<TramDepartmentInfo> GetParentsByParentId(long departmentId) {
        return departmentMapper.GetDepartmentsByParentId(departmentId);
    }

    @Override
    public List<Long> GetDepartmentIdsByUserId(long userId) {
        long roleId = this.iMemberService.getMemberInfo(userId).getRoleid();
        if(roleId!=1) {
            long departmentId = departmentMapper.GetDepartmentIdsByUserId(userId).getId();
            return departmentMapper.GetPartmentIdsByDepartmentId(departmentId);
        }else
        {
            return this.departmentMapper.getAllDepartmentIds();
        }
    }

    @Override
    public List<DepartmentViewModel> GetList(long userId, String text) {
        List<Long> departments = this.GetDepartmentIdsByUserId(userId);
        List<DepartmentViewModel> list = this.departmentMapper.GetList(text,departments);
        return list;
    }

    @Override
    public TramDepartmentInfo getDepartmentInfo(long id) {
        return this.departmentMapper.GetDepartmentInfo(id);
    }

    @Override
    public List<ComboTreeModel> getComboTreeListData(long userId) {
        TramMemberInfo memberInfo = this.iMemberService.getMemberInfo(userId);
        long owershipId = memberInfo.getOwnershipid();
        TramDepartmentInfo departmentInfo = this.getDepartmentInfo(owershipId);
        if(departmentInfo.getParentid()!=0){
            departmentInfo = this.getDepartmentInfo(departmentInfo.getParentid());
        }
        return this.getComboTreeDataOfRecursion(departmentInfo.getParentid());
    }

    @Override
    public void addDepartmentInfo(TramDepartmentInfo departmentInfo) {
        if(departmentInfo.getId()==0)
            this.departmentMapper.insertDepartment(departmentInfo);
        else
            this.departmentMapper.updateDepartment(departmentInfo);
    }

    @Override
    public void removeDepartmentInfo(String departmentIds) {
        this.departmentMapper.removeDepartment(departmentIds);
    }

    @Override
    public TramDepartmentInfo getDepartmentInfoByCode(String departmentcode) {
        return this.departmentMapper.getDepartmentInfoByCode(departmentcode);
    }

    @Override
    public List<TramDepartmentInfo> getDepartmentListByCode(String departmentcode) {
        TramDepartmentInfo departmentInfo = this.departmentMapper.getDepartmentInfoByCode(departmentcode);
        return  this.departmentMapper.getDepartmentListByParentId(departmentInfo.getId());
    }

    @Override
    public List<Long> getDepartmentInfoBydeviceCode(String deviceCode, boolean isgetparent) {
        List<Long> list =new ArrayList<>();
        TramDepartmentInfo departmentInfo = this.departmentMapper.getDepartmentInfoByDeviceCode(deviceCode);
        list.add(departmentInfo.getId());
        if(isgetparent){
            if(departmentInfo.getParentid()!=0){
                TramDepartmentInfo d= this.departmentMapper.GetDepartmentInfo(departmentInfo.getParentid());
                list.add(d.getId());
                return list;
            }
            else
            {
                return list;
            }
        }else{
            return list;
        }
    }

    private List<ComboTreeModel> getComboTreeDataOfRecursion(long parentId){
        List<TramDepartmentInfo> list = this.departmentMapper.GetDepartmentsByParentId(parentId);
        List<ComboTreeModel> list2 = new ArrayList<>();
        for(TramDepartmentInfo dep:list){
            ComboTreeModel comboTreeModel =new ComboTreeModel();
            comboTreeModel.setId(new Long(dep.getId()).intValue());
            comboTreeModel.setText(dep.getDepartmentname());
            comboTreeModel.setChildren(this.getComboTreeDataOfRecursion(dep.getId()));
            list2.add(comboTreeModel);
        }
        return list2;
    }

}
