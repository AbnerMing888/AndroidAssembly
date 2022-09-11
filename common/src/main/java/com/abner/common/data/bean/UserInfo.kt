package com.abner.common.data.bean

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/9
 *INTRODUCE:测试用户对象
 */
class UserInfo {
    var code: Int? = null
    var message: String? = null
    var data: User? = null

    class User {
        var userName: String? = null
        var userId: String? = null
        var nickName: String? = null
    }
}