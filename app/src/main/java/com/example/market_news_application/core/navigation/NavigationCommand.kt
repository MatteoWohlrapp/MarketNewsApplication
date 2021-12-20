package com.example.market_news_application.core.navigation

import androidx.navigation.NamedNavArgument

interface NavigationCommand {
    val arguments: List<NamedNavArgument>

    val destination: String

    fun destinationWithArguments(argument: String): NavigationCommand
}