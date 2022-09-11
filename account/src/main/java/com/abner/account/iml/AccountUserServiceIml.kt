package com.abner.account.iml

import android.app.AlertDialog
import android.content.Context
import android.text.TextUtils
import com.abner.common.data.bean.UserInfo
import com.abner.common.router.CommonRouterConstant
import com.abner.common.service.AccountUserService
import com.abner.common.utils.DataStoreUtils
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.gson.Gson

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/10
 *INTRODUCE:
 */
@Route(path = CommonRouterConstant.USER_INFO, name = "AccountUserServiceIml")
class AccountUserServiceIml : AccountUserService {

    override fun getUser(): UserInfo? {
        //获取用户信息后，转成需要的对象
        val userJson = DataStoreUtils.getSyncData("user", "")
        if (TextUtils.isEmpty(userJson)) {
            return null
        }
        return Gson().fromJson(userJson, UserInfo::class.java)
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:测试弹窗或其他功能
     */
    override fun showDialog() {
        AlertDialog.Builder(mContext)
            .setTitle("测试一个Dialog弹出框")
            .setMessage("简单测试以下")
            .setNegativeButton("取消") { _, _ ->

            }
            .setPositiveButton("确定") { _, _ ->


            }
            .show()
    }

    private var mContext: Context? = null

    override fun init(context: Context?) {
        mContext = context
    }
}