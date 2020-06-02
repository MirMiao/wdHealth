package com.wd.health.model.usermode

import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contract.usercontract.FindUserInfoCollectionContract
import com.wd.health.entity.userentity.FindUserInfoCollectionEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 时间 :2020/5/29  20:30
 * 作者 :苗恒
 * 功能 :  查询用户收藏资讯列表
 */
class FindUserInfoCollectionModel:FindUserInfoCollectionContract.IModel {
    override fun findUserInfoCollection(
        userId: Int,
        sessionId: String,
        page: Int,
        count: Int,
        findUserInfoCollectionModelCallBack: FindUserInfoCollectionContract.IModel.findUserInfoCollectionModelCallBack
    ) {
         RetrofitUtils.createService().findUserInfoCollection(userId,sessionId,page,count)
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe({
                 t: FindUserInfoCollectionEntity ->
                 findUserInfoCollectionModelCallBack.seccess(t)
             },{
                 t: Throwable ->
                 findUserInfoCollectionModelCallBack.let {
                     findUserInfoCollectionModelCallBack.failur(t)
                 }
             })
    }
}