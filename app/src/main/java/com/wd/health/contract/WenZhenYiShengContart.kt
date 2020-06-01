package com.wd.health.contract

import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBasePresenter
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.WenZhenYiShengEntity
import com.wd.health.entity.WenZhenYiShengXiangQingEntity

interface WenZhenYiShengContart {

    interface WenZhenYiShengM:IBaseModel{
        fun WenZhenYiShengA(deptId:Int,condition:Int,sortBy:Int,page:Int,count:Int,wenZhenYiShengCallBack: WenZhenYiShengCallBack)
        interface WenZhenYiShengCallBack{
            fun WenZhenYiShengseccess(wenZhenYiShengEntity: WenZhenYiShengEntity)
            fun WenZhenYiShengfaliur(throwable: Throwable)
        }

        fun WenZhenYiShengXiangQingA(doctorId:Int,wenZhenYiShengXiangQingCallBack: WenZhenYiShengXiangQingCallBack)
        interface WenZhenYiShengXiangQingCallBack{
            fun WenZhenYiShengXiangQingseccess(wenZhenYiShengXiangQingEntity: WenZhenYiShengXiangQingEntity)
            fun WenZhenYiShengXiangQingfaliur(throwable: Throwable)
        }

    }

    interface WenZhenYiShengV:IBaseView{
        fun WenZhenYiShengseccess(wenZhenYiShengEntity: WenZhenYiShengEntity)
        fun WenZhenYiShengfaliur(throwable: Throwable)

        fun WenZhenYiShengXiangQingseccess(wenZhenYiShengXiangQingEntity: WenZhenYiShengXiangQingEntity)
        fun WenZhenYiShengXiangQingfaliur(throwable: Throwable)

    }

    interface WenZhenYiShengP:IBasePresenter{
        fun WenZhenYiShengA(deptId:Int,condition:Int,sortBy:Int,page:Int,count:Int)

        fun WenZhenYiShengXiangQingA(doctorId:Int)
    }

}