package com.example.market_news_application.core.navigation

import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManager {
    var navigationState: MutableStateFlow<NavigationState> = MutableStateFlow(NavigationState())

    fun navigateUrl(navigationCommand: NavigationCommand) {
        navigationState.value = NavigationState(
            navigationCommand, false
        )
    }

    fun popBackStack(popBack: Boolean) {
        navigationState.value = NavigationState(null, popBack )
    }
}