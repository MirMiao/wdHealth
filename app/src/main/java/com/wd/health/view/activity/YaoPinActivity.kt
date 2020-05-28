package com.wd.health.view.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.health.R
import com.wd.health.adapter.MyKeShiPagerAdapter
import com.wd.health.adapter.MyYaoPinPagerAdapter
import com.wd.health.base.BaseActivity
import com.wd.health.contract.YaoPinContact
import com.wd.health.entity.BingZhengResult
import com.wd.health.entity.YaoPinListEntity
import com.wd.health.presenter.YaoPinPresenter
import kotlinx.android.synthetic.main.activity_bing_zheng.*
import kotlinx.android.synthetic.main.activity_yao_pin.*

//常见药品

class YaoPinActivity : BaseActivity<YaoPinPresenter>(),YaoPinContact.YaoPinV {

    override fun onLoadPresenter(): YaoPinPresenter {
        return YaoPinPresenter(this)
    }

    override fun initListener(savedInstanceState: Bundle?) {
        yao_bingzheng.setOnClickListener({startActivity(Intent(this,BingZhengActivity::class.java))})

        val myyaopinpager: MyYaoPinPagerAdapter = MyYaoPinPagerAdapter(supportFragmentManager)
        yao_vp.adapter=myyaopinpager
        yao_tab.setupWithViewPager(yao_vp)

    }

    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.activity_yao_pin
    }

    override fun YaoPinseccess(yaoPinListEntity: YaoPinListEntity) {

    }

    override fun YaoPinFailur(throwable: Throwable) {

    }
}
