package com.wd.health.entity

/**
 * 时间 :2020/5/21  16:27
 * 作者 :苗恒
 * 功能 :
 */
data class AEntity(
    val message: String,
    val result: List<Result>,
    val status: String
)

data class Result(
    val id: Int,
    val name: String
)