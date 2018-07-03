package com.sztvis.dubbo.prodiver;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.common.entity.UnSafeBehaviorTypes;
import com.sztvis.core.DateStyle;
import com.sztvis.core.DateUtil;
import com.sztvis.core.DayTypes;
import com.sztvis.core.TramException;
import com.sztvis.core.helper.StringHelper;
import com.sztvis.domain.DataAlarmConfigViewModel;
import com.sztvis.domain.domain.*;
import com.sztvis.domain.dto.*;
import com.sztvis.domain.dto.push.PushAlarmModel;
import com.sztvis.domain.dto.push.PushModel;
import com.sztvis.domain.dto.service.SaveAlarmQuery;
import com.sztvis.dubbo.*;
import com.sztvis.dubbo.prodiver.mapper.AlarmMapper;
import com.sztvis.dubbo.prodiver.mapper.BasicMapper;
import com.sztvis.dubbo.prodiver.mapper.CanMapper;
import com.sztvis.dubbo.prodiver.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import util.BeanRefUtil;
import util.LogUtil;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/10 上午10:33
 */
@Service(version = "1.0.0")
public class CanService implements ICanService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private BasicMapper basicMapper;
    @Autowired
    private AlarmMapper alarmMapper;
    @Reference(version="1.0.0")
    private IGpsService iGpsService;
    @Autowired
    private CanMapper canMapper;
    @Reference(version="1.0.0")
    private IDeviceService iDeviceService;
    @Reference(version="1.0.0")
    private IPushService iPushService;
    @Reference(version="1.0.0")
    private IConfigService iConfigService;
    @Reference(version="1.0.0")
    private ISiteSettingService iSiteSettingService;

    @Override
    public TramCanInfo GetCanInfo(String deviceCode, String updateTime) {
        Query query = new Query();
        query.addCriteria(new Criteria("devicecode").is(deviceCode));
        query.addCriteria(new Criteria("updatetime").is(updateTime));
        return this.mongoTemplate.findOne(query,TramCanInfo.class);
    }

    /**
     * 获得当前时间点之前的的最后一条CAN数据，目的是想这个CAN数据，赋值给新的CAN数据,包含纯电动车数据
     * @return
     */
    private TramCanInfo getBeforeCurrentTimeLastCanInfo(TramCanInfo canInfo){
        Query query = new Query();
        query.addCriteria(new Criteria("devicecode").is(canInfo.getDevicecode()));
        query.addCriteria(new Criteria("updatetime").lt(canInfo.getUpdatetime()));
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"updatetime")));
        TramCanInfo lastCanInfo = this.mongoTemplate.findOne(query,TramCanInfo.class);
        try {
            Map<String, String> valueMap = BeanRefUtil.getFieldValueMap(canInfo);
            BeanRefUtil.setFieldValue(lastCanInfo,valueMap);
            if(canInfo.getElectricCanInfo()!=null){
                if(lastCanInfo.getElectricCanInfo()==null)
                    lastCanInfo.setElectricCanInfo(canInfo.getElectricCanInfo());
                else{
                    Map<String, String> valueMap2 = BeanRefUtil.getFieldValueMap(canInfo.getElectricCanInfo());
                    ElectricCanInfo electricCanInfo = lastCanInfo.getElectricCanInfo();
                    BeanRefUtil.setFieldValue(electricCanInfo,valueMap2);
                    lastCanInfo.setElectricCanInfo(electricCanInfo);
                }
            }
        }catch (Exception ex){
            LogUtil.printLog(ex,this.getClass());
        }
        return lastCanInfo;
    }

    @Override
    public void Save(TramCanInfo canInfo) {
        TramCanInfo obj = this.GetCanInfo(canInfo.getDevicecode(),canInfo.getUpdatetime());
        TramCanInfo newCanInfo = this.getBeforeCurrentTimeLastCanInfo(canInfo);
        if(obj == null)
            this.mongoTemplate.save(newCanInfo);
        else
            this.Update(newCanInfo);
    }

    @Override
    public void Update(TramCanInfo canInfo) {
        Query query =new Query();
        query.addCriteria(new Criteria("devicecode").is(canInfo.getDevicecode()));
        query.addCriteria(new Criteria("updatetime").is(canInfo.getUpdatetime()));
        Update update = new Update();
        update.set("deviceid",canInfo.getDeviceid());
        update.set("devicecode",canInfo.getDevicecode());
        update.set("updatetime",canInfo.getUpdatetime());
        update.set("batteryvoltage",canInfo.getBatteryvoltage());
        update.set("batterycurrent",canInfo.getBatterycurrent());
        update.set("busstall",canInfo.getBusstall());
        update.set("baterysoc",canInfo.getBaterysoc());
        update.set("motorspeed",canInfo.getMotorspeed());
        update.set("enginefuelrae",canInfo.getEnginefuelrae());
        update.set("gasusetotal",canInfo.getGasusetotal());
        update.set("totalmileage",canInfo.getTotalmileage());
        update.set("shortmileage",canInfo.getShortmileage());
        update.set("fueleconomy",canInfo.getFueleconomy());
        update.set("fuelusespeed",canInfo.getFuelusespeed());
        update.set("oilpressure",canInfo.getOilpressure());
        update.set("pressure1",canInfo.getPressure1());
        update.set("pressure2",canInfo.getPressure2());
        update.set("remainingoil",canInfo.getRemainingoil());
        update.set("speed",canInfo.getSpeed());
        update.set("watertemperature",canInfo.getWatertemperature());
        update.set("rotationalspeed",canInfo.getRotationalspeed());
        update.set("totaloilconsumption",canInfo.getTotaloilconsumption());
        update.set("voltage",canInfo.getVoltage());
        update.set("tirelayoutnumber",canInfo.getTirelayoutnumber());
        update.set("tirenumber1",canInfo.getTirenumber1());
        update.set("tirepressure1",canInfo.getTirepressure1());
        update.set("tirepressure2",canInfo.getTirepressure2());
        update.set("tirenumber2",canInfo.getTirenumber2());
        update.set("outcartemperature",canInfo.getOutcartemperature());
        update.set("incartemperature",canInfo.getIncartemperature());
        ElectricCanInfo ecInfo = canInfo.getElectricCanInfo();
        if(ecInfo==null)
            ecInfo=new ElectricCanInfo();
        update.set("electricCanInfo.canId",ecInfo.getCanId());
        update.set("electricCanInfo.batterySingleCount",ecInfo.getBatterySingleCount());
        update.set("electricCanInfo.batteryProbeCount",ecInfo.getBatteryProbeCount());
        update.set("electricCanInfo.batteryMaxVoltageSingleCode",ecInfo.getBatteryMaxVoltageSingleCode());
        update.set("electricCanInfo.batteryMaxVoltage",ecInfo.getBatteryMaxVoltage());
        update.set("electricCanInfo.batteryMinVoltageCode",ecInfo.getBatteryMinVoltageCode());
        update.set("electricCanInfo.batteryMinVoltage",ecInfo.getBatteryMinVoltage());
        update.set("electricCanInfo.maxTempProbeNumber",ecInfo.getMaxTempProbeNumber());
        update.set("electricCanInfo.maxTempValue",ecInfo.getMaxTempValue());
        update.set("electricCanInfo.minTempProbeNumber",ecInfo.getMaxTempProbeNumber());
        update.set("electricCanInfo.minTempValue",ecInfo.getMinTempValue());
        update.set("electricCanInfo.highResistance",ecInfo.getHighResistance());
        update.set("electricCanInfo.electrical",ecInfo.getElectrical());
        update.set("electricCanInfo.leftElecRote",ecInfo.getLeftElecRote());
        update.set("electricCanInfo.leftElecInputVoltage",ecInfo.getLeftElecInputVoltage());
        update.set("electricCanInfo.leftElecTemp",ecInfo.getLeftElecTemp());
        update.set("electricCanInfo.leftElecContrTemp",ecInfo.getLeftElecContrTemp());
        update.set("electricCanInfo.leftElecTorque",ecInfo.getLeftElecTorque());
        update.set("electricCanInfo.leftElecMode",ecInfo.getLeftElecMode());
        update.set("electricCanInfo.leftElecCurrent",ecInfo.getLeftElecCurrent());
        update.set("electricCanInfo.rightElecRote",ecInfo.getRightElecRote());
        update.set("electricCanInfo.rightElecInputVoltage",ecInfo.getRightElecInputVoltage());
        update.set("electricCanInfo.rightElecTemp",ecInfo.getRightELecTemp());
        update.set("electricCanInfo.rightElecContrTemp",ecInfo.getRightElecContrTemp());
        update.set("electricCanInfo.rightElecTorque",ecInfo.getRightElecTorque());
        update.set("electricCanInfo.rightElecMode",ecInfo.getRightElecMode());
        update.set("electricCanInfo.rightElecCurrent",ecInfo.getRightElecCurrent());
        update.set("electricCanInfo.acceleratorPedal",ecInfo.getAcceleratorPedal());
        update.set("electricCanInfo.carVIN",ecInfo.getCarVIN());
        update.set("electricCanInfo.idlingSwitch",ecInfo.getIdlingSwitch());
        update.set("electricCanInfo.minimumBatteryNumber",ecInfo.getMinimumBatteryNumber());
        update.set("electricCanInfo.allBatteryMinimum",ecInfo.getAllBatteryMinimum());
        update.set("electricCanInfo.maxmumBatteryNumber",ecInfo.getMaxmumBatteryNumber());
        update.set("electricCanInfo.allBatteryMax",ecInfo.getAllBatteryMax());
        update.set("electricCanInfo.minimumTempBatteryNumber",ecInfo.getMinimumTempBatteryNumber());
        update.set("electricCanInfo.minimumTemp",ecInfo.getMinimumTemp());
        update.set("electricCanInfo.maxTempBatteryNumber",ecInfo.getMaxTempBatteryNumber());
        update.set("electricCanInfo.maxTemp",ecInfo.getMaxTemp());
        update.set("electricCanInfo.chargeSurplusHour",ecInfo.getChargeSurplusHour());
        update.set("electricCanInfo.chargeSurplusMinute",ecInfo.getChargeSurplusMinute());
        update.set("electricCanInfo.signleChargeValue",ecInfo.getSignleChargeValue());
        update.set("electricCanInfo.signleDisChargeValue",ecInfo.getSignleDisChargeValue());
        update.set("electricCanInfo.batteryTempState",ecInfo.getBatteryTempState());
        update.set("electricCanInfo.leakageState",ecInfo.getLeakageState());
        update.set("electricCanInfo.mxElec",ecInfo.getMxElec());
        update.set("electricCanInfo.setTemp",ecInfo.getSetTemp());
        update.set("electricCanInfo.airState",ecInfo.getAirState());
        update.set("electricCanInfo.okState",ecInfo.getOkState());
        update.set("electricCanInfo.shieldTurnState",ecInfo.getShieldTurnState());
        this.mongoTemplate.updateFirst(query, update, TramCanInfo.class);
    }

    @Override
    public TramCanInfo FindLastById(long deviceId) {
        Query query =new Query();
        query.addCriteria(new Criteria("deviceid").is(deviceId));
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"updatetime")));
        return this.mongoTemplate.findOne(query,TramCanInfo.class);
    }

    @Override
    public TramCanInfo FindLastByCode(String deviceCode) {
        Query query =new Query();
        query.addCriteria(new Criteria("devicecode").is(deviceCode));
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"updatetime")));
        return this.mongoTemplate.findOne(query,TramCanInfo.class);
    }

    @Override
    public void AddAlarmInfo(SaveAlarmQuery query) {
        TramDeviceInfo deviceInfo = this.deviceMapper.getDeviceInfoByCode(query.getDeviceCode());
        if(deviceInfo == null)
            throw new TramException("设备编码不存在！");
        int alarmType=query.getAlarmType();
        String updateTime = DateUtil.StringToString(query.getAlarmTime(), DateStyle.YYYY_MM_DD_HH_MM_SS);
        int c = this.canMapper.getAlarmCountByKeyAndUpdateTime(query.getDeviceId(),query.getAlarmType(),updateTime);
        if(c==0) {
            TramBasicInfo basicInfo = this.basicMapper.getBasicInfoByCustomId(alarmType);
            //这里加上一天之内已经存在了的报警，将不再增加

            //判断报警类型是否打开
            if (basicInfo.isTurn()) {
                //获得该设备最后一条gps数据
                TramGpsInfo gpsInfo = this.iGpsService.getLastGpsInfo(query.getDeviceCode(), query.getAlarmTime());
                TramAlarmInfo alarmInfo = new TramAlarmInfo();
                alarmInfo.setDeviceId(deviceInfo.getId());
                alarmInfo.setDeviceCode(deviceInfo.getDevicecode());
                alarmInfo.setUpdateTime(Timestamp.valueOf(updateTime));
                alarmInfo.setAlarmType(query.getAlarmType());
                alarmInfo.setParentAlarmType(basicInfo.getParentId());
                alarmInfo.setValue(query.getValue());
                alarmInfo.setSystemInsertTime(new Timestamp(System.currentTimeMillis()));
                alarmInfo.setAlarmVideoPath(query.getPath());
                alarmInfo.setSpeed(query.getSpeed());
                alarmInfo.setDistance(query.getDistance());
                alarmInfo.setBrake(query.isBrake());
                alarmInfo.setDepartmentId(deviceInfo.getDepartmentid());
                alarmInfo.setState(basicInfo.isEnable() ? 1 : 0);
                alarmInfo.setPath(query.getPath2());
                alarmInfo.setSystemInsertTime(Timestamp.valueOf(DateUtil.getCurrentTime()));
                if (gpsInfo != null)
                    alarmInfo.setLocation(gpsInfo.getLongitude() + "," + gpsInfo.getLatitude());
                this.alarmMapper.SaveAlarmInfo(alarmInfo);
                //返回主键Id
                long alarmId = alarmInfo.getId();
                //是否需要推送（推送到App,推送到页面）
                if (basicInfo.isPush()) {
                    try {
                        if (this.iSiteSettingService.GetSiteSettings().getAlarmTurn()==1&&(alarmType!=12||alarmType!=14)){
                            String extrias = query.getSpeed() + "|" + query.getDistance() + "|" + (query.isBrake() ? 1 : 0);
                            PushAlarmModel pushAlarmModel = new PushAlarmModel(alarmId, deviceInfo.getDevicecode(), basicInfo.getId().intValue(), updateTime, basicInfo.getAlarmName(), "", query.getPath(), extrias, query.getValue(), StringHelper.isEmpty(basicInfo.getCustomId()) ? 0 : Integer.valueOf(basicInfo.getCustomId()));
                            pushAlarmModel.setLongitude(gpsInfo!=null?gpsInfo.getLongitude():"");
                            pushAlarmModel.setLatitude(gpsInfo!=null?gpsInfo.getLatitude():"");
                            PushModel pushModel = new PushModel(2, pushAlarmModel);
                            this.iPushService.SendToMsgByDeviceCode(deviceInfo.getDevicecode(), pushModel);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void AddCanActInfo(String updateTime, String deviceCode, List<TramCanActinfo> map) {
        Query query=new Query();
        query.addCriteria(new Criteria("devicecode").is(deviceCode));
        query.addCriteria(new Criteria("updatetime").is(updateTime));
        //查找对应时间的Can信息
        TramCanInfo canInfo = this.mongoTemplate.findOne(query,TramCanInfo.class);
        if(canInfo != null){
            Update update = new Update();
            List<TramCanActinfo> list = canInfo.getActs();
            if(list==null)
                list = new ArrayList<>();
            Map<Integer,String> maps = new HashMap<>();
            for(TramCanActinfo ac:list){
                maps.put(ac.getCustomId(),ac.getValue());
            }
            for(TramCanActinfo ac:map){
                if(maps.keySet().contains(ac.getCustomId()))
                    list = UpdateActs(ac.getCustomId(),ac.getValue(),list);
                else
                    list.add(ac);
            }
            update.set("acts",list);
            this.mongoTemplate.updateFirst(query,update,TramCanInfo.class);
        }
    }
    private List<TramCanActinfo> UpdateActs(int customId,String newValue,List<TramCanActinfo> oldList){
        List<TramCanActinfo> list = new ArrayList<>();
        for(TramCanActinfo ac:oldList){
            if(ac.getCustomId()==customId){
                ac.setValue(newValue);
            }
            list.add(ac);
        }
        return list;
    }
    @Override
    public TramCanInfo getLastCanInfo(String deviceCode) {
        Query query = new Query();
        query.addCriteria(new Criteria("devicecode").is(deviceCode));
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"updatetime")));
        return this.mongoTemplate.findOne(query,TramCanInfo.class);
    }
    @Override
    public TramCanInfo getLastCanInfo(String deviceCode,String updateTime) {
        Query query = new Query();
        query.addCriteria(new Criteria("devicecode").is(deviceCode));
        query.addCriteria(new Criteria("updatetime").lte(updateTime));
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"updatetime")));
        return this.mongoTemplate.findOne(query,TramCanInfo.class);
    }
    public SaveAlarmQuery getAlarmQuery(String deviceCode,long deviceId,String updateTime,int type,String value,String extras,String path,String path2){
        SaveAlarmQuery query = new SaveAlarmQuery();
        String[] extraArray =extras.equals("")?null:extras.split(",");
        TramGpsInfo gpsInfo = this.iGpsService.getLastGpsInfo(deviceCode,updateTime);
        if(extraArray ==null||extraArray.length ==0){
            query.setSpeed(0D);
            query.setDistance(0L);
            query.setBrake(false);
        }else{
            query.setSpeed(Double.valueOf(extraArray[0]));
            query.setDistance(Double.valueOf(extraArray[1]));
            query.setBrake(extraArray[2].equals("2"));
        }
        query.setAlarmTime(updateTime);
        query.setAlarmType(type);
        query.setDeviceCode(deviceCode);
        query.setPath(path);
        query.setPath2(path2);
        query.setDeviceId(deviceId);
        query.setValue(value);
        return query;
    }

    @Override
    public CanViewModel getLastCanViewModel(String devicecode) {
        CanViewModel viewModel = new CanViewModel();
        TramCanInfo canInfo = this.getLastCanInfo(devicecode);
        TramGpsInfo gpsInfo = this.iGpsService.getLastGpsInfo(devicecode);
        CanModel canModel = new CanModel();
        canModel.setAfterpressure(canInfo.getPressure2());
        canModel.setBeforepressure(canInfo.getPressure1());
        canModel.setBrakeopenings("1");
        canModel.setElec(canInfo.getElectricCanInfo());
        canModel.setElecconsumption("");
        canModel.setElectricalratespeed("0");
        canModel.setElectricalstat("2");
        canModel.setLeftpress(canInfo.getPressure1());
        canModel.setRightpress(canInfo.getPressure2());
        canModel.setBeforepressure(canInfo.getPressure1());
        canModel.setAfterpressure(canInfo.getPressure2());
        canModel.setSpeed(canInfo.getSpeed());
        canModel.setIncartemp(canInfo.getIncartemperature());
        canModel.setOutcartemp(canInfo.getOutcartemperature());
        canModel.setWatertemp(canInfo.getWatertemperature());
        canModel.setTotalmileage(canInfo.getTotalmileage());
        canModel.setShortmileage(canInfo.getShortmileage());
        canModel.setSoc(canInfo.getBaterysoc());
        canModel.setRatespeed(canInfo.getRotationalspeed());
        canModel.setRatespped2(canInfo.getElectricCanInfo()==null?"0":canInfo.getElectricCanInfo().getRightElecRote());
        canModel.setRoate(gpsInfo==null?"0":gpsInfo.getDirection().toString());
        canModel.setLocation(gpsInfo==null?"":gpsInfo.getLongitude()+","+gpsInfo.getLatitude());
        canModel.setOilopenings(canInfo.getElectricCanInfo()==null?"0":canInfo.getElectricCanInfo().getAcceleratorPedal());
        CanStatModel s = new CanStatModel();
        s.setAbsturn(this.getCanStat(canInfo.getActs(),250));
        s.setAccturn(this.getCanStat(canInfo.getActs(),59));
        s.setActurn(this.getCanStat(canInfo.getActs(),258));
        s.setAfterfoglampsturn(this.getCanStat(canInfo.getActs(),48));
        s.setBeforefoglampsturn(this.getCanStat(canInfo.getActs(),47));
        s.setEnginepreheatingturn(this.getCanStat(canInfo.getActs(),70));
        s.setDippedlightsturn(this.getCanStat(canInfo.getActs(),50));
        s.setEngineworkturn(this.getCanStat(canInfo.getActs(),70));
        s.setFootbraketurn(this.getCanStat(canInfo.getActs(),42));
        s.setParkingbraketurn(this.getCanStat(canInfo.getActs(),43));
        s.setHeaderdoorturn(this.getCanStat(canInfo.getActs(),39));
        s.setMiddledoorturn(this.getCanStat(canInfo.getActs(),40));
        s.setLastdoorturn(this.getCanStat(canInfo.getActs(),41));
        s.setHighbeamturn(this.getCanStat(canInfo.getActs(),49));
        s.setLeftturn(this.getCanStat(canInfo.getActs(),52));
        s.setRightturn(this.getCanStat(canInfo.getActs(),51));
        s.setSafetybelt(this.getCanStat(canInfo.getActs(),59));
        viewModel.setCanstatinfo(s);
        viewModel.setCaninfo(canModel);
        viewModel.setTime(canInfo.getUpdatetime());
        viewModel.setDispatchinfo(this.getLastDispathModel(canInfo.getDevicecode()));
        return viewModel;
    }

    @Override
    public DispatchModel getLastDispathModel(String devicecode) {
        Query query = new Query();
        query.addCriteria(new Criteria("devicecode").is(devicecode));
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"updatetime")));
        TramDispatchInfo dispatchInfo = this.mongoTemplate.findOne(query,TramDispatchInfo.class);
        DispatchModel dModel = new DispatchModel();
        if(dispatchInfo!=null){
            dModel.setCurrentsite(dispatchInfo.getDispatchname());
            dModel.setInoroutsite(dispatchInfo.getDrivingdirection().intValue());
            dModel.setInoroutsitetype(dispatchInfo.getDispatchtype().intValue());
            dModel.setNextsite("");
            dModel.setSitetype(0);
        }
        return dModel;
    }

    @Override
    public void autoCalcUnsafeData(long deviceId, String updateTime) throws ParseException {

    }

    //车辆起步不关车门
    @Override
    public void autoCalcUnsafeGoingData(long deviceId, String updateTime) throws ParseException {
        String end = DateUtil.addSecond(updateTime,-1);
        Query query = new Query(Criteria.where("updatetime").gte(updateTime).lte(end).and("deviceid").is(deviceId));
        List<TramCanInfo> judge = mongoTemplate.find(query,TramCanInfo.class);
        if (judge.size()>=2) {
            if (!StringHelper.isEmpty(judge.get(0).getSpeed()) && !StringHelper.isEmpty(judge.get(1).getSpeed())){
                Double speed2 = Double.parseDouble(judge.get(0).getSpeed());
                Double speed1 = Double.parseDouble(judge.get(1).getSpeed());
                String date2 = judge.get(0).getUpdatetime();
                String date1 = judge.get(1).getUpdatetime();
                if (speed1==0 && speed2 - speed1>=5) {
                    for (TramCanInfo list : judge) {
                        List<TramCanActinfo> info = list.getActs();
                        List<TramCanActinfo> info1 = info.stream().filter(x -> x.getCustomId() == 23 || x.getCustomId() == 21).collect(Collectors.toList());
                        for (TramCanActinfo list1 : info1) {
                            if (list1.getValue().equals(2)) {
                                TramUnsafeBehaviorInfo usSafeInfo = new TramUnsafeBehaviorInfo();
                                TramDeviceInfo deviceInfo = this.iDeviceService.GetDriverInfo(deviceId, null);
                                if (deviceInfo != null) {
                                    usSafeInfo.setDeviceid(deviceInfo.getId());
                                    usSafeInfo.setDevicecode(deviceInfo.getDevicecode());
                                    usSafeInfo.setApplytime(new Timestamp(DateUtil.StringToDate(updateTime).getTime()));
                                    usSafeInfo.setCreatetime(DateUtil.getCurrentTimes());
                                    usSafeInfo.setSpeed(speed2);
                                    usSafeInfo.setUnsafetime(new Long(DateUtil.secondBetween(date2, date1)));
                                    usSafeInfo.setUnsafetype(new Long(UnSafeBehaviorTypes.CarGoingThenUnCloseDoor.getValue()));
                                    TramGpsInfo Gpsinfo = this.iGpsService.getLastGpsInfo(deviceInfo.getDevicecode(), updateTime);
                                    if (Gpsinfo != null)
                                        usSafeInfo.setLocation(Gpsinfo.getLongitude().concat(",").concat(Gpsinfo.getLatitude()));
                                    this.insertUnsafeData(usSafeInfo);
                                }
                            }
                        }
                    }
                }
                }
            }
    }

    //车辆未停稳开车门
    @Override
    public void autoCalcUnsafeStopingData(long deviceId, String updateTime) throws ParseException {
        String end = DateUtil.addSecond(updateTime,-1);
        Query query = new Query(Criteria.where("updatetime").gte(updateTime).lte(end).and("deviceid").is(deviceId));
        List<TramCanInfo> judge = mongoTemplate.find(query,TramCanInfo.class);
        if (judge.size()>=2) {
            if (!StringHelper.isEmpty(judge.get(0).getSpeed()) && !StringHelper.isEmpty(judge.get(1).getSpeed())){
                Double speed2 = Double.parseDouble(judge.get(0).getSpeed());
                Double speed1 = Double.parseDouble(judge.get(1).getSpeed());
                String date2 = judge.get(0).getUpdatetime();
                String date1 = judge.get(1).getUpdatetime();
                if (speed1==0 && speed2 - speed1>=5) {
                    for (TramCanInfo list : judge) {
                        List<TramCanActinfo> info = list.getActs();
                        List<TramCanActinfo> info1 = info.stream().filter(x -> x.getCustomId() == 23 || x.getCustomId() == 21).collect(Collectors.toList());
                        for (TramCanActinfo list1 : info1) {
                            if (list1.getValue().equals(2)) {
                                TramUnsafeBehaviorInfo usSafeInfo = new TramUnsafeBehaviorInfo();
                                TramDeviceInfo deviceInfo = this.iDeviceService.GetDriverInfo(deviceId, null);
                                if (deviceInfo != null) {
                                    usSafeInfo.setDeviceid(deviceInfo.getId());
                                    usSafeInfo.setDevicecode(deviceInfo.getDevicecode());
                                    usSafeInfo.setApplytime(new Timestamp(DateUtil.StringToDate(updateTime).getTime()));
                                    usSafeInfo.setCreatetime(DateUtil.getCurrentTimes());
                                    usSafeInfo.setSpeed(speed2);
                                    usSafeInfo.setUnsafetime(new Long(DateUtil.secondBetween(date2, date1)));
                                    usSafeInfo.setUnsafetype(new Long(UnSafeBehaviorTypes.CarUnStopingThenOpenDoor.getValue()));
                                    TramGpsInfo Gpsinfo = this.iGpsService.getLastGpsInfo(deviceInfo.getDevicecode(), updateTime);
                                    if (Gpsinfo != null)
                                        usSafeInfo.setLocation(Gpsinfo.getLongitude().concat(",").concat(Gpsinfo.getLatitude()));
                                    this.insertUnsafeData(usSafeInfo);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //急刹车
    @Override
    public void autoCalcEmergencyBrake(long deviceId, String updateTime){
        String end = DateUtil.addSecond(updateTime,-1);
        Query query = new Query(Criteria.where("updatetime").is(end).and("deviceid").is(deviceId));
        Query query1 = new Query(Criteria.where("updatetime").is(updateTime).and("deviceid").is(deviceId));
        TramCanInfo prev = mongoTemplate.findOne(query,TramCanInfo.class);
        TramCanInfo next = mongoTemplate.findOne(query1,TramCanInfo.class);
        if (next!= null && prev!= null){
            String SpeedPrev = prev.getSpeed();
            String SpeedNext = next.getSpeed();
            if (!StringHelper.isEmpty(SpeedPrev) && !StringHelper.isEmpty(SpeedNext)){
                Double spnext = Double.parseDouble(SpeedNext);
                Double spprev = Double.parseDouble(SpeedPrev);
                if (spnext - spprev >=15){
                    TramUnsafeBehaviorInfo usSafeInfo = new TramUnsafeBehaviorInfo();
                    TramDeviceInfo deviceInfo = this.iDeviceService.GetDriverInfo(deviceId, null);
                    if (deviceInfo != null) {
                        usSafeInfo.setDeviceid(deviceInfo.getId());
                        usSafeInfo.setDevicecode(deviceInfo.getDevicecode());
                        usSafeInfo.setApplytime(new Timestamp(DateUtil.StringToDate(updateTime).getTime()));
                        usSafeInfo.setCreatetime(DateUtil.getCurrentTimes());
                        usSafeInfo.setSpeed(spnext);
                        usSafeInfo.setUnsafetime(new  Long(1));
                        usSafeInfo.setUnsafetype(new Long(UnSafeBehaviorTypes.EmergencyBrake.getValue()));
                        TramGpsInfo Gpsinfo = this.iGpsService.getLastGpsInfo(deviceInfo.getDevicecode(), updateTime);
                        if (Gpsinfo != null)
                            usSafeInfo.setLocation(Gpsinfo.getLongitude().concat(",").concat(Gpsinfo.getLatitude()));
                        this.insertUnsafeData(usSafeInfo);
                    }
                }
            }
        }
    }

    // 空档滑行
    @Override
    public void autoCalcNeutralAndTravel(long deviceId, String updateTime){
        String end = DateUtil.addSecond(updateTime,-7);
        Query query = new Query(Criteria.where("updatetime").gte(end).lte(updateTime).and("deviceid").is(deviceId).and("speed").gte(20));
        long count = mongoTemplate.count(query,TramCanInfo.class);
        if (count>=7){
            TramUnsafeBehaviorInfo usSafeInfo = new TramUnsafeBehaviorInfo();
            TramDeviceInfo deviceInfo = this.iDeviceService.GetDriverInfo(deviceId, null);
            if (deviceInfo != null) {
                usSafeInfo.setDeviceid(deviceInfo.getId());
                usSafeInfo.setDevicecode(deviceInfo.getDevicecode());
                usSafeInfo.setApplytime(new Timestamp(DateUtil.StringToDate(updateTime).getTime()));
                usSafeInfo.setCreatetime(DateUtil.getCurrentTimes());
                usSafeInfo.setUnsafetime(new  Long(1));
                usSafeInfo.setUnsafetype(new Long(UnSafeBehaviorTypes.NeutralAndTravel.getValue()));
                this.insertUnsafeData(usSafeInfo);
            }
        }
    }

    //急减速
    @Override
    public void autoCalcQuickSlowDown(long deviceId, String updateTime){
        String end = DateUtil.addSecond(updateTime,-1);
        Query query = new Query(Criteria.where("updatetime").is(updateTime).and("deviceid").is(deviceId));
        Query query1 = new Query(Criteria.where("updatetime").is(end).and("deviceid").is(deviceId));
        TramCanInfo prev = mongoTemplate.findOne(query,TramCanInfo.class);
        TramCanInfo next = mongoTemplate.findOne(query1,TramCanInfo.class);
        if (next!= null && prev!= null){
            String SpeedPrev = prev.getSpeed();
            String SpeedNext = next.getSpeed();
            if (!StringHelper.isEmpty(SpeedPrev) && !StringHelper.isEmpty(SpeedNext)){
                Double spnext = Double.parseDouble(SpeedNext);
                Double spprev = Double.parseDouble(SpeedPrev);
                if (spnext - spprev >= -10){
                    TramUnsafeBehaviorInfo usSafeInfo = new TramUnsafeBehaviorInfo();
                    TramDeviceInfo deviceInfo = this.iDeviceService.GetDriverInfo(deviceId, null);
                    if (deviceInfo != null) {
                        usSafeInfo.setDeviceid(deviceInfo.getId());
                        usSafeInfo.setDevicecode(deviceInfo.getDevicecode());
                        usSafeInfo.setApplytime(new Timestamp(DateUtil.StringToDate(updateTime).getTime()));
                        usSafeInfo.setCreatetime(DateUtil.getCurrentTimes());
                        usSafeInfo.setSpeed(spnext);
                        usSafeInfo.setUnsafetime(new  Long(1));
                        usSafeInfo.setUnsafetype(new Long(UnSafeBehaviorTypes.QuickSlowDown.getValue()));
                        TramGpsInfo Gpsinfo = this.iGpsService.getLastGpsInfo(deviceInfo.getDevicecode(), updateTime);
                        if (Gpsinfo != null)
                            usSafeInfo.setLocation(Gpsinfo.getLongitude().concat(",").concat(Gpsinfo.getLatitude()));
                        this.insertUnsafeData(usSafeInfo);
                    }
                }
            }
        }
    }

    //倒车超速
    @Override
    public void autiCalcReversingSpeeding(long deviceId, String updateTime){
        String end = DateUtil.addSecond(updateTime,-1);
        Query query = new Query(Criteria.where("updatetime").is(updateTime).and("deviceid").is(deviceId).and("speed").gte(20));
        Query query1 = new Query(Criteria.where("updatetime").is(end).and("deviceid").is(deviceId));
        Query query2 = new Query(Criteria.where("updatetime").is(updateTime).and("deviceid").is(deviceId));
        long count = mongoTemplate.count(query,TramCanInfo.class);
        TramCanInfo prev = mongoTemplate.findOne(query1,TramCanInfo.class);
        TramCanInfo next = mongoTemplate.findOne(query2,TramCanInfo.class);
        Double Speedprev = Double.parseDouble(prev.getSpeed());
        Double Speednext = Double.parseDouble(next.getSpeed());
        if (count>=1 || Speednext-Speedprev>=5){
            TramUnsafeBehaviorInfo usSafeInfo = new TramUnsafeBehaviorInfo();
            TramDeviceInfo deviceInfo = this.iDeviceService.GetDriverInfo(deviceId, null);
            if (deviceInfo != null) {
                usSafeInfo.setDeviceid(deviceInfo.getId());
                usSafeInfo.setDevicecode(deviceInfo.getDevicecode());
                usSafeInfo.setApplytime(new Timestamp(DateUtil.StringToDate(updateTime).getTime()));
                usSafeInfo.setCreatetime(DateUtil.getCurrentTimes());
                usSafeInfo.setUnsafetime(new  Long(1));
                usSafeInfo.setUnsafetype(new Long(UnSafeBehaviorTypes.ReversingSpeeding.getValue()));
                this.insertUnsafeData(usSafeInfo);
            }
        }
    }

    //急加速
    @Override
    public void autoCalcRevvingUp(long deviceId, String updateTime){
        String end = DateUtil.addSecond(updateTime,-1);
        Query query = new Query(Criteria.where("updatetime").is(end).and("deviceid").is(deviceId));
        Query query1 = new Query(Criteria.where("updatetime").is(updateTime).and("deviceid").is(deviceId));
        TramCanInfo prev = mongoTemplate.findOne(query,TramCanInfo.class);
        TramCanInfo next = mongoTemplate.findOne(query1,TramCanInfo.class);
        if (next!= null && prev!= null){
            String SpeedPrev = prev.getSpeed();
            String SpeedNext = next.getSpeed();
            if (!StringHelper.isEmpty(SpeedPrev) && !StringHelper.isEmpty(SpeedNext)){
                Double spnext = Double.parseDouble(SpeedNext);
                Double spprev = Double.parseDouble(SpeedPrev);
                if (spnext - spprev >=10){
                    TramUnsafeBehaviorInfo usSafeInfo = new TramUnsafeBehaviorInfo();
                    TramDeviceInfo deviceInfo = this.iDeviceService.GetDriverInfo(deviceId, null);
                    if (deviceInfo != null) {
                        usSafeInfo.setDeviceid(deviceInfo.getId());
                        usSafeInfo.setDevicecode(deviceInfo.getDevicecode());
                        usSafeInfo.setApplytime(new Timestamp(DateUtil.StringToDate(updateTime).getTime()));
                        usSafeInfo.setCreatetime(DateUtil.getCurrentTimes());
                        usSafeInfo.setSpeed(spnext);
                        usSafeInfo.setUnsafetime(new  Long(1));
                        usSafeInfo.setUnsafetype(new Long(UnSafeBehaviorTypes.QuickSlowDown.getValue()));
                        TramGpsInfo Gpsinfo = this.iGpsService.getLastGpsInfo(deviceInfo.getDevicecode(), updateTime);
                        if (Gpsinfo != null)
                            usSafeInfo.setLocation(Gpsinfo.getLongitude().concat(",").concat(Gpsinfo.getLatitude()));
                        this.insertUnsafeData(usSafeInfo);
                    }
                }
            }
        }
    }

    // 超速
    @Override
    public void autoCalcSpeedingTravel(long deviceId, String updateTime) throws Exception {
        String end = DateUtil.addSecond(updateTime,-10);
        TramDeviceInfo Infos = this.iDeviceService.GetDriverInfo(deviceId, null);
        if (Infos.getSpeeduse()!=1)
            return;
        DataAlarmConfigViewModel data = this.iConfigService.GetAllConfigs();
        Double limitSpeed = Double.parseDouble(data.getValue().toString());
        Query query = new Query(Criteria.where("updatetime").gte(end).lte(updateTime).and("deviceid").is(deviceId));
        List<Double> SpeedQuery = new ArrayList<>();
        if (Infos.getSpeeduse() == 2){
            List<TramGpsInfo> Info = mongoTemplate.find(query.with(new Sort(Sort.Direction.DESC,"updatetime")),TramGpsInfo.class);
            for (TramGpsInfo itme:Info){
                SpeedQuery.add(itme.getSpeed());
            }
        }
        else{
            List<TramCanInfo> Info = mongoTemplate.find(query.with(new Sort(Sort.Direction.DESC, "updatetime")),TramCanInfo.class);
            for (TramCanInfo itme : Info){
                SpeedQuery.add(itme.getSpeed()==null?null:Double.parseDouble(itme.getSpeed()));
            }
        }
        List<Double> NullSpeed = SpeedQuery.stream().filter(x -> x!=null).collect(Collectors.toList());
        List<Double> Speed = NullSpeed.stream().filter(x -> x>=limitSpeed).collect(Collectors.toList());
        int count = SpeedQuery.size();
        int count1 = NullSpeed.size();
        int count2 = Speed.size();
        if (count == count1 && count1 == count2 && count!=0){
            TramUnsafeBehaviorInfo usSafeInfo = new TramUnsafeBehaviorInfo();
            TramDeviceInfo deviceInfo = this.iDeviceService.GetDriverInfo(deviceId, null);
            if (deviceInfo != null) {
                usSafeInfo.setDeviceid(deviceInfo.getId());
                usSafeInfo.setDevicecode(deviceInfo.getDevicecode());
                usSafeInfo.setApplytime(new Timestamp(DateUtil.StringToDate(end).getTime()));
                usSafeInfo.setCreatetime(DateUtil.getCurrentTimes());
                usSafeInfo.setSpeed(SpeedQuery.get(0));
                usSafeInfo.setUnsafetime(new  Long(10));
                usSafeInfo.setUnsafetype(new Long(UnSafeBehaviorTypes.SpeedingTravel.getValue()));
                TramGpsInfo Gpsinfo = this.iGpsService.getLastGpsInfo(deviceInfo.getDevicecode(), end);
                if (Gpsinfo != null)
                    usSafeInfo.setLocation(Gpsinfo.getLongitude().concat(",").concat(Gpsinfo.getLatitude()));
                this.insertUnsafeData(usSafeInfo);
            }
        }
    }

    // 起步急加速
    @Override
    public void autoCalcStartTravelSpeeding(long deviceId, String updateTime){
        String end = DateUtil.addSecond(updateTime,-1);
        Query query = new Query(Criteria.where("updatetime").is(end).and("deviceid").is(deviceId));
        Query query1 = new Query(Criteria.where("updatetime").is(updateTime).and("deviceid").is(deviceId));
        TramCanInfo prev = mongoTemplate.findOne(query.with(new Sort(Sort.Direction.DESC,"updatetime")),TramCanInfo.class);
        TramCanInfo next = mongoTemplate.findOne(query1.with(new Sort(Sort.Direction.DESC,"updatetime")),TramCanInfo.class);
        if (next!= null && prev!= null){
            Double SpeedPrev = Double.parseDouble(prev.getSpeed());
            Double SpeedNext = Double.parseDouble(next.getSpeed());
            if (SpeedPrev==0 && SpeedNext >= 0){
                if (SpeedNext - SpeedPrev >=7){
                    TramUnsafeBehaviorInfo usSafeInfo = new TramUnsafeBehaviorInfo();
                    TramDeviceInfo deviceInfo = this.iDeviceService.GetDriverInfo(deviceId, null);
                    if (deviceInfo != null) {
                        usSafeInfo.setDeviceid(deviceInfo.getId());
                        usSafeInfo.setDevicecode(deviceInfo.getDevicecode());
                        usSafeInfo.setApplytime(new Timestamp(DateUtil.StringToDate(updateTime).getTime()));
                        usSafeInfo.setCreatetime(DateUtil.getCurrentTimes());
                        usSafeInfo.setSpeed(SpeedNext);
                        usSafeInfo.setUnsafetime(new  Long(1));
                        usSafeInfo.setUnsafetype(new Long(UnSafeBehaviorTypes.StartTravelSpeeding.getValue()));
                        TramGpsInfo Gpsinfo = this.iGpsService.getLastGpsInfo(deviceInfo.getDevicecode(), updateTime);
                        if (Gpsinfo != null)
                            usSafeInfo.setLocation(Gpsinfo.getLongitude().concat(",").concat(Gpsinfo.getLatitude()));
                        this.insertUnsafeData(usSafeInfo);
                    }
                }
            }
        }
    }

    //夜间行驶
    @Override
    public void autoCalcTravelAtNight(long deviceId, String updateTime){
        if (DateUtil.getHour(updateTime)>=23 || DateUtil.getHour(updateTime)<=7){
            TramUnsafeBehaviorInfo usSafeInfo = new TramUnsafeBehaviorInfo();
            TramDeviceInfo deviceInfo = this.iDeviceService.GetDriverInfo(deviceId, null);
            if (deviceInfo != null) {
                usSafeInfo.setDeviceid(deviceInfo.getId());
                usSafeInfo.setDevicecode(deviceInfo.getDevicecode());
                usSafeInfo.setApplytime(new Timestamp(DateUtil.StringToDate(updateTime).getTime()));
                usSafeInfo.setCreatetime(DateUtil.getCurrentTimes());
                usSafeInfo.setUnsafetime(new  Long(1));
                usSafeInfo.setUnsafetype(new Long(UnSafeBehaviorTypes.TravelAtNight.getValue()));
                this.insertUnsafeData(usSafeInfo);
            }
        }
    }

    @Override
    public void insertUnsafeData(TramUnsafeBehaviorInfo behaviorInfo) {
        this.canMapper.insertUnsafeInfo(behaviorInfo);
    }

    @Override
    public void insertUnSafeData(long deviceId, String updateTime, int unsafeType) {
        TramDeviceInfo deviceInfo = this.deviceMapper.getDeviceInfoById(deviceId);
        TramGpsInfo gpsInfo = this.iGpsService.getLastGpsInfo(deviceInfo.getDevicecode(),updateTime);
        TramCanInfo canInfo = this.getLastCanInfo(deviceInfo.getDevicecode(),updateTime);
        TramUnsafeBehaviorInfo behaviorInfo = new TramUnsafeBehaviorInfo();
        behaviorInfo.setApplytime(Timestamp.valueOf(updateTime));
        behaviorInfo.setCreatetime(Timestamp.valueOf(DateUtil.getCurrentTime()));
        behaviorInfo.setDevicecode(deviceInfo.getDevicecode());
        behaviorInfo.setDeviceid(deviceId);
        behaviorInfo.setLocation(gpsInfo==null?"":gpsInfo.getLongitude()+","+gpsInfo.getLatitude());
        behaviorInfo.setRatespeed(canInfo==null?0:Long.valueOf(canInfo.getRotationalspeed()));
        behaviorInfo.setSpeed(canInfo==null?(gpsInfo==null?0:gpsInfo.getSpeed()):Double.valueOf(canInfo.getSpeed()));
        behaviorInfo.setUnsafetype((long)unsafeType);
        this.insertUnsafeData(behaviorInfo);
    }

    @Override
    public CanHistoryViewModel getCanHistorys(int dayType, long lineId) {
        CanHistoryViewModel viewModel = new CanHistoryViewModel();
        DayTypes dayTypes = new DayTypes().getDayByType(dayType);
        double totalMileage=0D,gasTotal=0D,gaslineTotal=0D,elecTotal=0D,longTime=0D;
        int f1 =0,f2 =0,f3=0,SpeedingTotal=0;
        List<CanHistoryEveryDayInfo> list = this.canMapper.getCanHistoryDayInfo(lineId,dayTypes.getStartTime(),dayTypes.getEndTime());
        for (CanHistoryEveryDayInfo c:list) {
            totalMileage+=c.getTotalmileage();
            gasTotal+=c.getGasavg();
            gaslineTotal+=c.getGasonlieavg();
            elecTotal+=c.getElectricavg();
            longTime+=c.getRuntimelong();
            SpeedingTotal+=c.getSpeedingtotal();
            f1+=c.getFaultonelv();
            f2+=c.getFaultsecondlv();
            f3+=c.getFaultthreelv();
        }
        viewModel.setLineId(lineId);
        viewModel.setElecEconomy(elecTotal);
        viewModel.setGasEconomy(gasTotal);
        viewModel.setTotalMileage(totalMileage);
        viewModel.setFuelEconomy(gaslineTotal);
        viewModel.setCarBusLongTime(longTime);
        viewModel.setSpeeding(SpeedingTotal);
        viewModel.setF1(f1);
        viewModel.setF2(f2);
        viewModel.setF3(f3);
        int day = 0;
        try {
            if(dayType<=4) {
                day = DateUtil.daysBetween(dayTypes.getStartTime(), dayTypes.getEndTime(),DateStyle.YYYY_MM_DD);
            }else{
                day = DateUtil.monthsBetween(dayTypes.getStartTime(),dayTypes.getEndTime())+1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> xalis = new ArrayList<>();
        List<List<Integer>> list1 = new ArrayList<>();
        List<String> faultXalias = new ArrayList<>();
        int p=0;
        for (TramBasicInfo b:this.basicMapper.getAlarmTypes(1)) {
            faultXalias.add(b.getAlarmName());
            List<Integer> list1s = new ArrayList<>();
            for(int i=0;i<day;i++){
                String start = DateUtil.addDay(dayTypes.getStartTime(),i),
                        end = DateUtil.addDay(start,1);
                if(dayType==5||dayType==6){
                    start = DateUtil.addMonth(dayTypes.getStartTime(),i);
                    end = DateUtil.addMonth(start,1);
                    if(p==0) {
                        xalis.add(dayType==6?DateUtil.StringToString(start,DateStyle.YYYY)+"年 "+start.split("-")[1] + "月":start.split("-")[1] + "月");
                    }
                }else{
                    if(p==0) {
                        xalis.add(start.split("-")[1]+"月"+start.split("-")[2] + "日");
                    }
                }
                int count = this.canMapper.getAlarmTrendsCountByLineId(lineId,start,end,b.getId().intValue());
                list1s.add(count);
            }
            p++;
            list1.add(list1s);
        }
        viewModel.setXlias(xalis);
        viewModel.setFaultXalias(faultXalias);
        viewModel.setFaults(list1);
        List<List<Integer>> list2 = new ArrayList<>();
        List<String> unsafeXalias = new ArrayList<>();
        for (TramBasicInfo b:this.basicMapper.getAlarmTypes(78)) {
            unsafeXalias.add(b.getAlarmName());
            List<Integer> list2s = new ArrayList<>();
            for(int i=0;i<day;i++){
                String start = DateUtil.addDay(dayTypes.getStartTime(),i),
                        end = DateUtil.addDay(start,1);
                if(dayType==5||dayType==6){
                    start = DateUtil.addMonth(dayTypes.getStartTime(),i);
                    end = DateUtil.addMonth(start,1);
                }
                int count = this.canMapper.getAlarmTrendsCountByLineId(lineId,start,end,b.getId().intValue());
                list2s.add(count);
            }
            list2.add(list2s);
        }
        viewModel.setUnsafeXalias(unsafeXalias);
        viewModel.setUnsafes(list2);
        return viewModel;
    }

    @Override
    public CanHistoryViewModel getCanHistoryBus(String code,int dayType){
        CanHistoryViewModel viewModel = new CanHistoryViewModel();
        long deviceId = this.alarmMapper.GetDeviceId(code);
        DayTypes dayTypes = new DayTypes().getDayByType(dayType);
        double totalMileage=0D,gasTotal=0D,gaslineTotal=0D,elecTotal=0D,longTime=0D;
        int f1 =0,f2 =0,f3=0,SpeedingTotal=0;
        List<CanHistoryEveryDayInfo> list = this.canMapper.getCanHistoryBus(deviceId,dayTypes.getStartTime(),dayTypes.getEndTime());
        for (CanHistoryEveryDayInfo c:list) {
            totalMileage+=c.getTotalmileage();
            gasTotal+=c.getGasavg();
            gaslineTotal+=c.getGasonlieavg();
            elecTotal+=c.getElectricavg();
            longTime+=c.getRuntimelong();
            SpeedingTotal+=c.getSpeedingtotal();
            f1+=c.getFaultonelv();
            f2+=c.getFaultsecondlv();
            f3+=c.getFaultthreelv();
        }
        viewModel.setTotalNumber(1);
        viewModel.setOperaterNumber(1);
        viewModel.setElecEconomy(elecTotal);
        viewModel.setGasEconomy(gasTotal);
        viewModel.setTotalMileage(totalMileage);
        viewModel.setFuelEconomy(gaslineTotal);
        viewModel.setCarBusLongTime(longTime);
        viewModel.setSpeeding(SpeedingTotal);
        viewModel.setF1(f1);
        viewModel.setF2(f2);
        viewModel.setF3(f3);
        int day = 0;
        try {
            if(dayType<=4) {
                day = DateUtil.daysBetween(dayTypes.getStartTime(), dayTypes.getEndTime(),DateStyle.YYYY_MM_DD);
            }else{
                day = DateUtil.monthsBetween(dayTypes.getStartTime(),dayTypes.getEndTime())+1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> xalis = new ArrayList<>();
        List<List<Integer>> list1 = new ArrayList<>();
        List<String> faultXalias = new ArrayList<>();
        int p=0;
        for (TramBasicInfo b:this.basicMapper.getAlarmTypes(1)) {
            faultXalias.add(b.getAlarmName());
            List<Integer> list1s = new ArrayList<>();
            for(int i=0;i<day;i++){
                String start = DateUtil.addDay(dayTypes.getStartTime(),i),
                        end = DateUtil.addDay(start,1);
                if(dayType==5||dayType==6){
                    start = DateUtil.addMonth(dayTypes.getStartTime(),i);
                    end = DateUtil.addMonth(start,1);
                    if(p==0) {
                        xalis.add(dayType==6?DateUtil.StringToString(start,DateStyle.YYYY)+"年 "+start.split("-")[1] + "月":start.split("-")[1] + "月");
                    }
                }else{
                    if(p==0) {
                        xalis.add(start.split("-")[1]+"月"+start.split("-")[2] + "日");
                    }
                }
                int count = this.canMapper.getAlarmTrendsCountBydevice(deviceId,start,end,b.getId().intValue());
                list1s.add(count);
            }
            p++;
            list1.add(list1s);
        }
        viewModel.setXlias(xalis);
        viewModel.setFaultXalias(faultXalias);
        viewModel.setFaults(list1);
        List<List<Integer>> list2 = new ArrayList<>();
        List<String> unsafeXalias = new ArrayList<>();
        for (TramBasicInfo b:this.basicMapper.getAlarmTypes(78)) {
            unsafeXalias.add(b.getAlarmName());
            List<Integer> list2s = new ArrayList<>();
            for(int i=0;i<day;i++){
                String start = DateUtil.addDay(dayTypes.getStartTime(),i),
                        end = DateUtil.addDay(start,1);
                if(dayType==5||dayType==6){
                    start = DateUtil.addMonth(dayTypes.getStartTime(),i);
                    end = DateUtil.addMonth(start,1);
                }
                int count = this.canMapper.getAlarmTrendsCountBydevice(deviceId,start,end,b.getId().intValue());
                list2s.add(count);
            }
            list2.add(list2s);
        }
        viewModel.setUnsafeXalias(unsafeXalias);
        viewModel.setUnsafes(list2);
        return viewModel;
    }

    @Override
    public List<List<Integer>> getAlarmTrends(int dayType, long lineId, List<Integer> types) {
        return null;
    }

    @Override
    public List<List<Integer>> getSignleAlarmTrends(int dayType, long deviceId, List<Integer> types) {
        return null;
    }



    private int getCanStat(List<TramCanActinfo> acts,int key){
        int r = 1;
        if(acts!=null) {
            for (TramCanActinfo a : acts) {
                if (a.getCustomId() == key) {
                    double d = Double.parseDouble(a.getValue());
                    r = (int) d;
                }
            }
        }
        return r;
    }
    @Override
    public boolean IsBarke(String deviceCode) {
        TramCanInfo canInfo = this.getLastCanInfo(deviceCode);
        boolean fag = false;
        for(TramCanActinfo c:canInfo.getActs()){
            if(c.getCustomId() == 42){
                fag = c.getValue() == "2";
                break;
            }
        }
        return fag;
    }

    @Override
    public boolean IsPark(String deviceCode) {
        TramCanInfo canInfo = this.getLastCanInfo(deviceCode);
        boolean fag = false;
        if(canInfo.getActs()!=null) {
            for (TramCanActinfo c : canInfo.getActs()) {
                if (c.getCustomId() == 43) {
                    fag = c.getValue() == "2";
                    break;
                }
            }
        }
        return fag;
    }

    @Override
    public TramCanInfo GetCanInfoByLastTime(String code, int year, int month, int day, int hour, int minute, int second)
    {
        StringBuffer time=new StringBuffer();
        int []time1={year,month,day,hour,minute,second};
        for (int i=0;i<6;i++)
        {
            time.append(String.valueOf(time1[i]));
            if (i<2)
                time.append("-");
            if (i==2)
                time.append(" ");
            if(3<=i&&i<5)
                time.append(":");
        }
        return this.canMapper.GetCanInfoByLastTime(Long.valueOf(code),time.toString());
    }

    @Override
    public int GetCanInfoBy10sTime(String code, String date, int second)
    {
        String starttime=DateUtil.addSecond(date,-second);
        return this.canMapper.GetCanInfoBy10sTime(code,starttime,date);
    }

    @Override
    public void CalcDeviceCanHistorys(){
        int[] behaviors = new int[]{ 99, 100, 101, 102, 103, 104, 105, 106, 107, 108 };
       // String start = DateUtil.addDay(DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD_00_00_00),-1);
        String start = "2018-04-11 00:00:00";
        //String end = DateUtil.addDay(DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD_23_59_59),-1);
        String end = "2018-04-11 23:59:59";
        List<TramDeviceInfo> list = this.deviceMapper.getTramDeviceCodeId();
        for (TramDeviceInfo item : list){
            try{
                CanHistoryEveryDayInfo model = new CanHistoryEveryDayInfo();
                model.setDeviceid(item.getId());
                model.setUpdatetime(start);
                model.setTotalcarfaultnumber((long)1);
                Query query = new  Query();
                Query query1 = new  Query();
                TramCanInfo Info1 = mongoTemplate.findOne(query.addCriteria(Criteria.where("deviceid").is(item.getId())).addCriteria(Criteria.where("updatetime").gte(start)).with(new Sort(new Sort.Order(Sort.Direction.ASC,"updatetime"))).limit(1),TramCanInfo.class);
                String FirstMilage = null;
                String LastMilage = null;
                if (Info1!=null){
                    FirstMilage = Info1.getShortmileage();
                }
                TramCanInfo Info2 = mongoTemplate.findOne(query1.addCriteria(Criteria.where("deviceid").is(item.getId())).addCriteria(Criteria.where("updatetime").lte(end)).with(new Sort(new Sort.Order(Sort.Direction.DESC,"updatetime"))).limit(1),TramCanInfo.class);
                if (Info2!=null){
                    LastMilage = Info2.getShortmileage();
                }
                //里程
                if (!StringHelper.isNotEmpty(FirstMilage) && !StringHelper.isNotEmpty(LastMilage)){
                    model.setTotalmileage(Math.abs(Double.parseDouble(LastMilage==null?String.valueOf(0):LastMilage) - Double.parseDouble(FirstMilage==null?String.valueOf(0):FirstMilage)));
                }
                else
                    model.setTotalmileage(0.0);
                //油耗
                model.setGasonlieavg(0.0);
                //电耗
                model.setElectricavg(0.0);
                //气耗
                model.setGasavg(0.0);
                //故障次数报警数
                model.setTotalfaultnumber((this.canMapper.GetTop1CanInfo("faultSql",item.getId(),start,end)));
                model.setFaultthreelv(this.canMapper.GetTop1CanInfo("faultSql2",item.getId(),start,end,2));
                model.setFaultsecondlv(this.canMapper.GetTop1CanInfo("faultSql2",item.getId(),start,end,1));
                model.setFaultonelv(this.canMapper.GetTop1CanInfo("faultSql2",item.getId(),start,end,0));
                model.setUnsafenumber(this.canMapper.GetTop1CanInfo("unsafeSql",item.getId(),start,end));
                model.setUnsafedriver(this.canMapper.GetTop1CanInfo("undriversql",item.getId(),start,end,behaviors));
                Double ss = this.canMapper.GetTop1CanInfo("timelongsql",item.getDevicecode(),start,end);
                model.setRuntimelong(StringHelper.isEmpty(ss)? 0 : ss);
                model.setSpeedingtotal(new Long(this.canMapper.GetTop1CanInfo("speedingSQL",item.getId(),start,end)));
                Long c = this.canMapper.GetTop1CanInfo("isexitsql",item.getId(),start,end);
                if (c == 0){
                    this.canMapper.GetTop1CanInfo("sql",model);
                }
            }
            catch(Exception ex){
                continue;
            }
        }
    }
}
