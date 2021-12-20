package com.example.data.news.remote

import com.example.data.news.remote.model.NewsRaw
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("company-news")
    suspend fun fetchCompanyNews(@Query(value = "symbol") symbol : String,
                                 @Query(value = "from") from : String,
                                 @Query(value = "to") to : String,
                                 @Query(value = "token") token: String) : List<NewsRaw>
}