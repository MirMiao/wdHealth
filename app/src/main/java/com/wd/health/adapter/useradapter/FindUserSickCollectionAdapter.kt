package com.wd.health.adapter.useradapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wd.health.R
import com.wd.health.entity.userentity.Result5
import java.text.SimpleDateFormat

/**
 * 时间 :2020/5/29  20:48
 * 作者 :苗恒
 * 功能 :查询用户资讯收藏列表
 */
class FindUserSickCollectionAdapter:RecyclerView.Adapter<FindUserSickCollectionAdapter.MyViewHolder>{
    val context: Context
    var result: List<Result5>
    constructor(context: Context, result: List<Result5>){
        this.context=context
        this.result=result
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val tv_name:TextView=itemView.findViewById(R.id.tv_name)
       val tv_sickInfo:TextView=itemView.findViewById(R.id.tv_sickInfo)
       val tv_collectNum:TextView=itemView.findViewById(R.id.tv_collectNum)
       val tv_adviceNum:TextView=itemView.findViewById(R.id.tv_adviceNum)
       val tv_time:TextView=itemView.findViewById(R.id.tv_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_sickfriend_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                holder.tv_name.setText(result.get(position).title)
                 holder.tv_sickInfo.setText(result.get(position).disease)
                  holder.tv_collectNum.setText("收藏    ${result.get(position).collectionNum}")
                  holder.tv_adviceNum.setText("建议     ${result.get(position).commentNum}")
        val createTime = result.get(position).createTime
        var simpleDateFormat= SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val format = simpleDateFormat.format(createTime)
        holder.tv_time.setText(format)
    }
}