package com.example.market_news_application.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.data.news.DateUtil
import com.example.domain.news.model.News
import com.example.market_news_application.core.navigation.NavigationCommandFactory
import com.example.market_news_application.core.ui.CircularIndeterminateProgressBar
import com.example.market_news_application.news.viewmodel.listscreen.NewsListViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class NewsListScreen(private val newsListViewModel: NewsListViewModel) {
    @Composable
    fun show() {

        val scrollState = rememberLazyListState()
        val scope = rememberCoroutineScope()
        val showScrollToTopButton = scrollState.firstVisibleItemIndex > 0

        Scaffold(
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                // button to scroll to the top
                ScrollToTopButton(
                    showButton = showScrollToTopButton,
                    scope = scope,
                    scrollState = scrollState
                )
            }) {
            Column {
                // search bar
                SearchBar(newsListViewModel)

                // list of news
                NewsList(
                    scrollState = scrollState,
                    newsListViewModel = newsListViewModel,
                )
            }

            // progress bar
            NewsListProgressBar(newsListViewModel)
        }

    }

    @Composable
    fun ScrollToTopButton(showButton: Boolean, scope: CoroutineScope, scrollState: LazyListState) {
        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            FloatingActionButton(
                onClick = { scope.launch { scrollState.animateScrollToItem(0) } },
                backgroundColor = Color.White,
                contentColor = Color.Black,
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Filled.ExpandLess,
                    contentDescription = "Scroll up"
                )
            }
        }
    }

    @Composable
    fun SearchBar(newsListViewModel: NewsListViewModel) {

        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colors.primary,
            elevation = 8.dp
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                var searchFieldText by rememberSaveable { mutableStateOf("AAPL") }
                val keyboardController = LocalFocusManager.current

                TextField(
                    modifier = Modifier
                        .fillMaxWidth(.9f)
                        .padding(8.dp),
                    value = searchFieldText,
                    onValueChange = { searchFieldText = it },
                    label = { Text("Search ticker") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search icon"
                        )
                    },
                    textStyle = TextStyle(color = Color.Black),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController.clearFocus()
                            newsListViewModel.updateTicker(searchFieldText)
                        }
                    )
                )
            }
        }
    }

    @Composable
    fun NewsList(
        scrollState: LazyListState,
        newsListViewModel: NewsListViewModel,
    ) {
        val news: List<News> by newsListViewModel.news.observeAsState(initial = listOf())

        SwipeRefresh(
            state = rememberSwipeRefreshState(false),
            onRefresh = { newsListViewModel.refresh() },
            indicator = { _, _ -> }) {


            LazyColumn(
                contentPadding = PaddingValues(bottom = 80.dp),
                state = scrollState,
                modifier = Modifier.fillMaxSize()
            ) {
                items(
                    items = news,
                    itemContent = {
                        NewsComponent(news = it)
                    })
            }

            // act when end of list reached
            LaunchedEffect(ViewUtil.isScrolledToEnd(scrollState)) {
                newsListViewModel.loadMore()
            }
        }
    }

    @Composable
    fun NewsComponent(news: News) {
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth()
                .clickable {
                    newsListViewModel.navigationManager.navigate(NavigationCommandFactory.provideToNewsComponentNavigation(news.id.toString()))
                },
            elevation = 2.dp,
            backgroundColor = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(16.dp))

        ) {
            Row {
                NewsListImage(url = news.image)
                Column(
                    modifier = Modifier
                        .padding(32.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                ) {
                    Text(text = news.headline, style = MaterialTheme.typography.h6)
                    Text(
                        text = DateUtil.mapTimestampToDate(news.datetime),
                        style = MaterialTheme.typography.subtitle1
                    )

                }
            }
        }
    }

    @Composable
    fun NewsListImage(url: String) {
        Image(
            painter = rememberImagePainter(url),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(120.dp)
                .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
        )
    }

    @Composable
    fun NewsListProgressBar(newsListViewModel: NewsListViewModel) {
        val loadingIndicator = newsListViewModel.isLoading.observeAsState(initial = false)
        CircularIndeterminateProgressBar(isLoading = loadingIndicator.value)
    }

}

@Preview(showBackground = true)
@Composable
fun NewsPreview() {
}