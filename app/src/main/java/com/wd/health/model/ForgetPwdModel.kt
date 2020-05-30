package com.wd.health.model

import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contract.ForgetPwdContract
import com.wd.health.contract.RegisterContract
import com.wd.health.entity.CheckCodeEntity
import com.wd.health.entity.EmailCodeEntity
import com.wd.health.entity.RegEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 时间 :2020/5/21  15:29
 * 作者 :苗恒
 * 功能 :  忘记密码
 */
class ForgetPwdModel:ForgetPwdContract.IModel {
        //获取验证码
    override fun getEmailCode(
        email: String,
        emailCodeModelCallBack: ForgetPwdContract.IModel.EmailCodeModelCallBack
    ) {
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
    //校验验证码
    override fun checkCode(
        email: String,
        code: String,
        checkCodeModelCallBack: ForgetPwdContract.IModel.CheckCodeModelCallBack
    ) {
        RetrofitUtils.createService().checkCode(email,code)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                 t: CheckCodeEntity ->
                checkCodeModelCallBack.let {
                    checkCodeModelCallBack.seccess(t)
                }
            },{
                t: Throwable ->
                checkCodeModelCallBack.let {
                    checkCodeModelCallBack.failur(t)
                }
            })
            }

}

