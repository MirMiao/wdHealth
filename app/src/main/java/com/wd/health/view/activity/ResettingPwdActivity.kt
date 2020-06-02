package com.wd.health.view.activity

import android.os.Bundle
import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.wd.health.R
import com.wd.health.base.BaseActivity
import com.wd.health.contract.ResettingPwdContract
import com.wd.health.entity.ResettingPwdEntity
import com.wd.health.presenter.ResettingPwdPresenter
import com.wd.health.util.RsaCoder
import com.wd.health.util.SaveAndGetUIdSessIdUtil
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_resettingpwd.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.themedImageSwitcher

/**
 * 时间 :2020/5/30  8:04
 * 作者 :苗恒
 * 功能 :
 */
class ResettingPwdActivity:BaseActivity<ResettingPwdPresenter>(),ResettingPwdContract.IView {
    override fun onLoadPresenter(): ResettingPwdPresenter {
        return ResettingPwdPresenter(this)
    }

    override fun initListener(savedInstanceState: Bundle?) {
        cb_pwd3.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                if(cb_pwd3.isChecked){
                    //显示密码
                    et_RegPwd3.transformationMethod= HideReturnsTransformationMethod.getInstance()
                    et_RegPwd3.setSelection(et_RegPwd3.text.length)  //把焦点放在最后一位
                }else{
                    //隐藏密码
                    et_RegPwd3.transformationMethod= PasswordTransformationMethod.getInstance()
                    et_RegPwd3.setSelection(et_RegPwd3.text.length)//把焦点放在最后一位
                }
            }
        })
        cb_pwd4.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                if(cb_pwd4.isChecked){
                    //显示密码
                    et_RegPwd4.transformationMethod= HideReturnsTransformationMethod.getInstance()
                    et_RegPwd4.setSelection(et_RegPwd4.text.length)  //把焦点放在最后一位
                }else{
                    //隐藏密码
                    et_RegPwd4.transformationMethod= PasswordTransformationMethod.getInstance()
                    et_RegPwd4.setSelection(et_RegPwd4.text.length)//把焦点放在最后一位
                }
            }
        })

    }

    override fun initData() {
        val email = intent.getStringExtra("email")
        bt_finish.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
               //获取输入的密码
                val pwd3 = et_RegPwd3.text.toString()
                 if(TextUtils.isEmpty(pwd3)){
                     myToast("设置新密码不得为空")
                     return
                 }
                val pwd4 = et_RegPwd4.text.toString()
                if(TextUtils.isEmpty(pwd4)){
                    myToast("确认密码不得为空")
                    return
                }
                val encryptByPublicKey = RsaCoder.encryptByPublicKey(pwd3)
                val encryptByPublicKey1 = RsaCoder.encryptByPublicKey(pwd4)
                if(pwd3.equals(pwd4)){

                }else{
                    myToast("两次密码输入的不一致")
                    return
                }
                //调用重置密码
              mPresenter.resettingPwd(email,encryptByPublicKey,encryptByPublicKey)

            }
        })
    }

    override fun layoutId(): Int {
        return R.layout.activity_resettingpwd
    }

    override fun seccess(resettingPwdEntity: ResettingPwdEntity) {
        //如果成功的话就会跳进登陆页面
       myToast(resettingPwdEntity.message)
        if("0000".equals(resettingPwdEntity.status)){
            val saveAndGetUIdSessIdUtil=SaveAndGetUIdSessIdUtil()
            saveAndGetUIdSessIdUtil.clear()
              startActivity<LoginActivity>()
        }
    }

    override fun failur(throwable: Throwable) {

    }
}