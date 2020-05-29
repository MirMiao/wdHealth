package com.wd.health.contract.usercontract

import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.LoginEntity
import com.wd.health.entity.userentity.UpdatePwdEntity

/**
 * 时间 :2020/5/28  23:16
 * 作者 :苗恒
 * 功能 :  修改用户密码
 */
interface UpdatePwdContract {
    interface IModel: IBaseModel {
        fun updateUserPwd(userId:Int,sessionId:String,oldPwd:String,newPwd:String,updateUserPwdModelCallBack: updateUserPwdModelCallBack) //修改用户密码
        interface updateUserPwdModelCallBack{
            fun seccess(updatePwdEntity: UpdatePwdEntity)
            fun failur(throwable: Throwable)
        }

    }

    interface IView: IBaseView {
        fun seccess(updatePwdEntity: UpdatePwdEntity)
        fun failur(throwable: Throwable)

    }
    interface IPresenter{
        fun updateUserPwd(userId:Int,sessionId:String,oldPwd:String,newPwd:String) //修改用户密码
    }

}