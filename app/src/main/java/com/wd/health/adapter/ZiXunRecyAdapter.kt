package com.wd.health.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wd.health.EvenBus.ZiXunEvent
import com.wd.health.R
import com.wd.health.entity.KeShiResult
import com.wd.health.entity.ZiXunListResult
import com.wd.health.view.activity.YaoPinXiangQingActivity
import com.wd.health.view.activity.ZiXunXiangQingActivity
import org.greenrobot.eventbus.EventBus

class ZiXunRecyAdapter: RecyclerView.Adapter<ZiXunRecyAdapter.ZiXunRecyViewHolder> {
    lateinit var context: Context
    lateinit var result: List<ZiXunListResult>
    constructor(context:Context,result: List<ZiXunListResult>){
        this.context=context
        this.result=result
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZiXunRecyViewHolder {
        val inflate = LayoutInflater.from(context).inflate(R.layout.recy_zixun, parent, false)
        val ziXunRecyViewHolder = ZiXunRecyViewHolder(inflate)
        return ziXunRecyViewHolder
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(holder: ZiXunRecyViewHolder, position: Int) {
        val get = result.get(position)
        val title = get.title
        val thumbnail = get.thumbnail
        val plateId = get.plateId


        val zixunim = holder.itemView.findViewById<ImageView>(R.id.zixun_im)
        val zixuntv = holder.itemView.findViewById<TextView>(R.id.zixun_tv)

        zixuntv.setText(title)
        Glide.with(context).load(thumbnail).into(zixunim)


        zixuntv.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                var zixunEvent=ZiXunEvent()
                zixunEvent.zixunid=plateId
                EventBus.getDefault().postSticky(zixunEvent)
                ContextCompat.startActivity(context, Intent(context, ZiXunXiangQingActivity::class.java), null)
            }
        })

    }

    class ZiXunRecyViewHolder(itemview:View): RecyclerView.ViewHolder(itemview) {
        init {
            val zixunim = itemview.findViewById<ImageView>(R.id.zixun_im)
            val zixuntv = itemview.findViewById<TextView>(R.id.zixun_tv)
        }
    }

}