package com.example.mystarwarslist.di

import android.content.Context
import com.example.mystarwarslist.common.Constants
import com.example.mystarwarslist.data.network.MyStarWarsListService
import com.github.ajalt.timberkt.Timber
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class RetrofitModule {
    @Provides
    fun provideGson(): Gson =
        GsonBuilder()
            .create()

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor { message ->
            Timber.tag("network").v(message)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor, context: Context): OkHttpClient {

        val clientBuilder = OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addNetworkInterceptor(loggingInterceptor)

        return clientBuilder.build()
    }

    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

    @Provides
    fun provideService(retrofit: Retrofit): MyStarWarsListService =
        retrofit.create(MyStarWarsListService::class.java)
}