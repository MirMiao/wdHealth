package com.wd.health.entity

/**
 * 时间 :2020/5/23  15:58
 * 作者 :苗恒
 * 功能 :
 */
data class LoginEntity(
    val message: String,
    val result: Result,
    val status: String
)

data class Result(
    val age: Int,
    val email: String,
    val headPic: String,
    val height: Int,
    val id: Int,
    val invitationCode: String,
    val jiGuangPwd: String,
    val nickName: String,
    val sessionId: String,
    val sex: Int,
    val userName: String,
    val weight: Int,
    val whetherBingWeChat: Int
)