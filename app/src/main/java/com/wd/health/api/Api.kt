package com.bw.doctor.base.api

/**
 * @ClassName: Api
 * @Description: Java类的作用
 * @Author: LazyRui
 * @CreateDate: 2020/5/19 20:32
 */
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


}