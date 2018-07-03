package com.sztvis.domain.dto;


import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/11 下午5:04
 */
public class HostApiModel  implements Serializable {
    private int Type;
    private Object MsgInfo;

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public Object getMsgInfo() {
        return MsgInfo;
    }

    public void setMsgInfo(Object msgInfo) {
        MsgInfo = msgInfo;
    }
}
