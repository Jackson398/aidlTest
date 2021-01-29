package com.aite.smart.gatewaylib.api

import java.lang.reflect.Type

interface IApi {
    fun getProtocol():String

    @RequestType
    fun getRequestType():String

    fun getResultEvent():Type

    @ProtocolType
    fun getProtocolType():String

    @ParamType
    fun getParamType():Int
}