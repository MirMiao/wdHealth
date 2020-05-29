package com.wd.health.view.activity.userActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.wd.health.R
import com.wd.health.adapter.useradapter.MyCollectAdapter
import com.wd.health.view.fragment.mycollectfragment.HealthConsultFragment
import com.wd.health.view.fragment.mycollectfragment.HealthVideoFragment
import com.wd.health.view.fragment.mycollectfragment.SickFriendFragment
import kotlinx.android.synthetic.main.activity_lead.*
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