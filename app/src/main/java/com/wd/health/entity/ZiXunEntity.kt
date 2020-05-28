package com.wd.health.entity

data class ZiXunEntity(
    val message: String,
    val result: List<ZiXunResult>,
    val status: String
)

data class ZiXunResult(
    val id: Int,
    val name: String,
    val sort: Int
)