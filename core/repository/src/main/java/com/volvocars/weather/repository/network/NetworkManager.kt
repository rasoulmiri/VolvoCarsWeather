package com.volvocars.weather.repository.network

import android.content.Context
import com.github.simonpercic.oklog3.OkLogInterceptor
import com.volvocars.weather.base.extension.GsonUtils
import com.volvocars.weather.repository.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkManager(
    private val context: Context,
) {

    fun <T> create(serviceClass: Class<T>): T = getClient().create(serviceClass)

    private fun getClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonUtils.gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(OkHttpClient.Builder()
                .apply {
                    if (BuildConfig.DEBUG) {
                        logInterceptor()
                        okLogInterceptor()
                    }
                }
                .readTimeout(120, TimeUnit.SECONDS)
                .connectTimeout(120, TimeUnit.SECONDS)
                .build())
            .build()
    }


    private fun OkHttpClient.Builder.logInterceptor(): OkHttpClient.Builder {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return this.addInterceptor(interceptor)
    }


    private fun OkHttpClient.Builder.okLogInterceptor(): OkHttpClient.Builder {
        val okLogInterceptor = OkLogInterceptor.builder().build()
        return this.addInterceptor(okLogInterceptor)
    }
}
