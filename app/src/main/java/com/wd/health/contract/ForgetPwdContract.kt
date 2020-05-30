package com.wd.health.contract

import com.bumptech.glide.provider.EncoderRegistry
import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.CheckCodeEntity
import com.wd.health.entity.EmailCodeEntity
import com.wd.health.entity.LoginEntity
import com.wd.health.entity.RegEntity
import java.util.*

/**
 * 时间 :2020/5/21  15:23
 * 作者 :苗恒
 * 功能 :忘记密码
 */
interface ForgetPwdContract {
    interface IModel:IBaseModel{
        fun getEmailCode(email:String,emailCodeModelCallBack: EmailCodeModelCallBack);
        fun checkCode(email:String,code:String,checkCodeModelCallBack: CheckCodeModelCallBack)
         interface EmailCodeModelCallBack{
             fun seccess(emailCodeEntity: EmailCodeEntity)
             fun failur(throwable: Throwable)
         }
        interface CheckCodeModelCallBack{
            fun seccess(checkCodeEntity: CheckCodeEntity)
            fun failur(throwable: Throwable)
        }
    }

    interface IView:IBaseView{
        fun checkCodeSeccess(checkCodeEntity: CheckCodeEntity)
        fun checkCodeFailur(throwable: Throwable)
        fun getEmailCodeSeccess(emailCodeEntity: EmailCodeEntity)
        fun getEmailCodeFailur(throwable: Throwable)
    }
    interface IPresenter{
        fun getEmailCode(email:String);
        fun checkCode(email:String,code:String)
    }
}