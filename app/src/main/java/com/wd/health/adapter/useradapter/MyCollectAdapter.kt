package com.wd.health.adapter.useradapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wd.health.view.fragment.CircleFragment
import com.wd.health.view.fragment.HomeFragment
import com.wd.health.view.fragment.VideoFragment
import com.wd.health.view.fragment.mycollectfragment.HealthConsultFragment
import com.wd.health.view.fragment.mycollectfragment.HealthVideoFragment
import com.wd.health.view.fragment.mycollectfragment.SickFriendFragment

/**
 * 时间 :2020/5/22  22:31
 * 作者 :苗恒
 * 功能 :  我的收藏
 */
open class MyCollectAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    var fragmentList=ArrayList<Fragment>()
    val titleList= ArrayList<String>()
    init {
        //健康咨询","健康食品","病友圈"
        titleList.add("健康咨询")
        titleList.add("健康食品")
        titleList.add("病友圈")
            fragmentList.add( HealthConsultFragment())
            fragmentList.add( HealthVideoFragment())
            fragmentList.add( SickFriendFragment())

    }

    override fun getItem(position: Int): Fragment {
         return fragmentList.get(position)
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList.get(position)
    }
}