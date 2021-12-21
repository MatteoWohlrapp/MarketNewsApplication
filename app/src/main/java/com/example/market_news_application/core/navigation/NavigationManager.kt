package com.example.market_news_application.core.navigation

import kotlinx.coroutines.flow.MutableStateFlow

interface NavigationManager {
    var navigationState: MutableStateFlow<NavigationState>

    fun navigateUrl(navigationRoute: String)

    fun popBackStack()
}