package com.wd.health.entity

data class ZiXunXiangQingEntity(
    val message: String,
    val result: ZiXunXiangQingResult,
    val status: String
)

data class ZiXunXiangQingResult(
    val content: String,
    val id: Int,
    val releaseTime: Long,
    val source: String,
    val title: String,
    val whetherCollection: Int
)