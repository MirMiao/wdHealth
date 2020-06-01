package com.wd.health.presenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contract.WenZhenYiShengContart
import com.wd.health.entity.WenZhenYiShengEntity
import com.wd.health.entity.WenZhenYiShengXiangQingEntity
import com.wd.health.model.WenZhenYiShengModel
import com.wd.health.model.YaoPinModule

class WenZhenYiShengPresenter:BasePresenter<WenZhenYiShengContart.WenZhenYiShengV>,WenZhenYiShengContart.WenZhenYiShengP {

    var model: WenZhenYiShengModel
    var context: Context
    constructor(context: Context){
        this.context=context
        model= WenZhenYiShengModel()
    }

    override fun WenZhenYiShengA(deptId: Int, condition: Int, sortBy: Int, page: Int, count: Int) {
       model?.WenZhenYiShengA(deptId,condition,sortBy,page,count,object :WenZhenYiShengContart.WenZhenYiShengM.WenZhenYiShengCallBack{
           override fun WenZhenYiShengseccess(wenZhenYiShengEntity: WenZhenYiShengEntity) {
               view?.WenZhenYiShengseccess(wenZhenYiShengEntity)
           }

           override fun WenZhenYiShengfaliur(throwable: Throwable) {
               view?.WenZhenYiShengfaliur(throwable)
           }

       })
    }

    override fun WenZhenYiShengXiangQingA(doctorId: Int) {
        model?.WenZhenYiShengXiangQingA(doctorId,object :WenZhenYiShengContart.WenZhenYiShengM.WenZhenYiShengXiangQingCallBack{
            override fun WenZhenYiShengXiangQingseccess(wenZhenYiShengXiangQingEntity: WenZhenYiShengXiangQingEntity) {
                view?.WenZhenYiShengXiangQingseccess(wenZhenYiShengXiangQingEntity)
            }

            override fun WenZhenYiShengXiangQingfaliur(throwable: Throwable) {
                view?.WenZhenYiShengXiangQingfaliur(throwable)
            }
        })
    }
}