package com.sztvis.domain.dto.nvrsetting;

import java.io.Serializable;

public class ForwordModel implements Serializable {
    private int type;
    private String source;
    private String target;
    private NvrResultResponse msgInfo;
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

    public NvrResultResponse getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(NvrResultResponse msgInfo) {
        this.msgInfo = msgInfo;
    }

    public ForwordModel(int type, String source, String target, NvrResultResponse msgInfo) {
        this.type = type;
        this.source = source;
        this.target = target;
        this.msgInfo = msgInfo;
    }
}
