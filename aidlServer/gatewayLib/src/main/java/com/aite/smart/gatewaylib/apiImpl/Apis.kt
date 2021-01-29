package com.aite.smart.gatewaylib.apiImpl

import com.aite.smart.gatewaylib.api.GatewayApi
import com.aite.smart.gatewaylib.data.Response

object Apis {
    val bind = GatewayApi.putJson("/AITE/SMART/gateway/bind", Response::class.java)
}