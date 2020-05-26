package com.wd.health.view.activity

import android.os.Bundle
import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import com.wd.health.R
import com.wd.health.base.BaseActivity
import com.wd.health.contract.RegisterContract
import com.wd.health.entity.EmailCodeEntity
import com.wd.health.entity.RegEntity
import com.wd.health.presenter.RegisterPresenter
import com.wd.health.util.RsaCoder
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

/**
 * 时间 :2020/5/23  20:57
 * 作者 :苗恒
 * 功能 :
 */
class RegisterActivity:BaseActivity<RegisterPresenter>(),RegisterContract.IView {
    override fun onLoadPresenter(): RegisterPresenter {
        return RegisterPresenter(this)
    }

    override fun initListener(savedInstanceState: Bundle?) {
        cb_pwd1.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                if(cb_pwd1.isChecked){
                    //显示密码
                    et_RegPwd1.transformationMethod= HideReturnsTransformationMethod.getInstance()
                    et_RegPwd1.setSelection(et_RegPwd1.text.length)  //把焦点放在最后一位
                }else{
                    //隐藏密码
                    et_RegPwd1.transformationMethod= PasswordTransformationMethod.getInstance()
                    et_RegPwd1.setSelection(et_RegPwd1.text.length)//把焦点放在最后一位
                }
            }
        })
        cb_pwd2.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                if(cb_pwd2.isChecked){
                    //显示密码
                    et_RegPwd2.transformationMethod= HideReturnsTransformationMethod.getInstance()
                    et_RegPwd2.setSelection(et_RegPwd2.text.length)  //把焦点放在最后一位
                }else{
                    //隐藏密码
                    et_RegPwd2.transformationMethod= PasswordTransformationMethod.getInstance()
                    et_RegPwd2.setSelection(et_RegPwd2.text.length)//把焦点放在最后一位
                }
            }
        })
        bt_getEmailCode.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                 //获取输入的邮箱
                val email = et_RegEmail.text.toString();
                if(TextUtils.isEmpty(email)){
                    myToast("邮箱不能为空")
                    return
                }
                mPresenter.getEmailCode(email)
            }
        })
        bt_register.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                //获取输入的邮箱
                val email = et_RegEmail.text.toString()
                //获取输入的验证码
                val emailCode = et_emailCode.text.toString()
                //获取第一次输入的密码
                val pwd1 = et_RegPwd1.text.toString()
                val encryptByPublicKey = RsaCoder.encryptByPublicKey(pwd1)
                //获取第二次输入的密码
                val pwd2 = et_RegPwd2.text.toString()

                val encryptByPublicKey1 = RsaCoder.encryptByPublicKey(pwd2)
                Log.i("xxx","encryptByPublicKey:"+encryptByPublicKey)
                Log.i("xxx","encryptByPublicKey1:"+encryptByPublicKey1)
                if(pwd1.equals(pwd2)){
                    mPresenter.reg(email,emailCode.toInt(),encryptByPublicKey,encryptByPublicKey)
                }else{
                    myToast("两次密码不一致,请重新输入")
                }
            }
        })
    }

    override fun initData() {

    }

    override fun layoutId(): Int {
      return R.layout.activity_register
    }

    override fun registerSeccess(regEntity: RegEntity) {
          myToast(regEntity.message)
    }

    override fun registerFailur(throwable: Throwable) {

    }

    override fun getEmailCodeSeccess(emailCodeEntity: EmailCodeEntity) {
           myToast(emailCodeEntity.message)
    }

    override fun getEmailCodeFailur(throwable: Throwable) {

    }

}