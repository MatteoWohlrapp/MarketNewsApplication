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
        get() = TODO("Not yet implemented")
    override val isLoading: MutableLiveData<Boolean>
        get() = TODO("Not yet implemented")
    override val symbol: String
        get() = TODO("Not yet implemented")
    override val navigationManager: NavigationManager
        get() = TODO("Not yet implemented")

}