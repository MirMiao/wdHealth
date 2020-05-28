package com.wd.health.contract

import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBasePresenter
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.BingZhengXiangQingEntity

interface BingZhengXiangQingContact {

    interface BingZhengXiangQingM:IBaseModel{
        fun BingZhengXiangQingA(id:Int,bingZhengXiangQingCallBack: BingZhengXiangQingCallBack)
        interface BingZhengXiangQingCallBack{
            fun BingZhengXiangQingseccess(bingZhengXiangQingEntity: BingZhengXiangQingEntity)
            fun BingZhengXiangQingfailur(throwable: Throwable)
        }
    }

    interface BingZhengXiangQingV:IBaseView{
        fun BingZhengXiangQingseccess(bingZhengXiangQingEntity: BingZhengXiangQingEntity)
        fun BingZhengXiangQingfailur(throwable: Throwable)
    }

    interface BingZhengXiangQingP:IBasePresenter{
        fun BingZhengXiangQingA(id:Int)
    }

}