package com.wd.health.contract

import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBasePresenter
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.YaoPinListEntity

interface YaoPinContact {

    interface YaoPinM:IBaseModel{
        fun YaoPinA(drugsCategoryId:Int,page:Int,count:Int,yaoPinCallBack: YaoPinCallBack)
        interface YaoPinCallBack{
            fun YaoPinseccess(yaoPinListEntity: YaoPinListEntity)
            fun YaoPinFailur(throwable: Throwable)
        }
    }

    interface YaoPinV:IBaseView{
        fun YaoPinseccess(yaoPinListEntity: YaoPinListEntity)
        fun YaoPinFailur(throwable: Throwable)
    }

    interface YaoPinP:IBasePresenter{
        fun YaoPinA(drugsCategoryId:Int,page:Int,count:Int)
    }

}