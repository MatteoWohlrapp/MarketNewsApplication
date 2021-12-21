package com.example.market_news_application.news.viewmodel.listscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.news.model.News
import com.example.market_news_application.core.navigation.NavigationManager
import com.example.market_news_application.news.viewmodel.ViewModelUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        news.postValue(NewsListViewModelMockData.getNews().value)
    }

    override fun refresh() {
    }

    override fun loadMore() {
    }

}