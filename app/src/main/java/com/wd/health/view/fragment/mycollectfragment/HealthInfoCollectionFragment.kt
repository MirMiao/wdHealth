package com.wd.health.view.fragment.mycollectfragment

import android.opengl.Visibility
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
import com.wd.health.contract.usercontract.FindUserInfoCollectionContract
import com.wd.health.entity.userentity.FindUserInfoCollectionEntity
import com.wd.health.model.usermode.FindUserInfoCollectionModel
import com.wd.health.presenter.userpresenter.FindUserInfoCollectionPresenter
import com.wd.health.util.SaveAndGetUIdSessIdUtil
import kotlinx.android.synthetic.main.fragment_healthinfo_layout.*

/**
 * 时间 :2020/5/29  13:24
 * 作者 :苗恒
 * 功能 :  健康咨询的fragment
 */
class HealthInfoCollectionFragment:BaseFragment<FindUserInfoCollectionPresenter>(),FindUserInfoCollectionContract.IView {
    override fun onLoadPresenter(): FindUserInfoCollectionPresenter {
        return FindUserInfoCollectionPresenter(context!!)
    }

    override fun initView(): View? {
        val inflate = LayoutInflater.from(context).inflate(R.layout.fragment_healthinfo_layout, null)
        return inflate
    }

    override fun initListener(savedInstanceState: Bundle?) {
        rv_healthInfo.layoutManager = LinearLayoutManager(context)
    }

    override fun initData() {
       val saveAndGetUIdSessIdUtil=SaveAndGetUIdSessIdUtil()
        val id = saveAndGetUIdSessIdUtil.getInt("id")
        val sessionId = saveAndGetUIdSessIdUtil.getString("sessionId")
        mPresenter.findUserInfoCollection(id,sessionId,1,5)
    }

    override fun seccess(findUserInfoCollectionEntity: FindUserInfoCollectionEntity) {
        myToast("${findUserInfoCollectionEntity.result}")
        if (findUserInfoCollectionEntity.result != null) {
            rv_healthInfo.visibility=View.VISIBLE
            rl_noMessage.visibility=View.GONE
            rv_healthInfo.adapter = FindUserInfoCollectionAdapter(context!!, findUserInfoCollectionEntity.result)
        }else{
            rv_healthInfo.visibility=View.GONE
            rl_noMessage.visibility=View.VISIBLE
        }
    }
    override fun failur(throwable: Throwable) {
    }

}