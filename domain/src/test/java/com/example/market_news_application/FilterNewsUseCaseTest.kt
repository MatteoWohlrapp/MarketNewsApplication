package com.example.market_news_application

import com.example.domain.news.NewsRepository
import com.example.domain.news.usecases.FilterNewsUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FilterNewsUseCaseTest {

    @Mock
    private lateinit var repository: NewsRepository
    private lateinit var filterNewsUseCase: FilterNewsUseCase

    @Test
    @Throws(Exception::class)
    fun getRefreshedNews() {
        runBlocking {
            Mockito.`when`(repository.observeNews(anyString())).thenReturn(
                flow { emit(NewUseCaseDataTestUtils.getAllAppleNews()) }
            )
            filterNewsUseCase = FilterNewsUseCase(repository)
            val filteredNews = filterNewsUseCase.invoke(
                "AAPL",
                listOf("Machine Learning", "Cloud")
            ).first()

            assert(
                NewUseCaseDataTestUtils.getFilteredAppleNews().size == filteredNews.size
            )

        }
    }
}