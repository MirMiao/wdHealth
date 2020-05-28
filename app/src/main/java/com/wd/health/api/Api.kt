package com.bw.doctor.base.api


object Api {
    const val BASE_URL:String = "http://mobile.bwstudent.com/" //base
    const val GET_EMAIL_CODE:String="health/user/v1/sendOutEmailCode" //获取邮箱验证码
    const val LOGIN:String="health/user/v1/login" //登陆
    const val REGISTER:String="health/user/v1/register" //注册
    const val Find_USER_WALLET:String="health/user/verify/v1/findUserWallet" //查找用户钱包
    const val FIND_USER_CONSUMPTION:String="health/user/verify/v1/findUserConsumptionRecordList" //查找用户消费记录

    const val ADD_USER_ARCHIVES:String="health/user/verify/v1/addUserArchives" //添加用户档案
    const val FIND_USER_ARCHIVES:String="health/user/verify/v1/findUserArchives" //查找用户档案
    const val UPDATE_USER_CONSUMPTION:String="health/user/verify/v1/updateUserArchives" //编辑用户档案
    const val DELETE_USER_CONSUMPTION:String="health/user/verify/v1/findUserConsumptionRecordList" //删除用户档案



    const val FIND_USER_SIGN_TODAY:String="health/user/verify/v1/whetherSignToday" //查询用户当天是否签到
    const val ADD_USER_SIGN:String="health/user/verify/v1/whetherSignToday" //用户签到
    const val FIND_USER_SYSTEMNOTICE_LIST:String="health/user/verify/v1/whetherSignToday" //查询用户的系统通知
    const val FIND_USER_NOTICE_READ_NUM:String="health/user/verify/v1/findUserNoticeReadNum" //查询用户的未读消息



}