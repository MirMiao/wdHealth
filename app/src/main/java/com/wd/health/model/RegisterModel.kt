package com.wd.health.model

import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contract.RegisterContract
import com.wd.health.entity.EmailCodeEntity
import com.wd.health.entity.RegEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 时间 :2020/5/21  15:29
 * 作者 :苗恒
 * 功能 :
 */
class RegisterModel:RegisterContract.IModel {
      //获取验证码
    override fun getEmailCode(email: String, emailCodeModelCallBack: RegisterContract.IModel.EmailCodeModelCallBack) {
       RetrofitUtils.createService().getEmailCode(email)
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe({
                   emailcodeEntity: EmailCodeEntity ->emailCodeModelCallBack.let {
               emailCodeModelCallBack.seccess(emailcodeEntity)
           }
           },{
                   error:Throwable ->emailCodeModelCallBack.let {
               emailCodeModelCallBack.failur(error)
           }
           });
    }
       //注册
    override fun reg(email: String, code: Int, pwd1: String, pwd2: String, registerModelCallBack: RegisterContract.IModel.RegisterModelCallBack) {
           RetrofitUtils.createService().register(email,code,pwd1,pwd2)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe({
                      regEntity: RegEntity ->
                    registerModelCallBack.let {
                        registerModelCallBack.seccess(regEntity)
                    }
               },{
                   error:Throwable ->registerModelCallBack.let {
                   registerModelCallBack.failur(error)
               }
               })
    }

}

