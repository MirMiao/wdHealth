package com.wd.health.contract

import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.BannerEntity
import com.wd.health.entity.EmailCodeEntity
import com.wd.health.entity.LoginEntity
import java.util.*

/**
 * 时间 :2020/5/21  15:23
 * 作者 :苗恒
 * 功能 :登陆
 */
interface LoginContract {
    interface IModel:IBaseModel{
        fun login(email:String,pwd:String,modelCallBack: ModelCallBack)
        interface ModelCallBack{
            fun seccess(loginEntity: LoginEntity)
            fun failur(throwable: Throwable)
        }

    }

    interface IView:IBaseView{
        fun seccess(loginEntity: LoginEntity)
        fun failur(throwable: Throwable)

    }
    interface IPresenter{
        fun login(email:String,pwd:String)
    }



}