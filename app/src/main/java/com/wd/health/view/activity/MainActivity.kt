package com.wd.health.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.wd.health.R
import com.wd.health.adapter.FragmentAdapter
import com.wd.health.base.BaseActivity
import com.wd.health.contract.IContract
import com.wd.health.entity.AEntity
import com.wd.health.presenter.Presenter
import com.wd.health.view.fragment.CircleFragment
import com.wd.health.view.fragment.HomeFragment
import com.wd.health.view.fragment.VideoFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

}
