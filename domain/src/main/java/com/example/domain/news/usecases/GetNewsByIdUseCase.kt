package com.example.domain.news.usecases

import com.example.domain.news.NewsRepository
import com.example.domain.news.model.News
import javax.inject.Inject

class GetNewsByIdUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend fun invoke(id : Int) : News {
        var news = newsRepository.loadNewsById(id)

        if(news == null)
            news = News()

        println("News: ${news.headline}")

        return news
    }
}