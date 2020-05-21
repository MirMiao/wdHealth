package com.wd.health.base

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.base.mvp.IBaseView
import org.jetbrains.anko.toast

/**
 * 时间 :2020/5/21  14:28
 * 作者 :苗恒
 * 功能 :
 */
abstract class BaseActivity<P:BasePresenter<*>>:AppCompatActivity(),IBaseView {

    lateinit var mPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())

        //actionBar隐藏
        supportActionBar?.hide()

        //跟随主题半透明
        val window: Window = getWindow()
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)


        //获取Presenter对象
        mPresenter = onLoadPresenter()
        mPresenter?.attachView(this)

        initListener(savedInstanceState)

        initData()

    }

    abstract fun onLoadPresenter(): P


    abstract fun initListener(savedInstanceState: Bundle?)

    /**
     * 初始化数据
     */
    abstract fun initData()


    abstract fun layoutId(): Int


    protected fun myToast(msg: String) {
        runOnUiThread { toast(msg) }
    }
}