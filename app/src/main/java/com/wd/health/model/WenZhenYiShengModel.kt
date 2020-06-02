package com.wd.health.model

import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contract.WenZhenYiShengContart
import com.wd.health.entity.WenZhenYiShengEntity
import com.wd.health.entity.WenZhenYiShengXiangQingEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WenZhenYiShengModel:WenZhenYiShengContart.WenZhenYiShengM {
    override fun WenZhenYiShengA(
        deptId: Int,
        condition: Int,
        sortBy: Int,
        page: Int,
        count: Int,
        wenZhenYiShengCallBack: WenZhenYiShengContart.WenZhenYiShengM.WenZhenYiShengCallBack
    ) {
        RetrofitUtils.createService().getWenZhenYiSheng(deptId,condition,sortBy,page,count)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                wenzhenyisheng:WenZhenYiShengEntity->let {
                wenZhenYiShengCallBack.WenZhenYiShengseccess(wenzhenyisheng)
            }
            },{
                wenzhenyishengt: Throwable ->  let {
                wenZhenYiShengCallBack.WenZhenYiShengfaliur(wenzhenyishengt)
            }
            })
    }

    override fun WenZhenYiShengXiangQingA(
        doctorId: Int,
        wenZhenYiShengXiangQingCallBack: WenZhenYiShengContart.WenZhenYiShengM.WenZhenYiShengXiangQingCallBack
    ) {
        RetrofitUtils.createService().getWenZhenYiShengXiangQing(doctorId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                wenzhenyishengxiangqing:WenZhenYiShengXiangQingEntity->let {
                wenZhenYiShengXiangQingCallBack.WenZhenYiShengXiangQingseccess(wenzhenyishengxiangqing)
            }
            },{
                wenzhenyishengxiangqingt: Throwable ->  let {
                wenZhenYiShengXiangQingCallBack.WenZhenYiShengXiangQingfaliur(wenzhenyishengxiangqingt)
            }
            })
    }
}