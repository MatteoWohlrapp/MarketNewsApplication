package com.example.market_news_application.core.navigation

import androidx.navigation.NamedNavArgument

sealed class NavigationUrl(val route: String, val arguments : List<NamedNavArgument>){

    object NewsList : NavigationUrl(route = "news/list", emptyList())

    object NewsComponent : NavigationUrl(route = "news/{id}", emptyList())
}
