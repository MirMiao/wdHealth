package com.wd.health.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wd.health.R
import com.wd.health.entity.YaoPinXiangQingResult
import com.wd.health.entity.ZiXunXiangQingResult

class ZiXunXiangQingRecyAdapter:RecyclerView.Adapter<ZiXunXiangQingRecyAdapter.ZiXunXiangQingViewHolder> {

    lateinit var context: Context
    lateinit var result: ZiXunXiangQingResult
    constructor(context: Context, result: ZiXunXiangQingResult){
        this.context=context
        this.result=result
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZiXunXiangQingViewHolder {
        val inflate =
            LayoutInflater.from(context).inflate(R.layout.recy_zixunxiangqing, parent, false)
        val ziXunXiangQingViewHolder = ZiXunXiangQingViewHolder(inflate)
        return ziXunXiangQingViewHolder
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: ZiXunXiangQingViewHolder, position: Int) {
        val source = result.source
        val title = result.title
        val content = result.content
        val releaseTime = result.releaseTime

        holder.biaoti.setText(title)
        holder.zuozhe.setText(source)
        holder.shijian.setText(""+releaseTime)
        holder.zhengwen.setText(content)

    }

    class ZiXunXiangQingViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        var biaoti = itemview.findViewById<TextView>(R.id.zixunxiangqing_biaoti)
        var zuozhe = itemview.findViewById<TextView>(R.id.zixunxiangqing_zuozhe)
        var shijian = itemview.findViewById<TextView>(R.id.zixunxiangqing_shijian)
        var zhengwen = itemview.findViewById<TextView>(R.id.zixunxiangqing_zhengwen)
    }
}