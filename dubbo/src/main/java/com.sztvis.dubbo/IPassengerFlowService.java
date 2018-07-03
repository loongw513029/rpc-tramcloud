package com.sztvis.dubbo;


import com.sztvis.domain.domain.TramPassengerFlow;

import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/3/29 上午11:20
 */
public interface IPassengerFlowService {

    void insertPassengerFlow(TramPassengerFlow passengerFlow);

    List<TramPassengerFlow> Getinfo(String code);

}
