package com.sztvis.dubbo;


import com.sztvis.domain.domain.TramCanActinfo;
import com.sztvis.domain.domain.TramCanInfo;
import com.sztvis.domain.domain.TramUnsafeBehaviorInfo;
import com.sztvis.domain.dto.CanHistoryViewModel;
import com.sztvis.domain.dto.CanViewModel;
import com.sztvis.domain.dto.DispatchModel;
import com.sztvis.domain.dto.service.SaveAlarmQuery;

import java.text.ParseException;
import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/10 上午10:32
 */
public interface ICanService {
    /**
     * 根据编码和时间获得CAN信息
     * @param deviceCode
     * @param updateTime
     * @return
     */
    TramCanInfo GetCanInfo(String deviceCode, String updateTime);

    /**
     * 新增CAN数据
     * @param canInfo
     */
    void Save(TramCanInfo canInfo);

    /**
     * 更新CAN数据
     * @param canInfo
     */
    void Update(TramCanInfo canInfo);

    /**
     * 获得该车时间倒序最后一条can数据
     * @param deviceId
     * @return TramCanInfo
     */
    TramCanInfo FindLastById(long deviceId);

    /**
     * 获得该车时间倒序最后一条can数据
     * @param deviceCode
     * @return
     */
    TramCanInfo FindLastByCode(String deviceCode);

    /**
     * 新增报警数据
     * @param query
     */
    void AddAlarmInfo(SaveAlarmQuery query);

    /**
     * 插入CAN动作,先根据时间和编码查找can信息，存在就在can信息下面增加一个动作集合
     * @param updateTime 关联can信息的时间
     * @param deviceCode 设备编码
     * @param map 动作集合
     */
    void AddCanActInfo(String updateTime, String deviceCode, List<TramCanActinfo> map);

    /**
     * 获得车辆最后一条Can数据
     * @param deviceCode
     * @return
     */
    TramCanInfo getLastCanInfo(String deviceCode);

    TramCanInfo getLastCanInfo(String deviceCode, String updateTime);

    /**
     * 查询车辆最后刹车状态
     * @param deviceCode
     * @return
     */
    boolean IsBarke(String deviceCode);

    /**
     * 查询车辆最后停车挡状态
     * @param deviceCode
     * @return
     */
    boolean IsPark(String deviceCode);
    /**
     * 拼装报警条件
     * @param deviceCode  设备编码
     * @param updateTime  更新时间
     * @param type 报警类型
     * @param value 报警值
     * @param extras 附带数据 车速，车距，刹车
     * @param path 报警视频路径
     * @param path2 报警视频2
     * @return
     */
    SaveAlarmQuery getAlarmQuery(String deviceCode, long deviceId, String updateTime, int type, String value, String extras, String path, String path2);

    /**
     * 获得最后一条can数据，包含can,can状态，调度，地图数据
     * @param devicecode
     * @return
     */
    CanViewModel getLastCanViewModel(String devicecode);

    /**
     * 获得最后一条调度数据
     * @param devicecode
     * @return
     */
    DispatchModel getLastDispathModel(String devicecode);

    /**
     * 统计不安全数据
     * @param deviceId
     */
    void autoCalcUnsafeData(long deviceId, String updateTime) throws ParseException;

    /**
     * 增加不安全行为数据
     * @param behaviorInfo
     */
    void insertUnsafeData(TramUnsafeBehaviorInfo behaviorInfo);

    /**
     * 增加不安全行为数据
     * @param deviceId 设备id
     * @param updateTime 时间点
     * @param unsafeType 不安全类型
     */
    void insertUnSafeData(long deviceId, String updateTime, int unsafeType);

    /**
     * 获取can巡检数据
     * @param dayType 时间类型
     * @param lineId 线路id
     * @return
     */
    CanHistoryViewModel getCanHistorys(int dayType, long lineId);

    /**
     * 获取单条线路趋势数据
     * @param dayType
     * @param lineId
     * @param types
     * @return
     */
    List<List<Integer>> getAlarmTrends(int dayType, long lineId, List<Integer> types);

    /**
     * 获取单车趋势数据
     * @param dayType
     * @param deviceId
     * @param types
     * @return
     */
    List<List<Integer>> getSignleAlarmTrends(int dayType, long deviceId, List<Integer> types);

    TramCanInfo GetCanInfoByLastTime(String code, int year, int month, int day, int hour, int minute, int second);

    int GetCanInfoBy10sTime(String code, String date, int second);

    void CalcDeviceCanHistorys();

    /**
     * 车辆起步不关车门
     * @param deviceId
     * @param updateTime
     * @return
     */
    void autoCalcUnsafeGoingData(long deviceId, String updateTime) throws ParseException;

    /**
     * 车辆未停稳开车门
     * @param deviceId
     * @param updateTime
     * @return
     */
    void autoCalcUnsafeStopingData(long deviceId, String updateTime) throws ParseException;

    /**
     * 急刹车
     * @param deviceId
     * @param updateTime
     * @return
     */
    void autoCalcEmergencyBrake(long deviceId, String updateTime);

    /**
     * 空档滑行
     * @param deviceId
     * @param updateTime
     * @return
     */
    void autoCalcNeutralAndTravel(long deviceId, String updateTime);

    /**
     * 急减速
     * @param deviceId
     * @param updateTime
     * @return
     */
    void autoCalcQuickSlowDown(long deviceId, String updateTime);

    /**
     * 倒车超速
     * @param deviceId
     * @param updateTime
     * @return
     */
    void autiCalcReversingSpeeding(long deviceId, String updateTime);

    /**
     * 急加速
     * @param deviceId
     * @param updateTime
     * @return
     */
    void autoCalcRevvingUp(long deviceId, String updateTime);

    /**
     * 超速
     * @param deviceId
     * @param updateTime
     * @return
     */
    void autoCalcSpeedingTravel(long deviceId, String updateTime) throws Exception;

    /**
     * 起步急加速
     * @param deviceId
     * @param updateTime
     * @return
     */
    void autoCalcStartTravelSpeeding(long deviceId, String updateTime);

    /**
     * 夜间行驶
     * @param deviceId
     * @param updateTime
     * @return
     */
    void autoCalcTravelAtNight(long deviceId, String updateTime);

    CanHistoryViewModel getCanHistoryBus(String code, int dayType);
}
