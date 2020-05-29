package com.wd.health.entity.userentity

/**
 * 时间 :2020/5/29  20:20
 * 作者 :苗恒
 * 功能 :  查询用户收藏病友圈列表
 */
data class FindUserSickCollectionEntity(
    val message: String,
    val result: List<Result5>,
    val status: String
)

data class Result5(
    val collectionNum: Int,
    val commentNum: Int,
    val createTime: Long,
    val disease: String,
    val id: Int,
    val sickCircleId: Int,
    val title: String
)