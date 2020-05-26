package com.wd.health.entity

data class YaoPinListEntity(
    val message: String,
    val result: List<YaoPinListResult>,
    val status: String
)

data class YaoPinListResult(
    val drugsCategoryId: Int,
    val id: Int,
    val name: String,
    val picture: String
)