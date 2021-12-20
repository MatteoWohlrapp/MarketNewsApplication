package com.example.market_news_application.core.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.random.Random

class NavigationManager() {
     var commands : MutableStateFlow<NavigationCommand> = MutableStateFlow(NavigationCommandFactory.provideToNewsListNavigation())


    fun navigate(directions: NavigationCommand){

        commands.value = directions
    }
}