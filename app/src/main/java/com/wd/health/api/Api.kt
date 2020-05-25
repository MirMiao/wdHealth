package com.bw.doctor.base.api


object Api {
    const val BASE_URL:String = "http://mobile.bwstudent.com/" //base
    const val GET_EMAIL_CODE:String="health/user/v1/sendOutEmailCode" //获取邮箱验证码
    const val LOGIN:String="health/user/v1/login" //登陆
    const val REGISTER:String="health/user/v1/register" //注册
    const val Find_USER_WALLET:String="health/user/verify/v1/findUserWallet" //查找用户钱包
    const val FIND_USER_CONSUMPTION:String="health/user/verify/v1/findUserConsumptionRecordList" //查找用户消费记录


}