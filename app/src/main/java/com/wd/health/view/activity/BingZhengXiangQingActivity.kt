package com.wd.health.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.wd.health.R
import com.wd.health.base.BaseActivity
import com.wd.health.contract.BingZhengXiangQingContact
import com.wd.health.entity.BingZhengXiangQingEntity
import com.wd.health.presenter.BingZhengXiangQingPresenter
import kotlinx.android.synthetic.main.activity_bing_zheng_xiang_qing.*

class BingZhengXiangQingActivity : BaseActivity<BingZhengXiangQingPresenter>(),BingZhengXiangQingContact.BingZhengXiangQingV {

    override fun onLoadPresenter(): BingZhengXiangQingPresenter {
        return BingZhengXiangQingPresenter(this)
    }

    override fun initListener(savedInstanceState: Bundle?) {
        bingzhengxiangqing_recy.layoutManager=LinearLayoutManager(this)
    }

    override fun initData() {
        mPresenter.BingZhengXiangQingA(1)
    }

    override fun layoutId(): Int {
        return R.layout.activity_bing_zheng_xiang_qing
    }

    override fun BingZhengXiangQingseccess(bingZhengXiangQingEntity: BingZhengXiangQingEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun BingZhengXiangQingfailur(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
