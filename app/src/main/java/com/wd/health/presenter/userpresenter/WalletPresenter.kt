package com.wd.health.presenter.userpresenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contract.usercontract.WalletContract
import com.wd.health.entity.userentity.FindUserConsumption
import com.wd.health.entity.userentity.FindUserWalletEntity
import com.wd.health.model.usermode.WalletModel

/**
 * 时间 :2020/5/25  20:22
 * 作者 :苗恒
 * 功能 :
 */
class WalletPresenter: BasePresenter<WalletContract.IView>,WalletContract.IPresenter {

    var context: Context
    var walletModel:WalletModel
    constructor(context: Context){
        this.context=context
        walletModel= WalletModel()
    }
    override fun findUserWallet(userId: Int, sessionId: String) {
        walletModel.findUserWallet(userId,sessionId,object :WalletContract.IModel.FindUserWalletModelCallBack{
            override fun seccess(findUserWalletEntity: FindUserWalletEntity) {
               view?.findUserWalletSeccess(findUserWalletEntity)
            }

            override fun failur(throwable: Throwable) {
                view?.findUserWalletFailur(throwable)
            }

        })
    }

    override fun findUserConsummtion(userId: Int, sessionId: String, page: Int, count: Int) {
        walletModel.findUserConsummtion(userId,sessionId,page,count,object :WalletContract.IModel.FindUserConsummtionModelCallBack{
            override fun seccess(findUserConsumption: FindUserConsumption) {
              view?.findUserConsummtionSeccess(findUserConsumption)
            }

            override fun failur(throwable: Throwable) {
              view?.findUserConsummtionFailur(throwable)
            }

        })
    }
}