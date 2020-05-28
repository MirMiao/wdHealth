package com.wd.health.presenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contract.BingZhengXiangQingContact
import com.wd.health.entity.BingZhengXiangQingEntity
import com.wd.health.model.BingZhengModule
import com.wd.health.model.BingZhengXiangModule

class BingZhengXiangQingPresenter:BasePresenter<BingZhengXiangQingContact.BingZhengXiangQingV>,BingZhengXiangQingContact.BingZhengXiangQingP {

    var model: BingZhengXiangModule
    var context: Context
    constructor(context: Context){
        this.context=context
        model= BingZhengXiangModule()
    }

    override fun BingZhengXiangQingA(id: Int) {
        model?.BingZhengXiangQingA(id,object :BingZhengXiangQingContact.BingZhengXiangQingM.BingZhengXiangQingCallBack{
            override fun BingZhengXiangQingseccess(bingZhengXiangQingEntity: BingZhengXiangQingEntity) {
                view?.BingZhengXiangQingseccess(bingZhengXiangQingEntity)
            }

            override fun BingZhengXiangQingfailur(throwable: Throwable) {
                view?.BingZhengXiangQingfailur(throwable)
            }

        })
    }
}