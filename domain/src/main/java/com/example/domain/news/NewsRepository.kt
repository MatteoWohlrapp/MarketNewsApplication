package com.example.domain.news

import com.example.domain.news.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun observeNews(symbol: String) : Flow<List<News>>

    suspend fun loadNews(symbol: String, from: Long, to: Long)

    suspend fun loadOldestNews(symbol: String) : News?

    suspend fun loadNewestNews(symbol: String) : News?

    suspend fun loadNewsById(id: Int) : News?

}