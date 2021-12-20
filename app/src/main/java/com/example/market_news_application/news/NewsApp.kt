package com.example.market_news_application.news

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.domain.news.model.News
import com.example.market_news_application.core.navigation.SetupNavGraph
import com.example.market_news_application.news.viewmodel.componentscreen.NewsComponentViewModel
import com.example.market_news_application.ui.screens.NewsListScreen
import com.example.market_news_application.news.viewmodel.listscreen.NewsListViewModel
import com.example.market_news_application.ui.screens.NewsComponentScreen


@Composable
fun NewsApp() {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Market News") })
        }) {
        //val navController = rememberNavController()


        /**NavHost(navController = navController, startDestination = "NewsList") {
            composable("NewsList") {

                NewsListScreen(
                    onNewsComponentClick = { news: News ->
                        navController.navigate("NewsComponent/${news.id}")
                    }
                )
            }
            composable(
                "NewsComponent/{id}",
                arguments = listOf(navArgument("id") { type = NavType.StringType })
            ) { navBackStackEntry ->
                val newsComponentViewModel: NewsComponentViewModel = hiltViewModel()
                val id = navBackStackEntry.arguments?.getString("id")
                if (id != null)
                    NewsComponentScreen(
                        id = Integer.valueOf(id),
                        onBackClick = {navController.popBackStack()}
                    )
            }
        } **/

    }
}

@Preview
@Composable
fun newsList(){

}





