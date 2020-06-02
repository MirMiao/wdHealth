package com.wd.health.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.health.R
import com.wd.health.adapter.MyWenZhenPagerAdapter
import com.wd.health.base.BaseActivity
import com.wd.health.contact.BannerContact
import com.wd.health.contract.WenZhenYiShengContart
import com.wd.health.entity.*
import com.wd.health.presenter.BannerPresenter
import com.wd.health.presenter.WenZhenYiShengPresenter
import kotlinx.android.synthetic.main.activity_wen_zhen.*
import org.greenrobot.eventbus.EventBus

class WenZhenActivity : BaseActivity<WenZhenYiShengPresenter>(),WenZhenYiShengContart.WenZhenYiShengV {

    override fun onLoadPresenter(): WenZhenYiShengPresenter {
        return WenZhenYiShengPresenter(this)
    }

    override fun initListener(savedInstanceState: Bundle?) {
        val myWenZhenPagerAdapter:MyWenZhenPagerAdapter=MyWenZhenPagerAdapter(supportFragmentManager)
        wenzhen_vp_keshi.adapter=myWenZhenPagerAdapter
        wenzhen_tab_keshi.setupWithViewPager(wenzhen_vp_keshi)

    }

    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.activity_wen_zhen
    }
    override fun WenZhenYiShengseccess(wenZhenYiShengEntity: WenZhenYiShengEntity) {

    }

    override fun WenZhenYiShengfaliur(throwable: Throwable) {

    }

    override fun WenZhenYiShengXiangQingseccess(wenZhenYiShengXiangQingEntity: WenZhenYiShengXiangQingEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun WenZhenYiShengXiangQingfaliur(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
