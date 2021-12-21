package com.example.market_news_application.core.navigation

import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManagerMock : NavigationManager {
    override var navigationState = MutableStateFlow(NavigationState())

    override fun navigateUrl(navigationRoute: String) {
    }

    override fun popBackStack() {
    }
}