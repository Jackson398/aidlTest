package com.aite.smart.gatewaylib.data

data class Response(var requestURL: String? = null,
                    var statusCode: Int? = 0,
                    var statusMsg: String? = null,
                    var errorCode: Int? = 0,
                    var errorMsg: String? = null
)