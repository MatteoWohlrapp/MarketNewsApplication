package com.example.data.news.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object NewsServiceFactory {

    fun makeNewsService() : NewsService{
        val retrofit = Retrofit.Builder().
                baseUrl("https://finnhub.io/api/v1/").
                client(makeHttpClient()).
                addConverterFactory(MoshiConverterFactory.create()).
                build()
        return retrofit.create(NewsService :: class.java)
    }

    private fun makeHttpClient() : OkHttpClient {
        val builder = OkHttpClient.Builder()

        return builder.connectTimeout(120, TimeUnit.SECONDS).
                readTimeout(120, TimeUnit.SECONDS).
                build()
    }
}