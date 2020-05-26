package com.wd.health.entity

data class YaoPinEntity(
    val message: String,
    val result: List<YaoPinResult>,
    val status: String
)

data class YaoPinResult(
    val id: Int,
    val name: String,
    val rank: Int
)