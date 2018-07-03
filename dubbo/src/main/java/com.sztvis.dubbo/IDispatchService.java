package com.sztvis.dubbo;


import com.sztvis.domain.domain.TramDispatchInfo;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/25 上午9:15
 */
public interface IDispatchService {
    /**
     * 保存调度信息，MongoDB
     * @param dispatchInfo
     */
    void insertDispatchInfo(TramDispatchInfo dispatchInfo);

    /**
     * 获得设备最后一条调度信息
     * @param deviceId
     * @return
     */
    TramDispatchInfo getLastDispatchInfo(long deviceId);
}
