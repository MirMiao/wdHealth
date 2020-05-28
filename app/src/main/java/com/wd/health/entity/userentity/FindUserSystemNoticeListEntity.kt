package com.wd.health.entity.userentity

/**
 * 时间 :2020/5/28  14:33
 * 作者 :苗恒
 * 功能 :  查询系统用户通知
 */
data class FindUserSystemNoticeListEntity(
    val message: String,
    val result: List<Result2>,
    val status: String
)

data class Result2(
    val content: String,
    val createTime: Long,
    val id: Int
)