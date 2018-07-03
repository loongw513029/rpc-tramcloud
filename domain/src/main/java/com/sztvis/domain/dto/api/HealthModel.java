package com.sztvis.domain.dto.api;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/11 下午6:36
 */
public class HealthModel implements Serializable {
    private String Code;
    private String EndPointIp;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getEndPointIp() {
        return EndPointIp;
    }

    public void setEndPointIp(String endPointIp) {
        EndPointIp = endPointIp;
    }

    public String getServerIp() {
        return ServerIp;
    }

    public void setServerIp(String serverIp) {
        ServerIp = serverIp;
    }

    private String ServerIp;

}
