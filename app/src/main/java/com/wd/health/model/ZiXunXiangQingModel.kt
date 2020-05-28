package com.wd.health.model

import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contract.ZiXunXiangQingContart
import com.wd.health.entity.ZiXunXiangQingEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ZiXunXiangQingModel:ZiXunXiangQingContart.ZiXunXiangQingM {
    override fun ZiXunXiangQingA(
        infoId: Int,
        ziXunXiangQingCallBack: ZiXunXiangQingContart.ZiXunXiangQingM.ZiXunXiangQingCallBack
    ) {
        RetrofitUtils.createService().getZiXunXiagQing(infoId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                zixunxiangqing:ZiXunXiangQingEntity->let {
                ziXunXiangQingCallBack.ZiXunXiangQingseccess(zixunxiangqing)
            }
            },{
                zixunxiangqingt: Throwable ->  let {
                ziXunXiangQingCallBack.ZiXunXiangQingfaliur(zixunxiangqingt)
            }
            })
    }
}