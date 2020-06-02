package com.wd.health.presenter.userpresenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contract.usercontract.FindUserInfoCollectionContract
import com.wd.health.contract.usercontract.FindUserSickCollectionContract
import com.wd.health.entity.userentity.FindUserInfoCollectionEntity
import com.wd.health.entity.userentity.FindUserSickCollectionEntity
import com.wd.health.model.usermode.FindUserInfoCollectionModel
import com.wd.health.model.usermode.FindUserSickCollectionModel

/**
 * 时间 :2020/5/29  20:35
 * 作者 :苗恒
 * 功能 :
 */
class FindUserSickCollectionPresenter:BasePresenter<FindUserSickCollectionContract.IView>,FindUserSickCollectionContract.IPresenter {
    val context:Context
    val  findUserSickCollectionModel:FindUserSickCollectionModel
    constructor(context: Context){
        this.context=context
        this.findUserSickCollectionModel= FindUserSickCollectionModel()
    }

    override fun findUserSickCollection(userId: Int, sessionId: String, page: Int, count: Int) {
        findUserSickCollectionModel.findUserSickCollection(userId,sessionId,page,count,object :FindUserSickCollectionContract.IModel.findUserSickCollectionModelCallBack{
            override fun seccess(findUserSickCollectionEntity: FindUserSickCollectionEntity) {
                view?.seccess(findUserSickCollectionEntity)
            }

            override fun failur(throwable: Throwable) {
                view?.failur(throwable)
            }

        })
    }
}