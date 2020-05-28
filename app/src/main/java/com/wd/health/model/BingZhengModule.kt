package com.wd.health.model

import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contract.BingZhengContact
import com.wd.health.entity.BingZhengEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BingZhengModule :BingZhengContact.BingZhengM{
    //根据科室查询对应病症
    override fun BingZhengA(
        departmentId: Int,
        bingZhengCallBack: BingZhengContact.BingZhengM.BingZhengCallBack
    ) {
        RetrofitUtils.createService().getBingZheng(departmentId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                bingzhengEntity:BingZhengEntity->bingZhengCallBack.let {
                bingZhengCallBack.bingzhengseccess(bingzhengEntity)
            }
            },{
                bingzhengt: Throwable ->  bingZhengCallBack.let {
                bingZhengCallBack.bingzhengfailur(bingzhengt)
            }
            })
    }


}