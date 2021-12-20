package com.example.market_news_application.core.navigation

data class NavigationState(
    val navigationCommand: NavigationCommand? = NavigationCommandImpl.toNewsListNavigation,
    val popBack: Boolean = false
)