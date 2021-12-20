package com.example.market_news_application

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.data.news.NewsRepositoryImpl
import com.example.data.news.cache.NewsDao
import com.example.data.news.remote.NewsService
import com.example.domain.news.NewsRepository
import com.example.market_news_application.core.database.NewsDatabase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException

@RunWith(MockitoJUnitRunner::class)
class NewsRepositoryTest {

    private lateinit var newsRepository: NewsRepository
    private lateinit var newsDao: NewsDao
    private lateinit var db: NewsDatabase
    @Mock
    private lateinit var mockNewsService : NewsService

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, NewsDatabase::class.java
        ).build()
        newsDao = db.newsDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun getCorrectNewsFrom() {
        runBlocking {
            `when` (mockNewsService.fetchCompanyNews(anyString(), anyString(), anyString(), anyString()))
                .thenReturn(NewsDaoDataTestUtils.getAllRawNews())
            newsRepository = NewsRepositoryImpl(mockNewsService, newsDao)
            newsRepository.loadNews("AAPL", 0, 0)
            val newsFromDb = newsRepository.observeNews("AAPL").first()
            assert(newsFromDb.size == NewsDaoDataTestUtils.getAAPLNews().size)
        }
    }
}