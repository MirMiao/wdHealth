package com.wd.health.adapter.useradapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wd.health.R
import com.wd.health.entity.userentity.Result
import com.wd.health.view.activity.userActivity.MyWalletActivity
import java.text.SimpleDateFormat

/**
 * 时间 :2020/5/25  21:00
 * 作者 :苗恒
 * 功能 :
 */
class WalletAdapter:RecyclerView.Adapter<WalletAdapter.MyViewHolder> {
    var  context: Context
    var result: List<Result>
    constructor(context: Context, result: List<Result>){
        this.context=context
        this.result=result
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       var tv_walletName:TextView=itemView.findViewById(R.id.tv_walletName)
       var tv_walletTime:TextView=itemView.findViewById(R.id.tv_walletTime)
       var tv_walletNum:TextView=itemView.findViewById(R.id.tv_walletNum)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
         return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_my_userconsumption_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return result.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val createTime = result.get(position).createTime
        var simpleDateFormat=SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val format = simpleDateFormat.format(createTime)
        holder.tv_walletTime.setText(format)
        holder.tv_walletName.setText(result.get(position).remark)
        val direction = result.get(position).direction
        if(direction==1){
            //收入
            holder.tv_walletNum.setTextColor(R.color.walletShouRu)
            holder.tv_walletNum.setText("+"+result.get(position).changeNum.toString())
        }else{
            holder.tv_walletNum.setTextColor(R.color.walletZhiChu)
            holder.tv_walletNum.setText("-"+result.get(position).changeNum.toString())
        }

    }
}