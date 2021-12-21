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

interface NewsComponentViewModel {

    val news : MutableLiveData<News>
    val isLoading : MutableLiveData<Boolean>

    fun getNews(id: Int)

     fun clearNews()
}