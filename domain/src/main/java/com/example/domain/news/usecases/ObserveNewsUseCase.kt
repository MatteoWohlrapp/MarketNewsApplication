package com.example.domain.news.usecases

import com.example.domain.news.NewsRepository
import com.example.domain.news.model.News
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext

class ObserveNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    private val symbol = MutableStateFlow("AAPL")

    suspend fun invoke(): Flow<List<News>> {
        return symbol.flatMapLatest{
            newsRepository.observeNews(it)
        }
    }

    suspend fun updateSymbol(symbol: String) {
        this.symbol.emit(symbol)
    }

}