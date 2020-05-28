package com.wd.health.entity

data class ZiXunListEntity(
    val message: String,
    val result: List<ZiXunListResult>,
    val status: String
)

data class ZiXunListResult(
    val id: Int,
    val plateId: Int,
    val releaseTime: Long,
    val source: String,
    val thumbnail: String,
    val title: String
)