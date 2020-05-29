package com.wd.health.view.fragment.mycollectfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * 时间 :2020/5/29  13:24
 * 作者 :苗恒
 * 功能 :  健康视频的fragment
 */
class HealthVideoFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val textView=TextView(context)
        textView.setText("健康视频")
        return textView
    }

}