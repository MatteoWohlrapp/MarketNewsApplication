package com.example.domain.news.usecases

import com.example.domain.news.NewsRepository
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject
import kotlin.math.pow

class LoadMoreNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {

    suspend fun invoke(symbol: String){
        println("loading more news")
        val oldestNews = newsRepository.loadOldestNews(symbol)
        val oldestDate = oldestNews?.datetime ?: System.currentTimeMillis()
        newsRepository.loadNews(symbol, TimeUtil.oneDayEarlier(oldestDate), oldestDate)
    }
}