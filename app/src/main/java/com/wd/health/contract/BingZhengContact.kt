package com.wd.health.contract

import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBasePresenter
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.BingZhengEntity

interface BingZhengContact {

    interface BingZhengM:IBaseModel{
        //根据科室查询对应病症
        fun BingZhengA(departmentId:Int,bingZhengCallBack: BingZhengCallBack)
        interface BingZhengCallBack{
            fun bingzhengseccess(bingZhengEntity: BingZhengEntity)
            fun bingzhengfailur(throwable: Throwable)
        }


    }

    interface BingZhengV:IBaseView{
        //根据科室查询对应病症
        fun bingzhengseccess(bingZhengEntity: BingZhengEntity)
        fun bingzhengfailur(throwable: Throwable)
    }

    interface BingZhengP:IBasePresenter{
        //根据科室查询对应病症
        fun BingZhengA(departmentId:Int)
    }


}