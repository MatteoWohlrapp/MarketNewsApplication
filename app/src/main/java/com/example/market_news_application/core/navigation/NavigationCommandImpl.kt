package com.example.market_news_application.core.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

object NavigationCommandImpl {

    val toNewsComponentNavigation = object : NavigationCommand {
        override val arguments: List<NamedNavArgument>
            get() = listOf(navArgument("id") { type = NavType.StringType })
        override val destination: String
            get() = "news/{id}"

        override fun destinationWithArguments(argument: String) = object : NavigationCommand {
            override val arguments: List<NamedNavArgument>
                get() = this.arguments
            override val destination: String
                get() = "news/$argument"

            override fun destinationWithArguments(argument: String) = this
        }
    }

    val toNewsListNavigation = object : NavigationCommand {
        override val arguments: List<NamedNavArgument>
            get() = emptyList()
        override val destination: String
            get() = "news/list"

        override fun destinationWithArguments(argument: String) = this
    }
}