package com.wd.health.view.activity.userActivity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.wd.health.R
import com.wd.health.util.SaveAndGetUIdSessIdUtil
import com.wd.health.view.activity.MainActivity
import kotlinx.android.synthetic.main.activity_my_setting_layout.*
import org.jetbrains.anko.startActivity

/**
 * 时间 :2020/5/24  16:10
 * 作者 :苗恒
 * 功能 :
 */
class MySettingActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_setting_layout)
        tv_backLogin.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
               val saveAndGetUIdSessIdUtil=SaveAndGetUIdSessIdUtil()
                saveAndGetUIdSessIdUtil.clear()
                startActivity<MainActivity>()
            }
        })

    }
}