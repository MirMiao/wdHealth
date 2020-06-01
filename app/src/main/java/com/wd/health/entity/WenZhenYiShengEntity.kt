package com.wd.health.entity

data class WenZhenYiShengEntity(
    val message: String,
    val result: List<WenZhenYiShengResult>,
    val status: String
)

data class WenZhenYiShengResult(
    val badNum: Int,
    val doctorId: Int,
    val doctorName: String,
    val imagePic: String,
    val inauguralHospital: String,
    val jobTitle: String,
    val praise: String,
    val praiseNum: Int,
    val serverNum: Int,
    val servicePrice: Int
)