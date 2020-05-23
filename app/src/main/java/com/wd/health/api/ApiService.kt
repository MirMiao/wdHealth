package com.bw.doctor.base.api
import com.wd.health.entity.EmailCodeEntity
import com.wd.health.entity.LoginEntity
import com.wd.health.entity.RegEntity
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
   //获取邮箱验证码
   @FormUrlEncoded
    @POST(Api.GET_EMAIL_CODE)
    fun getEmailCode(@Field("email") email:String):Observable<EmailCodeEntity>
   //登陆
   @FormUrlEncoded
   @POST(Api.LOGIN)
   fun login(@Field("email") email:String,@Field("pwd") pwd:String):Observable<LoginEntity>

   //注册
   @FormUrlEncoded
   @POST(Api.REGISTER)
   fun register(@Field("email") email:String,
                @Field("code") code:Int,
                @Field("pwd1") pwd1:String,
                @Field("pwd2") pwd2:String
                ):Observable<RegEntity>
}