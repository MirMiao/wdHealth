package com.wd.health.presenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contract.ForgetPwdContract
import com.wd.health.contract.RegisterContract
import com.wd.health.entity.CheckCodeEntity
import com.wd.health.entity.EmailCodeEntity
import com.wd.health.entity.RegEntity
import com.wd.health.model.ForgetPwdModel
import com.wd.health.model.RegisterModel

/**
 * 时间 :2020/5/21  15:31
 * 作者 :苗恒
 * 功能 :  忘记密码
 */
class ForgetPwdPresenter: BasePresenter<ForgetPwdContract.IView>,ForgetPwdContract.IPresenter{

    var context:Context
    var forgetPwdModel:ForgetPwdModel
            constructor(context: Context){
                this.context=context
                this.forgetPwdModel= ForgetPwdModel()
            }
    //获取验证码
    override fun getEmailCode(email: String) {
        forgetPwdModel.getEmailCode(email,object :ForgetPwdContract.IModel.EmailCodeModelCallBack{
            override fun seccess(emailCodeEntity: EmailCodeEntity) {
                view?.getEmailCodeSeccess(emailCodeEntity)
            }

            override fun failur(throwable: Throwable) {
                view?.getEmailCodeFailur(throwable)
            }

        })
    }

    override fun checkCode(email: String, code: String) {
        forgetPwdModel.checkCode(email,code,object :ForgetPwdContract.IModel.CheckCodeModelCallBack{
            override fun seccess(checkCodeEntity: CheckCodeEntity) {
              view?.checkCodeSeccess(checkCodeEntity)
            }

            override fun failur(throwable: Throwable) {
              view?.checkCodeFailur(throwable)
            }

        })

    }


}