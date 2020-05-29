package com.wd.health.presenter.userpresenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contract.usercontract.FindUserInfoCollectionContract
import com.wd.health.entity.userentity.FindUserInfoCollectionEntity
import com.wd.health.model.usermode.FindUserInfoCollectionModel

/**
 * 时间 :2020/5/29  20:35
 * 作者 :苗恒
 * 功能 :
 */
class FindUserInfoCollectionPresenter:BasePresenter<FindUserInfoCollectionContract.IView>,FindUserInfoCollectionContract.IPresenter {
    val context:Context
    val  findUserInfoCollectionModel:FindUserInfoCollectionModel
    constructor(context: Context){
        this.context=context
        this.findUserInfoCollectionModel= FindUserInfoCollectionModel()
    }

    override fun findUserInfoCollection(userId: Int, sessionId: String, page: Int, count: Int) {
        findUserInfoCollectionModel.findUserInfoCollection(userId,sessionId,page,count,object :FindUserInfoCollectionContract.IModel.findUserInfoCollectionModelCallBack{
            override fun seccess(findUserInfoCollectionEntity: FindUserInfoCollectionEntity) {
                view?.seccess(findUserInfoCollectionEntity)
            }

            override fun failur(throwable: Throwable) {
           view?.failur(throwable)
            }

        })
    }
}