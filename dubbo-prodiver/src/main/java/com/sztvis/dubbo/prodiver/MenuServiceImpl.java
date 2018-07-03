package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.domain.domain.TramMenuInfo;
import com.sztvis.domain.dto.response.MenuModel;
import com.sztvis.dubbo.IBasicService;
import com.sztvis.dubbo.IMenuService;
import com.sztvis.dubbo.prodiver.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2017/12/29 下午3:36
 */
@Service(version = "1.0.0")
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Reference(version = "1.0.0")
    private IBasicService iBasicService;

    public List<MenuModel> GetExtNavDataMenu(Long ParentId, long roleId){
        String roleIds = this.iBasicService.getRoleInfo(roleId).getRoleIds();
        List<String> mArr = Arrays.asList(roleIds.split(","));
        List<MenuModel> list = new ArrayList<>();
        List<TramMenuInfo> lists = menuMapper.GetMenus(ParentId);
        for(int i =0;i<lists.size();i++){
            MenuModel menuModel=new MenuModel();
            menuModel.setCls(lists.get(i).getCls());
            menuModel.setGlyph(lists.get(i).getIcon());
            menuModel.setText(lists.get(i).getMenuname());
            menuModel.setUri(lists.get(i).getUrl());
            menuModel.setMenu(GetExtNavDataMenu(lists.get(i).getId(),roleId));
            if(mArr.contains(lists.get(i).getId()+"")) {
                list.add(menuModel);
            }
        }
        return list;
    }
}
