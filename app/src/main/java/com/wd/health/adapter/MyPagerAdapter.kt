package com.wd.health.adapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wd.health.view.fragment.ZiXunFragment

//首页咨询pager
class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    var fragmentList=ArrayList<Fragment>()
   init {
       fragmentList.add(ZiXunFragment.newInstance(1))
       fragmentList.add(ZiXunFragment.newInstance(2))
       fragmentList.add(ZiXunFragment.newInstance(3))
       fragmentList.add(ZiXunFragment.newInstance(4))
       fragmentList.add(ZiXunFragment.newInstance(5))
   }
    override fun getItem(position: Int): Fragment {

        return fragmentList.get(position)
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0->return "健康要闻"
            1->return "医学动态"
            2->return "医疗动态"
            3->return "美容养生"
            4->return "健身减肥"
            else->return "222"
        }
        return "hhh"
    }

}