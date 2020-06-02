package com.wd.health.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.wd.health.EvenBus.YaoPinEvent
import com.wd.health.EvenBus.ZiXunEvent
import com.wd.health.R
import com.wd.health.adapter.ZiXunXiangQingRecyAdapter
import com.wd.health.base.BaseActivity
import com.wd.health.contract.ZiXunXiangQingContart
import com.wd.health.entity.ZiXunXiangQingEntity
import com.wd.health.presenter.ZiXunXiangQingPresenter
import kotlinx.android.synthetic.main.activity_zi_xun_xiang_qing.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class ZiXunXiangQingActivity : BaseActivity<ZiXunXiangQingPresenter>(),ZiXunXiangQingContart.ZiXunXiangQingV {
    override fun onLoadPresenter(): ZiXunXiangQingPresenter {
        return ZiXunXiangQingPresenter(this)
    }

    override fun initListener(savedInstanceState: Bundle?) {

        EventBus.getDefault().register(this)

        zixunxiangqing_fanhui.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                finish()
            }
        })

        zixunxiangqing_recy.layoutManager=LinearLayoutManager(this)


        zixunxiangqing_fenxiang.setOnClickListener({})

    }

    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    fun onYaoPinEvent(zixunEvent: ZiXunEvent){
        val zixunid = zixunEvent.zixunid
        mPresenter.ZiXunXiangQingA(zixunid!!)
    }

    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.activity_zi_xun_xiang_qing
    }

    override fun ZiXunXiangQingseccess(ziXunXiangQingEntity: ZiXunXiangQingEntity) {
        val ziXunXiangQingRecyAdapter=ZiXunXiangQingRecyAdapter(this,ziXunXiangQingEntity.result)
        zixunxiangqing_recy.adapter=ziXunXiangQingRecyAdapter
    }

    override fun ZiXunXiangQingfaliur(throwable: Throwable) {

    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }


}
