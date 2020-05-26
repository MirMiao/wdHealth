package com.wd.health

import android.app.Application
import android.content.Context
import com.bw.doctor.base.api.Api

/**
 * 时间 :2020/5/21  16:15
 * 作者 :苗恒
 * 功能 :
 */
class App:Application() {
    companion object{
        var context: Context?=null
    }
    override fun onCreate() {
        super.onCreate()
        context=this
    }
}