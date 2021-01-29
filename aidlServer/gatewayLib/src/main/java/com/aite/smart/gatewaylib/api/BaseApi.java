package com.aite.smart.gatewaylib.api;

import androidx.annotation.NonNull;

import java.lang.reflect.Type;

public class BaseApi implements IApi {
    //结果事件，转成成实体类
    protected Type resultEvent;

    //参数类型
    @ParamType
    protected int paramType;

    //协议类型
    @ProtocolType
    protected String protocolType;

    //请求类型
    @RequestType
    protected String requestType;

    //协议
    protected String protocol;


    @NonNull
    @Override
    public String getProtocol() {
        return protocol;
    }

    @Override
    public String getRequestType() {
        return requestType;
    }


    @Override
    public Type getResultEvent() {
        return resultEvent;
    }

    @ProtocolType
    @Override
    public String getProtocolType() {
        return protocolType;
    }

    @Override
    public int getParamType() {
        return paramType;
    }
}
