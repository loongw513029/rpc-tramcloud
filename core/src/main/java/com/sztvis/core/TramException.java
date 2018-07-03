package com.sztvis.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author longweiqian
 * @company tvis
 * @date 2017/12/28 下午5:06
 */
public class TramException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(TramException.class);
    private static final long serialVersionUID = 1L;


    private String errorCode;
    private boolean propertiesKey = true;

    public TramException(String message){
        super(message);
    }

    public TramException(String errorCode,String message,boolean propertiesKey){
        super(message);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }

    public TramException(String errorCode,String message,Throwable cause,boolean propertiesKey){
        super(message);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }

    public TramException(String message,Throwable cause){
        super(message,cause);
    }


    public TramException(String errorCode,String message){
        this(errorCode,message,true);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isPropertiesKey() {
        return propertiesKey;
    }

    public void setPropertiesKey(boolean propertiesKey) {
        this.propertiesKey = propertiesKey;
    }
}
