package com.sztvis.common.entity;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/17 下午1:59
 */
public enum StatusCodeEnum {
    Success("200"),Error("500"),CustomeError("508"),Unauthorized("401"),ParameterError("400"),TokenInvaild("403"),
    HttpMethodError("405"),HttpRequestError("406"),URLExpireError("407"),DataNotFound("404");

    private StatusCodeEnum(String status){
        this.value = status;
    }

    public String getValue() {
        return value;
    }

    private String value;

}
