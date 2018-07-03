package com.sztvis.dubbo.prodiver;


import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.core.DateStyle;
import com.sztvis.core.DateUtil;
import com.sztvis.domain.domain.TramPassengerFlow;
import com.sztvis.dubbo.IPassengerFlowService;
import com.sztvis.dubbo.prodiver.mapper.PassengerFlowMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/3/29 上午11:20
 */
@Service(version = "1.0.0")
public class PassengerFlowService implements IPassengerFlowService {
    @Autowired
    private PassengerFlowMapper passengerFlowMapper;

    @Override
    public void insertPassengerFlow(TramPassengerFlow passengerFlow) {
        this.passengerFlowMapper.insertPassengerFlow(passengerFlow);
    }

    @Override
    public List<TramPassengerFlow> Getinfo(String code){
        String time = DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD_23_59_59);
        List<TramPassengerFlow> list = new ArrayList<>();
        for (int i = 0;i < 3;i++){
            list.add(this.passengerFlowMapper.Getinfo(code,DateUtil.addDay(time,-i)));
        }
        return list;
    }
}
