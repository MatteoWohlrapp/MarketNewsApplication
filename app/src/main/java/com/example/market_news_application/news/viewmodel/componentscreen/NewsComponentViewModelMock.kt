package com.example.market_news_application.news.viewmodel.componentscreen

import androidx.lifecycle.MutableLiveData
import com.example.domain.news.model.News

class NewsComponentViewModelMock  : NewsComponentViewModel {

    override val news = MutableLiveData(News())
    override val isLoading = MutableLiveData(false)


    override fun getNews(id: Int) {
    }

    override fun clearNews() {
    }
}