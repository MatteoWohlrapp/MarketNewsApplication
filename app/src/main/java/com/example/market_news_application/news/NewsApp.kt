package com.example.market_news_application.news

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.market_news_application.core.navigation.NavigationGraph


@Composable
fun NewsApp(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Market News") })
        }) {
        NavigationGraph(navController = navController)
    }
}






