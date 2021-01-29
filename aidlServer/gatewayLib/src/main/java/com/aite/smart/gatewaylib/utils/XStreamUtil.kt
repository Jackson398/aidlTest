package com.aite.smart.gatewaylib.utils

import android.util.Log
import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.io.xml.Xpp3DomDriver

object XStreamUtil {
    private const val TAG = "XStreamUtil"

    /**
     * java 转换成xml
     *
     * @param obj 对象实例
     * @return String xml字符串
     */
    fun toXml(obj: Any): String {
        return try {
            val xstream = XStream(Xpp3DomDriver())
            xstream.processAnnotations(obj.javaClass) //支持通过注解方式
            """<?xml version="1.0" encoding="UTF-8" ?>${xstream.toXML(obj)}"""
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(TAG, "toXml: null " + obj.javaClass.simpleName)
            ""
        }
    }

    /**
     * 将传入xml文本转换成Java对象
     *
     * @param xmlStr xml格式字符串
     * @param cls 实体类
     * @return T
     */
    fun <T> toBean(xmlStr: String, cls: Class<T>?): T? {
        return try {
            val xstream = XStream(Xpp3DomDriver())
            xstream.processAnnotations(cls) //支持通过注解方式
            xstream.fromXML(xmlStr) as T
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(TAG, "toBean: xmlStr=$xmlStr")
            null
        }
    }
}