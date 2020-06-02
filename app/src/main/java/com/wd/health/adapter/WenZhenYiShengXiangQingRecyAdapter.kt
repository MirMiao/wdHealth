package com.wd.health.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bw.doctor.base.utils.RetrofitUtils
import com.wd.health.R
import com.wd.health.entity.WenZhenYiShengXiangQingResult

class WenZhenYiShengXiangQingRecyAdapter:RecyclerView.Adapter<WenZhenYiShengXiangQingRecyAdapter.YiShengXiangQingViewHolder> {

    lateinit var context: Context
    lateinit var result: WenZhenYiShengXiangQingResult



    constructor(context: Context, result: WenZhenYiShengXiangQingResult){
        this.context=context
        this.result=result
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YiShengXiangQingViewHolder {
        val inflate =
            LayoutInflater.from(context).inflate(R.layout.recy_yishengxiangqing, parent, false)
        val yiShengXiangQingViewHolder = YiShengXiangQingViewHolder(inflate)
        return yiShengXiangQingViewHolder
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: YiShengXiangQingViewHolder, position: Int) {

        val imagePic = result.imagePic
        val doctorName = result.doctorName
        val jobTitle = result.jobTitle
        val inauguralHospital = result.inauguralHospital
        val praiseNum = result.praiseNum
        val serverNum = result.serverNum
        val servicePrice = result.servicePrice

        RetrofitUtils.getRoundphoto(imagePic,holder.yishengxiangqingim)
        holder.yishengxiangqingname.setText(doctorName)
        holder.yishengxiangqingzhicheng.setText(jobTitle)
        holder.yishengxiangqingyiyuan.setText(inauguralHospital)
        holder.yishengxiangqinghaoping.setText("好评率"+praiseNum+"%")
        holder.yishengxiangqinghuanzheshu.setText("服务患者数"+serverNum)
        holder.yishengxiangqingjiage.setText(""+servicePrice+"H币/次")


        holder.yishengxiangqingzixun.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        holder.yishengxiangqingdian.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {

            }
        })


    }

    class YiShengXiangQingViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        var yishengxiangqingim = itemview.findViewById<ImageView>(R.id.yishengxiangqing_im)
        var yishengxiangqingname = itemview.findViewById<TextView>(R.id.yishengxiangqing_name)
        var yishengxiangqingzhicheng = itemview.findViewById<TextView>(R.id.yishengxiangqing_zhicheng)
        var yishengxiangqingyiyuan = itemview.findViewById<TextView>(R.id.yishengxiangqing_yiyuan)
        var yishengxiangqinghaoping = itemview.findViewById<TextView>(R.id.yishengxiangqing_haoping)
        var yishengxiangqinghuanzheshu = itemview.findViewById<TextView>(R.id.yishengxiangqing_huanzheshu)
        var yishengxiangqingjiage = itemview.findViewById<TextView>(R.id.yishengxiangqing_jiage)
        var yishengxiangqingzixun = itemview.findViewById<Button>(R.id.yishengxiangqing_zixun)
        var yishengxiangqingdian = itemview.findViewById<ImageView>(R.id.yishengxiangqing_dian)
    }



}