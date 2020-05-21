package com.wd.health.base.mvp

/**
 * 时间 :2020/5/21  14:29
 * 作者 :苗恒
 * 功能 :
 */
abstract class BasePresenter<V:IBaseView>:IBasePresenter {
    var view:V?=null
    override fun attachView(view:IBaseView){
        this.view=view as V
    }
    override fun deatchView(){
        view=null
    }
}