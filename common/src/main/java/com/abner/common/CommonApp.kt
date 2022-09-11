package com.abner.common

import android.app.Application
import android.util.Log
import com.abner.common.utils.DataStoreUtils
import com.alibaba.android.arouter.launcher.ARouter

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/8
 *INTRODUCE:初始化
 */
abstract class CommonApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (isDebug()) {  // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()   // 打印日志
            ARouter.openDebug()  // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化

        DataStoreUtils.init(this)
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:是否是测试环境
     */
    abstract fun isDebug(): Boolean
}