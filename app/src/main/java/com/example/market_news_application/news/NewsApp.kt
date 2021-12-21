package com.example.market_news_application.news

import androidx.compose.material.*
import androidx.compose.runtime.*
import com.example.market_news_application.core.navigation.NavigationGraph
import com.example.market_news_application.ui.theme.MarketNewsApplicationTheme


@Composable
fun NewsApp() {
    MarketNewsApplicationTheme {
        Surface(color = MaterialTheme.colors.background) {
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text(text = "Market News") })
                }) {
                NavigationGraph()
            }
        }
    }
}






