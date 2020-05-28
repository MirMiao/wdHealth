package com.wd.health.presenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contract.YaoPinContact
import com.wd.health.entity.YaoPinListEntity
import com.wd.health.model.YaoPinModule

class YaoPinPresenter:BasePresenter<YaoPinContact.YaoPinV>,YaoPinContact.YaoPinP {
    var model: YaoPinModule
    var context: Context
    constructor(context: Context){
        this.context=context
        model= YaoPinModule()
    }

    override fun YaoPinA(drugsCategoryId: Int, page: Int, count: Int) {
        model?.YaoPinA(drugsCategoryId,page,count,object :YaoPinContact.YaoPinM.YaoPinCallBack{
            override fun YaoPinseccess(yaoPinListEntity: YaoPinListEntity) {
                view?.YaoPinseccess(yaoPinListEntity)
            }

            override fun YaoPinFailur(throwable: Throwable) {
                view?.YaoPinFailur(throwable)
            }
        })
    }
}