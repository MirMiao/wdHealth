package com.wd.health.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wd.health.R
import com.wd.health.entity.BingZhengResult
import com.wd.health.entity.BingZhengXiangQingResult

class BingZhengXiangQingRecyAdapter:RecyclerView.Adapter<BingZhengXiangQingRecyAdapter.BingZhengXiangQingViewHolder> {

    lateinit var context: Context
    lateinit var result: BingZhengXiangQingResult

    constructor(context: Context, result: BingZhengXiangQingResult){
        this.context=context
        this.result=result
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BingZhengXiangQingViewHolder {
        val inflate =
            LayoutInflater.from(context).inflate(R.layout.recy_bingzhengxiangqing, parent, false)
        val bingZhengXiangQingViewHolder = BingZhengXiangQingViewHolder(inflate)
        return bingZhengXiangQingViewHolder
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: BingZhengXiangQingViewHolder, position: Int) {
        val pathology = result.pathology
        val symptom = result.symptom
        val benefitTaboo = result.benefitTaboo
        val chineseMedicineTreatment = result.chineseMedicineTreatment
        val westernMedicineTreatment = result.westernMedicineTreatment

        holder.bingli.setText(pathology)
        holder.zhengzhuang.setText(symptom)
        holder.yiji.setText(benefitTaboo)
        holder.zhongyao.setText(chineseMedicineTreatment)
        holder.xiyao.setText(westernMedicineTreatment)

    }

    class BingZhengXiangQingViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        var bingli = itemview.findViewById<TextView>(R.id.bzxq_bingli)
        var zhengzhuang = itemview.findViewById<TextView>(R.id.bzxq_zhengzhuang)
        var yiji = itemview.findViewById<TextView>(R.id.bzxq_yiji)
        var xiyao = itemview.findViewById<TextView>(R.id.bzxq_xiyao)
        var zhongyao = itemview.findViewById<TextView>(R.id.bzxq_zhongyao)
    }

}