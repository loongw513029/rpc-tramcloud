package com.sztvis.dubbo;


import com.sztvis.domain.amap.GeoStatusResult;
import com.sztvis.domain.amap.GeofenceFrom;
import com.sztvis.domain.amap.GeofenceResult;
import com.sztvis.domain.domain.TramElectronicFenceInfo;

import java.util.List;

public interface IElecFenceService {

    List<TramElectronicFenceInfo> getElecFenceList();

    TramElectronicFenceInfo getElecFenceInfo(long id);

    void insertElecFanceInfo(TramElectronicFenceInfo info);

    GeofenceResult saveGeoFence(GeofenceFrom geofenceFrom);

    GeofenceResult updateGeoFence(GeofenceFrom geofenceFrom, String gid);

    GeoStatusResult StartMonitor(String key, String diu, String locations);
}
