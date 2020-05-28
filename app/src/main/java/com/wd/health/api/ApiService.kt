package com.bw.doctor.base.api
import com.wd.health.entity.EmailCodeEntity
import com.wd.health.entity.LoginEntity
import com.wd.health.entity.RegEntity
import com.wd.health.entity.userentity.*
import io.reactivex.Observable
import kotlinx.android.parcel.RawValue
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
   fun register(@Field("email") email:String, @Field("code") code:Int, @Field("pwd1") pwd1:String, @Field("pwd2") pwd2:String):Observable<RegEntity>
    //查找用户钱包
    @GET(Api.Find_USER_WALLET)
    fun findUserWallet(@Header("userId") userId:Int,@Header("sessionId") sessionId:String):Observable<FindUserWalletEntity>
    //查找用户消费明细
    @GET(Api.FIND_USER_CONSUMPTION)
    fun findUserConsumption(@Header("userId") userId:Int,@Header("sessionId") sessionId:String,
                            @Query("page") page:Int, @Query("count") count:Int):Observable<FindUserConsumption>
    //查看用户档案
    @GET(Api.FIND_USER_ARCHIVES)
    fun findUserArchives(@Header("userId") userId:Int,@Header("sessionId") sessionId:String):Observable<FindUserArchiverEntity>
    //----------------------------------------------------------------------------------------------------------------------

     //查询用户当天是否签到
    @GET(Api.FIND_USER_SIGN_TODAY)
    fun findUserSignToday(@Header("userId") userId:Int,@Header("sessionId") sessionId:String):Observable<FindUserSignToadyEntity>

    //用户签到
    @GET(Api.ADD_USER_SIGN)
    fun addUserSign(@Header("userId") userId:Int,@Header("sessionId") sessionId:String):Observable<UserAddSignEntity>

    //查询未读消息
    @GET(Api.FIND_USER_NOTICE_READ_NUM)
    fun findUserNoticeReadNum(@Header("userId") userId:Int,@Header("sessionId") sessionId:String):Observable<FindUserNoticeReadNumEntity>

}