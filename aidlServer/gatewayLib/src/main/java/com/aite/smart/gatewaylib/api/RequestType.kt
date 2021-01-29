package com.aite.smart.gatewaylib.api

import androidx.annotation.StringDef

/**
 * 请求类型
 */
@StringDef(RequestType.Get, RequestType.Post, RequestType.Put, RequestType.Delete)
annotation class RequestType {
    companion object {
        const val Get = "GET"
        const val Post = "POST"
        const val Put = "PUT"
        const val Delete = "DELETE"
    }
}