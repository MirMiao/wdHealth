package com.wd.health.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.health.R
import com.wd.health.base.BaseActivity
import com.wd.health.contract.IContract
import com.wd.health.entity.AEntity
import com.wd.health.presenter.Presenter
import org.jetbrains.anko.toast

class MainActivity : BaseActivity<Presenter>(),IContract.IView {
    override fun onLoadPresenter(): Presenter {
        return Presenter(this)
    }
    override fun initListener(savedInstanceState: Bundle?) {
    }
    override fun initData() {
        mPresenter.getA()
    }

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun seccess(o: AEntity) {
        toast(o.message)
    }

    override fun failur(throwable: Throwable) {
    }


}
