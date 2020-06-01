package com.wd.health.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bw.doctor.base.BaseFragment
import com.wd.health.EvenBus.YiShengEvent
import com.wd.health.R
import com.wd.health.adapter.WenZhenYiShengRecyAdapter
import com.wd.health.adapter.WenZhenYiShengXiangQingRecyAdapter
import com.wd.health.contract.WenZhenYiShengContart
import com.wd.health.entity.WenZhenYiShengEntity
import com.wd.health.entity.WenZhenYiShengXiangQingEntity
import com.wd.health.presenter.WenZhenYiShengPresenter
import kotlinx.android.synthetic.main.fragment_wenzhenyisheng.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class WenZhenFragment:BaseFragment<WenZhenYiShengPresenter>(),WenZhenYiShengContart.WenZhenYiShengV,WenZhenYiShengRecyAdapter.onYiShengID {

    companion object{
        fun newInstance(foo:Int):WenZhenFragment{
            val arg=Bundle()
            arg.putInt("foo",foo)
            val fragment=WenZhenFragment()
            fragment.arguments=arg
            return fragment
        }
    }

    override fun onLoadPresenter(): WenZhenYiShengPresenter {
        return WenZhenYiShengPresenter(context!!)
    }

    override fun initView(): View? {
        val inflate = LayoutInflater.from(context).inflate(R.layout.fragment_wenzhenyisheng, null)
        return inflate
    }

    override fun initListener(savedInstanceState: Bundle?) {

        val arguments = arguments
        val int = arguments?.getInt("foo")
        wenzhen_rp.setOnCheckedChangeListener(object :RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when(checkedId){
                    R.id.wenzhen_rb1-> mPresenter.WenZhenYiShengA(int!!,1,0,1,5)
                    R.id.wenzhen_rb2-> mPresenter.WenZhenYiShengA(int!!,2,0,1,5)
                    R.id.wenzhen_rb3-> mPresenter.WenZhenYiShengA(int!!,3,0,1,5)
                    R.id.wenzhen_rb4-> mPresenter.WenZhenYiShengA(int!!,4,0,1,5)
                }
            }
        })

        wenzhen_yisheng.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        wenzhen_yishengxiangqing.layoutManager=LinearLayoutManager(context)


    }

    override fun initData() {



    }

    override fun WenZhenYiShengseccess(wenZhenYiShengEntity: WenZhenYiShengEntity) {
        val wenZhenYiShengRecyAdapter=WenZhenYiShengRecyAdapter(context!!,wenZhenYiShengEntity.result)
        wenzhen_yisheng.adapter=wenZhenYiShengRecyAdapter
    }

    override fun WenZhenYiShengfaliur(throwable: Throwable) {

    }

    override fun WenZhenYiShengXiangQingseccess(wenZhenYiShengXiangQingEntity: WenZhenYiShengXiangQingEntity) {
        val wenZhenYiShengXiangQingRecyAdapter=WenZhenYiShengXiangQingRecyAdapter(context!!,wenZhenYiShengXiangQingEntity.result)
        wenzhen_yishengxiangqing.adapter=wenZhenYiShengXiangQingRecyAdapter
    }

    override fun WenZhenYiShengXiangQingfaliur(throwable: Throwable) {

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onYiShengClick(id: Int) {
        mPresenter.WenZhenYiShengXiangQingA(id)
    }

}