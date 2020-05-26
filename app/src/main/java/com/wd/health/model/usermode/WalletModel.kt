package com.wd.health.model.usermode

import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contract.usercontract.WalletContract
import com.wd.health.entity.EmailCodeEntity
import com.wd.health.entity.userentity.FindUserConsumption
import com.wd.health.entity.userentity.FindUserWalletEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 时间 :2020/5/25  20:16
 * 作者 :苗恒
 * 功能 :  用户钱包
 */
class WalletModel:WalletContract.IModel {
    //查找用户的H币
    override fun findUserWallet(userId: Int, sessionId: String, findUserWalletModelCallBack: WalletContract.IModel.FindUserWalletModelCallBack) {
        RetrofitUtils.createService().findUserWallet(userId,sessionId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                       findUserWalletEntity:FindUserWalletEntity->
                         findUserWalletModelCallBack.let {
                             findUserWalletModelCallBack.seccess(findUserWalletEntity)
                         }

            },{
                t: Throwable ->
                   findUserWalletModelCallBack.let {
                       findUserWalletModelCallBack.failur(t)
                   }
            });
    }
     //查找用户的账单
    override fun findUserConsummtion(userId: Int, sessionId: String, page: Int, count: Int, findUserConsummtionModelCallBack: WalletContract.IModel.FindUserConsummtionModelCallBack) {
         RetrofitUtils.createService().findUserConsumption(userId,sessionId,page,count)
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe({
                       findUserConsummtion:FindUserConsumption->
                    findUserConsummtionModelCallBack.let {
                        findUserConsummtionModelCallBack.seccess(findUserConsummtion)
                    }

             },{
                     t: Throwable ->
                 findUserConsummtionModelCallBack.let {
                     findUserConsummtionModelCallBack.failur(t)
                 }
             });
    }
}