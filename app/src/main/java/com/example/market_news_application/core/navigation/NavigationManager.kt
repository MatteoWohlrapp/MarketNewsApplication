package com.example.market_news_application.core.navigation

import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManager {
    var navigationState: MutableStateFlow<NavigationState> = MutableStateFlow(NavigationState())

    fun navigateUrl(navigationRoute: String) {
        navigationState.value = NavigationState(
            navigationRoute, false
        )
    }

    fun popBackStack() {
        navigationState.value = NavigationState("", true )
    }
}