package com.wd.health.model.usermode

import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contract.usercontract.UpdatePwdContract
import com.wd.health.entity.userentity.UpdatePwdEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 时间 :2020/5/28  23:22
 * 作者 :苗恒
 * 功能 :  修改用户密码
 */
class UpdateUserPwdModel:UpdatePwdContract.IModel {
    override fun updateUserPwd(
        userId: Int,
        sessionId: String,
        oldPwd: String,
        newPwd: String,
        updateUserPwdModelCallBack: UpdatePwdContract.IModel.updateUserPwdModelCallBack
    ) {
        RetrofitUtils.createService().updateUserPwd(userId,sessionId,oldPwd,newPwd)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                t: UpdatePwdEntity ->
                updateUserPwdModelCallBack.let {
                    updateUserPwdModelCallBack.seccess(t)
                }
            },{
                t: Throwable ->
                updateUserPwdModelCallBack.let {
                    updateUserPwdModelCallBack.failur(t)
                }
            })
    }

}