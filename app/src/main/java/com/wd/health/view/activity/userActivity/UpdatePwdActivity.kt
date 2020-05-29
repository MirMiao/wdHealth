package com.wd.health.view.activity.userActivity

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.wd.health.R
import com.wd.health.base.BaseActivity
import com.wd.health.contract.usercontract.UpdatePwdContract
import com.wd.health.entity.userentity.UpdatePwdEntity
import com.wd.health.presenter.userpresenter.UpdateUserPwdPresenter
import com.wd.health.util.RsaCoder
import com.wd.health.util.SaveAndGetUIdSessIdUtil
import com.wd.health.view.activity.LoginActivity
import kotlinx.android.synthetic.main.activity_update_pwd.*
import org.jetbrains.anko.startActivity

/**
 * 时间 :2020/5/29  7:05
 * 作者 :苗恒
 * 功能 :
 */
class UpdatePwdActivity:BaseActivity<UpdateUserPwdPresenter>(),UpdatePwdContract.IView {
    override fun onLoadPresenter(): UpdateUserPwdPresenter {
        return UpdateUserPwdPresenter(this)
    }

    override fun initListener(savedInstanceState: Bundle?) {
        bt_sure.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                //获取输入的内容
                val oldPwd = et_oldPwd.text.toString()
                if(TextUtils.isEmpty(oldPwd)){
                    myToast("原密码不能为空")
                    return
                }
                val newPwd = et_newPwd.text.toString()
                if(TextUtils.isEmpty(newPwd)){
                    myToast("新密码不能为空")
                    return
                }
                val newPwd2 = et_newPwd2.text.toString()
                if(TextUtils.isEmpty(newPwd2)){
                    myToast("确认密码不能为空")
                    return
                }
                if(newPwd.equals(newPwd2)){

                }else{
                    myToast("两次输入的密码不一致")
                    return
                }

                val saveAndGetUIdSessIdUtil=SaveAndGetUIdSessIdUtil()
                val id = saveAndGetUIdSessIdUtil.getInt("id")
                val sessionId = saveAndGetUIdSessIdUtil.getString("sessionId")
                val encryptByPublicKey = RsaCoder.encryptByPublicKey(oldPwd)
                val encryptByPublicKey1 = RsaCoder.encryptByPublicKey(newPwd)
                mPresenter.updateUserPwd(id,sessionId,encryptByPublicKey,encryptByPublicKey1)
            }
        })
    }

    override fun initData() {

    }

    override fun layoutId(): Int {
       return R.layout.activity_update_pwd
    }

    override fun seccess(updatePwdEntity: UpdatePwdEntity) {
          myToast("成功了没有啊")
          myToast(updatePwdEntity.message)
        if("0000".equals(updatePwdEntity.status)){
            val saveAndGetUIdSessIdUtil=SaveAndGetUIdSessIdUtil()
            saveAndGetUIdSessIdUtil.clear()
            startActivity<LoginActivity>()
        }
    }

    override fun failur(throwable: Throwable) {
        myToast("失败了")
        //myToast("${throwable.message}")
    }
}