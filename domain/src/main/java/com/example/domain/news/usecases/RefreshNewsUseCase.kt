package com.example.domain.news.usecases

import com.example.domain.news.NewsRepository
import javax.inject.Inject

class RefreshNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend fun invoke(symbol: String){
        val now = System.currentTimeMillis()
        val lastRequest = newsRepository.loadNewestNews(symbol)

        val lastRequestDate = lastRequest?.datetime ?: TimeUtil.oneDayEarlier(now)

        newsRepository.loadNews(symbol, lastRequestDate, now)
    }
}