package com.wd.health.entity

//科室列表
data class KeShiEntity(
    val message: String,
    val result: List<KeShiResult>,
    val status: String
)

data class KeShiResult(
    val departmentName: String,
    val id: Int,
    val pic: String,
    val rank: Int
)