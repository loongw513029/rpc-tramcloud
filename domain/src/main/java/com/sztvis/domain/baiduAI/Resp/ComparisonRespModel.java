package com.sztvis.domain.baiduAI.Resp;

import java.io.Serializable;
import java.util.List;

public class ComparisonRespModel implements Serializable {

    private long log_id;
    private int result_num;
    private Object ext_info;
    private List<ComparisonResult> result;

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public int getResult_num() {
        return result_num;
    }

    public void setResult_num(int result_num) {
        this.result_num = result_num;
    }

    public Object getExt_info() {
        return ext_info;
    }

    public void setExt_info(Object ext_info) {
        this.ext_info = ext_info;
    }

    public List<ComparisonResult> getResult() {
        return result;
    }

    public void setResult(List<ComparisonResult> result) {
        this.result = result;
    }
}

