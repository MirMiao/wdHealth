package com.wd.health.contract

import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBasePresenter
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.ZiXunListEntity

interface ZiXunListContacr {

    interface ZiXunListM:IBaseModel{
        fun ZiXunListA(plateId:Int,page:Int,count:Int,ziXunListCallBack:ZiXunListCallBack)
        interface ZiXunListCallBack{
            fun zixunlistseccess(ziXunListEntity: ZiXunListEntity)
            fun zixunfailur(throwable: Throwable)
        }
    }

    interface ZiXunListV:IBaseView{
        fun zixunlistseccess(ziXunListEntity: ZiXunListEntity)
        fun zixunfailur(throwable: Throwable)
    }

    interface ZiXunListP{
        fun ZiXunListA(plateId:Int,page:Int,count:Int)
    }

}