package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.sztvis.core.DateUtil;
import com.sztvis.core.helper.HttpHelp;
import com.sztvis.domain.amap.GeoStatusResult;
import com.sztvis.domain.amap.GeofenceFrom;
import com.sztvis.domain.amap.GeofenceResult;
import com.sztvis.domain.amap.StartupFrom;
import com.sztvis.domain.domain.TramElectronicFenceInfo;
import com.sztvis.dubbo.IElecFenceService;
import com.sztvis.dubbo.prodiver.mapper.ElecFenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.UUID;

@Service(version = "1.0.0")
public class ElecFenceService implements IElecFenceService {

    @Autowired
    private ElecFenceMapper elecFenceMapper;
    @Value("${amap.webapikey}")
    private String amapWebApi;

    @Override
    public List<TramElectronicFenceInfo> getElecFenceList() {
        return this.elecFenceMapper.getElecFenceList();
    }

    @Override
    public TramElectronicFenceInfo getElecFenceInfo(long id) {
        return this.elecFenceMapper.getElecFenceInfo(id);
    }

    @Override
    public void insertElecFanceInfo(TramElectronicFenceInfo info) {
        this.elecFenceMapper.insertElecFenceInfo(info);
        String condition = "";
        if(info.isInTrun())
            condition = "enter";
        if(info.isOutTrun())
            condition = "leave";
        if(info.isOutTrun()&&info.isInTrun())
            condition = "enter;leave";
        GeofenceFrom from =new GeofenceFrom("围栏"+ UUID.randomUUID().toString().replaceAll("-",""),
                info.getLng()+","+info.getLat(),info.getRadius()+"",null,true, DateUtil.addYear(DateUtil.getCurrentTime(),5),
                "",condition);
        this.saveGeoFence(from);
    }

    @Override
    public GeofenceResult saveGeoFence(GeofenceFrom geofenceFrom) {
        String url = "http://restapi.amap.com/v4/geofence/meta?key="+amapWebApi;
        String jsonStr = JSON.toJSONString(geofenceFrom);
        String str = HttpHelp.sendHttp(url,jsonStr,"POST");
        GeofenceResult result =  JSON.parseObject(str,GeofenceResult.class);
        if(result.getData().getStatus()=="0") {
            String startUrl = String.format("http://restapi.amap.com/v4/geofence/meta?key=%s&gid=%s", amapWebApi, result.getData().getGid());
            StartupFrom startupFrom = new StartupFrom(true);
            HttpHelp.sendHttp(startUrl, JSON.toJSONString(startupFrom), "PATCH");
        }
        return result;
    }

    @Override
    public GeofenceResult updateGeoFence(GeofenceFrom geofenceFrom,String gid) {
        String url = String.format("http://restapi.amap.com/v4/geofence/meta?key=%s&gid=%s",amapWebApi,gid);
        String jsonStr = JSON.toJSONString(geofenceFrom);
        String str = HttpHelp.sendHttp(url,jsonStr,"PATCH");
        GeofenceResult result = JSON.parseObject(str,GeofenceResult.class);
        if(result.getData().getStatus()=="0") {
            String startUrl = String.format("http://restapi.amap.com/v4/geofence/meta?key=%s&gid=%s", amapWebApi, result.getData().getGid());
            StartupFrom startupFrom = new StartupFrom(true);
            HttpHelp.sendHttp(startUrl, JSON.toJSONString(startupFrom), "PATCH");
        }
        return result;
    }

    @Override
    public GeoStatusResult StartMonitor(String key, String diu, String locations) {
        String url = String.format("http://restapi.amap.com/v4/geofence/status?key=%s&diu=%s&locations=%s",amapWebApi,diu,locations);
        String jsonStr = HttpHelp.sendHttpGet(url);
        GeoStatusResult result = JSON.parseObject(jsonStr,GeoStatusResult.class);
        return result;
    }


}
