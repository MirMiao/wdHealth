package com.wd.health.view.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.bigkoo.convenientbanner.ConvenientBanner
import com.bw.doctor.base.BaseFragment
import com.wd.health.R
import com.wd.health.adapter.MyPagerAdapter
import com.wd.health.contact.BannerContact
import com.wd.health.entity.BannerEntity
import com.wd.health.entity.KeShiEntity
import com.wd.health.entity.ZiXunEntity
import com.wd.health.presenter.BannerPresenter
import com.wd.health.view.activity.BingZhengActivity
import com.wd.health.view.activity.SousuoActivity
import com.wd.health.view.activity.YaoPinActivity
import com.wd.health.view.activity.ZiXunActivity
import com.wd.health.weight.BannerImageHolderView
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * 时间 :2020/5/22  22:24
 * 作者 :苗恒
 * 功能 :
 */
class HomeFragment: BaseFragment<BannerPresenter>(),BannerContact.BannerV{
    override fun onLoadPresenter(): BannerPresenter {
        return BannerPresenter(context!!)
    }

    override fun initView(): View? {
        val inflate = LayoutInflater.from(context).inflate(R.layout.fragment_home, null)
        return inflate
    }

    override fun initListener(savedInstanceState: Bundle?) {
        home_toux.setOnClickListener {  }

        home_sousuo.setOnClickListener({startActivity(Intent(context,SousuoActivity::class.java))})
        home_bing.setOnClickListener ({startActivity(Intent(context,BingZhengActivity::class.java))})
        home_yao.setOnClickListener({startActivity(Intent(context,YaoPinActivity::class.java))})
        home_quzixun.setOnClickListener({startActivity(Intent(context,ZiXunActivity::class.java))})

        home_recy_wenzhen.layoutManager=GridLayoutManager(context,4)


        val mypagerAdapter: MyPagerAdapter =MyPagerAdapter(childFragmentManager)
        zixun_viewPager.adapter=mypagerAdapter
        zixun_tab.setupWithViewPager(zixun_viewPager)

        var home_banne:ConvenientBanner<Int>


    }

    override fun initData() {
        mPresenter.BannerA()
        mPresenter.KeShiA()
        mPresenter.ZixunA()
    }

    override fun seccess(bannerBean: BannerEntity) {
        val result = bannerBean.result
        /*home_banner.setPages(CBViewHolderCreator{BannerImageHolderView()},result)
            .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
            .startTurning(2000)*/

    }

    override fun failur(throwable: Throwable) {
        Log.d("xxx",""+throwable)
    }

    override fun keshiseccess(keShiEntity: KeShiEntity) {
        val homeWenZhenRecyAdapter = com.wd.health.adapter.HomeWenZhenRecyAdapter(context!!, keShiEntity.result)
        home_recy_wenzhen.adapter=homeWenZhenRecyAdapter
    }

    override fun keshifailur(throwable: Throwable) {
        Log.d("xxx",""+throwable)
    }

    override fun zixunseccess(ziXunEntity: ZiXunEntity) {

    }

    override fun zixunfailur(throwable: Throwable) {
        Log.d("xxx",""+throwable)
    }

}