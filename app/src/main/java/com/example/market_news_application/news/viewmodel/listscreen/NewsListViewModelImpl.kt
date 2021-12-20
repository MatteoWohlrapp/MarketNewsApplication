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

@HiltViewModel
class NewsListViewModelImpl @Inject constructor(
    private val observeNewsUseCase: ObserveNewsUseCase,
    private val refreshNewsUseCase: RefreshNewsUseCase,
    private val loadMoreNewsUseCase: LoadMoreNewsUseCase,
    override val navigationManager: NavigationManager
) : NewsListViewModel, ViewModel() {

    override val news = MutableLiveData<List<News>>(listOf())
    override val isLoading = MutableLiveData(false)
    override val symbol = "AAPL"

    override fun updateTicker(symbol: String) {
        ViewModelUtil.suspendFunction(viewModelScope) {
            observeNewsUseCase.updateSymbol(symbol)
            refresh()
        }
    }

    override fun getNews() {
        ViewModelUtil.suspendFunction(viewModelScope) {
            observeNewsUseCase.invoke().collect {
                isLoading.postValue(false)
                news.postValue(it)
            }
        }
    }

    override fun refresh() {
        ViewModelUtil.suspendFunction(viewModelScope) {
            isLoading.postValue(true)
            refreshNewsUseCase.invoke(symbol)
        }
    }

    override fun loadMore() {
        ViewModelUtil.suspendFunction(viewModelScope) {
            isLoading.postValue(true)
            loadMoreNewsUseCase.invoke(symbol)
        }
    }
}