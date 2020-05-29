package com.wd.health.presenter.userpresenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contract.usercontract.UpdatePwdContract
import com.wd.health.entity.userentity.UpdatePwdEntity
import com.wd.health.model.usermode.UpdateUserPwdModel
import com.wd.health.model.usermode.UserHomeModel

/**
 * 时间 :2020/5/28  23:24
 * 作者 :苗恒
 * 功能 : 修改用户密码
 */
class UpdateUserPwdPresenter:BasePresenter<UpdatePwdContract.IView>,UpdatePwdContract.IPresenter{
    var context: Context
    var updateUserPwdModel:UpdateUserPwdModel
    constructor(context: Context){
        this.context=context
        this.updateUserPwdModel= UpdateUserPwdModel()
    }
    override fun updateUserPwd(userId: Int, sessionId: String, oldPwd: String, newPwd: String) {
        updateUserPwdModel.updateUserPwd(userId,sessionId,oldPwd,newPwd,object :UpdatePwdContract.IModel.updateUserPwdModelCallBack{
            override fun seccess(updatePwdEntity: UpdatePwdEntity) {
               view?.seccess(updatePwdEntity)
            }

            override fun failur(throwable: Throwable) {
               view?.failur(throwable)
            }

        })
    }
}