package com.abner.common.service

import com.abner.common.data.bean.UserInfo
import com.alibaba.android.arouter.facade.template.IProvider

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/10
 *INTRODUCE:
 */
interface AccountUserService : IProvider {

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:获取用户信息
    */
    fun getUser(): UserInfo?


    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:测试弹出Dialog
    */
    fun showDialog()

}