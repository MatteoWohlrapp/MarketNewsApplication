package com.example.market_news_application.core.navigation

import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManagerImpl : NavigationManager {
    override var navigationState: MutableStateFlow<NavigationState> = MutableStateFlow(NavigationState())

    override fun navigateUrl(navigationRoute: String) {
        navigationState.value = NavigationState(
            navigationRoute, false
        )
    }

    override fun popBackStack() {
        navigationState.value = NavigationState("", true )
    }
}