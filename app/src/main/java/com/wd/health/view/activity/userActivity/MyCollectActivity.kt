package com.wd.health.view.activity.userActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wd.health.R
import com.wd.health.adapter.useradapter.MyCollectAdapter
import kotlinx.android.synthetic.main.activity_my_collect_layout.*

/**
 * 时间 :2020/5/24  16:10
 * 作者 :苗恒
 * 功能 :
 */
class MyCollectActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_collect_layout)

        viewPager.adapter=MyCollectAdapter(supportFragmentManager)
         tabLayout1.setupWithViewPager(viewPager)


    }

}