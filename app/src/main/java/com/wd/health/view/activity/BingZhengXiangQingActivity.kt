package com.wd.health.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.wd.health.EvenBus.BingZhengEvent
import com.wd.health.R
import com.wd.health.adapter.BingZhengXiangQingRecyAdapter
import com.wd.health.base.BaseActivity
import com.wd.health.contract.BingZhengXiangQingContact
import com.wd.health.entity.BingZhengXiangQingEntity
import com.wd.health.presenter.BingZhengXiangQingPresenter
import kotlinx.android.synthetic.main.activity_bing_zheng_xiang_qing.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class BingZhengXiangQingActivity : BaseActivity<BingZhengXiangQingPresenter>(),BingZhengXiangQingContact.BingZhengXiangQingV {

    override fun onLoadPresenter(): BingZhengXiangQingPresenter {
        return BingZhengXiangQingPresenter(this)
    }

    override fun initListener(savedInstanceState: Bundle?) {

       EventBus.getDefault().register(this)

        bingzhengxiangqing_recy.layoutManager=LinearLayoutManager(this)
    }

    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    fun onBingZhengEvent(bingZhengEvet: BingZhengEvent){
        val bingzhengid = bingZhengEvet.bingzhengid
        mPresenter.BingZhengXiangQingA(bingzhengid!!)
    }

    override fun initData() {
    }

    override fun layoutId(): Int {
        return R.layout.activity_bing_zheng_xiang_qing
    }

    override fun BingZhengXiangQingseccess(bingZhengXiangQingEntity: BingZhengXiangQingEntity) {
        val xiangqingrecy=BingZhengXiangQingRecyAdapter(this,bingZhengXiangQingEntity.result)
        bingzhengxiangqing_recy.adapter=xiangqingrecy
    }

    override fun BingZhengXiangQingfailur(throwable: Throwable) {

    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

}
