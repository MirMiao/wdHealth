package com.bw.doctor.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.base.mvp.IBaseView
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.toast

/**
 * @ClassName: BaseFragment
 * @Description: Java类的作用
 * @Author: LazyRui
 * @CreateDate: 2020/5/19 10:55
 */
abstract class BaseFragment<P: BasePresenter<*>> : Fragment() , IBaseView {
    lateinit var mPresenter: P
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }
    protected fun init() {
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //获取Presenter对象
        mPresenter = onLoadPresenter()
        mPresenter?.attachView(this)
        return initView()
    }
    abstract fun onLoadPresenter(): P
    abstract fun initView(): View?
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener(savedInstanceState)
        initData()
    }
    abstract fun initListener(savedInstanceState: Bundle?)
    abstract fun initData()

    /**
     * toast
     */
    protected fun myToast(msg: String) {
        context?.runOnUiThread { toast(msg) }
    }

}