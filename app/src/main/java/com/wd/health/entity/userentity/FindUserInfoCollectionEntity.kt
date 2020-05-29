package com.wd.health.entity.userentity

/**
 * 时间 :2020/5/29  20:17
 * 作者 :苗恒
 * 功能 : 查询用户资讯收藏列表
 */
data class FindUserInfoCollectionEntity(
    val message: String,
    val result: List<Result4>,
    val status: String
)

data class Result4(
    val createTime: Long,
    val id: Int,
    val infoId: Int,
    val thumbnail: String,
    val title: String
)