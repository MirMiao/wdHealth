package com.wd.health.view.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.wd.health.R
import com.wd.health.base.BaseActivity
import com.wd.health.contract.ForgetPwdContract
import com.wd.health.entity.CheckCodeEntity
import com.wd.health.entity.EmailCodeEntity
import com.wd.health.presenter.ForgetPwdPresenter
import kotlinx.android.synthetic.main.activity_forget.*

/**
 * 时间 :2020/5/30  7:07
 * 作者 :苗恒
 * 功能 :
 */
class ForgetPwdActivity:BaseActivity<ForgetPwdPresenter>(),ForgetPwdContract.IView {
    override fun onLoadPresenter(): ForgetPwdPresenter {
        return ForgetPwdPresenter(this)
    }

    override fun initListener(savedInstanceState: Bundle?) {
        bt_getCode.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
               //获取输入的邮箱
                val email = et_email2.text.toString()
                if(TextUtils.isEmpty(email)){
                    myToast("邮箱不得为空")
                    return
                }
                mPresenter.getEmailCode(email)
            }

        })
        bt_next.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                val email = et_email2.text.toString()
                if(TextUtils.isEmpty(email)){
                    myToast("邮箱不得为空")
                    return
                }
                val code = et_code.text.toString()
                if(TextUtils.isEmpty(code)){
                    myToast("验证码不得为空")
                    return
                }
                mPresenter.checkCode(email,code)
            }

        })
    }

    override fun initData() {

    }

    override fun layoutId(): Int {
      return R.layout.activity_forget
    }

    override fun checkCodeSeccess(checkCodeEntity: CheckCodeEntity) {
            myToast(checkCodeEntity.message)
        if("0000".equals(checkCodeEntity.status)){
            //跳转
             val intent=Intent(this,ResettingPwdActivity::class.java)
            val email = et_email2.text.toString()
             intent.putExtra("email",email)
              startActivity(intent)
        }
    }

    override fun checkCodeFailur(throwable: Throwable) {

    }

    override fun getEmailCodeSeccess(emailCodeEntity: EmailCodeEntity) {
          myToast(emailCodeEntity.message)
    }

    override fun getEmailCodeFailur(throwable: Throwable) {

    }
}