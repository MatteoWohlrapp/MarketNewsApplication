package com.example.market_news_application.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.domain.news.model.News
import com.example.market_news_application.R
import com.example.market_news_application.core.navigation.NavigationCommandFactory
import com.example.market_news_application.core.ui.CircularIndeterminateProgressBar
import com.example.market_news_application.news.viewmodel.componentscreen.NewsComponentViewModel


@Composable
fun NewsComponentScreen(
    id: Int,
    newsComponentViewModel: NewsComponentViewModel
) {
    val news: News by newsComponentViewModel.news.observeAsState(initial = News())
    newsComponentViewModel.getNews(id)

    Column {
        NewsComponentImage(url = news.image)
        Text(
            news.headline,
            Modifier.padding(16.dp),
            style = MaterialTheme.typography.h6
        )
        Text(
            news.summary,
            Modifier.padding(16.dp),
            style = MaterialTheme.typography.body1
        )
    }
    // button to return
    BackButton(newsComponentViewModel)
    // progress bar
    NewsComponentProgressBar(newsComponentViewModel)
}


@Composable
fun NewsComponentImage(url: String) {
    if(url != "") {
        Image(
            painter = rememberImagePainter(url),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
        )
    } else {
        Image(
            painter = painterResource(id = R.drawable.breaking_news),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(8.dp)
                .size(120.dp)
                .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
        )
    }
}

@Composable
fun BackButton(newsComponentViewModel: NewsComponentViewModel) {

    FloatingActionButton(
        onClick = {
            newsComponentViewModel.navigationManager.popBackStack(true)
        },
        backgroundColor = Color.White,
        contentColor = Color.Black,
        shape = CircleShape,
        modifier = Modifier.padding(8.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Go Back"
        )
    }

}

@Composable
fun NewsComponentProgressBar(newsComponentViewModel: NewsComponentViewModel) {
    val loadingIndicator = newsComponentViewModel.isLoading.observeAsState(initial = false)
    CircularIndeterminateProgressBar(isLoading = loadingIndicator.value)
}

