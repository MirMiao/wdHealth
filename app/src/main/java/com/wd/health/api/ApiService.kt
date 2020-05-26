package com.bw.doctor.base.api
import com.wd.health.entity.*
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @ClassName: ApiService
 * @Description: Java类的作用
 * @Author: LazyRui
 * @CreateDate: 2020/5/19 19:33
 */
interface ApiService {
   @GET("health/user/video/v1/findVideoCategoryList")
   fun getA(): Observable<AEntity>

   //首页轮播图
   @GET(Api.BANNER_SHOW)
   fun getBanner():Observable<BannerEntity>
   //查询科室列表
   @GET(Api.KESHI_LIST)
   fun getKeShiList():Observable<KeShiEntity>
   //健康咨询板块
   @GET(Api.ZIXUN)
   fun getZiXun():Observable<ZiXunEntity>
   //健康咨询列表
   @GET(Api.ZIXUN_LIST)
   fun getZiXunList(@Query("plateId") plateId:Int, @Query("page") page:Int, @Query("count") count:Int):Observable<ZiXunListEntity>
   //根据科室查询对应病症
   @GET(Api.BINGZHENG)
   fun getBingZheng(@Query("departmentId") departmentId:Int):Observable<BingZhengEntity>
   //查询常见病症详情
   @GET(Api.BINGZHENG_XIANGQING)
   fun getBingZhengXiangQing(@Query("id") id:Int):Observable<BingZhengXiangQingEntity>

   //药品科目分类列表查询
   @GET(Api.YAOPIN)
   fun getYaoPin():Observable<YaoPinEntity>
   //根据药品类目查询常见药品
   @GET(Api.YAOPIN_LIST)
   fun getYaoPinList(@Query("drugsCategoryId") drugsCategoryId:Int,@Query("page") page:Int, @Query("count") count:Int):Observable<YaoPinListEntity>
   //查询常见药品详情
   @GET(Api.YAOPIN_XIANGQING)
   fun getYaoPinXiangQing(@Query("id") id:Int):Observable<YaoPinXiangQingEntity>














   
}