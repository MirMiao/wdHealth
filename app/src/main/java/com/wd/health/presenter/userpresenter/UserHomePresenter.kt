package com.wd.health.presenter.userpresenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contract.usercontract.UserHomeContract
import com.wd.health.entity.userentity.FindUserNoticeReadNumEntity
import com.wd.health.entity.userentity.FindUserSignToadyEntity
import com.wd.health.entity.userentity.UserAddSignEntity
import com.wd.health.model.usermode.UserHomeModel
import com.wd.health.model.usermode.WalletModel

/**
 * 时间 :2020/5/28  15:13
 * 作者 :苗恒
 * 功能 :  用户首页
 */
class UserHomePresenter:BasePresenter<UserHomeContract.IView>,UserHomeContract.IPresenter {
    var context: Context
    var userHomeModel:UserHomeModel
    constructor(context: Context){
        this.context=context
        this.userHomeModel= UserHomeModel()
    }
    //查看用户是否签到
    override fun findUserSignToday(userId: Int, sessionId: String) {
        userHomeModel.findUserSignToday(userId,sessionId,object :UserHomeContract.IModel.FindUserSignTodayModelCallBack{
            override fun seccess(findUserSignToadyEntity: FindUserSignToadyEntity) {
                view?.findUserSignTodaySeccess(findUserSignToadyEntity)
            }

            override fun failur(throwable: Throwable) {
                view?.findUserSignTodayFailur(throwable)
            }

        })
    }
     //签到
    override fun addUserSign(userId: Int, sessionId: String) {
         userHomeModel.addUserSign(userId,sessionId,object :UserHomeContract.IModel.AddUserSignModelCallBack{
             override fun seccess(userAddSignEntity: UserAddSignEntity) {
                 view?.addUserSignSeccess(userAddSignEntity)
             }

             override fun failur(throwable: Throwable) {
                 view?.addUserSignFailur(throwable)
             }

         })
    }
    //查询未读列表
    override fun findUserNoticeReadNum(userId: Int, sessionId: String) {
          userHomeModel.findUserNoticeReadNum(userId,sessionId,object :UserHomeContract.IModel.FindUserNoticeReadNumModelCallBack{
              override fun seccess(findUserNoticeReadNumEntity: FindUserNoticeReadNumEntity) {
                 view?.findUserNoticeReadNumSeccess(findUserNoticeReadNumEntity)
              }

              override fun failur(throwable: Throwable) {
                  view?.findUserNoticeReadNumFailur(throwable)
              }

          })
    }

}