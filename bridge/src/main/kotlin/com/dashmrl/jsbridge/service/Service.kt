package com.dashmrl.jsbridge.service

import com.dashmrl.jsbridge.Proxy
import com.dashmrl.jsbridge.callback.JSCallback
import com.dashmrl.jsbridge.model.Request
import com.dashmrl.jsbridge.util.JSON

/**
 * Author       xinliu
 * Date         10/22/17
 * Time         10:31 AM
 * used to handle the call from JS environment
 */
abstract class Service<in T, out R> {
    internal fun handleJSCall(requestStr: String, proxy: Proxy) {
        val request = JSON.parse<Request<T>>(requestStr)
        handle(request.param, JSCallback(proxy, request.uuid))
    }

    abstract fun handle(data: T, callback: JSCallback<R>)

}