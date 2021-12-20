package com.example.market_news_application.core.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.market_news_application.news.viewmodel.componentscreen.NewsComponentViewModelImpl
import com.example.market_news_application.news.viewmodel.listscreen.NewsListViewModelImpl
import com.example.market_news_application.ui.screens.NewsComponentScreen
import com.example.market_news_application.ui.screens.NewsListScreen


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.NewsList.route
    ) {
        composable(NavigationRoute.NewsList.route) {
            val newsListViewModel: NewsListViewModelImpl = hiltViewModel()
            newsListViewModel.getNews()
            NewsListScreen(newsListViewModel).show()
        }
        composable(
            NavigationRoute.NewsComponent.route,
            arguments = NavigationRoute.NewsComponent.navArguments
        ) {
            val newsComponentViewModel: NewsComponentViewModelImpl = hiltViewModel()
            val id =
                it.arguments?.getString(NavigationRoute.NewsComponent.navArguments[0].name)
            if (id != null)
                NewsComponentScreen(Integer.valueOf(id), newsComponentViewModel).show()
        }
    }
}