package com.example.market_news_application.core.navigation

data class NavigationState(
    val navigationCommand: NavigationCommand? = NavigationCommandFactory.provideToNewsListNavigation(),
    val popBack: Boolean = false
)