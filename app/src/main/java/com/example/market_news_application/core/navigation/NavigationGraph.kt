package com.example.market_news_application.core.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.market_news_application.news.viewmodel.componentscreen.NewsComponentViewModel
import com.example.market_news_application.news.viewmodel.listscreen.NewsListViewModel
import com.example.market_news_application.ui.screens.NewsComponentScreen
import com.example.market_news_application.ui.screens.NewsListScreen


@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationCommandFactory.provideToNewsListNavigation().destination
    ) {
        composable(NavigationCommandFactory.provideToNewsListNavigation().destination) {
            val newsListViewModel: NewsListViewModel = hiltViewModel()
            newsListViewModel.getNews()
            NewsListScreen(newsListViewModel).show()
        }
        composable(
            NavigationCommandFactory.provideToNewsComponentNavigation("{id}").destination,
            arguments = NavigationCommandFactory.provideToNewsComponentNavigation("{id}").arguments
        ) {
            val newsComponentViewModel: NewsComponentViewModel = hiltViewModel()
            val id = it.arguments?.getString(NavigationCommandFactory.provideToNewsComponentNavigation("{id}").arguments[0].name)
            if (id != null)
                NewsComponentScreen(newsComponentViewModel).show(id = Integer.valueOf(id))

        }
    }
}