package com.wd.health.util

import com.wd.health.App

/**
 * 时间 :2020/5/25  14:38
 * 作者 :苗恒
 * 功能 :
 */
class SaveAndGetUIdSessIdUtil {
    val sp = App.getContext().getSharedPreferences("userInfo", 0)
    //存放userId
     fun savaUserId(userId:Int){
         sp.edit().putInt("userId",userId).commit()
     }
    //存放sessionId
    fun savaSessionId(sessionId:String){
        sp.edit().putString("sessionId",sessionId).commit()
    }
    //取出userId
    fun getUserId():Int{
        val userId = sp.getInt("userId", 0)
        return userId
    }
    //取出sessionId
    fun getSessionId():String{
        val sessionId = sp.getString("sessionId", "")
        return sessionId!!
    }
}