package com.aite.smart.gatewaylib.api

class GatewayApi<T> private constructor() : BaseApi() {
    companion object {
        fun <T> putXml(protocol: String, resultContent: Class<T>): GatewayApi<T> {
            val api = GatewayApi<T>()
            api.protocol = protocol
            api.resultEvent = resultContent
            api.requestType = RequestType.Put
            api.paramType = ParamType.xml
            api.protocolType = ProtocolType.APP_XML
            return api
        }

        fun <T> postXml(protocol: String, resultContent: Class<T>? = null): GatewayApi<T> {
            val api = GatewayApi<T>()
            api.protocol = protocol
            api.resultEvent = resultContent
            api.requestType = RequestType.Post
            api.paramType = ParamType.xml
            api.protocolType = ProtocolType.APP_XML
            return api
        }


        fun <T> putJson(protocol: String, resultContent: Class<T>): GatewayApi<T> {
            val api = GatewayApi<T>()
            api.protocol = protocol
            api.resultEvent = resultContent
            api.requestType = RequestType.Put
            api.paramType = ParamType.json
            api.protocolType = ProtocolType.APP_JSON
            return api
        }

        fun <T> getXml(protocol: String, resultContent: Class<T>? = null): GatewayApi<T> {
            val api = GatewayApi<T>()
            api.protocol = protocol
            api.resultEvent = resultContent
            api.requestType = RequestType.Get
            api.paramType = ParamType.none
            api.protocolType = ProtocolType.APP_XML
            return api
        }

        fun <T> getJson(protocol: String, resultContent: Class<T>? = null): GatewayApi<T> {
            val api = GatewayApi<T>()
            api.protocol = protocol
            api.resultEvent = resultContent
            api.requestType = RequestType.Get
            api.paramType = ParamType.none
            api.protocolType = ProtocolType.APP_JSON
            return api
        }
    }
}