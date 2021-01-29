package com.aite.smart.gatewaylib.api

import androidx.annotation.IntDef

/**
 * 参数类型
 */
@IntDef(ParamType.none, ParamType.json, ParamType.xml)
annotation class ParamType {
    companion object {
        const val none = 1
        const val json = 2
        const val xml = 3
    }
}