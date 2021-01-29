package com.aite.smart.gatewaylib.api

import android.util.Log
import com.aite.smart.gatewaylib.apiImpl.Apis
import com.aite.smart.gatewaylib.utils.JsonUtil
import com.aite.smart.gatewaylib.utils.XStreamUtil
import java.util.concurrent.ExecutorService
import java.util.concurrent.ScheduledThreadPoolExecutor

class GatewayScheduler {
    private var executorService: ExecutorService? = null

    companion object {
        private const val TAG = "GatewayScheduler"

        @Volatile
        private var mInstance: GatewayScheduler? = null

        val instance: GatewayScheduler?
            get() {
                if (mInstance == null) {
                    synchronized(GatewayScheduler::class.java) {
                        if (mInstance == null) {
                            mInstance = GatewayScheduler()
                        }
                    }
                }
                return mInstance
            }
    }

    init {
        executorService = ScheduledThreadPoolExecutor(0, DefaultThreadFactory())
    }

    /**
     * @param api IApi对象
     * @param params bean对象或者json字符串
     */
    fun send(api: IApi, params: Any? = null, timeout: Int? = null) {
        executorService?.submit(PostMessage(api, params, timeout))
    }

    internal inner class PostMessage(private val api: IApi, private val params: Any? = null,
                                     private val timeout: Int? = null) : Runnable {
        override fun run() {
            //参数类型
            var reqBody = ""

            when (api.getParamType()) {
                ParamType.none -> {
                    reqBody = ""
                    Log.d(TAG, "1 reqBody=$reqBody")

                }
                ParamType.xml -> {
                    reqBody = XStreamUtil.toXml(params!!)
                    Log.d(TAG, "2 reqBody=$reqBody")
                }
                ParamType.json -> {
                    reqBody = JsonUtil.toJsonString(params)
                    Log.d(TAG, "3 reqBody=$reqBody")

                }
            }
            Log.d(TAG, "reqBody=$reqBody")

            val resp = ""
            // todo
            Log.d(TAG, "resp=$resp")

            notifyLiveDataChanged(api, resp)

        }
    }

    private fun notifyLiveDataChanged(api: IApi, response: String) {
        //结果
        var result: Any? = null
        if (api.getProtocolType() == ProtocolType.APP_XML) {
            result = XStreamUtil.toBean(response, api.getResultEvent() as Class<*>?)
        } else if (api.getProtocolType() == ProtocolType.APP_JSON) {
            result = JsonUtil.toBean(response, api.getResultEvent() as Class<*>?)
        }
        Log.d(TAG, "result=$result")

        if (result == null) {
            // todo
        } else {
            // todo
        }
    }
}