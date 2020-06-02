package com.bw.doctor.base.api


object Api {
    const val BASE_URL:String = "http://mobile.bwstudent.com/"
    //首页轮播图
    const val BANNER_SHOW:String="health/share/v1/bannersShow"
    //查询科室列表
    const val KESHI_LIST="health/share/knowledgeBase/v1/findDepartment"
    //健康咨询板块
    const val ZIXUN="health/share/information/v1/findInformationPlateList"
    //健康咨询列表
    const val ZIXUN_LIST="health/share/information/v1/findInformationList"
    //健康咨询详情
    const val ZIXUN_XIANGQING="health/share/information/v1/findInformation"
    //根据科室查询对应病症
    const val BINGZHENG="health/share/knowledgeBase/v1/findDiseaseCategory"
    //查询常见病症详情
    const val BINGZHENG_XIANGQING="health/share/knowledgeBase/v1/findDiseaseKnowledge"

    //药品科目分类列表查询
    const val YAOPIN="health/share/knowledgeBase/v1/findDrugsCategoryList"
    //根据药品类目查询常见药品
    const val YAOPIN_LIST="health/share/knowledgeBase/v1/findDrugsKnowledgeList"
    //查询常见药品详情
    const val YAOPIN_XIANGQING="health/share/knowledgeBase/v1/findDrugsKnowledge"

    //查询问诊医生列表
    const val WENZHEN_YISHEN="health/user/inquiry/v1/findDoctorList"
    //问诊医生详情
    const val WENZHEN_YISHENGXIANGQING="health/user/inquiry/v1/findDoctorInfo"


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
    const val ADD_USER_SIGN:String="health/user/verify/v1/addSign" //用户签到
    const val FIND_USER_SYSTEMNOTICE_LIST:String="health/user/verify/v1/whetherSignToday" //查询用户的系统通知
    const val FIND_USER_NOTICE_READ_NUM:String="health/user/verify/v1/findUserNoticeReadNum" //查询用户的未读消息


    const val UPDATE_USER_PWD:String="health/user/verify/v1/updateUserPwd" //修改用户密码

    const val FIND_USERINFO_COLLECTION:String="health/user/verify/v1/findUserInfoCollectionList" //查询用户资讯收藏列表
    const val FIND_USER_SICK_COLLECTION:String="health/user/verify/v1/findUserSickCollectionList" //查询用户病友圈收藏列表



    const val CHECK_CODE:String="health/user/v1/checkCode" //校验验证码
    const val RESETTING_PWD:String="health/user/v1/resetUserPwd" //重置密码





}