package com.example.market_news_application.news.viewmodel.listscreen

import androidx.lifecycle.MutableLiveData
import com.example.domain.news.model.News

interface NewsListViewModel  {

    val news : MutableLiveData<List<News>>
    val isLoading : MutableLiveData<Boolean>
    val symbol : String


    fun updateTicker(symbol: String)

    fun getNews()

    fun refresh()

    fun loadMore()
}