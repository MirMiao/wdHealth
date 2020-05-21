package com.bw.doctor.base.api
import com.wd.health.entity.AEntity
import io.reactivex.Observable
import org.reactivestreams.Subscriber
import retrofit2.http.*

/**
 * @ClassName: ApiService
 * @Description: Java类的作用
 * @Author: LazyRui
 * @CreateDate: 2020/5/19 19:33
 */
interface ApiService {
   @GET("health/user/video/v1/findVideoCategoryList")
   fun getA():Observable<AEntity>
}