package com.wd.health.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import androidx.viewpager.widget.ViewPager
import com.wd.health.R
import com.wd.health.adapter.FragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*

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
