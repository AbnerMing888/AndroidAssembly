package com.abner.common.router

import android.app.Activity
import android.os.Bundle
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter
import java.io.Serializable

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/8
 *INTRODUCE:路由跳转
 */
class CommonRouterManger private constructor() {
    companion object {
        val instance by lazy(LazyThreadSafetyMode.NONE) {
            CommonRouterManger()
        }
    }

    /**
     * AUTHOR:AbnerMing
     *普通跳转
     */
    fun navigationActivity(path: String) {
        ARouter.getInstance().build(path).navigation()
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:回调跳转
     */
    fun navigationActivity(
        path: String,
        context: Activity,
        requestCode: Int,
        vararg params: Pair<String, Any>
    ) {
        ARouter.getInstance().build(path).putExtras(*params).navigation(context, requestCode)
    }

    fun navigationActivity(path: String, bundle: Bundle) {
        ARouter.getInstance().build(path)
            .withBundle("bundle_info", bundle).navigation()
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:携带参数跳转
     */
    fun navigationActivityParams(path: String, vararg params: Pair<String, Any>) {
        val navigation = ARouter.getInstance().build(path)
            .putExtras(*params)
        navigation.navigation()
    }

    fun Postcard.putExtras(vararg params: Pair<String, Any>): Postcard {
        if (params.isEmpty()) return this
        params.forEach { (key, value) ->
            when (value) {
                is Int -> withInt(key, value)
                is String -> withString(key, value)
                is Boolean -> withBoolean(key, value)
                is Char -> withChar(key, value)
                is Byte -> withByte(key, value)
                is Float -> withFloat(key, value)
                is Bundle -> withBundle(key, value)
                is Double -> withDouble(key, value)
                is ByteArray -> withByteArray(key, value)
                is Serializable -> withSerializable(key, value)
                is ArrayList<*> -> {
                    withStringArrayList(key, value as ArrayList<String>)
                }
                is Object -> withObject(key, value)
            }
        }
        return this
    }
}