package com.example.market_news_application.news

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.market_news_application.core.navigation.NavigationManager
import com.example.market_news_application.core.navigation.SetupNavGraph
import com.example.market_news_application.ui.theme.MarketNewsApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import java.lang.NullPointerException
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val navController = rememberNavController()
            navigationManager.commands.collectAsState().value.also { navigationCommand ->
                Log.d("Navigation", "command changed")

                if (navigationCommand.destination.isNotEmpty())
                    try {
                        navController.navigate(navigationCommand.destination)
                    } catch(e: NullPointerException){
                        println(e.message)
                        Log.d("Navigation", "Nullpointer with: ${navigationCommand.destination}")
                    }
            }

            MarketNewsApplicationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    //NewsApp()
                    Scaffold(
                        topBar = {
                            TopAppBar(title = { Text(text = "Market News") })
                        }) {
                        SetupNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
}