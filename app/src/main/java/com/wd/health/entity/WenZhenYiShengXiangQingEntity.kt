package com.wd.health.entity

data class WenZhenYiShengXiangQingEntity(
    val message: String,
    val result: WenZhenYiShengXiangQingResult,
    val status: String
)

data class WenZhenYiShengXiangQingResult(
    val badNum: Int,
    val commentList: List<WenZhenYiShengXiangQingComment>,
    val commentNum: Int,
    val doctorId: Int,
    val doctorName: String,
    val doctorReceiveGiftList: List<Any>,
    val followFlag: Int,
    val goodField: String,
    val imagePic: String,
    val inauguralHospital: String,
    val jobTitle: String,
    val personalProfile: String,
    val praise: String,
    val praiseNum: Int,
    val serverNum: Int,
    val servicePrice: Int
)

data class WenZhenYiShengXiangQingComment(
    val commentTime: Long,
    val content: String,
    val headPic: String,
    val nickName: String
)