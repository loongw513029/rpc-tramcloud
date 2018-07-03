package com.sztvis.dubbo;

import com.sztvis.domain.domain.TramChannelInfo;
import com.sztvis.domain.domain.TramDeviceInfo;
import com.sztvis.domain.domain.TramLineInfo;
import com.sztvis.domain.dto.AppNumViewModel;
import com.sztvis.common.ComboTreeModel;
import com.sztvis.domain.dto.LineViewModel;
import com.sztvis.domain.dto.SelectViewModel;

import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/4 下午6:26
 */
public interface ILineService {

    List<TramLineInfo> GetLinesByDepartmentId(long departmentId);

    List<Long> GetLineIdsByUserId(long userId);

    List<LineViewModel> getList(long userId, String linename, long departmentId);

    TramLineInfo getLineInfo(long Id);

    List<ComboTreeModel> getLineTreeList(long userId);

    List<TramDeviceInfo>  getDevices(long lineId, long userId);

    List<TramChannelInfo> GetChannlsByDeviceId(long deviceId);

    /**
     * 保存线路
     * @param lineViewModel
     */

    void saveAndUpdateLine(LineViewModel lineViewModel);

    /**
     * 删除线路
     * @param lineIds
     */
    void removeLines(String lineIds);

    AppNumViewModel GetAppNumByLineId(Long lineId);

    List<SelectViewModel> GetDropDownLine(Long userId);
}
