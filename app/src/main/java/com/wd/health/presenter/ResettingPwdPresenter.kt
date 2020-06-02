package com.wd.health.presenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contract.LoginContract
import com.wd.health.contract.ResettingPwdContract
import com.wd.health.entity.LoginEntity
import com.wd.health.entity.ResettingPwdEntity
import com.wd.health.model.LoginModel
import com.wd.health.model.ResettingPwdModel

/**
 * 时间 :2020/5/21  15:31
 * 作者 :苗恒
 * 功能 :  密码重置
 */
class ResettingPwdPresenter: BasePresenter<ResettingPwdContract.IView>,ResettingPwdContract.IPresenter{

    var context:Context
    var resettingPwdModel:ResettingPwdModel
            constructor(context: Context){
                this.context=context
                this.resettingPwdModel= ResettingPwdModel()
            }

    override fun resettingPwd(email: String, pwd1: String, pwd2: String) {
        resettingPwdModel.resettingPwd(email,pwd1,pwd2,object :ResettingPwdContract.IModel.ResettingPwdModelCallBack{
            override fun seccess(resettingPwdEntity: ResettingPwdEntity) {
               view?.seccess(resettingPwdEntity)
            }

            override fun failur(throwable: Throwable) {
                view?.failur(throwable)
            }

        })
    }


}