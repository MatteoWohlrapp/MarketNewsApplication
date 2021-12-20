package com.example.market_news_application.news.viewmodel.listscreen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.news.model.News
import com.example.domain.news.usecases.LoadMoreNewsUseCase
import com.example.domain.news.usecases.ObserveNewsUseCase
import com.example.domain.news.usecases.RefreshNewsUseCase
import com.example.market_news_application.core.navigation.NavigationManager
import com.example.market_news_application.news.viewmodel.ViewModelUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

abstract class NewsListViewModel  : ViewModel() {
    val news = MutableLiveData<List<News>>(listOf())
    val isLoading = MutableLiveData(false)
    val symbol = "AAPL"
    abstract val navigationManager : NavigationManager


    open fun updateTicker(symbol: String) {}

    open fun getNews() {}

    open fun refresh() {}

    open fun loadMore() {}
}