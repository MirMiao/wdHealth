package com.wd.health.util

import com.wd.health.App

/**
 * 时间 :2020/5/25  14:38
 * 作者 :苗恒
 * 功能 :
 */
class SaveAndGetUIdSessIdUtil {
    val sp = App.getContext().getSharedPreferences("userInfo", 0)
    //存放int类型的值
     fun savaInt(name:String,value:Int){
         sp.edit().putInt(name,value).commit()
     }
    //存放String类型的值
    fun savaString(name: String,value:String){
        sp.edit().putString(name,value).commit()
    }
    //根据名字取出int值
    fun getInt(name:String):Int{
        val userId = sp.getInt(name, 0)
        return userId
    }
    //根据名字取出int值
    fun getString(name: String):String{
        val sessionId = sp.getString(name, "")
        return sessionId!!
    }
    //清除数据
    fun clear(){
        sp.edit().clear().commit()
    }
}