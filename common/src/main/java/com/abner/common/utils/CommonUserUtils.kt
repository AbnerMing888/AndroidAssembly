package com.abner.common.utils

import android.text.TextUtils
import com.abner.common.data.bean.UserInfo
import com.abner.common.utils.DataStoreUtils.getSyncData
import com.abner.common.utils.DataStoreUtils.putSyncData
import com.google.gson.Gson

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/9
 *INTRODUCE:
 */
class CommonUserUtils {

    companion object {
        val instance by lazy(LazyThreadSafetyMode.NONE) {
            CommonUserUtils()
        }
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:是否登录，实际业务中，请根据存储的用户信息进行判断
     */
    fun isLogin(): Boolean {
        if (getUser() != null &&
            getUser()?.data != null
            && !TextUtils.isEmpty(getUser()?.data?.userId)
        ) {
            return true
        }
        return false
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:获取存储的用户信息，请根据实际业务进行返回,当前仅用于测试
     */
    fun getUser(): UserInfo? {
        //获取用户信息后，转成需要的对象
        val userJson = getSyncData("user", "")
        if (TextUtils.isEmpty(userJson)) {
            return null
        }
        return Gson().fromJson(userJson, UserInfo::class.java)
    }

    /**
     * AUTHOR:AbnerMing
     * INTRODUCE:保存用户数据，请以实际为准
     */
    fun setUser(json: String) {
        //存储用户信息
        putSyncData("user", json)
    }
}