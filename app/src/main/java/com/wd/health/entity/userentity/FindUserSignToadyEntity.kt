package com.wd.health.entity.userentity

/**
 * 时间 :2020/5/28  14:35
 * 作者 :苗恒
 * 功能 :  查询用户当天是否签到
 */
data class FindUserSignToadyEntity(
    val message: String,
    val result: Int,
    val status: String
)