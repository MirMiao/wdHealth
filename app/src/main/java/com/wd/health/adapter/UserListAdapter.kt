package com.wd.health.adapter

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wd.health.R
import org.greenrobot.eventbus.EventBus
import org.jetbrains.anko.include
import java.util.zip.Inflater

/**
 * 时间 :2020/5/24  7:00
 * 作者 :苗恒
 * 功能 :
 */
class UserListAdapter:RecyclerView.Adapter<UserListAdapter.MyViewHolder> {
    var titleList: List<String>
   var imageList: List<Bitmap>
    var context:Context
    constructor(titleList: List<String>, imageList: List<Bitmap>,context: Context){
        this.titleList=titleList
        this.imageList=imageList
        this.context=context
    }

   inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      var textView:TextView=itemView.findViewById(R.id.item_userListTitle)
      var imageview:ImageView=itemView.findViewById(R.id.item_userListImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_userlist_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return titleList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
          holder.textView.text=titleList.get(position)
        holder.imageview.setImageBitmap(imageList.get(position))
        holder.itemView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                EventBus.getDefault().postSticky(""+position)
            }

        })

    }


}