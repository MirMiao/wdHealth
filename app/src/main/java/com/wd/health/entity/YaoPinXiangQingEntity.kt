package com.wd.health.entity

data class YaoPinXiangQingEntity(
    val message: String,
    val result: YaoPinXiangQingResult,
    val status: String
)

data class YaoPinXiangQingResult(
    val approvalNumber: String,
    val component: String,
    val createTime: Long,
    val drugsCategoryId: Int,
    val effect: String,
    val id: Int,
    val mindMatter: String,
    val name: String,
    val packing: String,
    val picture: String,
    val shape: String,
    val sideEffects: String,
    val storage: String,
    val taboo: String,
    val usage: String
)