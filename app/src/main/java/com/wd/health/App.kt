package com.wd.health

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.bw.doctor.base.api.Api
import org.greenrobot.eventbus.EventBus

/**
 * 时间 :2020/5/21  16:15
 * 作者 :苗恒
 * 功能 :
 */
class App:Application() {
    //以后就可以直接在任意的类里面使用WdTools.getContext()获取Context对象了。
    companion object {
        var context:Application? = null
        fun getContext():Context{
            return context!!
        }

    }
    override fun onCreate() {
        super.onCreate()
        context=this

        MultiDex.install(this)

    }
}