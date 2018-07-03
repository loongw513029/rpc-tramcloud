package com.sztvis.dubbo;


import com.sztvis.domain.dto.push.PushModel;

import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/29 上午9:55
 */
public interface IPushService {

    void sendMsg(PushModel msg);

    /**
     * 一对一发送
     * @param users 用户UUID集合
     * @param msg 发送内容
     */
    void sendToUsers(List<String> users, PushModel msg);

    /**
     * 根据设备编码查询用户从而推送信息
     * @param deviceCode
     * @param msg
     */
    void SendToMsgByDeviceCode(String deviceCode, PushModel msg);
}
