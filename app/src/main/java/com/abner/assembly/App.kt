package com.abner.assembly

import com.abner.common.CommonApp

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/8
 *INTRODUCE:
 */
class App : CommonApp() {

    override fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }
}