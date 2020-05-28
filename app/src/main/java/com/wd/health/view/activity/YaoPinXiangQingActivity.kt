package com.wd.health.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.wd.health.EvenBus.YaoPinEvent
import com.wd.health.R
import com.wd.health.adapter.YaoPinXiangQingRecyAdapter
import com.wd.health.base.BaseActivity
import com.wd.health.contract.YaoPinXiangQingContart
import com.wd.health.entity.YaoPinXiangQingEntity
import com.wd.health.presenter.YaoPinXiangQingPresenter
import kotlinx.android.synthetic.main.activity_yao_pin_xiang_qing.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class YaoPinXiangQingActivity : BaseActivity<YaoPinXiangQingPresenter>(),YaoPinXiangQingContart.YaoPinXiangQingV {

    override fun onLoadPresenter(): YaoPinXiangQingPresenter {
        return YaoPinXiangQingPresenter(this)
    }

    override fun initListener(savedInstanceState: Bundle?) {
        EventBus.getDefault().register(this)

        yaopinxiangqing_recy.layoutManager=LinearLayoutManager(this)


    }

    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    fun onYaoPinEvent(yaoPinEvent: YaoPinEvent){
        val yaopinid = yaoPinEvent.yaopinid
        mPresenter.YaoPinXiangQingA(yaopinid!!)
    }

    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.activity_yao_pin_xiang_qing
    }

    override fun YaoPinXiangQingsuccess(yaoPinXiangQingEntity: YaoPinXiangQingEntity) {
        val yaopinxiangqingrecy=YaoPinXiangQingRecyAdapter(this,yaoPinXiangQingEntity.result)
        yaopinxiangqing_recy.adapter=yaopinxiangqingrecy
    }

    override fun YaoPinXiangQingfaliur(throwable: Throwable) {

    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

}
