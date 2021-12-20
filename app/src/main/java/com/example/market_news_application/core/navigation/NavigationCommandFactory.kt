package com.example.market_news_application.core.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

object NavigationCommandFactory {

    fun provideToNewsListNavigation() = object : NavigationCommand {
        override val arguments: List<NamedNavArgument>
            get() = emptyList()
        override val destination: String
            get() = "news/list"
    }

    fun provideToNewsComponentNavigation(id : String) = object : NavigationCommand {
        override val arguments: List<NamedNavArgument>
            get() = listOf(navArgument("id"){type = NavType.StringType})
        override val destination: String
            get() = "news/$id"
    }
}