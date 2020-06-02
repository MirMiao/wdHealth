package com.wd.health.contract.usercontract

import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.userentity.*

/**
 * 时间 :2020/5/28  14:55
 * 作者 :苗恒
 * 功能 :  用户首页
 */
interface UserHomeContract {
    interface IModel: IBaseModel {
        fun findUserSignToday(userId:Int,sessionId:String,findUserSignTodayModelCallBack: FindUserSignTodayModelCallBack);//查询是否签到
        fun addUserSign(userId:Int,sessionId:String,addUserSignModelCallBack: AddUserSignModelCallBack)//用户签到
        fun findUserNoticeReadNum(userId:Int,sessionId:String,findUserNoticeReadNumModelCallBack: FindUserNoticeReadNumModelCallBack)//查看用户未读消息

        interface FindUserSignTodayModelCallBack{
            fun seccess(findUserSignToadyEntity: FindUserSignToadyEntity)
            fun failur(throwable: Throwable)
        }
        interface AddUserSignModelCallBack{
            fun seccess(userAddSignEntity: UserAddSignEntity)
            fun failur(throwable: Throwable)
        }
          interface FindUserNoticeReadNumModelCallBack{
            fun seccess(findUserNoticeReadNumEntity: FindUserNoticeReadNumEntity)
            fun failur(throwable: Throwable)
        }

    }

    interface IView: IBaseView {
        fun findUserSignTodaySeccess(findUserSignToadyEntity: FindUserSignToadyEntity)
        fun findUserSignTodayFailur(throwable: Throwable)
        fun addUserSignSeccess(userAddSignEntity: UserAddSignEntity)
        fun addUserSignFailur(throwable: Throwable)
        fun findUserNoticeReadNumSeccess(findUserNoticeReadNumEntity: FindUserNoticeReadNumEntity)
        fun findUserNoticeReadNumFailur(throwable: Throwable)
    }
    interface IPresenter{
        fun findUserSignToday(userId:Int,sessionId:String);//查询是否签到
        fun addUserSign(userId:Int,sessionId:String)//用户签到
        fun findUserNoticeReadNum(userId:Int,sessionId:String)//查看用户未读消息
    }
}