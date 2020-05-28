package com.wd.health.model.usermode

import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contract.usercontract.UserHomeContract
import com.wd.health.entity.userentity.FindUserNoticeReadNumEntity
import com.wd.health.entity.userentity.FindUserSignToadyEntity
import com.wd.health.entity.userentity.UserAddSignEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 时间 :2020/5/28  15:05
 * 作者 :苗恒
 * 功能 :
 */
class UserHomeModel:UserHomeContract.IModel {
    //查询用户当前是否签到
    override fun findUserSignToday(
        userId: Int,
        sessionId: String,
        findUserSignTodayModelCallBack: UserHomeContract.IModel.FindUserSignTodayModelCallBack
    ) {
        RetrofitUtils.createService().findUserSignToday(userId,sessionId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    t: FindUserSignToadyEntity ->
                  findUserSignTodayModelCallBack.let {
                      findUserSignTodayModelCallBack.seccess(t)
                  }
            },{
                t: Throwable -> findUserSignTodayModelCallBack.let {
                  findUserSignTodayModelCallBack.failur(t)
            }
            })
    }
      //用户签到
    override fun addUserSign(
        userId: Int,
        sessionId: String,
        addUserSignModelCallBack: UserHomeContract.IModel.AddUserSignModelCallBack
    ) {
          RetrofitUtils.createService().addUserSign(userId,sessionId)
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe({
                  t: UserAddSignEntity ->
                  addUserSignModelCallBack.let {
                      addUserSignModelCallBack.seccess(t)
                  }
              },{

                t: Throwable  ->
                  addUserSignModelCallBack.let {
                      addUserSignModelCallBack.failur(t)
                  }
              })
    }
     //查询用户的未读消息
    override fun findUserNoticeReadNum(
        userId: Int,
        sessionId: String,
        findUserNoticeReadNumModelCallBack: UserHomeContract.IModel.FindUserNoticeReadNumModelCallBack
    ) {
         RetrofitUtils.createService().findUserNoticeReadNum(userId,sessionId)
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe({
                 t: FindUserNoticeReadNumEntity ->
                 findUserNoticeReadNumModelCallBack.let {
                     findUserNoticeReadNumModelCallBack.seccess(t)
                 }
             },{
                 t: Throwable ->
                 findUserNoticeReadNumModelCallBack.let {
                 findUserNoticeReadNumModelCallBack.failur(t)
             }
             })
    }
}