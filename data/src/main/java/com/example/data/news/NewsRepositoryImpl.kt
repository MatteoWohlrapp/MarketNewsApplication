package com.example.data.news

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.data.news.cache.NewsDao
import com.example.data.news.cache.model.mapToNews
import com.example.data.news.cache.model.mapToNewsLocal
import com.example.data.news.remote.NewsService
import com.example.domain.news.NewsRepository
import com.example.domain.news.model.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService,
    private val newsDao: NewsDao
)
    : NewsRepository{

    private val token = "c2iecvaad3i8gi7peso0"

    override suspend fun observeNews(symbol: String) :  Flow<List<News>>{
        return newsDao.getNewsFlow(symbol).map { it.mapToNews() }
    }

    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    override suspend fun loadNews(symbol: String, from: Long, to: Long) {
        val fromString = DateUtil.mapTimestampToDate(from)
        val toString = DateUtil.mapTimestampToDate(to)
        val newsLocal = newsService.fetchCompanyNews(symbol, fromString, toString, token).
                mapToNewsLocal()

        newsDao.insertAll(newsLocal)
    }

    override suspend fun loadOldestNews(symbol: String): News? {
        return newsDao.requestOldestNews(symbol)?.mapToNews()
    }

    override suspend fun loadNewestNews(symbol: String): News? {
        return newsDao.requestNewestNews(symbol)?.mapToNews()
    }

    override suspend fun loadNewsById(id: Int): News? {
        return newsDao.getNewsById(id)?.mapToNews()
    }
}