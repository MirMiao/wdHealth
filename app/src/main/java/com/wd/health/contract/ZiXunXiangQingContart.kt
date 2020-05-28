package com.wd.health.contract

import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBasePresenter
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.ZiXunXiangQingEntity

interface ZiXunXiangQingContart {

    interface ZiXunXiangQingM:IBaseModel{
        fun ZiXunXiangQingA(infoId:Int,ziXunXiangQingCallBack: ZiXunXiangQingCallBack)
        interface ZiXunXiangQingCallBack{
            fun ZiXunXiangQingseccess(ziXunXiangQingEntity: ZiXunXiangQingEntity)
            fun ZiXunXiangQingfaliur(throwable: Throwable)
        }
    }

    interface ZiXunXiangQingV:IBaseView{
        fun ZiXunXiangQingseccess(ziXunXiangQingEntity: ZiXunXiangQingEntity)
        fun ZiXunXiangQingfaliur(throwable: Throwable)
    }

    interface ZiXunXiangQingP:IBasePresenter{
        fun ZiXunXiangQingA(infoId:Int)
    }

}