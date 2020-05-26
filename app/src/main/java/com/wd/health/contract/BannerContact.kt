package com.wd.health.contact
import com.wd.health.base.mvp.IBaseModel
import com.wd.health.base.mvp.IBaseView
import com.wd.health.entity.BannerEntity
import com.wd.health.entity.KeShiEntity
import com.wd.health.entity.ZiXunEntity

interface BannerContact {

    interface BannerM: IBaseModel {
        fun BannerA(bannerCallBack: BannerCallBack)
        interface BannerCallBack{
            fun seccess(bannerBean: BannerEntity)
            fun failur(throwable: Throwable)
        }
        //科室列表
        fun KeShiA(keShiCallBack: KeShiCallBack)
        interface KeShiCallBack{
            fun keshiseccess(keShiEntity: KeShiEntity)
            fun keshifailur(throwable: Throwable)
        }
        //健康咨询板块
        fun ZiXunA(ziXunCallBack: ZiXunCallBack)
        interface ZiXunCallBack{
            fun zixunseccess(ziXunEntity: ZiXunEntity)
            fun zixunfailur(throwable: Throwable)
        }
    }

    interface BannerV: IBaseView {
        fun seccess(bannerBean: BannerEntity)
        fun failur(throwable: Throwable)
        //科室列表
        fun keshiseccess(keShiEntity: KeShiEntity)
        fun keshifailur(throwable: Throwable)
        //健康咨询板块
        fun zixunseccess(ziXunEntity: ZiXunEntity)
        fun zixunfailur(throwable: Throwable)
    }

    interface BannerP{
        fun BannerA()
        //科室列表
        fun KeShiA()
        //健康咨询板块
        fun ZixunA()
    }

}