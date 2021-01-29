package com.aite.smart.gatewaylib.utils

import android.util.Log
import com.google.gson.Gson

object JsonUtil {
    private const val TAG = "jsonUtil"

    /**
     * 转成json
     *
     * @param object
     * @return
     */
    fun toJsonString(`object`: Any?): String {
        return Gson().toJson(`object`)
    }

    /**
     * 转成bean
     *
     * @param json json字符串
     * @param cls
     * @return
     */
    fun <T> toBean(json: String, cls: Class<T>?): T? {
        var t: T? = null
        try {
            t = Gson().fromJson(json, cls)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(TAG, "toBean: json=$json")
        }
        return t
    }
}