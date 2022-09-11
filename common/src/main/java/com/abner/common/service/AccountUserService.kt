package com.abner.common.service

import com.abner.common.data.bean.UserInfo
import com.alibaba.android.arouter.facade.template.IProvider

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/10
 *INTRODUCE:
 */
interface AccountUserService : IProvider {

    fun getUser(): UserInfo?


    fun showDialog()

}