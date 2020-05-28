package com.wd.health.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.wd.health.R
import com.wd.health.adapter.ZiXunRecyAdapter
import com.wd.health.base.BaseActivity
import com.wd.health.contract.ZiXunListContacr
import com.wd.health.entity.ZiXunListEntity
import com.wd.health.presenter.ZiXunListPresenter
import kotlinx.android.synthetic.main.activity_zi_xun.*

class ZiXunActivity : BaseActivity<ZiXunListPresenter>(),ZiXunListContacr.ZiXunListV {

    override fun onLoadPresenter(): ZiXunListPresenter {
        return ZiXunListPresenter(this)
    }

    override fun initListener(savedInstanceState: Bundle?) {
        zixun_toux.setOnClickListener({})

        zixun_recy.layoutManager=LinearLayoutManager(this)


    }

    override fun initData() {

        var bundle=this.intent.extras
        val int = bundle?.getInt("f")
        mPresenter.ZiXunListA(int!!,1,5)
    }

    override fun layoutId(): Int {
        return R.layout.activity_zi_xun
    }

    override fun zixunlistseccess(ziXunListEntity: ZiXunListEntity) {
        val ziXunRecyAdapter=ZiXunRecyAdapter(this,ziXunListEntity.result)
        zixun_recy.adapter=ziXunRecyAdapter
    }

    override fun zixunfailur(throwable: Throwable) {

    }
}
