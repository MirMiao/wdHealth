package com.wd.health.model

import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contract.YaoPinContact
import com.wd.health.entity.YaoPinListEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class YaoPinModule:YaoPinContact.YaoPinM {
    override fun YaoPinA(
        drugsCategoryId: Int,
        page: Int,
        count: Int,
        yaoPinCallBack: YaoPinContact.YaoPinM.YaoPinCallBack
    ) {
        RetrofitUtils.createService().getYaoPinList(drugsCategoryId,page,count)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                yaopinlistEntity: YaoPinListEntity ->  yaoPinCallBack.let {
                yaoPinCallBack.YaoPinseccess(yaopinlistEntity)
            }
            },{
                yaopinlistt: Throwable ->  yaoPinCallBack.let {
                yaoPinCallBack.YaoPinFailur(yaopinlistt)
            }
            })
    }
}