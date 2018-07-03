package com.sztvis.dubbo;


import com.sztvis.domain.domain.TramBasicInfo;
import com.sztvis.domain.dto.BasicViewModel;
import com.sztvis.common.ComboTreeModel;
import com.sztvis.domain.dto.response.RoleViewModel;

import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/4 下午2:19
 */
public interface IBasicService {
    /**
     * 根据用户获得该用户所管辖设备列表集合
     * @param userId
     * @return
     */
    List<String> GetDeviceScopeByUserId(long userId);

    /**
     * 获得报警或者动作集合对应的主机上传自定义Id集合
     * @param type
     * @return
     */
    List<Integer> getCustomIdsByType(int type) throws Exception;

    /**
     * 根据主机自定义Id获得基础类
     * @param customId
     * @return
     */
    TramBasicInfo getBasicInfoByCustomId(int customId);

    /**
     *
     * @return
     */
    List<ComboTreeModel> getRoleList();

    List<ComboTreeModel> getMenuList();

    /**
     * get single role info
     * @param id
     * @return
     */
    RoleViewModel getRoleInfo(long id);

    /**
     *
     * @param model
     */
    void saveAndUpdateRole(RoleViewModel model);

    /**
     * 获得报警类型下拉列表
     * @param parentId
     * @return
     */
    List<ComboTreeModel> getAlarmTypeListByParentId(long parentId);

    /**
     * 获得报警基本信息列
     * @param type
     * @param keywords
     * @return
     */
    List<BasicViewModel> getBasicList(int type, String keywords, int page, int size);

    int getBasicListCount(int type, String keywords);

    void insertBasicInfo(TramBasicInfo basicInfo);

    void updateBasicInfo(TramBasicInfo basicInfo);

    List<Long> getDeviceIdsByRoleLv(long userId);

    List<Long> GetAlarmKeysByUserId(long userId);

    List<BasicViewModel> getBasicList(int type, String keywords);

    List<ComboTreeModel> GetCanHistoryCode(String[] LineIds);
}
