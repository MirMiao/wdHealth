package com.wd.health.model

import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contract.YaoPinXiangQingContart
import com.wd.health.entity.YaoPinXiangQingEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class YaoPinXiangQingModel:YaoPinXiangQingContart.YaoPinXiangQingM {
    override fun YaoPinXiangQingA(
        id: Int,
        yaoPinXiangQingCallBack: YaoPinXiangQingContart.YaoPinXiangQingM.YaoPinXiangQingCallBack
    ) {
        RetrofitUtils.createService().getYaoPinXiangQing(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                yaopinxiangqingEntity: YaoPinXiangQingEntity -> let {
                yaoPinXiangQingCallBack.YaoPinXiangQingsuccess(yaopinxiangqingEntity)
            }
            },{
                yaopinxiangqingt: Throwable -> let {
                yaoPinXiangQingCallBack.YaoPinXiangQingfaliur(yaopinxiangqingt)
            }
            })
    }
}