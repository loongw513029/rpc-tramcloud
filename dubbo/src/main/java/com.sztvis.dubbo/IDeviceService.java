package com.sztvis.dubbo;


import com.sztvis.common.ComboTreeModel;
import com.sztvis.common.entity.DeviceStateFiled;
import com.sztvis.domain.domain.*;
import com.sztvis.domain.dto.*;
import com.sztvis.domain.dto.api.DeviceFilterSearchResult;
import com.sztvis.domain.dto.api.HVNVRModel;

import java.beans.IntrospectionException;
import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/4 下午6:30
 */
public interface IDeviceService {

    /**
     * 根据编码取得设备信息
     * @param deviceCode
     * @return
     */
    TramDeviceInfo getDeviceInfoByCode(String deviceCode);

    /**
     * 根据id获得设备信息
     * @param Id
     * @return
     */
    TramDeviceInfo getDeviceInfoById(long Id);

    /**
     * 根据设备编码查询设备id
     * @param deviceCode
     * @return
     */
    long getDeviceIdByCode(String deviceCode);

    /**
     * 根据线路获得设备列表
     * @param lineId
     * @return
     */
    List<TramDeviceInfo> GetDevicesByLineId(long lineId);

    /**
     * 增加心跳记录
     * @param healthInfo
     */
    void AddDeviceHealthInfo(TramDeviceHealthInfo healthInfo);

    /**
     * 修改设备状态
     * @param deviceCode
     * @param state
     */
    void UpdateDeviceStatus(String deviceCode, boolean state);

    /**
     * 修改实时巡检表数据，无该设备的巡检数据则新增一条
     * @param deviceCode
     * @param filed
     * @param value
     * @Param fieldtype 字段类型 1:String,2:Double,3:Boolean
     */
    void UpdateRealTimeInspect(String deviceCode, DeviceStateFiled filed, Object value, int fieldtype);

    /**
     * 获得设备列表
     * @param userId
     * @param devicetype
     * @param departmentId
     * @param lineId
     * @param status
     * @param keywords
     * @return
     */
    List<DeviceViewModel> getList(long userId, int devicetype, long departmentId, long lineId, int status, String keywords);

    /**
     *  车辆信息编辑模型
     * @param id
     * @return
     */
    BusAndDeviceViewModel getDeviceViewModel(long id);

    /**
     * 司机下拉列表数据
     * @param departmentid
     * @return
     */
    List<ComboTreeModel> getDriverComboList(long departmentid);

    /**
     * 保存车辆设备通道信息
     * @param model
     */
    void saveDeviceInfo(BusAndDeviceViewModel model);


    List<Long> getBusIdsByDeviceIds(String deviceIds);

    /**
     * 删除设备信息
     * @param deviceIds
     */
    void removeDeviceInfo(String deviceIds);

    /**
     * 添加雷达数据
     * @param radarInfo
     */
    void insertRadarInfo(TramRadarInfo radarInfo);

    /**
     * 添加NVR状态数据
     * @param deviceStatusInfo
     */
    void insertDeviceStatusInfo(TramDeviceStatusInfo deviceStatusInfo);

    /**
     * 修改设备的NVR巡检实时状态信息，或产生报警
     * @param deviceInfo
     * @param hvnvrModel
     */
    void updateDeviceNvrStatus(TramDeviceInfo deviceInfo, HVNVRModel hvnvrModel);
    /**
     * 修改设备的NVR巡检实时状态信息，或产生报警,新协议
     * @param deviceInfo
     * @param hvnvrModel
     */
    void updateDeviceNvrStatusV2(TramDeviceInfo deviceInfo, HVNVRModel hvnvrModel);

    /**
     * 获得设备的实时巡检数据
     * @param deviceid
     * @return
     */
    TramDeviceStateInspectRealtimeInfo getDeviceStateInspectRealTimeInfo(long deviceid);

    /**
     * 获得最后一条调度信息
     * @param deviceid
     * @return
     */
    TramDispatchInfo getLastDispatchInfo(long deviceid);

    /**
     * 地图上车辆列表
     * @param devices
     * @return
     */
    List<MapDeviceViewModel> getMapDeviceList(String devices);

    DeviceViewModel getDeviceConfig(long id);

    /**
     * 获得巡检列表
     * @param userid 用户id
     * @param departmentid 机构id
     * @param lineid 线路id
     * @param type 状态类型
     * @param keywords 设备自编码
     * @return
     */
    List<DeviceInspectViewModel> getDeviceInspectList(long userid, long departmentid, long lineid, int type, String keywords);

    /**
     * 单车分析统计
     */
    void autoCanSignleStatis();

    void autoDeviceStatus();

    /**
     * 获得时间段内心跳数据条数
     * @param deviceCode 设备编码
     * @param starttime 开始时间
     * @param endTime 结束时间
     * @return
     */
    long getDeviceHealthInfo(String deviceCode, String starttime, String endTime);

    /**
     * 获取当前设备状态推送模型
     * @param deviceId
     * @return
     */
    DeviceStatusPushModel getCurrentDeviceStatus(long deviceId);

    /**
     * 获得用户所属机构下面所有设备Id
     * @param userId
     * @return
     */
    List<Long> getDeviceIdsByUserId(long userId);

    /**
     * 获得司机信息
     * @param Id
     * @param code
     * @return
     */
    TramDeviceInfo GetDriverInfo(long Id, String code);

    /**
     * 设备搜索结果
     * @param code
     * @return
     */

    DeviceFilterSearchResult GetAppDeviceFilterSearch(String code);

    /**
     * 根据机构Id获得该机构下所有设备Id
     * @param user
     * @return
     */

    List<Long> GetDeviceIdsByDepartmentId(CurrentUserInfo user);

    /**
     * 获得设备信息
     * @param dayType
     * @param deviceId
     * @return
     */
    AppBusViewModel GetAppBusModel(int dayType, long deviceId);

    /**
     * 获得通道列表
     * @param deviceId
     * @return
     */

    List<TramChannelInfo> GetChannelsByDeviceId(long deviceId);

    /**
     * 新增刷卡记录
     * @param payTerminalRecords
     */
    void insertPayTerminalRecords(PayTerminalRecords payTerminalRecords);

    /**
     * 巡检CAN完整性
     */
    void InspectCanIntegrity();

    List<String> GetAllCarCodes(CurrentUserInfo user);

    int GetCountByDateTime(String code, String date1, String date2);

    void autoStatement() throws IntrospectionException, NoSuchFieldException, IllegalAccessException;

    void AutoInspectDeviceADAS();

    List<String> GetDeviceCodeByDriverId(long driverId);

    List<PayTerminalRecords> getPayRecords(String cardno, String date1, String date2, String sitename);

    /**
     * 统计车辆昨天是否在线过
     */
    void autoClacOnlineResult();

    void updatePayTerminalImage(String image, String deviceCode, String updateTime);

    int getAlarmCount(long parentId, String devicecode);
}
