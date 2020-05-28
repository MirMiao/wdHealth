package com.wd.health.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.EvenBus.YaoPinEvent
import com.wd.health.R
import com.wd.health.entity.YaoPinListResult
import com.wd.health.view.activity.StartActivity
import com.wd.health.view.activity.YaoPinXiangQingActivity
import org.greenrobot.eventbus.EventBus

class YaoPinRecyAdapter:RecyclerView.Adapter<YaoPinRecyAdapter.YaoPinViewHolder> {
    lateinit var context: Context
    lateinit var result: List<YaoPinListResult>
    constructor(context: Context, result: List<YaoPinListResult>){
        this.context=context
        this.result=result
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YaoPinViewHolder {
        val inflate = LayoutInflater.from(context).inflate(R.layout.recy_yaopin, parent, false)
        val yaoPinViewHolder = YaoPinViewHolder(inflate)
        return yaoPinViewHolder
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(holder: YaoPinViewHolder, position: Int) {
        val get = result.get(position)
        val name = get.name
        val picture = get.picture
        val id = get.id

        holder.tv.setText(name)
        RetrofitUtils.getRoundphoto(picture,holder.im)

        holder.im.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                val yaopinEvent=YaoPinEvent()
                yaopinEvent.yaopinid=id
                EventBus.getDefault().postSticky(yaopinEvent)
                startActivity(context, Intent(context, YaoPinXiangQingActivity::class.java),null)
            }
        })


    }

    class YaoPinViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        var im = itemview.findViewById<ImageView>(R.id.recy_yaopin_im)
        var tv = itemview.findViewById<TextView>(R.id.recy_yaopin_tv)
    }

}