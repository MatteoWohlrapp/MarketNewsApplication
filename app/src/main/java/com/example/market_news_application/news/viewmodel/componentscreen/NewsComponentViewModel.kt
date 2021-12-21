package com.example.market_news_application.news.viewmodel.componentscreen

import androidx.lifecycle.MutableLiveData
import com.example.domain.news.model.News

interface NewsComponentViewModel {

    val news : MutableLiveData<News>
    val isLoading : MutableLiveData<Boolean>

    fun getNews(id: Int)

     fun clearNews()
}