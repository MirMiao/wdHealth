package com.wd.health.model

import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contract.LoginContract
import com.wd.health.contract.ResettingPwdContract
import com.wd.health.entity.LoginEntity
import com.wd.health.entity.ResettingPwdEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 时间 :2020/5/21  15:29
 * 作者 :苗恒
 * 功能 :  重置密码
 */
class ResettingPwdModel:ResettingPwdContract.IModel {
    override fun resettingPwd(
        email: String,
        pwd1: String,
        pwd2: String,
        resettingPwdModelCallBack: ResettingPwdContract.IModel.ResettingPwdModelCallBack
    ) {

            RetrofitUtils.createService().resettingPwd(email,pwd1,pwd2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    t: ResettingPwdEntity ->
                    resettingPwdModelCallBack.let {
                        resettingPwdModelCallBack.seccess(t)
                    }
                },{
                    t: Throwable->
                    resettingPwdModelCallBack.let {
                        resettingPwdModelCallBack.failur(t)
                    }

                })

        }



}