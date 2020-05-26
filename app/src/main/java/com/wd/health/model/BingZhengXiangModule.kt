package com.wd.health.model

import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contract.BingZhengXiangQingContact
import com.wd.health.entity.BingZhengXiangQingEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BingZhengXiangModule:BingZhengXiangQingContact.BingZhengXiangQingM {
    override fun BingZhengXiangQingA(
        id: Int,
        bingZhengXiangQingCallBack: BingZhengXiangQingContact.BingZhengXiangQingM.BingZhengXiangQingCallBack
    ) {
        RetrofitUtils.createService().getBingZhengXiangQing(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                bingzhengxiangqing:BingZhengXiangQingEntity->bingZhengXiangQingCallBack.let {
                bingZhengXiangQingCallBack.BingZhengXiangQingseccess(bingzhengxiangqing)
            }
            },{
                bingzhengxiangqingt: Throwable ->  bingZhengXiangQingCallBack.let {
                bingZhengXiangQingCallBack.BingZhengXiangQingfailur(bingzhengxiangqingt)
            }
            })
    }
}