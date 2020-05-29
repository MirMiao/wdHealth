package com.wd.health.view.fragment.mycollectfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bw.doctor.base.BaseFragment
import com.wd.health.R
import com.wd.health.adapter.useradapter.FindUserInfoCollectionAdapter
import com.wd.health.adapter.useradapter.FindUserSickCollectionAdapter
import com.wd.health.contract.usercontract.FindUserSickCollectionContract
import com.wd.health.entity.userentity.FindUserSickCollectionEntity
import com.wd.health.presenter.userpresenter.FindUserSickCollectionPresenter
import com.wd.health.util.SaveAndGetUIdSessIdUtil
import kotlinx.android.synthetic.main.activity_my_wallet_layout.*
import kotlinx.android.synthetic.main.fragment_healthinfo_layout.*
import kotlinx.android.synthetic.main.fragment_sickfriend_layout.*

/**
 * 时间 :2020/5/29  13:24
 * 作者 :苗恒
 * 功能 :  健康咨询的fragment
 */
class SickFriendFragment:BaseFragment<FindUserSickCollectionPresenter>(),FindUserSickCollectionContract.IView {
    override fun onLoadPresenter(): FindUserSickCollectionPresenter {
        return FindUserSickCollectionPresenter(context!!)
    }

    override fun initView(): View? {
        val inflate = LayoutInflater.from(context).inflate(R.layout.fragment_sickfriend_layout, null)
        return inflate
    }

    override fun initListener(savedInstanceState: Bundle?) {
        rv_sickFriend.layoutManager=LinearLayoutManager(context)
    }
    override fun initData() {
        val saveAndGetUIdSessIdUtil= SaveAndGetUIdSessIdUtil()
        val id = saveAndGetUIdSessIdUtil.getInt("id")
        val sessionId = saveAndGetUIdSessIdUtil.getString("sessionId")
        mPresenter.findUserSickCollection(id,sessionId,1,10)
    }

    override fun seccess(findUserSickCollectionEntity: FindUserSickCollectionEntity) {
        if (findUserSickCollectionEntity.result != null) {
            rv_sickFriend.visibility=View.VISIBLE
            rl_noMessage1.visibility=View.GONE
            rv_sickFriend.overScrollMode= View.OVER_SCROLL_NEVER  //去除阴影
            rv_sickFriend.adapter = FindUserSickCollectionAdapter(context!!, findUserSickCollectionEntity.result)
        }else{
            rv_sickFriend.visibility=View.GONE
            rl_noMessage1.visibility=View.VISIBLE
        }
    }

    override fun failur(throwable: Throwable) {

    }

}