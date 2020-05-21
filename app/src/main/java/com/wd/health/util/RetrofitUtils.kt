package com.bw.doctor.base.utils

import com.bw.doctor.base.api.Api
import com.bw.doctor.base.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * @ClassName: RrrtrofitUtils
 * @Description: Java类的作用
 * @Author: LazyRui
 * @CreateDate: 2020/5/19 19:23
 */
class RetrofitUtils private constructor(){

    companion object {

        private fun <T> getService(baseUrl: String, service: Class<T>): T {

            var clien = OkHttpClient.Builder()
                //自定义拦截器用于日志输出
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            val retrofit = Retrofit.Builder().baseUrl(baseUrl)
                //格式转换
                .addConverterFactory(GsonConverterFactory.create())
                //正常的retrofit返回的是call，此方法用于将call转化成Rxjava的Observable或其他类型
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(clien)
                .build()
            return retrofit.create(service)
        }

        //可用于多种不同种类的请求
        fun createService(): ApiService {
            return getService(Api.BASE_URL, ApiService::class.java)
        }

    }


}