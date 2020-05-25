package com.wd.health.entity.userentity

/**
 * 时间 :2020/5/25  20:03
 * 作者 :苗恒
 * 功能 :  查找用户消费记录
 */
data class FindUserConsumption(
    val message: String,
    val result: List<Result>,
    val status: String
)

data class Result(
    val changeNum: Int,
    val createTime: Long,
    val direction: Int,
    val remark: String,
    val type: Int
)