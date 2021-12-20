package com.example.domain.news.usecases

import com.example.domain.news.NewsRepository
import com.example.domain.news.model.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FilterNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    fun invoke(symbol: String, keywords: List<String>): Flow<List<News>> {
        return flow {
            repository.observeNews(symbol).collect {
                val relevantNews = mutableListOf<News>()
                for(news in it){
                    var relevant = true
                    for(keyword in keywords){
                        if(!news.headline.contains(keyword))
                            relevant = false
                    }
                    if (relevant)
                        relevantNews.add(news)
                }
                emit(relevantNews)
            }
        }
    }
}