package com.wd.health.entity.userentity

/**
 * 时间 :2020/5/25  20:03
 * 作者 :苗恒
 * 功能 :  查找用户钱包
 */
data class FindUserWalletEntity(
    val message: String,
    val result: Int,
    val status: String
)