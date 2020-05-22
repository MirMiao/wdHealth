package com.wd.health.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wd.health.view.fragment.CircleFragment
import com.wd.health.view.fragment.HomeFragment
import com.wd.health.view.fragment.VideoFragment

/**
 * 时间 :2020/5/22  22:31
 * 作者 :苗恒
 * 功能 :
 */
class FragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    var fragmentList=ArrayList<Fragment>()
    init {
        val homeFragment= HomeFragment()
        val circleFragment= CircleFragment()
        val videoFragment= VideoFragment()
        fragmentList.add(homeFragment)
        fragmentList.add(circleFragment)
        fragmentList.add(videoFragment)
    }

    override fun getItem(position: Int): Fragment {
         return fragmentList.get(position)
    }

    override fun getCount(): Int {
        return fragmentList.size
    }
}