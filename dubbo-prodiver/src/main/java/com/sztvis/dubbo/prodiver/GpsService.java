package com.sztvis.dubbo.prodiver;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.common.entity.DeviceStateFiled;
import com.sztvis.core.DateUtil;
import com.sztvis.domain.domain.TramCanInfo;
import com.sztvis.domain.domain.TramDeviceStateInspectRealtimeInfo;
import com.sztvis.domain.domain.TramDispatchInfo;
import com.sztvis.domain.domain.TramGpsInfo;
import com.sztvis.domain.dto.BusAndDeviceViewModel;
import com.sztvis.domain.dto.GpsViewModel;
import com.sztvis.domain.dto.MapHistoryLocationModel;
import com.sztvis.domain.entity.PageBean;
import com.sztvis.domain.entity.SpringDataPageable;
import com.sztvis.dubbo.ICanService;
import com.sztvis.dubbo.IDeviceService;
import com.sztvis.dubbo.IGpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import util.GPSUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/12 上午9:10
 */
@Service(version = "1.0.0")
public class GpsService implements IGpsService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Reference(version = "1.0.0")
    private IDeviceService iDeviceService;
    @Reference(version = "1.0.0")
    private IGpsService iGpsService;
    @Reference(version = "1.0.0")
    private ICanService iCanService;
    @Override
    public void saveGpsInfo(TramGpsInfo gpsInfo) {
        this.mongoTemplate.save(gpsInfo);
        //保存数据，跟新设备Gps状态
        this.iDeviceService.UpdateRealTimeInspect(gpsInfo.getDevicecode(), DeviceStateFiled.GpsState,true,3);
    }

    @Override
    public TramGpsInfo getLastGpsInfo(String deviceCode,String UpdateTime) {
        Query query1=new Query();
        query1.addCriteria(new Criteria("devicecode").is(deviceCode));
        query1.addCriteria(new Criteria("updatetime").lte(UpdateTime));//<=
        query1.with(new Sort(new Sort.Order(Sort.Direction.DESC,"updatetime")));
        TramGpsInfo gpsInfo = this.mongoTemplate.findOne(query1,TramGpsInfo.class);
        return gpsInfo;
    }

    @Override
    public TramGpsInfo getLastGpsInfo(String deviceCode) {
        Query query1=new Query();
        query1.addCriteria(new Criteria("devicecode").is(deviceCode));
        query1.with(new Sort(new Sort.Order(Sort.Direction.DESC,"updatetime")));
        TramGpsInfo gpsInfo = this.mongoTemplate.findOne(query1,TramGpsInfo.class);
        return gpsInfo;
    }

    @Override
    public TramGpsInfo getLastGpsInfo(long deviceId) {
        Query query1=new Query();
        query1.addCriteria(new Criteria("deviceid").is(deviceId));
        query1.with(new Sort(new Sort.Order(Sort.Direction.DESC,"updatetime")));
        TramGpsInfo gpsInfo = this.mongoTemplate.findOne(query1,TramGpsInfo.class);
        return gpsInfo;
    }

    @Override
    public GpsViewModel getAppGpsViewModel(long deviceid, String starttime) {
        TramGpsInfo gpsInfo = this.iGpsService.getLastGpsInfo(deviceid);
        BusAndDeviceViewModel deviceInfo = this.iDeviceService.getDeviceViewModel(deviceid);
        TramCanInfo canInfo = this.iCanService.getLastCanInfo(deviceInfo.getDevicecode());
        TramDeviceStateInspectRealtimeInfo real = this.iDeviceService.getDeviceStateInspectRealTimeInfo(deviceid);
        GpsViewModel model = new GpsViewModel();
        model.setDeviceId(deviceid);
        model.setCode(gpsInfo.getDevicecode());
        model.setUpdateTime(gpsInfo.getUpdatetime());
        model.setGpsOnLine(real.isGpsstate());
        model.setSpeed(canInfo==null?gpsInfo==null?"0":Math.floor(gpsInfo.getSpeed())+"":(canInfo.getSpeed()==null?Math.floor(gpsInfo.getSpeed())+"":canInfo.getSpeed()));
        model.setClientIp(deviceInfo.getClientip());
        model.setOnline(real.isOnlineState());
        model.setChannel(deviceInfo.getVideochannel());
        model.setDeviceNumber(deviceInfo.getBusnumber());
        model.setLocation(gpsInfo==null?"":(gpsInfo.getLongitude()+","+gpsInfo.getLatitude()));
        int state = this.getDeviceCurrentGpsState(deviceid,starttime,real.isGpsstate(),real.isOnlineState(),deviceInfo.getDevicecode());
        model.setState(state);
        model.setRotate(gpsInfo==null?0:gpsInfo.getDirection());
        model.setUpTime(gpsInfo.getUpdatetime());
        TramDispatchInfo dispatchInfo = this.iDeviceService.getLastDispatchInfo(deviceid);
        model.setDispatch(dispatchInfo==null?"":dispatchInfo.getDispatchname());
        return model;
    }

    @Override
    public long getGpsCount(long deviceid, String starttime, String endtime) {
        Query query1=new Query();
        query1.addCriteria(new Criteria("deviceid").is(deviceid));
        query1.addCriteria(new Criteria().andOperator(Criteria.where("updatetime").lte(endtime),
                Criteria.where("updatetime").lte(starttime)));
        return this.mongoTemplate.count(query1,TramGpsInfo.class);
    }

    @Override
    public int getDeviceCurrentGpsState(long deviceid, String starttime, boolean gpsState,boolean onLineState,String deviceCode) {
        TramDeviceStateInspectRealtimeInfo realtimeInfo = this.iDeviceService.getDeviceStateInspectRealTimeInfo(deviceid);
        boolean isPark = this.iCanService.IsPark(deviceCode);
        if(!onLineState)
            return 7;
        if(gpsState){
            if(!isPark){
                if(realtimeInfo.isGpsstate())
                    return 1;
                else
                    return 3;
            }else{
                if(realtimeInfo.isGpsstate())
                    return 2;
                else
                    return 4;
            }
        }else{
            if(realtimeInfo.isGpsstate())
                return 5;
            else
                return 6;
        }
    }

    @Override
    public PageBean<MapHistoryLocationModel> getMapHistoryGpsList(long deviceId, String startTime, String endTime, int page, int rows) {
        SpringDataPageable pageable = new SpringDataPageable();
        Query query = new Query();
        query.addCriteria(new Criteria("deviceid").is(deviceId));
        query.addCriteria(new Criteria().andOperator(Criteria.where("updatetime").lte(endTime),
                Criteria.where("updatetime").gte(startTime)));
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"updatetime"));
        pageable.setPagenumber(page);
        pageable.setPagesize(rows);
        pageable.setSort(sort);
        Long count = mongoTemplate.count(query, TramGpsInfo.class);
        List<TramGpsInfo> list = mongoTemplate.find(query.with(pageable), TramGpsInfo.class);
        Page<TramGpsInfo> pagelist = new PageImpl<TramGpsInfo>(list, pageable, count);
        PageBean<MapHistoryLocationModel> pageBean = new PageBean<>(page, rows, count.intValue());
        List<MapHistoryLocationModel> list2 = new ArrayList<>();
        for (TramGpsInfo gps:pagelist.getContent()) {
            MapHistoryLocationModel model = new MapHistoryLocationModel();
            model.setLatitude(gps.getLatitude());
            model.setLongitude(gps.getLongitude());
            model.setUpdateTime(gps.getUpdatetime());
            model.setSpeed(gps.getSpeed());
            list2.add(model);
        }
        pageBean.setItems(list2);
        return pageBean;
    }

    @Override
    public List<String> getLocations(long deviceId, String startTime, String endTime) {
        Query query = new Query();
        query.addCriteria(new Criteria("deviceid").is(deviceId));
        query.addCriteria(new Criteria().andOperator(Criteria.where("updatetime").lte(endTime),
                Criteria.where("updatetime").gte(startTime)));
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"updatetime"));
        query.with(sort);
        List<TramGpsInfo> list = this.mongoTemplate.find(query,TramGpsInfo.class);
        List<String> list2 = new ArrayList<>();
        for (TramGpsInfo g:list) {
            double[] d = GPSUtil.gps84_To_Gcj02(Double.valueOf(g.getLatitude()),Double.valueOf(g.getLongitude()));
            list2.add(d[1]+","+d[0]);
        }
        return list2;
    }

    @Override
    public long GetCountBy10sGps(long deviceId, String date, int second)
    {
        String starttime= DateUtil.addSecond(date,-second);
        Query query1=new Query();
        query1.addCriteria(Criteria.where("deviceid").is(deviceId));
        query1.addCriteria(Criteria.where("updatetime").lte(date).gte(starttime));
        return this.mongoTemplate.count(query1,TramGpsInfo.class);
    }
}
