package com.example.market_news_application.news.viewmodel.componentscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.news.model.News
import com.example.domain.news.usecases.GetNewsByIdUseCase
import com.example.market_news_application.news.viewmodel.ViewModelUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsComponentViewModelImpl @Inject constructor(
    private val getNewsByIdUseCase: GetNewsByIdUseCase
) : NewsComponentViewModel() {


    override fun getNews(id: Int) {
        ViewModelUtil.suspendFunction(viewModelScope) {
            isLoading.postValue(true)
            news.postValue(getNewsByIdUseCase.invoke(id))
            isLoading.postValue(false)
        }
    }

    override fun clearNews() {
        news.postValue(News())
    }
}