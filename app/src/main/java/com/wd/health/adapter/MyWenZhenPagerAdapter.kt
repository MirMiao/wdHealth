package com.wd.health.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wd.health.view.fragment.WenZhenFragment

class MyWenZhenPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    var fragmentList=ArrayList<Fragment>()

    init {
        fragmentList.add(WenZhenFragment.newInstance(7))
        fragmentList.add(WenZhenFragment.newInstance(4))
        fragmentList.add(WenZhenFragment.newInstance(2))
        fragmentList.add(WenZhenFragment.newInstance(5))
        fragmentList.add(WenZhenFragment.newInstance(12))
        fragmentList.add(WenZhenFragment.newInstance(9))
        fragmentList.add(WenZhenFragment.newInstance(6))
        fragmentList.add(WenZhenFragment.newInstance(11))
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList.get(position)
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0->return "内科"
            1->return "眼科"
            2->return "骨科"
            3->return "小儿科"
            4->return "传染病科"
            5->return "皮肤科"
            6->return "耳鼻喉科"
            7->return "精神病科"
            else->return "222"
        }
        return "hhh"
    }


}