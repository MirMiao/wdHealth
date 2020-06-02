package com.wd.health.contract.usercontract

import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.userentity.FindUserInfoCollectionEntity
import com.wd.health.entity.userentity.UpdatePwdEntity

/**
 * 时间 :2020/5/29  20:21
 * 作者 :苗恒
 * 功能 :  查询用户收藏资讯列表
 */
interface FindUserInfoCollectionContract {
    interface IModel: IBaseModel {
        fun findUserInfoCollection(userId:Int,sessionId:String,page:Int,count:Int,findUserInfoCollectionModelCallBack: findUserInfoCollectionModelCallBack) //查询用户资讯列表

        interface findUserInfoCollectionModelCallBack{
            fun seccess(findUserInfoCollectionEntity: FindUserInfoCollectionEntity)
            fun failur(throwable: Throwable)
        }

    }

    interface IView: IBaseView {
        fun seccess(findUserInfoCollectionEntity: FindUserInfoCollectionEntity)
        fun failur(throwable: Throwable)

    }
    interface IPresenter{
        fun findUserInfoCollection(userId:Int,sessionId:String,page:Int,count:Int) //查询用户资讯列表

    }
}