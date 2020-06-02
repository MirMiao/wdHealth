package com.wd.health.view.activity.userActivity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import butterknife.OnClick
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.wd.health.R
import com.wd.health.util.SaveAndGetUIdSessIdUtil
import com.wd.health.view.activity.MainActivity
import kotlinx.android.synthetic.main.activity_my_setting_layout.*
import kotlinx.android.synthetic.main.activity_my_setting_layout.iv_headPic
import kotlinx.android.synthetic.main.activity_my_setting_layout.tv_userName
import kotlinx.android.synthetic.main.activity_userhome.*
import org.jetbrains.anko.startActivity

/**
 * 时间 :2020/5/24  16:10
 * 作者 :苗恒
 * 功能 :
 */
class MySettingActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_setting_layout)
        val  saveAndGetUIdSessIdUtil=SaveAndGetUIdSessIdUtil()
        val id = saveAndGetUIdSessIdUtil.getInt("id")
        val sessionId = saveAndGetUIdSessIdUtil.getString("sessionId")
        val headPic = saveAndGetUIdSessIdUtil.getString("headPic")
        val nickName = saveAndGetUIdSessIdUtil.getString("nickName")
        // .apply(RequestOptions.bitmapTransform(new RoundedCorners(15)))
        Glide.with(this).load(headPic)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(50)))
            .into(iv_headPic)
        tv_userName.setText(nickName)

         //退出登陆
        tv_backLogin.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
               val saveAndGetUIdSessIdUtil=SaveAndGetUIdSessIdUtil()
                saveAndGetUIdSessIdUtil.clear()
                startActivity<MainActivity>()
            }
        })
        //修改密码
        rl_updatePwd.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                   startActivity<UpdatePwdActivity>()
            }

        })
    }
}