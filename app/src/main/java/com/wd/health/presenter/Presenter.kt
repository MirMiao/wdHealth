package com.wd.health.presenter

import android.content.Context
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contact.BannerContact
import com.wd.health.contract.IContract
import com.wd.health.entity.AEntity
import com.wd.health.entity.BannerEntity
import com.wd.health.model.Model

/**
 * 时间 :2020/5/21  15:31
 * 作者 :苗恒
 * 功能 :
 */
class Presenter: BasePresenter<IContract.IView>,IContract.IPresenter{
     var context:Context?
    var model:Model?=null;
     constructor(context: Context){
       this.context=context
         //创建一个model对象
          model=Model()
     }
    override fun getA() {
       model?.getA(object :IContract.IModel.ModelCallBack{
           override fun seccess(o: AEntity) {
               view?.seccess(o)
           }

           override fun failur(throwable: Throwable) {
               view?.failur(throwable)
           }

       })
    }

}