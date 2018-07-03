package com.sztvis.dubbo;


import com.sztvis.domain.dto.response.MenuModel;

import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2017/12/29 下午1:39
 */

public interface IMenuService {

    List<MenuModel> GetExtNavDataMenu(Long ParentId, long roleId);
}
