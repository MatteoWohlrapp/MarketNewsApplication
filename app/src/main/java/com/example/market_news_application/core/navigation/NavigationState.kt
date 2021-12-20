package com.example.market_news_application.core.navigation

data class NavigationState(
    val navigationRoute: String = NavigationRoute.NewsList.route,
    val popBack: Boolean = false
)