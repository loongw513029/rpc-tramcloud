package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.domain.domain.*;
import com.sztvis.domain.dto.response.TreeAttributeModel;
import com.sztvis.domain.dto.response.TreeModel;
import com.sztvis.dubbo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/4 下午2:16
 */
@Service(version = "1.0.0")
public class TreeService implements ITreeService {

    @Reference(version = "1.0.0")
    private IDepartmentService iDepartmentService;
    @Reference(version = "1.0.0")
    private ILineService iLineService;
    @Reference(version = "1.0.0")
    private IDeviceService iDeviceService;
    @Reference(version = "1.0.0")
    private IMemberService iMemberService;
    @Override
    public List<TreeModel> GetTreeList(long userId) {
        List<TreeModel> list =new ArrayList<>();
        List<TramDepartmentInfo> departments = new ArrayList<>();
        TramMemberInfo memberInfo = this.iMemberService.getMemberInfo(userId);
        if(memberInfo.getRoleid()==1){
            departments = this.iDepartmentService.getDepartmentList();
        }else {
            TramDepartmentInfo departmentinfo = iDepartmentService.GetParentPartmentIdsByUserId(userId);
            departments.add(departmentinfo);
        }
        for(int i=0;i<departments.size();i++) {
            TreeModel treeModel = new TreeModel();
            treeModel.setText(departments.get(i).getDepartmentname());
            treeModel.setId(departments.get(i).getId());
            treeModel.setState(i==0?"open":"closed");
            treeModel.setIconCls("tree-department");
            treeModel.setEdit(true);
            TreeAttributeModel m2 = new TreeAttributeModel();
            m2.setState(false);
            m2.setLevel(1);
            treeModel.setAttributes(m2);
            treeModel.setChildren(this.GetChindDepartmentList(departments.get(i).getId()));
            list.add(treeModel);
        }
        return list;
    }
    private List<TreeModel> GetChindDepartmentList(long departmentId){
        List<TreeModel> list=new ArrayList<>();
        List<TramDepartmentInfo> dlist = iDepartmentService.GetParentsByParentId(departmentId);
        for(int i=0;i<dlist.size();i++){
            TreeModel model =new TreeModel();
            model.setState(i==0?"open":"closed");
            model.setId(dlist.get(i).getId());
            model.setText(dlist.get(i).getDepartmentname());
            model.setChecked(false);
            model.setEdit(true);
            model.setIconCls("tree-child-department");
            model.setChildren(this.GetChildLineList(dlist.get(i).getId()));
            TreeAttributeModel m2=new TreeAttributeModel();
            m2.setLevel(2);
            model.setAttributes(m2);
            list.add(model);
        }
        return list;
    }

    private List<TreeModel> GetChildLineList(long departmentId){
        List<TreeModel> list=new ArrayList<>();
        List<TramLineInfo> dlist = iLineService.GetLinesByDepartmentId(departmentId);
        for(int i=0;i<dlist.size();i++){
            TreeModel model =new TreeModel();
            model.setState(i==0?"open":"closed");
            model.setId(dlist.get(i).getId());
            model.setText(dlist.get(i).getLinename());
            model.setChecked(false);
            model.setEdit(true);
            model.setIconCls("tree-customline");
            model.setChildren(this.GetChindDevicesByLineId(dlist.get(i).getId()));
            TreeAttributeModel m2=new TreeAttributeModel();
            m2.setLevel(3);
            model.setAttributes(m2);
            list.add(model);
        }
        return list;
    }

    private List<TreeModel> GetChindDevicesByLineId(long lineId){
        List<TreeModel> list=new ArrayList<>();
        List<TramDeviceInfo> dlist = iDeviceService.GetDevicesByLineId(lineId);
        for(int i=0;i<dlist.size();i++){
            TreeModel model =new TreeModel();
            model.setState("closed");
            model.setId(dlist.get(i).getId());
            model.setText(dlist.get(i).getDevicecode());
            model.setChecked(false);
            model.setIconCls(dlist.get(i).getDevicestatus()==1?(dlist.get(i).getHostsofttype()==0?"device-nvr-online":"device-dvr-online"):"device-offline");
            model.setEdit(dlist.get(i).getDevicestatus()==1);
            model.setChildren(this.getChannelListByDeviceId(dlist.get(i).getId()));
            TreeAttributeModel m2=new TreeAttributeModel();
            m2.setIsdevice(true);
            m2.setLevel(4);
            model.setAttributes(m2);
            list.add(model);
        }
        return list;
    }
    private List<TreeModel> getChannelListByDeviceId(long deviceId){
        List<TreeModel> list=new ArrayList<>();
        List<TramChannelInfo> dlist = iDeviceService.GetChannelsByDeviceId(deviceId);
        for(int i=0;i<dlist.size();i++){
            TreeModel model =new TreeModel();
            model.setState("open");
            model.setId(deviceId);
            model.setText(dlist.get(i).getChannelname());
            model.setChecked(false);
            model.setIconCls("");
            model.setEdit(true);
            TreeAttributeModel m2=new TreeAttributeModel();
            m2.setIsdevice(false);
            m2.setChannel(dlist.get(i).getNo());
            m2.setLevel(5);
            model.setAttributes(m2);
            list.add(model);
        }
        return list;
    }
}
