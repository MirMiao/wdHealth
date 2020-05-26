package com.wd.health.presenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contract.ZiXunListContacr
import com.wd.health.entity.ZiXunListEntity
import com.wd.health.model.BannerModel
import com.wd.health.model.ZiXunListModel

class ZiXunListPresenter:BasePresenter<ZiXunListContacr.ZiXunListV>,ZiXunListContacr.ZiXunListP {
    var model: ZiXunListModel
    var context: Context
    constructor(context: Context){
        this.context=context
        model= ZiXunListModel()
    }
    override fun ZiXunListA(plateId: Int, page: Int, count: Int) {
        model?.ZiXunListA(plateId,page,count,object :ZiXunListContacr.ZiXunListM.ZiXunListCallBack{
            override fun zixunlistseccess(ziXunListEntity: ZiXunListEntity) {
                view?.zixunlistseccess(ziXunListEntity)
            }

            override fun zixunfailur(throwable: Throwable) {
                view?.zixunfailur(throwable)
            }

        })
    }


}