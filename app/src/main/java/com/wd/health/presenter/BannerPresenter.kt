package com.wd.health.presenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contact.BannerContact
import com.wd.health.entity.BannerEntity
import com.wd.health.entity.KeShiEntity
import com.wd.health.entity.ZiXunEntity
import com.wd.health.model.BannerModel

class BannerPresenter: BasePresenter<BannerContact.BannerV>,BannerContact.BannerP {
    var model:BannerModel
    var context:Context
    constructor(context: Context){
        this.context=context
        model= BannerModel()
    }
    override fun BannerA() {
        model?.BannerA(object :BannerContact.BannerM.BannerCallBack{
            override fun seccess(bannerBean: BannerEntity) {
                view?.seccess(bannerBean)
            }

            override fun failur(throwable: Throwable) {
                view?.failur(throwable)
            }

        })
    }

    override fun KeShiA() {
        model?.KeShiA(object :BannerContact.BannerM.KeShiCallBack{
            override fun keshiseccess(keShiEntity: KeShiEntity) {
                view?.keshiseccess(keShiEntity)
            }

            override fun keshifailur(throwable: Throwable) {
                view?.keshifailur(throwable)
            }

        })
    }

    override fun ZixunA() {
        model?.ZiXunA(object :BannerContact.BannerM.ZiXunCallBack{
            override fun zixunseccess(ziXunEntity: ZiXunEntity) {
                view?.zixunseccess(ziXunEntity)
            }

            override fun zixunfailur(throwable: Throwable) {
                view?.zixunfailur(throwable)
            }

        })
    }
}