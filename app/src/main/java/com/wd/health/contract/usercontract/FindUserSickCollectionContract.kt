package com.wd.health.contract.usercontract

import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.userentity.FindUserInfoCollectionEntity
import com.wd.health.entity.userentity.FindUserSickCollectionEntity
import com.wd.health.entity.userentity.UpdatePwdEntity

/**
 * 时间 :2020/5/29  20:21
 * 作者 :苗恒
 * 功能 :  查询用户收藏病友圈列表
 */
interface FindUserSickCollectionContract {
    interface IModel: IBaseModel {
        fun findUserSickCollection(userId:Int,sessionId:String,page:Int,count:Int,findUserSickCollectionModelCallBack: findUserSickCollectionModelCallBack) //查询用户收藏病友圈列表

        interface findUserSickCollectionModelCallBack{
            fun seccess(findUserSickCollectionEntity: FindUserSickCollectionEntity)
            fun failur(throwable: Throwable)
        }

    }

    interface IView: IBaseView {
        fun seccess(findUserSickCollectionEntity: FindUserSickCollectionEntity)
        fun failur(throwable: Throwable)

    }
    interface IPresenter{
        fun findUserSickCollection(userId:Int,sessionId:String,page:Int,count:Int) //查询用户收藏病友圈列表


    }
}