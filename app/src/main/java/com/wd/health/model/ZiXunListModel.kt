package com.wd.health.model

import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contract.ZiXunListContacr
import com.wd.health.entity.ZiXunListEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ZiXunListModel:ZiXunListContacr.ZiXunListM{
    override fun ZiXunListA(
        plateId: Int,
        page: Int,
        count: Int,
        ziXunListCallBack: ZiXunListContacr.ZiXunListM.ZiXunListCallBack
    ) {
        RetrofitUtils.createService().getZiXunList(plateId,page,count)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                zixunlist:ZiXunListEntity->ziXunListCallBack.let {
                ziXunListCallBack.zixunlistseccess(zixunlist)
            }
            },{
                zixunlistt: Throwable ->  ziXunListCallBack.let {
                ziXunListCallBack.zixunfailur(zixunlistt)
            }
            })
    }

}