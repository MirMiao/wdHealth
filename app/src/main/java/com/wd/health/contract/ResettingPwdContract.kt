package com.wd.health.contract

import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.BannerEntity
import com.wd.health.entity.EmailCodeEntity
import com.wd.health.entity.LoginEntity
import com.wd.health.entity.ResettingPwdEntity
import java.util.*

/**
 * 时间 :2020/5/21  15:23
 * 作者 :苗恒
 * 功能 :重置密码
 */
interface ResettingPwdContract {
    interface IModel:IBaseModel{
        fun resettingPwd(email:String,pwd1:String,pwd2:String,resettingPwdModelCallBack: ResettingPwdModelCallBack)
        interface ResettingPwdModelCallBack{
            fun seccess(resettingPwdEntity: ResettingPwdEntity)
            fun failur(throwable: Throwable)
        }
    }

    interface IView:IBaseView{
        fun seccess(resettingPwdEntity: ResettingPwdEntity)
        fun failur(throwable: Throwable)

    }
    interface IPresenter{
        fun resettingPwd(email:String,pwd1:String,pwd2:String)
    }



}