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


    const val GET_EMAIL_CODE:String="health/user/v1/sendOutEmailCode" //获取邮箱验证码
    const val LOGIN:String="health/user/v1/login" //登陆
    const val REGISTER:String="health/user/v1/register" //注册
    const val Find_USER_WALLET:String="health/user/verify/v1/findUserWallet" //查找用户钱包
    const val FIND_USER_CONSUMPTION:String="health/user/verify/v1/findUserConsumptionRecordList" //查找用户消费记录


}