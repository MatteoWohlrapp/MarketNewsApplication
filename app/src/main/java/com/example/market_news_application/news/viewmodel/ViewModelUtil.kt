package com.example.market_news_application.news.viewmodel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object ViewModelUtil {
    fun suspendFunction(viewModelScope : CoroutineScope, function : suspend () -> Unit){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                function.invoke()
            }
        }
    }
}