package com.sztvis.domain;

import java.io.Serializable;

public class BaseModel  implements Serializable {
    /// <summary>
    /// 0：请求接入 1：设定GPS频率 2：下发设置视频设置
    /// </summary>
    public int type;
    /// <summary>

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Object getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(Object msgInfo) {
        this.msgInfo = msgInfo;
    }

    /// 来源客户端
    /// </summary>
    public String source;
    /// <summary>
    /// 目标code
    /// </summary>
    public String target;
    public Object msgInfo;
}
