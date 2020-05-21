package com.wd.health.base.mvp

/**
 * 时间 :2020/5/21  14:48
 * 作者 :苗恒
 * 功能 :
 */
interface IBasePresenter {
      //在Activity创建时提供一个view对象（view即是Activity）
    fun attachView(view:IBaseView);
    //在Activity销毁时清除view对象，防止内存泄露
    fun deatchView();
}