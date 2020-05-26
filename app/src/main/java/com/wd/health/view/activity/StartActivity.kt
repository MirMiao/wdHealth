package com.wd.health.view.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.wd.health.R
import kotlinx.android.synthetic.main.activity_start.*
import org.jetbrains.anko.startActivity

/**
 * 时间 :2020/5/22  14:49
 * 作者 :苗恒
 * 功能 :
 */
class StartActivity:AppCompatActivity(){
    private var mTime = 3
    private var mHandler: Handler = Handler()
    private val mRunnable: Runnable = object : Runnable {
        override fun run() {
            // TODO: 倒计时逻辑
           if(mTime == 1) {
               startActivity<LeadActivity>()
               //跳转成功存值
           }
            mTime--
           tv_time_down.text = "倒计时:（${mTime}）秒"
            // 每隔一秒调用
             mHandler.postDelayed(this, 1_000L)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        mHandler.removeCallbacks(mRunnable)
        mHandler.postDelayed(mRunnable, 1_000L)
    }

}