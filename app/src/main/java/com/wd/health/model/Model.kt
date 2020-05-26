package com.wd.health.model


import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.contract.IContract
import com.wd.health.entity.AEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 时间 :2020/5/21  15:29
 * 作者 :苗恒
 * 功能 :
 */
class Model:IContract.IModel {
    override fun getA(modelCallBack: IContract.IModel.ModelCallBack) {
      RetrofitUtils.createService().getA()
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
              aEntity: AEntity ->modelCallBack.let{
               modelCallBack.seccess(aEntity)
          }
          },{
              error:Throwable ->modelCallBack.let {
              modelCallBack.failur(error)
          }
          });


    }

}