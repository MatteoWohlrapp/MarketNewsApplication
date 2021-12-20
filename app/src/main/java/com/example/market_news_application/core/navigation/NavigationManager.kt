package com.example.market_news_application.core.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.random.Random

class NavigationManager {
    var navigationState: MutableStateFlow<NavigationState> = MutableStateFlow(NavigationState())

    fun navigateUrl(directions: NavigationCommand) {
        navigationState.value = NavigationState(
            directions, false
        )
    }

    fun popBackStack(popBack: Boolean) {
        navigationState.value = NavigationState(null, true )
    }
}