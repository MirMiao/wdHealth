package com.wd.health.presenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contract.ZiXunListContacr
import com.wd.health.contract.ZiXunXiangQingContart
import com.wd.health.entity.ZiXunXiangQingEntity
import com.wd.health.model.ZiXunListModel
import com.wd.health.model.ZiXunXiangQingModel

class ZiXunXiangQingPresenter:BasePresenter<ZiXunXiangQingContart.ZiXunXiangQingV>,ZiXunXiangQingContart.ZiXunXiangQingP {

    var model: ZiXunXiangQingModel
    var context: Context
    constructor(context: Context){
        this.context=context
        model= ZiXunXiangQingModel()
    }

    override fun ZiXunXiangQingA(infoId: Int) {
        model?.ZiXunXiangQingA(infoId,object :ZiXunXiangQingContart.ZiXunXiangQingM.ZiXunXiangQingCallBack{
            override fun ZiXunXiangQingseccess(ziXunXiangQingEntity: ZiXunXiangQingEntity) {
                view?.ZiXunXiangQingseccess(ziXunXiangQingEntity)
            }

            override fun ZiXunXiangQingfaliur(throwable: Throwable) {
                view?.ZiXunXiangQingfaliur(throwable)
            }

        })
    }


}