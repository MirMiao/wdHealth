package com.wd.health.contract.usercontract

import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.EmailCodeEntity
import com.wd.health.entity.LoginEntity
import com.wd.health.entity.RegEntity
import com.wd.health.entity.userentity.FindUserConsumption
import com.wd.health.entity.userentity.FindUserWalletEntity

/**
 * 时间 :2020/5/25  20:09
 * 作者 :苗恒
 * 功能 :  钱包页面的契约类
 */
interface WalletContract {
    interface IModel:IBaseModel{
        fun findUserWallet(userId:Int,sessionId:String,findUserWalletModelCallBack: FindUserWalletModelCallBack);//查找用户钱包
        fun findUserConsummtion(userId:Int,sessionId:String,page:Int,count:Int,findUserConsummtionModelCallBack: FindUserConsummtionModelCallBack)
        interface FindUserWalletModelCallBack{
            fun seccess(findUserWalletEntity: FindUserWalletEntity)
            fun failur(throwable: Throwable)
        }
        interface FindUserConsummtionModelCallBack{
            fun seccess(findUserConsumption: FindUserConsumption)
            fun failur(throwable: Throwable)
        }
    }

    interface IView:IBaseView{
        fun findUserWalletSeccess(findUserWalletEntity: FindUserWalletEntity)
        fun findUserWalletFailur(throwable: Throwable)
        fun findUserConsummtionSeccess(findUserConsumption: FindUserConsumption)
        fun findUserConsummtionFailur(throwable: Throwable)
    }
    interface IPresenter{
        fun findUserWallet(userId:Int,sessionId:String)
        fun findUserConsummtion(userId:Int,sessionId:String,page:Int,count:Int)
    }
}