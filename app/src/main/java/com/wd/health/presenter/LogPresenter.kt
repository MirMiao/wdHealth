package com.wd.health.presenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contract.LoginContract
import com.wd.health.entity.LoginEntity
import com.wd.health.model.LoginModel

/**
 * 时间 :2020/5/21  15:31
 * 作者 :苗恒
 * 功能 :
 */
class LogPresenter: BasePresenter<LoginContract.IView>,LoginContract.IPresenter{

    var context:Context
    var loginModel:LoginModel
            constructor(context: Context){
                this.context=context
                loginModel= LoginModel()
            }

    override fun login(email: String, pwd: String) {
        loginModel.login(email,pwd,object :LoginContract.IModel.ModelCallBack{
            override fun seccess(loginEntity: LoginEntity) {
                view?.seccess(loginEntity)
            }

            override fun failur(throwable: Throwable) {
                view?.failur(throwable)
            }

        })

    }


}