package com.example.market_news_application.news.viewmodel.listscreen

import androidx.lifecycle.MutableLiveData
import com.example.domain.news.model.News
import com.example.market_news_application.core.navigation.NavigationManager

interface NewsListViewModel  {

    val news : MutableLiveData<List<News>>
    val isLoading : MutableLiveData<Boolean>
    val symbol : String
    val navigationManager: NavigationManager


    fun updateTicker(symbol: String)

    fun getNews()

    fun refresh()

    fun loadMore()
}