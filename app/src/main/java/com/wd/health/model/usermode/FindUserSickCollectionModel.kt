package com.wd.health.model.usermode

import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contract.usercontract.FindUserInfoCollectionContract
import com.wd.health.contract.usercontract.FindUserSickCollectionContract
import com.wd.health.entity.userentity.FindUserInfoCollectionEntity
import com.wd.health.entity.userentity.FindUserSickCollectionEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 时间 :2020/5/29  20:30
 * 作者 :苗恒
 * 功能 :  查询用户收藏病友圈列表
 */
class FindUserSickCollectionModel:FindUserSickCollectionContract.IModel {


        override fun findUserSickCollection(
            userId: Int,
            sessionId: String,
            page: Int,
            count: Int,
            findUserSickCollectionModelCallBack: FindUserSickCollectionContract.IModel.findUserSickCollectionModelCallBack
        ) {
                RetrofitUtils.createService().findUserSickClooection(userId,sessionId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    t: FindUserSickCollectionEntity->
                    findUserSickCollectionModelCallBack.let {
                        findUserSickCollectionModelCallBack.seccess(t)
                    }
                },{
                        t: Throwable ->
                    findUserSickCollectionModelCallBack.let {
                        findUserSickCollectionModelCallBack.failur(t)
                    }
                })
        }
    }
