package com.example.market_news_application.news.viewmodel.listscreen

import androidx.lifecycle.MutableLiveData
import com.example.domain.news.model.News

class NewsListViewModelMock: NewsListViewModel {
    override val news: MutableLiveData<List<News>>
        get() = MutableLiveData(listOf())
    override val isLoading: MutableLiveData<Boolean>
        get() = MutableLiveData(false)
    override val symbol: String
        get() = "AAPL"

    override fun updateTicker(symbol: String) {
    }

    override fun getNews() {
    }

    override fun refresh() {
    }

    override fun loadMore() {
    }

}