package com.wd.health.view.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.bw.doctor.base.BaseFragment
import com.wd.health.R
import com.wd.health.adapter.BingZhengRecyAdapter
import com.wd.health.adapter.MyKeShiPagerAdapter
import com.wd.health.contract.BingZhengContact
import com.wd.health.entity.BingZhengEntity
import com.wd.health.presenter.BingZhengPresenter
import kotlinx.android.synthetic.main.fragment_bingzheng.*

class BingZhengFragment:BaseFragment<BingZhengPresenter>(),BingZhengContact.BingZhengV {

    companion object{
        fun newInstance(foo:Int):BingZhengFragment{
            val arg=Bundle()
            arg.putInt("foo",foo)
            val fragment=BingZhengFragment()
            fragment.arguments=arg
            return fragment
        }
    }

    override fun onLoadPresenter(): BingZhengPresenter {
        return BingZhengPresenter(context!!)
    }

    override fun initView(): View? {
        val inflate = layoutInflater.inflate(R.layout.fragment_bingzheng, null)
        return inflate
    }

    override fun initListener(savedInstanceState: Bundle?) {
        bingzheng_recy.layoutManager=GridLayoutManager(context,2)

    }

    override fun initData() {
        val arguments = arguments
        val int = arguments?.getInt("foo")
        if (int != null) {
            mPresenter.BingZhengA(int)
        }
    }

    override fun bingzhengseccess(bingZhengEntity: BingZhengEntity) {
       val bingZhengRecyAdapter=BingZhengRecyAdapter(context!!,bingZhengEntity.result)
        bingzheng_recy.adapter=bingZhengRecyAdapter

    }

    override fun bingzhengfailur(throwable: Throwable) {

    }
}