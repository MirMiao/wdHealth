package com.wd.health.presenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contract.RegisterContract
import com.wd.health.entity.EmailCodeEntity
import com.wd.health.entity.RegEntity
import com.wd.health.model.RegisterModel

/**
 * 时间 :2020/5/21  15:31
 * 作者 :苗恒
 * 功能 :
 */
class RegisterPresenter: BasePresenter<RegisterContract.IView>,RegisterContract.IPresenter{

    var context:Context
    var registerModel:RegisterModel
            constructor(context: Context){
                this.context=context
                registerModel= RegisterModel()
            }
     //注册
    override fun reg(email: String, code: Int, pwd1: String, pwd2: String) {
         registerModel.reg(email,code,pwd1,pwd2,object :RegisterContract.IModel.RegisterModelCallBack{
             override fun seccess(regEntity: RegEntity) {
                view?.registerSeccess(regEntity)
             }

             override fun failur(throwable: Throwable) {
                 view?.registerFailur(throwable)
             }

         })
    }

    //获取验证码
    override fun getEmailCode(email: String) {
        registerModel.getEmailCode(email,object :RegisterContract.IModel.EmailCodeModelCallBack{
            override fun seccess(emailCodeEntity: EmailCodeEntity) {
                view?.getEmailCodeSeccess(emailCodeEntity)
            }

            override fun failur(throwable: Throwable) {
                view?.getEmailCodeFailur(throwable)
            }

        })
    }


}