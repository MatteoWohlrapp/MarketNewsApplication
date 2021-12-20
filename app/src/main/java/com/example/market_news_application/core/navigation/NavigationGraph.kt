package com.example.market_news_application.core.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.market_news_application.news.viewmodel.componentscreen.NewsComponentViewModel
import com.example.market_news_application.news.viewmodel.componentscreen.NewsComponentViewModelImpl
import com.example.market_news_application.news.viewmodel.listscreen.NewsListViewModel
import com.example.market_news_application.news.viewmodel.listscreen.NewsListViewModelImpl
import com.example.market_news_application.ui.screens.NewsComponentScreen
import com.example.market_news_application.ui.screens.NewsListScreen


@Composable
fun NavigationGraph(navController: NavHostController) {
    // TODO: make use of factory in different way -> redundant calls
    NavHost(
        navController = navController,
        startDestination = NavigationCommandFactory.provideToNewsListNavigation().destination
    ) {
        composable(NavigationCommandFactory.provideToNewsListNavigation().destination) {
            val newsListViewModel: NewsListViewModelImpl = hiltViewModel()
            newsListViewModel.getNews()
            NewsListScreen(newsListViewModel)
        }
        composable(
            NavigationCommandFactory.provideToNewsComponentNavigation("{id}").destination,
            arguments = NavigationCommandFactory.provideToNewsComponentNavigation("{id}").arguments
        ) {
            val newsComponentViewModel: NewsComponentViewModelImpl = hiltViewModel()
            val id =
                it.arguments?.getString(NavigationCommandFactory.provideToNewsComponentNavigation("{id}").arguments[0].name)
            if (id != null)
                NewsComponentScreen(Integer.valueOf(id), newsComponentViewModel)
        }
    }
}