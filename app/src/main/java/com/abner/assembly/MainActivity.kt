package com.abner.assembly

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.abner.common.router.CommonRouterConstant
import com.abner.common.router.CommonRouterManger

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //模拟跳转account组件
        findViewById<Button>(R.id.btn_account).setOnClickListener {
            CommonRouterManger.instance.navigationActivity(CommonRouterConstant.ACCOUNT)
        }
        //模拟跳转code组件
        findViewById<Button>(R.id.btn_code).setOnClickListener {
            CommonRouterManger.instance.navigationActivity(CommonRouterConstant.CODE)
        }
    }
}