package com.wd.health.view.activity.userActivity

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.wd.health.R
import com.wd.health.adapter.useradapter.WalletAdapter
import com.wd.health.base.BaseActivity
import com.wd.health.contract.usercontract.WalletContract
import com.wd.health.entity.userentity.FindUserConsumption
import com.wd.health.entity.userentity.FindUserWalletEntity
import com.wd.health.presenter.userpresenter.WalletPresenter
import com.wd.health.util.SaveAndGetUIdSessIdUtil
import com.wd.health.view.activity.LoginActivity
import kotlinx.android.synthetic.main.activity_my_wallet_layout.*
import kotlinx.android.synthetic.main.activity_userhome.*
import org.jetbrains.anko.startActivity

/**
 * 时间 :2020/5/24  16:10
 * 作者 :苗恒
 * 功能 :
 */
class MyWalletActivity : BaseActivity<WalletPresenter>(), WalletContract.IView {
        override fun onLoadPresenter(): WalletPresenter {
            return WalletPresenter(this)
        }

        override fun initListener(savedInstanceState: Bundle?) {
        }

        override fun initData() {
          val saveAndGetUIdSessIdUtil=SaveAndGetUIdSessIdUtil()
            val id = saveAndGetUIdSessIdUtil.getInt("id")
            val sessionId = saveAndGetUIdSessIdUtil.getString("sessionId")
            mPresenter.findUserWallet(id,sessionId)
            mPresenter.findUserConsummtion(id,sessionId,1,100)
        }

        override fun layoutId(): Int {
            return R.layout.activity_my_wallet_layout
        }

        override fun findUserWalletSeccess(findUserWalletEntity: FindUserWalletEntity) {
            val userWalletNum = findUserWalletEntity.result.toString()
            tv_walletNum.setText(userWalletNum)

        }

        override fun findUserWalletFailur(throwable: Throwable) {

        }

        override fun findUserConsummtionSeccess(findUserConsumption: FindUserConsumption) {
              if(findUserConsumption.result!=null){
                    rv_wallet.overScrollMode= View.OVER_SCROLL_NEVER  //去除阴影
                    rv_wallet.layoutManager=LinearLayoutManager(this)
                    rv_wallet.adapter=WalletAdapter(this,findUserConsumption.result)
              }
        }

        override fun findUserConsummtionFailur(throwable: Throwable) {

        }
}