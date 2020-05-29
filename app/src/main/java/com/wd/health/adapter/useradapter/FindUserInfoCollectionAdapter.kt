package com.wd.health.adapter.useradapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wd.health.R
import com.wd.health.entity.userentity.Result4

/**
 * 时间 :2020/5/29  20:48
 * 作者 :苗恒
 * 功能 :查询用户资讯收藏列表
 */
class FindUserInfoCollectionAdapter:RecyclerView.Adapter<FindUserInfoCollectionAdapter.MyViewHolder>{
    val context: Context
    val result: List<Result4>
    constructor(context: Context, result: List<Result4>){
        this.context=context
        this.result=result
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //return WalletAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_my_userconsumption_layout, parent, false))
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_finduserinfo_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }
}