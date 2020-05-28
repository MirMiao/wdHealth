package com.wd.health.weight

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.wd.health.R

class SousuoItemView: RelativeLayout {

    constructor(context: Context?):super(context)
    constructor(context: Context?, attrs: AttributeSet?):super(context,attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyeAttr:Int):super(context,attrs,defStyeAttr)

    init {
        View.inflate(context,R.layout.item_sousuo,this)
    }

}