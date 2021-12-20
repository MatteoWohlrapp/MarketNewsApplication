package com.example.market_news_application.core.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

const val ID_ARGUMENT_KEY = "id"

sealed class NavigationRoute(val route: String, val navArguments: List<NamedNavArgument>){

    object NewsList : NavigationRoute(route = "news/list", navArguments = listOf())

    object NewsComponent : NavigationRoute(route = "news/{$ID_ARGUMENT_KEY}", navArguments = listOf(
        navArgument("id") { type = NavType.StringType })){
        fun passId(id: String) : String {
            return this.route.replace(oldValue = "{$ID_ARGUMENT_KEY}", newValue = "$id")
        }
    }

}
