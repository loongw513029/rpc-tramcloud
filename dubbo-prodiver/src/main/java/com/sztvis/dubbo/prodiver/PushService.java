package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.domain.dto.push.PushModel;
import com.sztvis.dubbo.IPushService;

import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/7/3 上午11:48
 */
@Service(version = "1.0.0")
public class PushService implements IPushService {
    @Override
    public void sendMsg(PushModel msg) {

    }

    @Override
    public void sendToUsers(List<String> users, PushModel msg) {

    }

    @Override
    public void SendToMsgByDeviceCode(String deviceCode, PushModel msg) {

    }
}
