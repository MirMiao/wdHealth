package com.wd.health.view.activity

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.wd.health.R
import kotlinx.android.synthetic.main.activity_lead.*
import org.jetbrains.anko.startActivity

/**
 * 时间 :2020/5/22  15:15
 * 作者 :苗恒
 * 功能 :
 */
class LeadActivity:AppCompatActivity() {
    private val imageViews = ArrayList<ImageView>()
    var ids= intArrayOf(R.drawable.start_one,R.drawable.start_two,R.drawable.start_three,R.drawable.start_four,R.drawable.start_five)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lead)
        //用来填充viewPager的ImageView集合
        initData()
    }

    private fun initData() {
        for (i in ids.indices){
            val imageView = ImageView(this)
            imageView.setBackgroundResource(ids[i])
            imageViews.add(imageView)
        }
        viewpager.adapter=MyAdapter()
        //当点击的最后一张图片就跳转到主界面
        viewpager.setOnTouchListener(object :View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                 when(event?.action){
                     MotionEvent.ACTION_UP ->
                        if(viewpager.currentItem==(imageViews.size-1)){
                             startActivity<MainActivity>()
                        }
                 }
                return false
            }

        })
    }


    inner class MyAdapter: PagerAdapter() {
        override fun isViewFromObject(view: View, `object`: Any): Boolean {
          return view == `object`
        }

        override fun getCount(): Int {
            return imageViews.size
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var imageView: ImageView = imageViews.get(position)
            //添加到容器中
            container.addView(imageView)
            return imageView
        }
        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View?)
        }

    }
}