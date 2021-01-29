package com.aite.smart.gatewaylib.api

import androidx.annotation.StringDef

/**
 * 协议类型
 */
@StringDef(ProtocolType.APP_FORM_URLENCODED, ProtocolType.APP_JSON, ProtocolType.APP_XML, ProtocolType.APP_OCTET_STREAM, ProtocolType.MULTIPART_FORM_DATA, ProtocolType.TEXT_HTML, ProtocolType.TEXT_PLAIN, ProtocolType.WILDCARD)
annotation class ProtocolType {
    companion object {
        const val APP_FORM_URLENCODED = "application/x-www-form-urlencoded"
        const val APP_JSON = "application/json"
        const val APP_XML = "application/xml"
        const val APP_OCTET_STREAM = "application/octet-stream"
        const val MULTIPART_FORM_DATA = "multipart/form-data"
        const val TEXT_HTML = "text/html"
        const val TEXT_PLAIN = "text/plain"
        const val WILDCARD = "*/*"
    }
}