package com.wd.health.entity.userentity

/**
 * 时间 :2020/5/26  15:44
 * 作者 :苗恒
 * 功能 : 用户查看自己的档案
 */
data class FindUserArchiverEntity(
    val message: String,
    val result: Result1,
    val status: String
)

data class Result1(
    val diseaseBefore: String,
    val diseaseMain: String,
    val diseaseNow: String,
    val id: Int,
    val picture: String,
    val treatmentEndTime: Long,
    val treatmentHospitalRecent: String,
    val treatmentProcess: String,
    val treatmentStartTime: Long,
    val userId: Int
)