package com.wd.health.presenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contract.YaoPinXiangQingContart
import com.wd.health.entity.YaoPinXiangQingEntity
import com.wd.health.model.YaoPinModule
import com.wd.health.model.YaoPinXiangQingModel

class YaoPinXiangQingPresenter:BasePresenter<YaoPinXiangQingContart.YaoPinXiangQingV>,YaoPinXiangQingContart.YaoPinXiangQingP {

    var model: YaoPinXiangQingModel
    var context: Context
    constructor(context: Context){
        this.context=context
        model= YaoPinXiangQingModel()
    }

    override fun YaoPinXiangQingA(id: Int) {
        model?.YaoPinXiangQingA(id,object :YaoPinXiangQingContart.YaoPinXiangQingM.YaoPinXiangQingCallBack{
            override fun YaoPinXiangQingsuccess(yaoPinXiangQingEntity: YaoPinXiangQingEntity) {
                view?.YaoPinXiangQingsuccess(yaoPinXiangQingEntity)
            }

            override fun YaoPinXiangQingfaliur(throwable: Throwable) {
                view?.YaoPinXiangQingfaliur(throwable)
            }

        })
    }
}