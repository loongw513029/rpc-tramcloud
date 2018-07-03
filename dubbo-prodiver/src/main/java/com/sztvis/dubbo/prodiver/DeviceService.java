package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sztvis.common.ComboTreeModel;
import com.sztvis.common.entity.BusType;
import com.sztvis.common.entity.DeviceStateFiled;
import com.sztvis.common.entity.UnSafeBehaviorTypes;
import com.sztvis.core.DateStyle;
import com.sztvis.core.DateUtil;
import com.sztvis.core.DayTypes;
import com.sztvis.core.helper.EnumHelper;
import com.sztvis.core.helper.StringHelper;
import com.sztvis.domain.domain.*;
import com.sztvis.domain.dto.*;
import com.sztvis.domain.dto.api.DeviceFilterSearchResult;
import com.sztvis.domain.dto.api.HVNVRModel;
import com.sztvis.domain.dto.push.PushModel;
import com.sztvis.dubbo.*;
import com.sztvis.dubbo.prodiver.mapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/4 下午6:30
 */

@Service(version = "1.0.0")
public class DeviceService implements IDeviceService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private AlarmMapper alarmMapper;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Reference(version = "1.0.0")
    private IDepartmentService iDepartmentService;
    @Autowired
    private DriverMapper driverMapper;
    @Reference(version = "1.0.0")
    private ICanService iCanService;
    @Reference(version = "1.0.0")
    private IBasicService iBasicService;
    @Reference(version = "1.0.0")
    private IGpsService iGpsService;
    @Reference(version = "1.0.0")
    private IPushService iPushService;
    @Autowired
    private BasicMapper basicMapper;
    @Autowired
    private UnSafeMapper unSafeMapper;
    @Reference(version = "1.0.0")
    private IMemberService iMemberService;
    @Autowired
    private CanMapper canMapper;

    @Override
    public TramDeviceInfo getDeviceInfoByCode(String deviceCode) {

        return this.deviceMapper.getDeviceInfoByCode(deviceCode);
    }

    @Override
    public TramDeviceInfo getDeviceInfoById(long Id) {

        return this.deviceMapper.getDeviceInfoById(Id);
    }

    @Override
    public long getDeviceIdByCode(String deviceCode) {
        return this.deviceMapper.getDeviceIdByCode(deviceCode);
    }

    @Override
    public List<TramDeviceInfo> GetDevicesByLineId(long lineId) {
        return deviceMapper.getDevicesByLineId(lineId);
    }

    @Override
    public void AddDeviceHealthInfo(TramDeviceHealthInfo healthInfo) {
        TramGpsInfo gpsInfo = this.iGpsService.getLastGpsInfo(healthInfo.getDevicecode());
        if(gpsInfo!=null)
            healthInfo.setLocation(gpsInfo.getLongitude()+","+gpsInfo.getLatitude());
        else
            healthInfo.setLocation("");
        healthInfo.setGuid(UUID.randomUUID().toString());
        this.mongoTemplate.save(healthInfo);
        this.UpdateRealTimeInspect(healthInfo.getDevicecode(), DeviceStateFiled.OnlineState,true,3);
        //更新设备最后在线时间
        this.deviceMapper.updateLastOnlineTime(healthInfo.getUpdatetime(),healthInfo.getDevicecode());
    }

    @Override
    public void UpdateDeviceStatus(String deviceCode, boolean state) {
        int v = state?1:-1;
        this.deviceMapper.udpateDeviceState(deviceCode,v);
       // this.UpdateRealTimeInspect(deviceCode,DeviceStateFiled.OnlineState,true,3);
    }

    @Override
    public void UpdateRealTimeInspect(String deviceCode, DeviceStateFiled filed, Object value,int fieldtype) {
        TramDeviceInfo deviceInfo = this.getDeviceInfoByCode(deviceCode);
        int count = this.deviceMapper.getRealtimeInspectCount(deviceCode);
        if(count == 0){
            TramDeviceStateInspectRealtimeInfo info = new TramDeviceStateInspectRealtimeInfo();
            info.setDeviceid(deviceInfo.getId());
            info.setDeviceCode(deviceInfo.getDevicecode());
            this.deviceMapper.insertRealtimeInspect(info);
        }
        if(filed==DeviceStateFiled.OnlineState){
            this.UpdateDeviceStatus(deviceCode,(boolean)value);
        }
        this.deviceMapper.updateRealtimeInspect(deviceCode,filed.getValue(),value,fieldtype);
    }

    @Override
    public List<DeviceViewModel> getList(long userId, int devicetype, long departmentId, long lineId, int status, String keywords) {

        List<Long> departments = this.iDepartmentService.GetDepartmentIdsByUserId(userId);
        return this.deviceMapper.getBusList(departments,devicetype,departmentId,lineId,status,keywords);
    }

    @Override
    public BusAndDeviceViewModel getDeviceViewModel(long id) {
        BusAndDeviceViewModel deviceViewModel = this.deviceMapper.getBusAndDeviceInfo(id);
        List<ChannelViewModel> list = this.deviceMapper.getChannelViewModelList(id);
        deviceViewModel.setChannellist(JSON.toJSONString(list));
        return deviceViewModel;
    }

    @Override
    public List<ComboTreeModel> getDriverComboList(long departmentid) {
        return this.driverMapper.getDriverComboList(departmentid);
    }

    @Override
    public void saveDeviceInfo(BusAndDeviceViewModel model) {
        TramDeviceInfo deviceInfo = model.ConvertToDeviceInfo();
        TramBusInfo busInfo = model.ConvertToBusInfo();
        if(model.getId() == 0)
        {
            this.deviceMapper.insertBusInfo(busInfo);
            long busId = busInfo.getId();
            model.setBusid(busId);
            deviceInfo.setBusid(busId);
            this.deviceMapper.insertDeviceInfo(deviceInfo);
        }else{
            this.deviceMapper.updateBusInfo(busInfo);
            this.deviceMapper.updateDeviceInfo(deviceInfo);
        }
        this.deviceMapper.removeChannelInfo(deviceInfo.getId());
        List<ChannelViewModel> cList = JSON.parseArray(model.getChannellist(),ChannelViewModel.class);
        for(ChannelViewModel m:cList){
            TramChannelInfo channelInfo = new TramChannelInfo();
            channelInfo.setDeviceid(deviceInfo.getId());
            channelInfo.setChannelname(m.getChannelname());
            channelInfo.setNo(m.getNo());
            channelInfo.setSupportptz(m.isSupportptz());
            this.deviceMapper.insertChannelInfo(channelInfo);
        }
    }

    @Override
    public List<Long> getBusIdsByDeviceIds(String deviceIds) {
        return this.deviceMapper.getBusIds(deviceIds);
    }

    @Override
    public void removeDeviceInfo(String deviceIds) {
        List<Long> busIds = this.deviceMapper.getBusIds(deviceIds);
        this.deviceMapper.removeDeviceInfo(deviceIds);
        this.deviceMapper.removeBusInfo(StringHelper.listToString(busIds,','));
        this.deviceMapper.removeChannels(deviceIds);
    }

    @Override
    public void insertRadarInfo(TramRadarInfo radarInfo) {
        this.mongoTemplate.save(radarInfo);
        PushModel pushModel = new PushModel(4,radarInfo);
        this.iPushService.SendToMsgByDeviceCode(radarInfo.getDevicecode(),pushModel);
    }

    @Override
    public void insertDeviceStatusInfo(TramDeviceStatusInfo deviceStatusInfo) {
        this.mongoTemplate.save(deviceStatusInfo);
    }

    @Override
    public void updateDeviceNvrStatus(TramDeviceInfo deviceInfo, HVNVRModel hvnvrModel) {
        switch (hvnvrModel.getType()){
            case 1://录像状态
                //true:主盘 false:副盘
                boolean diskType = Boolean.valueOf(hvnvrModel.getValue1());
                //状态
                boolean videotapState = Boolean.valueOf(hvnvrModel.getValue2());
                this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.Videotape,videotapState,3);
                if(!videotapState)
                    this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                            hvnvrModel.getUpdateTime(),1001,"录像状态异常:"+(diskType?"主盘":"副盘"),"","",""));
                break;
            case 2://视频状态
                //状态
                boolean videoState = Boolean.valueOf(hvnvrModel.getValue1());
                this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.Video,videoState,3);
                if(!videoState)
                    this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                            hvnvrModel.getUpdateTime(),1002,"视频状态异常","","",""));
                break;
            case 3://硬盘状态
                boolean diskState = Boolean.valueOf(hvnvrModel.getValue1());
                this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.HardDisk,diskState,3);
                if(!diskState)
                    this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                            hvnvrModel.getUpdateTime(),1003,"硬盘状态异常","","",""));
                break;
            case 4://SdCard状态
                boolean sdcardState = Boolean.valueOf(hvnvrModel.getValue1());
                this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.SDCard,sdcardState,3);
                if(!sdcardState)
                    this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                            hvnvrModel.getUpdateTime(),1004,"SD卡状态异常","","",""));
                break;
            case 5://硬盘空间
                String surplusDiskSize = hvnvrModel.getValue2();//剩余空间
                this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.SurplusDiskSize,surplusDiskSize,1);
                TramBasicInfo basicInfo = this.iBasicService.getBasicInfoByCustomId(1003);
                Double thrshold = Double.valueOf(basicInfo.getThreShold());
                if(Double.valueOf(surplusDiskSize)<=thrshold)
                    this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                            hvnvrModel.getUpdateTime(),1003,"硬盘剩余空间不足"+thrshold+"G","","",""));
                break;
            case 6://SD卡空间
                String surplusSdcardSize = hvnvrModel.getValue2();//剩余空间
                this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.SurplusSdcardSize,surplusSdcardSize,1);
                TramBasicInfo basicInfo2 = this.iBasicService.getBasicInfoByCustomId(1004);
                Double thrshold2 = Double.valueOf(basicInfo2.getThreShold());
                if(Double.valueOf(surplusSdcardSize)<=thrshold2)
                    this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                            hvnvrModel.getUpdateTime(),1003,"SD卡剩余空间不足"+thrshold2+"G","","",""));
                break;
            case 7://时间校准
                Boolean timingState = Boolean.valueOf(hvnvrModel.getValue1());
                this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.TimingState,timingState,3);
                break;
            case 8://sim卡号
                this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.SIMCardNo,hvnvrModel.getValue1(),1);
                break;
            case 9://CPU使用率
                Double cpuUseRate = Double.valueOf(hvnvrModel.getValue2());
                this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.CPUUseRate,cpuUseRate,2);
                TramBasicInfo basic = this.iBasicService.getBasicInfoByCustomId(1005);
                Double cpuUseRateThrshold = Double.valueOf(basic.getThreShold());
                if(cpuUseRate>=cpuUseRateThrshold)
                    this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                            hvnvrModel.getUpdateTime(),1005,"CPU使用率过高","","",""));
                break;
            case 10:
                Double cpuTemp = Double.valueOf(hvnvrModel.getValue2());
                this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.CPUTemp,cpuTemp,2);
                TramBasicInfo basic1 = this.iBasicService.getBasicInfoByCustomId(1006);
                Double cpuTempThrshold = Double.valueOf(basic1.getThreShold());
                if(cpuTemp>=cpuTempThrshold)
                    this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                            hvnvrModel.getUpdateTime(),1006,"CPU温度过高","","",""));
                break;
            case 11:
                Double memoryTemp = Double.valueOf(hvnvrModel.getValue2());
                this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.MemoryUseRate,memoryTemp,2);
                TramBasicInfo basic2 = this.iBasicService.getBasicInfoByCustomId(1007);
                Double memoryThrshold = Double.valueOf(basic2.getThreShold());
                if(memoryTemp>=memoryThrshold)
                    this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                            hvnvrModel.getUpdateTime(),1007,"内存使用率过高","","",""));
                break;
            case 12:
                Double diskTemp = Double.valueOf(hvnvrModel.getValue2());
                this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.DiskTemp,diskTemp,2);
                TramBasicInfo basic3 = this.iBasicService.getBasicInfoByCustomId(1008);
                Double diskTemphrshold = Double.valueOf(basic3.getThreShold());
                if(diskTemp>=diskTemphrshold)
                    this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                            hvnvrModel.getUpdateTime(),1008,"硬盘温度过高","","",""));
                break;
            case 13://SSD温度
                Double ssdTemp = Double.valueOf(hvnvrModel.getValue2());
                this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.SSDTemp,ssdTemp,2);
                break;
            case 14://Gps信号
                break;
            case 15://SIM卡余额
                Double banance = Double.valueOf(hvnvrModel.getValue1());
                this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.SIMBalance,banance,2);
                break;
            case 16://网络信号
                break;
            case 17:
                this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.InternetSignal,hvnvrModel.getValue1(),2);
                break;

        }
    }

    @Override
    public void updateDeviceNvrStatusV2(TramDeviceInfo deviceInfo, HVNVRModel hvnvrModel) {
        switch (hvnvrModel.getType()){
            case 1://状态信息
                Map<Integer,Integer> map = JSON.parseObject(hvnvrModel.getValue1(),new TypeReference<Map<Integer,Integer>>(){});
                Set<Integer> keys = map.keySet();
                for(Integer key:keys){
                    boolean state  = map.get(key)==1;
                    switch (key){
                        case 1://录像状态
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.Videotape,state,3);
                            if(!state){
                                this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                                        hvnvrModel.getUpdateTime(),1001,"录像状态异常:"+(hvnvrModel.getValue2()=="1"?"主盘":"副盘"),"","",""));
                            }
                            break;
                        case 2://视频状态
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.Video,state,3);
                            if(!state){
                                this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                                        hvnvrModel.getUpdateTime(),1002,"视频状态异常","","",""));
                            }
                            break;
                        case 3://硬盘状态
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.HardDisk,state,3);
                            if(!state){
                                this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                                        hvnvrModel.getUpdateTime(),1003,"硬盘状态异常","","",""));
                            }
                            break;
                        case 4://SD卡状态
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.SDCard,state,3);
                            if(!state){
                                this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                                        hvnvrModel.getUpdateTime(),1004,"SD卡状态异常","","",""));
                            }
                            break;
                        case 5://主机网络状态
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.InternetState,state,3);
                            if(!state){
                                this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                                        hvnvrModel.getUpdateTime(),1001,"主机网络状态异常","","",""));
                            }
                            break;
                        case 6://GPS天线状态
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.GpsSignalState, map.get(key),4);
                            break;
                    }
                }
                break;
            case 2://空间信息
                Map<Integer,Double> map2 = JSON.parseObject(hvnvrModel.getValue1(),new TypeReference<Map<Integer,Double>>(){});
                Set<Integer> keys2 = map2.keySet();
                for(Integer key:keys2){
                    switch (key){
                        case 1://硬盘空间
                            String surplusDiskSize = hvnvrModel.getValue2();//剩余空间
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.SurplusDiskSize,surplusDiskSize,1);
                            TramBasicInfo basicInfo = this.iBasicService.getBasicInfoByCustomId(1003);
                            Double thrshold = Double.valueOf(basicInfo.getThreShold());
                            if(Double.valueOf(surplusDiskSize)<=thrshold)
                                this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                                        hvnvrModel.getUpdateTime(),1003,"硬盘剩余空间不足"+thrshold+"G","","",""));
                            break;
                        case 2://SD卡空间
                            String surplusSdcardSize = hvnvrModel.getValue2();//剩余空间
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.SurplusSdcardSize,surplusSdcardSize,1);
                            TramBasicInfo basicInfo2 = this.iBasicService.getBasicInfoByCustomId(1004);
                            Double thrshold2 = Double.valueOf(basicInfo2.getThreShold());
                            if(Double.valueOf(surplusSdcardSize)<=thrshold2)
                                this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                                        hvnvrModel.getUpdateTime(),1003,"SD卡剩余空间不足"+thrshold2+"G","","",""));
                            break;
                    }
                }
                break;
            case 3://SIM卡信息
                Map<Integer,String> map3 = JSON.parseObject(hvnvrModel.getValue1(),new TypeReference<Map<Integer,String>>(){});
                for(Integer key:map3.keySet()) {
                    switch (key) {
                        case 1:
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(), DeviceStateFiled.SIMCardNo, map3.get(key), 1);
                            break;
                        case 2:
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(), DeviceStateFiled.SIMBalance, map3.get(key), 1);
                            break;
                        case 3:
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(), DeviceStateFiled.SIMOperator, map3.get(key), 1);
                            break;
                    }
                }
                break;
            case 4://使用率信息
                Map<Integer,Double> map4 = JSON.parseObject(hvnvrModel.getValue1(),new TypeReference<Map<Integer,Double>>(){});
                for(Integer key:map4.keySet()){
                    switch (key){
                        case 1:
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.CPUUseRate,map4.get(key),2);
                            TramBasicInfo basic = this.iBasicService.getBasicInfoByCustomId(1005);
                            Double cpuUseRateThrshold = Double.valueOf(basic.getThreShold());
                            if(map4.get(key)>=cpuUseRateThrshold)
                                this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                                        hvnvrModel.getUpdateTime(),1005,"CPU使用率过高","","",""));
                            break;
                        case 2:
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.MemoryUseRate,map4.get(key),2);
                            TramBasicInfo basic2 = this.iBasicService.getBasicInfoByCustomId(1007);
                            Double cpuUseRateThrshold2 = Double.valueOf(basic2.getThreShold());
                            if(map4.get(key)>=cpuUseRateThrshold2)
                                this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),deviceInfo.getId(),
                                        hvnvrModel.getUpdateTime(),1007,"内存使用率过高","","",""));
                            break;
                    }
                }
                break;
            case 5://温度信息
                Map<Integer,Double> map5 = JSON.parseObject(hvnvrModel.getValue1(),new TypeReference<Map<Integer,Double>>(){});
                for(Integer key:map5.keySet()){
                    int type = 0;
                    DeviceStateFiled field =null;
                    switch (key){
                        case 1:
                            type = 1006;
                            field = DeviceStateFiled.CPUTemp;
                            break;
                        case 2:
                            type = 1008;
                            field = DeviceStateFiled.DiskTemp;
                            break;
                        case 3:
                            type = 1010;
                            field = DeviceStateFiled.SSDTemp;
                            break;
                        case 4:
                            type = 1011;
                            field = DeviceStateFiled.BoxTemp;
                            break;
                        case 5:
                            field = DeviceStateFiled.ExtendTemp1;
                            break;
                        case 6:
                            field = DeviceStateFiled.ExtendTemp2;
                            break;
                        case 7:
                            field = DeviceStateFiled.ExtendTemp3;
                            break;
                        case 8:
                            field = DeviceStateFiled.ExtendTemp4;
                            break;
                    }
                    this.UpdateRealTimeInspect(hvnvrModel.getCode(),field,map5.get(key),1);
                    if(type>0) {
                        TramBasicInfo basic2 = this.iBasicService.getBasicInfoByCustomId(type);
                        Double cpuUseRateThrshold2 = Double.valueOf(basic2.getThreShold());
                        if (map5.get(key) >= cpuUseRateThrshold2)
                            this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(), deviceInfo.getId(),
                                    hvnvrModel.getUpdateTime(), type, basic2.getAlarmName(), "", "", ""));
                    }

                }
                break;
            case 6://信号信息
                Map<Integer,Double> map6 = JSON.parseObject(hvnvrModel.getValue1(),new TypeReference<Map<Integer,Double>>(){});
                for(Integer key:map6.keySet()){
                    switch (key){
                        case 1:
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.GpsSignal,map6.get(key),2);
                            break;
                        case 2:
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.InternetSignal,map6.get(key),2);
                            break;
                    }
                }
                break;
            case 7://电压信息
                Map<Integer,Double> map7 = JSON.parseObject(hvnvrModel.getValue1(),new TypeReference<Map<Integer,Double>>(){});
                for(Integer key:map7.keySet()){
                    switch (key){
                        case 1:
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.Voltage1,map7.get(key),2);
                            break;
                        case 2:
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.Voltage2,map7.get(key),2);
                            break;
                    }
                }
                break;
            case 8://硬件信息
                Map<Integer,String> map8 = JSON.parseObject(hvnvrModel.getValue1(),new TypeReference<Map<Integer,String>>(){});
                for(Integer key:map8.keySet()){
                    switch (key){
                        case 1:
                            this.UpdateRealTimeInspect(hvnvrModel.getCode(),DeviceStateFiled.FiveGModeType,map8.get(key),1);
                            break;
                        case 2://倾斜角
                            TramBasicInfo qxbasicInfo = this.iBasicService.getBasicInfoByCustomId(11);
                            String[] hostQx = map8.get(key).split(",");
                            double x = Double.valueOf(hostQx[0]),y = Double.valueOf(hostQx[1]);
                            if(!StringHelper.isEmpty(qxbasicInfo.getThreShold())){
                                double thrshold = Double.valueOf(qxbasicInfo.getThreShold());
                                boolean isTilt = false;
                                String str = "";
                                if(x>-thrshold&&x<thrshold)
                                {
                                    if (y > thrshold){
                                        str = "左倾"; isTilt = true;
                                    }else if (y < -thrshold){
                                        str = "右倾"; isTilt = true;
                                    }
                                }
                                else if (x > -thrshold)
                                {
                                    if (y > thrshold){
                                        str = "左后倾";isTilt = true;
                                    }else if (y < -thrshold){
                                        str = "右后倾"; isTilt = true;
                                    }else{
                                        str = "右倾"; isTilt = true;
                                    }
                                }
                                else
                                {
                                    if (y > thrshold){
                                        str = "左前倾"; isTilt = true;
                                    }else if (y < -thrshold) {
                                        str = "右前倾"; isTilt = true;
                                    }else{
                                        str = "前倾"; isTilt = true;
                                    }
                                }
                                if(isTilt)
                                    this.iCanService.AddAlarmInfo(this.iCanService.getAlarmQuery(deviceInfo.getDevicecode(),
                                            deviceInfo.getId(),hvnvrModel.getUpdateTime(),11,"车辆发生"+str+"斜，角度："+map8.get(key),"","",""));
                            }
                            break;
                    }
                }
                break;

        }
    }


    @Override
    public TramDeviceStateInspectRealtimeInfo getDeviceStateInspectRealTimeInfo(long deviceid) {
        return this.deviceMapper.getDeviceStateInspectRealTimeInfo(deviceid);
    }

    @Override
    public TramDispatchInfo getLastDispatchInfo(long deviceid) {
        Query query = new Query();
        query.addCriteria(new Criteria("deviceid").is(deviceid));
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"updatetime")));
        return this.mongoTemplate.findOne(query,TramDispatchInfo.class);
    }

    @Override
    public List<MapDeviceViewModel> getMapDeviceList(String devices) {
        return this.deviceMapper.getMapDeviceList(devices);
    }

    @Override
    public DeviceViewModel getDeviceConfig(long id) {
        return this.deviceMapper.getDeviceViewModel(id);
    }

    @Override
    public List<DeviceInspectViewModel> getDeviceInspectList(long userid, long departmentid, long lineid, int type, String keywords) {
        List<Long> departmens = this.iDepartmentService.GetDepartmentIdsByUserId(userid);
        return this.deviceMapper.getDeviceInspectList(departmens,departmentid,lineid,type,keywords);
    }

    @Override
    public void autoCanSignleStatis() {
        List<TramDeviceInfo> devices = this.deviceMapper.getAllDevices();
        for(TramDeviceInfo device:devices){
            Query query1 = new Query();
            String lastTime = DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD);
            String firstTime = DateUtil.addDay(DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD),-1);
            query1.addCriteria(new Criteria("devicecode").is(device.getDevicecode()));
            query1.addCriteria(new Criteria("updatetime").lte(lastTime));
            query1.with(new Sort( new Sort.Order(Sort.Direction.DESC,"updatetime")));
            TramCanInfo lastCanInfo = this.mongoTemplate.findOne(query1,TramCanInfo.class);
            Query query2 = new Query();
            query2.addCriteria(new Criteria("devicecode").is(device.getDevicecode()));
            query2.addCriteria(new Criteria("updatetime").gte(firstTime));
            query2.with(new Sort( new Sort.Order(Sort.Direction.ASC,"updatetime")));
            TramCanInfo firstCanInfo = this.mongoTemplate.findOne(query2,TramCanInfo.class);
            if(firstCanInfo != null && lastCanInfo != null){
                TramBusInfo busInfo = this.deviceMapper.getBusInfo(device.getBusid());
                String updateTime = firstTime;
                CanHistoryEveryDayInfo everyDayInfo = new CanHistoryEveryDayInfo();
                everyDayInfo.setUpdatetime(updateTime);
                Double mileage = Double.valueOf(lastCanInfo.getTotalmileage()==null?"0":lastCanInfo.getTotalmileage())-Double.valueOf(firstCanInfo.getTotalmileage()==null? String.valueOf(0) : firstCanInfo.getTotalmileage());
                everyDayInfo.setTotalmileage(mileage);
                double avg =0D;
                if(!StringHelper.isEmpty(lastCanInfo.getBaterysoc())&&!StringHelper.isEmpty(firstCanInfo.getBaterysoc())){
                    avg = Double.valueOf(firstCanInfo.getBaterysoc())-Double.valueOf(lastCanInfo.getBaterysoc());
                }
                if(busInfo.getBustype()== BusType.DoubleBMSBus.getValue()||busInfo.getBustype()==BusType.PureElectricBus.getValue()){
                    //电车
                    everyDayInfo.setElectricavg(avg);
                }
                else{
                    everyDayInfo.setGasavg(avg);
                }
                everyDayInfo.setGasonlieavg(0D);
                everyDayInfo.setDeviceid(device.getId());
                everyDayInfo.setFaultonelv(this.alarmMapper.getCountByDeviceAndLevel(device.getId(),1));
                everyDayInfo.setFaultsecondlv(this.alarmMapper.getCountByDeviceAndLevel(device.getId(),2));
                everyDayInfo.setFaultthreelv(this.alarmMapper.getCountByDeviceAndLevel(device.getId(),3));
                long unsafeNum = this.deviceMapper.getUnsafeCountByDeviceIdEveryDay(device.getId(),firstTime,lastTime);
                everyDayInfo.setUnsafenumber(unsafeNum);
                Double ss = this.canMapper.GetTop1CanInfo("timelongsql",device.getDevicecode(),firstTime,lastTime);
                everyDayInfo.setRuntimelong(StringHelper.isEmpty(ss)? 0 : ss);
                try {
                    this.deviceMapper.insertCanHistoryEveryDayData(everyDayInfo);
                }catch (Exception ex){
                    logger.debug(ex.getMessage());
                }
            }
        }
    }

    @Override
    public void autoDeviceStatus(){
        List<TramDeviceInfo> devices = this.deviceMapper.getAllDevices();
        String endTime = DateUtil.getCurrentTime();
        String startTime = DateUtil.addMinute(endTime,-1);
        for(TramDeviceInfo device:devices){
            String nowTime = DateUtil.getCurrentTime();
            String stTime = DateUtil.addMinute(nowTime,-5);
            long deviceHealthCount = this.getDeviceHealthInfo(device.getDevicecode(),stTime,nowTime);
            if(deviceHealthCount == 0){
                this.UpdateRealTimeInspect(device.getDevicecode(),DeviceStateFiled.OnlineState,false,3);
            }else{
                this.UpdateRealTimeInspect(device.getDevicecode(),DeviceStateFiled.OnlineState,true,3);
                String time = DateUtil.StringToString(nowTime,DateStyle.YYYY_MM_DD);
                if(this.deviceMapper.getDeviceOnlineRecordCount(device.getDevicecode(),time)==0) {
                    Deviceonlinerecords records = new Deviceonlinerecords();
                    records.setUpdatetime(time);
                    records.setDevicecode(device.getDevicecode());
                    this.deviceMapper.insertDeviceOnlineRecord(records);
                }
            }
            //推送
            PushModel pushModel = new PushModel(1,this.getCurrentDeviceStatus(device.getId()));
            this.iPushService.sendMsg(pushModel);
            //巡检CAN和Gps的即时状态
            Query query = new Query();
            query.addCriteria(new Criteria("devicecode").is(device.getDevicecode()));
            query.addCriteria(new Criteria().andOperator(Criteria.where("updatetime").lte(endTime),Criteria.where("updatetime").gte(startTime)));
            long qc1 = this.mongoTemplate.count(query,TramCanInfo.class);
            long qc2 = this.mongoTemplate.count(query,TramGpsInfo.class);
            if(qc1>0)
                this.UpdateRealTimeInspect(device.getDevicecode(),DeviceStateFiled.CanState,true,3);
            else
                this.UpdateRealTimeInspect(device.getDevicecode(),DeviceStateFiled.CanState,false,3);

            if(qc2>0)
                this.UpdateRealTimeInspect(device.getDevicecode(),DeviceStateFiled.GpsState,true,3);
            else
                this.UpdateRealTimeInspect(device.getDevicecode(),DeviceStateFiled.GpsState,false,3);
        }
    }

    @Override
    public DeviceStatusPushModel getCurrentDeviceStatus(long deviceId){
        TramDeviceInfo deviceInfo = this.getDeviceInfoById(deviceId);
        DeviceStatusPushModel pushModel = new DeviceStatusPushModel();
        pushModel.setCode(deviceInfo.getDevicecode());
        TramDeviceStateInspectRealtimeInfo inspectInfo = this.getDeviceStateInspectRealTimeInfo(deviceId);
        pushModel.setCanState(inspectInfo.isCanstate());
        pushModel.setGpsState(inspectInfo.isGpsstate());
        pushModel.setHostSoftType(deviceInfo.getHostsofttype().intValue());
        pushModel.setOnline(inspectInfo.isOnlineState());
        return pushModel;
    }

    @Override
    public List<Long> getDeviceIdsByUserId(long userId) {
        long roleId = this.iMemberService.getMemberInfo(userId).getRoleid();
        if(roleId!=1) {
            List<Long> departmenIds = this.iDepartmentService.GetDepartmentIdsByUserId(userId);
            return this.deviceMapper.getDeviceIdByDepartmens(departmenIds);
        }else
            return this.deviceMapper.getAllDeviceIds();
    }

    @Override
    public long getDeviceHealthInfo(String deviceCode, String starttime, String endTime) {
        Query query = new Query();
        query.addCriteria(new Criteria("devicecode").is(deviceCode));
        query.addCriteria(new Criteria().andOperator(Criteria.where("updatetime").lte(endTime),Criteria.where("updatetime").gte(starttime)));
        return this.mongoTemplate.count(query,TramDeviceHealthInfo.class);
    }

    @Override
    public TramDeviceInfo GetDriverInfo(long Id,String code){
        return this.deviceMapper.GetDriverInfo(Long.valueOf(Id),code);
    }

    @Override
    public DeviceFilterSearchResult GetAppDeviceFilterSearch(String code)
    {
        return this.deviceMapper.GetAppDeviceFilterSearch(code);
    }

    @Override
    public List<Long> GetDeviceIdsByDepartmentId(CurrentUserInfo user)
    {
        return this.deviceMapper.GetDeviceIdsByDepartmentId(user);
    }

    @Override
    public AppBusViewModel GetAppBusModel(int dayType, long deviceId)
    {
        int dayn=0;
        Double Mileage= Double.valueOf(0);
        AppBusViewModel model1=this.deviceMapper.GetAppBusModelsql1(deviceId);
        DayTypes dayTypes=DayTypes.getDayByType(dayType);
        try {
            dayn=DateUtil.daysBetween(dayTypes.getStartTime(),dayTypes.getEndTime()) + 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int i=0;i<dayn;i++)
        {
            String time=DateUtil.addDay(DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD),-i);
            Double milage=this.deviceMapper.GetAppBusModelsql2(deviceId,"'"+time+"'");
            Mileage += StringHelper.isEmpty(milage) ? 0 : Double.valueOf(milage);
        }
        AppBusViewModel model=new AppBusViewModel();
        model.setBusTypeName(this.basicMapper.BasicName(model1.getBusType()));
        model.setMileage(Mileage);
        return model;
    }

    @Override
    public List<TramChannelInfo> GetChannelsByDeviceId(long deviceId){ return this.deviceMapper.GetChannelsByDeviceId(deviceId);}

    @Override
    public void insertPayTerminalRecords(PayTerminalRecords payTerminalRecords) {
        this.deviceMapper.insertPayTerminalRecords(payTerminalRecords);
    }

    @Override
    public void InspectCanIntegrity() {
        List<String> codes = this.deviceMapper.getDeviceCodes();
        for (String code:codes) {
            String startTime =  DateUtil.addHour(DateUtil.getCurrentTime(),-2);
            String endTime = DateUtil.getCurrentTime();
            Query query = new Query();
            query.addCriteria(new Criteria("devicecode").is(code));
            query.addCriteria(new Criteria().andOperator(Criteria.where("updatetime").gte(startTime),Criteria.where("updatetime").lte(endTime)));
            long c1 = this.mongoTemplate.count(query,TramCanInfo.class);
            query.addCriteria(new Criteria("acts").ne(null));
            long c2 = this.mongoTemplate.count(query,TramCanInfo.class);
            if(c1==0||c2==0)
                this.UpdateRealTimeInspect(code,DeviceStateFiled.IsCanIntegrity,false,3);
            else
                this.UpdateRealTimeInspect(code,DeviceStateFiled.IsCanIntegrity,true,3);
        }
    }

    @Override
    public List<String> GetAllCarCodes(CurrentUserInfo user){
        if (user!=null && user.getUserName()!="admin"){
            List<Long> Ids = this.GetDeviceIdsByDepartmentId(user);
            return this.deviceMapper.getDeviceCodesBIds(Ids);
        }
        else
            return this.deviceMapper.getDeviceCodes();
    }

    @Override
    public int GetCountByDateTime(String code, String date1, String date2) {
        return 0;
    }

    @Override
    public void autoStatement() throws IntrospectionException, NoSuchFieldException, IllegalAccessException {
        List<TramDeviceInfo> devices = this.deviceMapper.getAllDevices();
        String lastTime = DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD);
        String firstTime = DateUtil.addDay(DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD),-1);
        for (TramDeviceInfo list:devices){
            //不安全行为统计
            Tramunsafereportinfo info=new Tramunsafereportinfo();
            Class clazz=info.getClass();
            info.setDeviceid(list.getId());
            info.setDevicecode(list.getDevicecode());
            info.setUpdatetime(Timestamp.valueOf(DateUtil.getCurrentTime()));
            info.setCreatetime(Timestamp.valueOf(DateUtil.getCurrentTime()));
            for (UnSafeBehaviorTypes dicl : UnSafeBehaviorTypes.values()){
                String name= dicl.name();
                Field f=clazz.getDeclaredField(name.toLowerCase());
                int c=this.unSafeMapper.Countunsafe(list.getId(),String.valueOf(dicl.getValue()),firstTime,lastTime);
                f.set(info,new Long(c));
            }
            if (this.unSafeMapper.CountTramUnSafeReportInfo(list.getId(),firstTime,lastTime)==0)
                this.unSafeMapper.InsertReportInfo(info);
            //行为识别统计
            Trambehaviorreportinfo behaviorInfo = new Trambehaviorreportinfo();
            Class behavior=behaviorInfo.getClass();
            behaviorInfo.setDeviceid(list.getId());
            behaviorInfo.setDevicecode(list.getDevicecode());
            behaviorInfo.setUpdatetime(Timestamp.valueOf(DateUtil.getCurrentTime()));
            behaviorInfo.setCreatetime(Timestamp.valueOf(DateUtil.getCurrentTime()));
            for (int i = 99;i < 109;i++){
                String name= EnumHelper.getName(i);
                Field f=behavior.getDeclaredField(name.toLowerCase());
                int c=this.unSafeMapper.CountCanAlarm(list.getId(),i,firstTime,lastTime);
                f.set(behaviorInfo,new Long(c));
            }
            if (this.unSafeMapper.CountBehavior(list.getId(),firstTime,lastTime)==0)
                this.unSafeMapper.InsertBehavior(behaviorInfo);
            //ADAS统计
            Tramadasreportinfo adasInfo=new Tramadasreportinfo();
            Class adas=adasInfo.getClass();
            adasInfo.setDeviceid(list.getId());
            adasInfo.setDevicecode(list.getDevicecode());
            adasInfo.setUpdatetime(Timestamp.valueOf(DateUtil.getCurrentTime()));
            adasInfo.setCreatetime(Timestamp.valueOf(DateUtil.getCurrentTime()));
            for (int i=118;i<125;i++){
                String name= EnumHelper.getName(i);
                Field f=adas.getDeclaredField(name.toLowerCase());
                int c=this.unSafeMapper.CountCanAlarm(list.getId(),i,firstTime,lastTime);
                f.set(adasInfo,new Long(c));
            }
            if (this.unSafeMapper.CountAdas(list.getId(),firstTime,lastTime)==0)
                this.unSafeMapper.InsertAdas(adasInfo);
        }
    }

    @Override
    public void AutoInspectDeviceADAS(){
        List<TramDeviceInfo> devices = this.deviceMapper.getAllDevices();
        String endTime = DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD);
        String startTime = DateUtil.addDay(endTime,-1);
        for (TramDeviceInfo deviceInfo:devices){
            int count1 = this.getAlarmCount(61,deviceInfo.getDevicecode());
            int count2 = this.getAlarmCount(78,deviceInfo.getDevicecode());
            if(count1>0)
                this.UpdateRealTimeInspect(deviceInfo.getDevicecode(),DeviceStateFiled.BehaviorInspectState,true,3);
            else
                this.UpdateRealTimeInspect(deviceInfo.getDevicecode(),DeviceStateFiled.BehaviorInspectState,false,3);
            if(count2>0)
                this.UpdateRealTimeInspect(deviceInfo.getDevicecode(),DeviceStateFiled.AdasInspectState,true,3);
            else
                this.UpdateRealTimeInspect(deviceInfo.getDevicecode(),DeviceStateFiled.AdasInspectState,false,3);
            Query query1 =new Query();
            query1.addCriteria(new Criteria("devicecode").is(deviceInfo.getDevicecode()));
            query1.addCriteria(new Criteria().andOperator(Criteria.where("updatetime").gte(startTime),Criteria.where("updatetime").lte(endTime)));
            long qc1 = this.mongoTemplate.count(query1,TramCanInfo.class);
            long qc2 = this.mongoTemplate.count(query1,TramGpsInfo.class);
            if(qc1>0)
                this.UpdateRealTimeInspect(deviceInfo.getDevicecode(),DeviceStateFiled.CanInspectState,true,3);
            else
                this.UpdateRealTimeInspect(deviceInfo.getDevicecode(),DeviceStateFiled.CanInspectState,false,3);
            if(qc2>0)
                this.UpdateRealTimeInspect(deviceInfo.getDevicecode(),DeviceStateFiled.GpsInspectState,true,3);
            else
                this.UpdateRealTimeInspect(deviceInfo.getDevicecode(),DeviceStateFiled.GpsInspectState,false,3);
        }
    }

    @Override
    public List<String> GetDeviceCodeByDriverId(long driverId) {
        return null;
    }

    private void AddDeviceInspectState(long deviceId,String code,int key,String fag,String field){
        TramDeviceStatusInfo statInfo = new TramDeviceStatusInfo();
        statInfo.setDevicecode(code);
        statInfo.setDeviceid(deviceId);
        statInfo.setType(Long.valueOf(key));
        statInfo.setValue1(fag);
        statInfo.setValue2(fag);
        statInfo.setUpdatetime(DateUtil.getCurrentTime());
        this.deviceMapper.InsertDeviceStatus(statInfo,DateUtil.getCurrentTime());
        this.UpdateRealTimeDeviceStateTable(deviceId,field, Boolean.parseBoolean(fag));
    }

    private void UpdateRealTimeDeviceStateTable(long deviceId, String field, Object value){
        int record = this.deviceMapper.DeviceStateInspectRealTime(deviceId);
        if (record == 0)
            this.deviceMapper.InsertDeviceStateInspectRealTime(field,deviceId,value);
        else {
            this.deviceMapper.UpdateDeviceStateInspectRealTime(field, deviceId, value);
            if(field == DeviceStateFiled.OnlineState.getValue()){
                String nowDate = DateUtil.getCurrentTime();
                this.deviceMapper.updateDeviceLastTime(deviceId,nowDate);
            }
        }
    }

    @Override
    public List<PayTerminalRecords> getPayRecords(String cardno, String date1, String date2, String sitename){
        return this.deviceMapper.getPayRecords(cardno,date1,date2,sitename);
    }

    @Override
    public void autoClacOnlineResult() {
        List<TramDeviceInfo> codes = this.deviceMapper.getAllDevices();
        for(TramDeviceInfo deviceInfo:codes){
            String endTime = DateUtil.StringToString(DateUtil.getCurrentTime(),DateStyle.YYYY_MM_DD);
            String startTime = DateUtil.addDay(endTime,-1);
            Query query = new Query();
            query.addCriteria(new Criteria("devicecode").is(deviceInfo.getDevicecode()));
            query.addCriteria(new Criteria().andOperator(Criteria.where("updatetime").gte(startTime),Criteria.where("updatetime").lte(endTime)));
            long count = this.mongoTemplate.count(query,TramDeviceHealthInfo.class);
            if(count>0){
                Deviceonlinerecords records = new Deviceonlinerecords();
                records.setDevicecode(deviceInfo.getDevicecode());
                records.setUpdatetime(startTime);
                if(this.deviceMapper.getDeviceOnlineRecordCount(deviceInfo.getDevicecode(),startTime)==0) {
                    this.deviceMapper.insertDeviceOnlineRecord(records);
                }
            }
        }
    }

    @Override
    public void updatePayTerminalImage(String image, String deviceCode, String updateTime) {
        this.deviceMapper.updatePayTerminalImage(image,deviceCode,updateTime);
    }

    @Override
    public int getAlarmCount(long parentId, String devicecode) {
        String endTime = DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD);
        String startTime = DateUtil.addDay(endTime,-1);
        return this.deviceMapper.getAlarmCount(parentId,devicecode,startTime,endTime);
    }
}
