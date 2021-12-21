package com.example.market_news_application.news

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.market_news_application.core.navigation.NavigationGraph
import com.example.market_news_application.core.navigation.NavigationManager
import com.example.market_news_application.ui.theme.MarketNewsApplicationTheme


@Composable
fun NewsApp(navController: NavHostController, navigationManager: NavigationManager) {
    MarketNewsApplicationTheme {
        Surface(color = MaterialTheme.colors.background) {
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text(text = "Market News") })
                }) {
                NavigationGraph(
                    navController = navController,
                    navigationManager = navigationManager
                )
            }
        }
    }
}






