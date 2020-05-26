package com.wd.health.view.activity

import android.content.Intent
import android.os.Bundle
import com.wd.health.R
import com.wd.health.adapter.MyKeShiPagerAdapter
import com.wd.health.base.BaseActivity
import com.wd.health.contract.BingZhengContact
import com.wd.health.entity.BingZhengEntity
import com.wd.health.presenter.BingZhengPresenter
import kotlinx.android.synthetic.main.activity_bing_zheng.*
//常见病症
class BingZhengActivity : BaseActivity<BingZhengPresenter>(),BingZhengContact.BingZhengV {

    override fun onLoadPresenter(): BingZhengPresenter {
        return BingZhengPresenter(this)
    }

    override fun initListener(savedInstanceState: Bundle?) {

        yaowu.setOnClickListener({startActivity(Intent(this,YaoPinActivity::class.java))})

        val myKeShipager:MyKeShiPagerAdapter= MyKeShiPagerAdapter(supportFragmentManager)
        bingzheng_vp.adapter=myKeShipager
        bingzheng_tab.setupWithViewPager(bingzheng_vp)

    }

    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.activity_bing_zheng
    }

    override fun bingzhengseccess(bingZhengEntity: BingZhengEntity) {

    }

    override fun bingzhengfailur(throwable: Throwable) {

    }
}
