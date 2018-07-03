package com.sztvis.domain.dto.push;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/29 上午9:22
 */
public class PushModel {

    /**
     * 推送消息类型， 1:设备状态 2:报警类型 3:地图 4:雷达 5:ADAS状态 6:CAN数据 0：重新登录
     */
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(Object msgInfo) {
        this.msgInfo = msgInfo;
    }

    private Object msgInfo;

    public PushModel(int type, Object msgInfo) {
        this.type = type;
        this.msgInfo = msgInfo;
    }
}
