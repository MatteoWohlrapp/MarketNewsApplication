package com.example.market_news_application.core.navigation

data class NavigationState(
    val navigationRoute: String = Screen.NewsList.route,
    val popBack: Boolean = false
)