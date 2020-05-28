package com.wd.health.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.wd.health.EvenBus.BingZhengEvent
import com.wd.health.R
import com.wd.health.entity.BingZhengResult
import com.wd.health.view.activity.BingZhengXiangQingActivity
import com.wd.health.view.activity.SousuoActivity
import com.wd.health.view.activity.StartActivity
import org.greenrobot.eventbus.EventBus

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

        holder.tv.setText(name)

        holder.tv.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                val bingzhengEvent=BingZhengEvent()
                bingzhengEvent.bingzhengid=id
                EventBus.getDefault().postSticky(bingzhengEvent)
                startActivity(context,Intent(context,BingZhengXiangQingActivity::class.java),null)
            }
        })

    }

    public class BingZhengViewHolder(itemview:View): RecyclerView.ViewHolder(itemview) {
        var tv = itemview.findViewById<TextView>(R.id.recy_bingzheng_tv)
    }



}