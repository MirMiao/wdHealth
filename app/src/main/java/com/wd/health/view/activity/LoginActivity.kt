package com.wd.health.view.activity

import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.wd.health.R
import com.wd.health.base.BaseActivity
import com.wd.health.contract.LoginContract
import com.wd.health.entity.LoginEntity
import com.wd.health.presenter.LogPresenter
import com.wd.health.util.RsaCoder
import com.wd.health.util.SaveAndGetUIdSessIdUtil
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import java.util.*

/**
 * 时间 :2020/5/23  15:53
 * 作者 :苗恒
 * 功能 :
 */
class LoginActivity:BaseActivity<LogPresenter>(),LoginContract.IView {
    override fun onLoadPresenter(): LogPresenter {
        return LogPresenter(this)
    }

    override fun initListener(savedInstanceState: Bundle?) {
        iv_pwd.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                if(iv_pwd.isChecked){
                    //显示密码
                    et_pwd.transformationMethod=HideReturnsTransformationMethod.getInstance()
                    et_pwd.setSelection(et_pwd.text.length)  //把焦点放在最后一位
                }else{
                    //隐藏密码
                    et_pwd.transformationMethod=PasswordTransformationMethod.getInstance()
                    et_pwd.setSelection(et_pwd.text.length)//把焦点放在最后一位
                }
            }
        })
        bt_login.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                //获取输入的邮箱
                val email = et_email.text.toString()
                if(TextUtils.isEmpty(email)){
                    toast("邮箱不能为空")
                    return
                }
                val pwd = et_pwd.text.toString();
                if(TextUtils.isEmpty(pwd)){
                    toast("密码不能为空")
                    return
                }
                val encryptByPublicKey = RsaCoder.encryptByPublicKey(pwd);
                mPresenter.login(email,encryptByPublicKey)
            }

        })
        tv_rightReg.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
               startActivity<RegisterActivity>()
            }
        })
        tv_forgetPwd.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {

            }

        })
    }
    override fun initData() {
    }

    override fun layoutId(): Int {
          return R.layout.activity_login
    }

    override fun seccess(loginEntity: LoginEntity) {
        myToast(loginEntity.message)
        if("0000".equals(loginEntity.status)){
            val result = loginEntity.result
            //把用户的userId和sessionId存储起来   存储集合
           var  saveAndGetUIdSessIdUtil=SaveAndGetUIdSessIdUtil()
            saveAndGetUIdSessIdUtil.savaInt("age",result.age)
            saveAndGetUIdSessIdUtil.savaInt("height",result.height)
            saveAndGetUIdSessIdUtil.savaInt("id",result.id)
            saveAndGetUIdSessIdUtil.savaInt("sex",result.sex)
            saveAndGetUIdSessIdUtil.savaInt("weight",result.weight)
            saveAndGetUIdSessIdUtil.savaInt("whetherBingWeChat",result.whetherBingWeChat)
            saveAndGetUIdSessIdUtil.savaString("email",result.email)
            saveAndGetUIdSessIdUtil.savaString("headPic",result.headPic)
            saveAndGetUIdSessIdUtil.savaString("invitationCode",result.invitationCode)
            saveAndGetUIdSessIdUtil.savaString("jiGuangPwd",result.jiGuangPwd)
            saveAndGetUIdSessIdUtil.savaString("nickName",result.nickName)
            saveAndGetUIdSessIdUtil.savaString("sessionId",result.sessionId)
            saveAndGetUIdSessIdUtil.savaString("userName",result.userName)

            startActivity<MainActivity>()
        }
    }
    override fun failur(throwable: Throwable) {
    }
}