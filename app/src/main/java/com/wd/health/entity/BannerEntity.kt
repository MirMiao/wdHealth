package com.wd.health.entity

import com.bigkoo.convenientbanner.ConvenientBanner


data class BannerEntity(
    val message: String,
    val result: List<BannerResult>,
    val status: String
)

 data class BannerResult(
    val imageUrl: String,
    val jumpUrl: String,
    val rank: Int,
    val title: String
)