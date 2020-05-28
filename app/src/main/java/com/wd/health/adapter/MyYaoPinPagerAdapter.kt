package com.wd.health.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wd.health.view.fragment.YaoPinFragment

class MyYaoPinPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    var YaoPinPager=ArrayList<Fragment>()
    init {
        YaoPinPager.add(YaoPinFragment.newInstance(1))
        YaoPinPager.add(YaoPinFragment.newInstance(3))
        YaoPinPager.add(YaoPinFragment.newInstance(4))
        YaoPinPager.add(YaoPinFragment.newInstance(2))
        YaoPinPager.add(YaoPinFragment.newInstance(5))
        YaoPinPager.add(YaoPinFragment.newInstance(6))
    }

    override fun getItem(position: Int): Fragment {
        return YaoPinPager.get(position)
    }

    override fun getCount(): Int {
        return YaoPinPager.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0->return "感冒用药"
            1->return "风湿骨伤"
            2->return "两性健康"
            3->return "儿童用药"
            4->return "三高用药"
            5->return "其他药品"
            else->return "222"
        }
        return "hhh"
    }

}