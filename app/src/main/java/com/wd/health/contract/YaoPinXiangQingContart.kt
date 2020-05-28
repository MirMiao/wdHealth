package com.wd.health.contract

import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBasePresenter
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.YaoPinXiangQingEntity

interface YaoPinXiangQingContart {

    interface YaoPinXiangQingM:IBaseModel{
        fun YaoPinXiangQingA(id:Int,yaoPinXiangQingCallBack: YaoPinXiangQingCallBack)
        interface YaoPinXiangQingCallBack{
            fun YaoPinXiangQingsuccess(yaoPinXiangQingEntity: YaoPinXiangQingEntity)
            fun YaoPinXiangQingfaliur(throwable: Throwable)
        }
    }

    interface YaoPinXiangQingV:IBaseView{
        fun YaoPinXiangQingsuccess(yaoPinXiangQingEntity: YaoPinXiangQingEntity)
        fun YaoPinXiangQingfaliur(throwable: Throwable)
    }

    interface YaoPinXiangQingP:IBasePresenter{
        fun YaoPinXiangQingA(id:Int)
    }

}