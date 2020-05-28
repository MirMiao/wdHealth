package com.wd.health.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.bw.doctor.base.BaseFragment
import com.wd.health.R
import com.wd.health.adapter.YaoPinRecyAdapter
import com.wd.health.contract.YaoPinContact
import com.wd.health.entity.YaoPinListEntity
import com.wd.health.presenter.YaoPinPresenter
import kotlinx.android.synthetic.main.fragment_yaopin.*

class YaoPinFragment:BaseFragment<YaoPinPresenter>(), YaoPinContact.YaoPinV  {

    companion object{
        fun newInstance(fo:Int):YaoPinFragment{
            val arg=Bundle()
            arg.putInt("fo",fo)
            val fragment=YaoPinFragment()
            fragment.arguments=arg
            return fragment
        }
    }

    override fun onLoadPresenter(): YaoPinPresenter {
        return YaoPinPresenter(context!!)
    }

    override fun initView(): View? {
        val inflate = LayoutInflater.from(context).inflate(R.layout.fragment_yaopin, null)
        return inflate
    }

    override fun initListener(savedInstanceState: Bundle?) {

        yaopin_recy.layoutManager=GridLayoutManager(context,2)

    }

    override fun initData() {
        val arguments = arguments
        val int = arguments?.getInt("fo")
        mPresenter.YaoPinA(int!!,1,5)
    }

    override fun YaoPinseccess(yaoPinListEntity: YaoPinListEntity) {
        val yaopinRecyAdapter= YaoPinRecyAdapter(context!!,yaoPinListEntity.result)
        yaopin_recy.adapter=yaopinRecyAdapter
    }

    override fun YaoPinFailur(throwable: Throwable) {

    }

}