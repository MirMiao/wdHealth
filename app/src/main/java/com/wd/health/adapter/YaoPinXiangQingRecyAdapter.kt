package com.wd.health.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wd.health.R
import com.wd.health.entity.YaoPinXiangQingResult

class YaoPinXiangQingRecyAdapter:RecyclerView.Adapter<YaoPinXiangQingRecyAdapter.YaoPinXiangQingViewHolder> {

    lateinit var context: Context
    lateinit var result: YaoPinXiangQingResult
    constructor(context: Context, result: YaoPinXiangQingResult){
        this.context=context
        this.result=result
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YaoPinXiangQingViewHolder {
        val inflate =
            LayoutInflater.from(context).inflate(R.layout.recy_yaopinxiangqing, parent, false)
        val yaoPinXiangQingViewHolder = YaoPinXiangQingViewHolder(inflate)
        return yaoPinXiangQingViewHolder
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: YaoPinXiangQingViewHolder, position: Int) {

        val name = result.name
        val component = result.component
        val taboo = result.taboo
        val effect = result.effect
        val usage = result.usage
        val shape = result.shape
        val packing = result.packing
        val sideEffects = result.sideEffects
        val storage = result.storage
        val mindMatter = result.mindMatter

        holder.yaopinname.setText(name)
        holder.yaopinchengfen.setText(component)
        holder.yaopinjinji.setText(taboo)
        holder.yaopinzhuzhi.setText(effect)
        holder.yaopinyongliang.setText(usage)
        holder.yaopinxingzhuang.setText(shape)
        holder.yaopinguige.setText(packing)
        holder.yaopinbuliang.setText(sideEffects)
        holder.yaopinchucang.setText(storage)
        holder.yaopinzhuyi.setText(mindMatter)

    }

    class YaoPinXiangQingViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        var yaopinname = itemview.findViewById<TextView>(R.id.yaopin_name)
        var yaopinchengfen = itemview.findViewById<TextView>(R.id.yaopin_chengfen)
        var yaopinjinji = itemview.findViewById<TextView>(R.id.yaopin_jinji)
        var yaopinzhuzhi = itemview.findViewById<TextView>(R.id.yaopin_zhuzhi)
        var yaopinyongliang = itemview.findViewById<TextView>(R.id.yaopin_yongliang)
        var yaopinxingzhuang = itemview.findViewById<TextView>(R.id.yaopin_xingzhuang)
        var yaopinguige = itemview.findViewById<TextView>(R.id.yaopin_guige)
        var yaopinbuliang = itemview.findViewById<TextView>(R.id.yaopin_buliang)
        var yaopinchucang = itemview.findViewById<TextView>(R.id.yaopin_chucang)
        var yaopinzhuyi = itemview.findViewById<TextView>(R.id.yaopin_zhuyi)

    }


}