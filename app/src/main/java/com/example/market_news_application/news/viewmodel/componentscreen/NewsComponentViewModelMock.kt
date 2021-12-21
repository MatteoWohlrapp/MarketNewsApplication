package com.example.market_news_application.news.viewmodel.componentscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.news.model.News
import com.example.domain.news.usecases.GetNewsByIdUseCase
import com.example.market_news_application.core.navigation.NavigationManager
import com.example.market_news_application.news.viewmodel.ViewModelUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class NewsComponentViewModelMock : NewsComponentViewModel {

    override val news = MutableLiveData(News())
    override val isLoading = MutableLiveData(false)


    override fun getNews(id: Int) {
    }

    override fun clearNews() {
    }
}