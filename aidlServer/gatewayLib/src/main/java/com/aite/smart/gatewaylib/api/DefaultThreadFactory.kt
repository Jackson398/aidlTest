package com.aite.smart.gatewaylib.api

import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicInteger

class DefaultThreadFactory() : ThreadFactory {

    companion object {
        @JvmStatic
        private val poolNumber = AtomicInteger(1)
    }

    private var group: ThreadGroup? = null

    private val threadNumber = AtomicInteger(1)

    private var namePrefix: String? = null

    init {
        val s = System.getSecurityManager()
        group = if (s != null) s.threadGroup else Thread.currentThread().threadGroup
        namePrefix = "pool-" + poolNumber.getAndIncrement() + "-thread-"
    }
    override fun newThread(r: Runnable?): Thread {
        val t = Thread(group, r,
                namePrefix + threadNumber.getAndIncrement(),
                0)
        if (t.isDaemon) t.isDaemon = false
        if (t.priority != Thread.NORM_PRIORITY) t.priority = Thread.NORM_PRIORITY
        return t
    }
}