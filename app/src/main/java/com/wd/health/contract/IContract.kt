package com.wd.health.contract

import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.AEntity
import com.wd.health.entity.BannerEntity
import java.util.*

/**
 * 时间 :2020/5/21  15:23
 * 作者 :苗恒
 * 功能 :
 */
interface IContract {
    interface IModel:IBaseModel{

        fun getA(modelCallBack: ModelCallBack)
        interface ModelCallBack{
            fun seccess(o: AEntity)
            fun failur(throwable: Throwable)
        }

    }

    interface IView:IBaseView{
        fun seccess(o: AEntity)
        fun failur(throwable: Throwable)

    }
    interface IPresenter{
        fun getA()


    }



}