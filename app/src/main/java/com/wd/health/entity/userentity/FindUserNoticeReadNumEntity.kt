package com.wd.health.entity.userentity

/**
 * 时间 :2020/5/28  14:47
 * 作者 :苗恒
 * 功能 :  查询用户未读的消息
 */
data class FindUserNoticeReadNumEntity(
    val message: String,
    val result: List<Result3>,
    val status: String
)

data class Result3(
    val notReadNum: Int,
    val noticeType: Int
)