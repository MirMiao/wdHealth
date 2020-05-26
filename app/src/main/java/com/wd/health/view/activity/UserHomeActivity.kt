package com.wd.health.view.activity

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.wd.health.R
import com.wd.health.adapter.UserListAdapter
import com.wd.health.view.activity.userActivity.*
import kotlinx.android.synthetic.main.activity_userhome.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import kotlin.concurrent.thread

/**
 * 时间 :2020/5/24  6:44
 * 作者 :苗恒
 * 功能 :
 */
class UserHomeActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userhome)
        EventBus.getDefault().register(this)
        val titleList = listOf<String>("我的档案", "我的钱包", "我的收藏","被采纳建议","我的视频"
         ,"我的病友圈","我的关注","我的任务","设置管理")
        val resources = resources;
        val file = BitmapFactory.decodeResource(resources, R.mipmap.my_icon_file_n);//我的档案
        val wallet = BitmapFactory.decodeResource(resources, R.mipmap.my_icon_wallet_n);//我的钱包
        val collection = BitmapFactory.decodeResource(resources, R.mipmap.common_button_collection_small_n);//我的收藏
        val advice = BitmapFactory.decodeResource(resources, R.mipmap.my_icon_advice_n);//被采纳建议
        val video = BitmapFactory.decodeResource(resources, R.mipmap.my_icon_video_n);//我的视频
        val circle = BitmapFactory.decodeResource(resources, R.mipmap.my_icon_circle_n);//我的病友圈
        val love = BitmapFactory.decodeResource(resources, R.mipmap.common_icon_attention_large_n);//我的关注
        val task = BitmapFactory.decodeResource(resources, R.mipmap.my_icon_task_n);//我的任务
        val set = BitmapFactory.decodeResource(resources, R.mipmap.my_icon_set_n);//设置管理
        val imageList= listOf<Bitmap>(file,wallet,collection,advice,video,circle,love,task,set)
        var gridLayoutManager:GridLayoutManager=GridLayoutManager(this,3)

        rv_userList.layoutManager=gridLayoutManager
        rv_userList.overScrollMode=View.OVER_SCROLL_NEVER  //去除阴影

        rv_userList.adapter=UserListAdapter(titleList,imageList,this)
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun a(position:String){
        val toInt = position.toInt()
        when(toInt){
            0-> startActivity<MyFilesActivity>()
            1-> startActivity<MyWalletActivity>()
            2-> startActivity<MyCollectActivity>()
            3-> startActivity<MyAdviceActivity>()
            4-> startActivity<MyVideoActivity>()
            5-> startActivity<MyFallFriendActivity>()
            6-> startActivity<MyConcernActivity>()
            7-> startActivity<MyTaskActivity>()
            8-> startActivity<MySettingActivity>()
        }
    }
}