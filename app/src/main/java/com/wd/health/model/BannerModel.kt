package com.wd.health.model
import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contact.BannerContact
import com.wd.health.entity.BannerEntity
import com.wd.health.entity.KeShiEntity
import com.wd.health.entity.ZiXunEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BannerModel:BannerContact.BannerM {
    override fun BannerA(bannerCallBack: BannerContact.BannerM.BannerCallBack) {
        RetrofitUtils.createService().getBanner()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                bannerbean: BannerEntity ->  bannerCallBack.let{
                bannerCallBack.seccess(bannerbean)
            }
            },{
                t: Throwable ->  bannerCallBack.let{
                bannerCallBack.failur(t)
            }
            })

    }
    //科室列表
    override fun KeShiA(keShiCallBack: BannerContact.BannerM.KeShiCallBack) {
        RetrofitUtils.createService().getKeShiList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                keshiEntity:KeShiEntity->keShiCallBack.let {
                keShiCallBack.keshiseccess(keshiEntity)
            }
            },{
                keshit: Throwable -> keShiCallBack.let {
                keShiCallBack.keshifailur(keshit)
            }
            })
    }

    //健康咨询板块
    override fun ZiXunA(ziXunCallBack: BannerContact.BannerM.ZiXunCallBack) {
        RetrofitUtils.createService().getZiXun()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                zixunEntity:ZiXunEntity->ziXunCallBack.let {
                ziXunCallBack.zixunseccess(zixunEntity)
            }
            },{
                zixunt: Throwable ->ziXunCallBack.let {
                ziXunCallBack.zixunfailur(zixunt)
            }
            })
    }
}