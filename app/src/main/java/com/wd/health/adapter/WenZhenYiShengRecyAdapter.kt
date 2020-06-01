package com.wd.health.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.EvenBus.YiShengEvent
import com.wd.health.R
import com.wd.health.entity.WenZhenYiShengResult
import com.wd.health.entity.YaoPinXiangQingResult
import org.greenrobot.eventbus.EventBus

class WenZhenYiShengRecyAdapter:RecyclerView.Adapter<WenZhenYiShengRecyAdapter.WenZhenYiShengViewHolder> {

    lateinit var context: Context
    lateinit var result: List<WenZhenYiShengResult>
    var onyishengd:onYiShengID?=null

    constructor(context: Context, result: List<WenZhenYiShengResult>){
        this.context=context
        this.result=result
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WenZhenYiShengViewHolder {
        val inflate = LayoutInflater.from(context).inflate(R.layout.recy_yisheng, parent, false)
        val wenZhenYiShengViewHolder = WenZhenYiShengViewHolder(inflate)
        return wenZhenYiShengViewHolder
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(holder: WenZhenYiShengViewHolder, position: Int) {
        val get = result.get(position)
        val doctorName = get.doctorName
        val doctorId = get.doctorId
        val imagePic = get.imagePic

        holder.yishengname.setText(doctorName)
        Glide.with(context).load(imagePic).into(holder.yishengim)

        holder.yishengname.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                onyishengd?.onYiShengClick(doctorId)
            }
        })

    }

    class WenZhenYiShengViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        var yishengname = itemview.findViewById<TextView>(R.id.yisheng_tv)
        var yishengim = itemview.findViewById<ImageView>(R.id.yisheng_im)
    }


    interface onYiShengID{
        fun onYiShengClick(id:Int)
    }


}