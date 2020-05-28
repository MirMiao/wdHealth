package com.wd.health.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bw.doctor.base.BaseFragment
import com.wd.health.R
import com.wd.health.adapter.ZiXunRecyAdapter
import com.wd.health.contract.ZiXunListContacr
import com.wd.health.entity.ZiXunListEntity
import com.wd.health.presenter.ZiXunListPresenter
import com.wd.health.view.activity.ZiXunActivity
import kotlinx.android.synthetic.main.fragment_zixun.*

//首页咨询fragment
class ZiXunFragment:BaseFragment<ZiXunListPresenter>(),ZiXunListContacr.ZiXunListV {

    companion object{
        fun newInstance(foo:Int):ZiXunFragment{
            val arg=Bundle()
            arg.putInt("foo",foo)
            val fragment=ZiXunFragment()
            fragment.arguments=arg
            return fragment
        }
    }

    override fun onLoadPresenter(): ZiXunListPresenter {
        return ZiXunListPresenter(context!!)
    }

    override fun initView(): View? {
        val inflate = LayoutInflater.from(context).inflate(R.layout.fragment_zixun, null)
        return inflate
    }

    override fun initListener(savedInstanceState: Bundle?) {
        recy_zixun.layoutManager=LinearLayoutManager(context)

        home_quzixun.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                val arguments = arguments
                val int = arguments?.getInt("foo")
                var intent=Intent(context,ZiXunActivity::class.java)
                var bundle=Bundle()
                bundle.putInt("f",int!!)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        })

    }

    override fun initData() {
        val arguments = arguments
        val int = arguments?.getInt("foo")
        if (int != null) {
            mPresenter.ZiXunListA(int,1,5)
        }
    }

    override fun zixunlistseccess(ziXunListEntity: ZiXunListEntity) {
        val ziXunRecyAdapter = ZiXunRecyAdapter(context!!, ziXunListEntity.result)
        recy_zixun.adapter=ziXunRecyAdapter
    }

    override fun zixunfailur(throwable: Throwable) {

    }


}