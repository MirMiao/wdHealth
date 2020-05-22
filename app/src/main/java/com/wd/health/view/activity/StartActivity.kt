package com.wd.health.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.wd.health.R
import kotlinx.android.synthetic.main.activity_start.*
import org.jetbrains.anko.startActivity

/**
 * 时间 :2020/5/22  14:49
 * 作者 :苗恒
 * 功能 :
 */
class StartActivity:AppCompatActivity(),ViewPropertyAnimatorListener{
  /*   private  var handler:Handler=object :Handler(){
         override fun handleMessage(msg: Message) {
             super.handleMessage(msg)
             if(msg.what==1){
              startActivity<MainActivity>()
             }
         }
     }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
         //发送两秒的延迟
         // handler.sendEmptyMessageDelayed(1,2000)
        //缩小动画
        ViewCompat.animate(imageView).scaleX(1.0f).scaleY(1.0f)
            .setListener(this)
            .setDuration(2000)
    }

    override fun onAnimationEnd(view: View?) {
        //动画结束进入到主界面
        startActivity<LeadActivity>()
    }

    override fun onAnimationCancel(view: View?) {
    }

    override fun onAnimationStart(view: View?) {
    }
}