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
fun NavigationGraph() {

    val appState = rememberNewsAppState()

    NavHost(
        navController = appState.navController,
        startDestination = Screen.NewsList.route
    ) {
        composable(Screen.NewsList.route) { backStack ->
            val newsListViewModel: NewsListViewModelImpl = hiltViewModel()
            newsListViewModel.getNews()
            NewsListScreen(newsListViewModel,
                onNewsComponentClick = { id ->
                    appState.navigateToNewsComponent(id, backStack)
                })
        }
        composable(
            Screen.NewsComponent.route,
            arguments = Screen.NewsComponent.navArguments
        ) {
            val newsComponentViewModel: NewsComponentViewModelImpl = hiltViewModel()
            val id =
                it.arguments?.getString(Screen.NewsComponent.navArguments[0].name)
            if (id != null)
                NewsComponentScreen(
                    Integer.valueOf(id),
                    newsComponentViewModel,
                    onBackPressed = { appState.navigateBack() })
        }
    }
}