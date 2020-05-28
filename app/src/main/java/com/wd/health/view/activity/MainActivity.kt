package com.wd.health.view.activity

import android.os.Bundle
import android.util.LogPrinter
import android.widget.RadioGroup
import androidx.viewpager.widget.ViewPager
import com.wd.health.R
import com.wd.health.adapter.FragmentAdapter
import com.wd.health.base.BaseActivity
import com.wd.health.base.mvp.BasePresenter
import com.wd.health.contract.LoginContract
import com.wd.health.entity.LoginEntity
import com.wd.health.presenter.LogPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<LogPresenter>(),LoginContract.IView{
    override fun initListener(savedInstanceState: Bundle?) {

        val fragmentAdapter:FragmentAdapter=FragmentAdapter(supportFragmentManager)
        viewPager.adapter=fragmentAdapter

        rg.setOnCheckedChangeListener(object :RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
                when(p1){
                    R.id.rb_1 -> viewPager.setCurrentItem(0)
                    R.id.rb_2 -> viewPager.setCurrentItem(1)
                    R.id.rb_3 -> viewPager.setCurrentItem(2)
                }
            }
        })
        viewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                rg.check(rg.getChildAt(position).id)
            }

        })


    }

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun onLoadPresenter(): LogPresenter {
        return LogPresenter(this)
    }

    override fun initData() {

    }

    override fun seccess(loginEntity: LoginEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun failur(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}


