package com.wd.health.entity

data class BingZhengEntity(
    val message: String,
    val result: List<BingZhengResult>,
    val status: String
)

data class BingZhengResult(
    val departmentId: Int,
    val id: Int,
    val name: String
)