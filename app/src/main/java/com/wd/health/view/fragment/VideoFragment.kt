package com.wd.health.view.fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * 时间 :2020/5/22  22:24
 * 作者 :苗恒
 * 功能 :
 */
class VideoFragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val textview:TextView= TextView(context)
        textview.setText("视频")
        return  textview
    }
}