package com.seit.silaba.utilities;

import java.io.Serializable;

/**
 * Created by andy410 on 08/01/2016.
 */
public class SilabaError implements Serializable
{
    String code;
    String message;
    String DevMessage;

    public SilabaError(){}
    
    public SilabaError(String message,String code,String DevMessage)
    {
    	this.code=code;
    	this.message=message;
    	this.DevMessage=DevMessage;
    }
    
    
    public SilabaError(String message,String code)
    {
    	this.code=code;
    	this.message=message;
    }

    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDevMessage() {
        return DevMessage;
    }

    public void setDevMessage(String devMessage) {
        DevMessage = devMessage;
    }
}
