package com.wd.health.model

import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contract.LoginContract
import com.wd.health.entity.LoginEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 时间 :2020/5/21  15:29
 * 作者 :苗恒
 * 功能 :
 */
class LoginModel:LoginContract.IModel {
    override fun login(email: String, pwd: String, modelCallBack: LoginContract.IModel.ModelCallBack) {
        RetrofitUtils.createService().login(email,pwd)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    loginentity: LoginEntity ->modelCallBack.let {
                modelCallBack.seccess(loginentity)
            }
            },{
                    error:Throwable ->modelCallBack.let {
                modelCallBack.failur(error)
            }
            });
    }


}