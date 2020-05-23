package com.wd.health.contract

import com.bumptech.glide.provider.EncoderRegistry
import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.EmailCodeEntity
import com.wd.health.entity.LoginEntity
import com.wd.health.entity.RegEntity
import java.util.*

/**
 * 时间 :2020/5/21  15:23
 * 作者 :苗恒
 * 功能 :注册
 */
interface RegisterContract {
    interface IModel:IBaseModel{
        fun getEmailCode(email:String,emailCodeModelCallBack: EmailCodeModelCallBack);
        fun reg(email:String,code:Int,pwd1:String,pwd2:String,registerModelCallBack: RegisterModelCallBack)
         interface EmailCodeModelCallBack{
             fun seccess(emailCodeEntity: EmailCodeEntity)
             fun failur(throwable: Throwable)
         }
        interface RegisterModelCallBack{
            fun seccess(regEntity: RegEntity)
            fun failur(throwable: Throwable)
        }
    }

    interface IView:IBaseView{
        fun registerSeccess(regEntity: RegEntity)
        fun registerFailur(throwable: Throwable)
        fun getEmailCodeSeccess(emailCodeEntity: EmailCodeEntity)
        fun getEmailCodeFailur(throwable: Throwable)
    }
    interface IPresenter{
        fun reg(email:String,code:Int,pwd1:String,pwd2:String)
        fun getEmailCode(email:String)
    }
}