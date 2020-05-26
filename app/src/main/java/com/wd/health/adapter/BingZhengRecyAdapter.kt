package com.wd.health.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wd.health.R
import com.wd.health.entity.BingZhengResult
import com.wd.health.view.activity.BingZhengXiangQingActivity

class BingZhengRecyAdapter:RecyclerView.Adapter<BingZhengRecyAdapter.BingZhengViewHolder> {

    lateinit var context: Context
    lateinit var result: List<BingZhengResult>
    constructor(context: Context, result: List<BingZhengResult>){
        this.context=context
        this.result=result
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BingZhengViewHolder {
        val inflate = LayoutInflater.from(context).inflate(R.layout.recy_bingzheng, parent, false)
        val bingZhengViewHolder = BingZhengViewHolder(inflate)
        return bingZhengViewHolder
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(holder: BingZhengViewHolder, position: Int) {
        val get = result.get(position)
        val name = get.name
        val id = get.id

        val tv = holder.itemView.findViewById<TextView>(R.id.recy_bingzheng_tv)
        tv.setText(name)

        val intent=Intent()
        tv.setOnClickListener({ intent.setClass(context,BingZhengXiangQingActivity::class.java)})



    }

    class BingZhengViewHolder(itemview:View): RecyclerView.ViewHolder(itemview) {
        init {
            val tv = itemview.findViewById<TextView>(R.id.recy_bingzheng_tv)
        }
    }

}