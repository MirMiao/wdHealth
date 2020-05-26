package com.wd.health.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.R
import com.wd.health.entity.KeShiResult
import kotlinx.android.synthetic.main.recy_home_wenzhen.view.*

class HomeWenZhenRecyAdapter: RecyclerView.Adapter<HomeWenZhenRecyAdapter.WenZhenViewHolder> {
    lateinit var context:Context
    lateinit var result: List<KeShiResult>
   constructor(context:Context,result: List<KeShiResult>){
       this.context=context
       this.result=result
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WenZhenViewHolder {
        val inflate = LayoutInflater.from(context).inflate(R.layout.recy_home_wenzhen, parent, false)
        val wenZhenViewHolder = WenZhenViewHolder(inflate)
        return wenZhenViewHolder
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(holder: WenZhenViewHolder, position: Int) {
        val get = result.get(position)
        val pic = get.pic
        val departmentName = get.departmentName
        val wenzhenIm = holder.itemView.wenzhen_im
        val wenzhenTv = holder.itemView.wenzhen_tv
        RetrofitUtils.getRoundphoto(pic,wenzhenIm)
        wenzhenTv.setText(departmentName)
    }

    class WenZhenViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        init {
            val wenzhenim = itemView.findViewById<ImageView>(R.id.wenzhen_im)
            val wenzhentv= itemView.findViewById<TextView>(R.id.wenzhen_tv)
        }
    }

}