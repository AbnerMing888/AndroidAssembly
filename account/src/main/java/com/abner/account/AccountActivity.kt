package com.abner.account

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.abner.common.router.CommonRouterConstant
import com.abner.common.router.CommonRouterManger
import com.abner.common.utils.CommonUserUtils
import com.alibaba.android.arouter.facade.annotation.Route

/**
 *AUTHOR:AbnerMing
 *DATE:2022/9/8
 *INTRODUCE:Account页面
 */
@Route(path = CommonRouterConstant.ACCOUNT)
class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        //普通页面跳转
        findViewById<Button>(R.id.btn_code).setOnClickListener {
            CommonRouterManger.instance.navigationActivity(CommonRouterConstant.CODE)
        }
        //页面带参数跳转
        findViewById<Button>(R.id.btn_code_params).setOnClickListener {
            CommonRouterManger.instance.navigationActivityParams(
                CommonRouterConstant.CODE,
                "params" to "我是携带的参数",
                "params2" to 100
            )
        }

        //模拟登录，真实业务中，请以实际为准，目前只是测试
        findViewById<Button>(R.id.btn_login).setOnClickListener {
            //登录成功之后，保存用户信息，格式自定义，请以实际为准,当前为Demo测试
            val json = "{\n" +
                    "\t\"code\": 0,\n" +
                    "\t\"message\": \"登录成功\",\n" +
                    "\t\"data\": {\n" +
                    "\t\t\"userName\": \"Abner0002323\",\n" +
                    "\t\t\"userId\": \"896767898989989879\",\n" +
                    "\t\t\"nickName\": \"AbnerMing\"\n" +
                    "\t}\n" +
                    "}"
            CommonUserUtils.instance.setUser(json)
            Toast.makeText(this, "模拟登录成功", Toast.LENGTH_SHORT).show()
        }
    }
}