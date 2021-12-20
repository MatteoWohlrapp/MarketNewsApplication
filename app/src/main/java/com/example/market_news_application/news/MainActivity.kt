package com.example.market_news_application.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.market_news_application.core.navigation.NavigationManager
import com.example.market_news_application.core.navigation.NavigationGraph
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
            // observing the navigation state
            navigationManager.navigationState.collectAsState().value.also { navigationState ->
                // needed, because it always collects the first one which is always null
                try {
                    if (navigationState.popBack)
                        navController.popBackStack()
                    else {
                        if (navigationState.navigationCommand != null)
                            navController.navigate(navigationState.navigationCommand.destination)
                    }
                } catch (e: NullPointerException) {
                    println(e.message)
                }
            }


            MarketNewsApplicationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NewsApp(navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
}