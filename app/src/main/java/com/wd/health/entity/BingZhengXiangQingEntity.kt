package com.wd.health.entity

data class BingZhengXiangQingEntity(
    val message: String,
    val result: BingZhengXiangQingResult,
    val status: String
)

data class BingZhengXiangQingResult(
    val benefitTaboo: String,
    val createTime: Long,
    val diseaseCategoryId: Int,
    val id: Int,
    val pathology: String,
    val symptom: String,
    val chineseMedicineTreatment:String,
    val westernMedicineTreatment: String
)