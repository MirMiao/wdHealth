package com.wd.health.presenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contract.BingZhengContact
import com.wd.health.entity.BingZhengEntity
import com.wd.health.model.BingZhengModule
import com.wd.health.model.ZiXunListModel

class BingZhengPresenter:BasePresenter<BingZhengContact.BingZhengV>,BingZhengContact.BingZhengP {
    var model: BingZhengModule
    var context: Context
    constructor(context: Context){
        this.context=context
        model= BingZhengModule()
    }

    //根据科室查询对应病症
    override fun BingZhengA(departmentId: Int) {
        model?.BingZhengA(departmentId,object :BingZhengContact.BingZhengM.BingZhengCallBack{
            override fun bingzhengseccess(bingZhengEntity: BingZhengEntity) {
                view?.bingzhengseccess(bingZhengEntity)
            }

            override fun bingzhengfailur(throwable: Throwable) {
                view?.bingzhengfailur(throwable)
            }
        })
    }



}