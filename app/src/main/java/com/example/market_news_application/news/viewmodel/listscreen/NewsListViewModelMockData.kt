package com.example.market_news_application.news.viewmodel.listscreen

import com.example.domain.news.model.News
import kotlinx.coroutines.flow.MutableStateFlow

object NewsListViewModelMockData {

    private val news = mutableListOf(
        News(
            "",
            1638704608009,
            1.toString(),
            1,
            "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
            "AAPL",
            "Internet",
            "What a day.",
            ""
        ),
        News(
            "",
            1638704608009,
            2.toString(),
            2,
            "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
            "AAPL",
            "Internet",
            "What a day.",
            ""
        ),
        News(
            "",
            1638704608009,
            3.toString(),
            3,
            "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
            "AAPL",
            "Internet",
            "What a day.",
            ""
        ),
        News(
            "",
            1638704608009,
            4.toString(),
            4,
            "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
            "AAPL",
            "Internet",
            "What a day.",
            ""
        ),
        News(
            "",
            1638704608009,
            5.toString(),
            5,
            "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
            "AAPL",
            "Internet",
            "What a day.",
            ""
        ),
        News(
            "",
            1638704608009,
            6.toString(),
            6,
            "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
            "AAPL",
            "Internet",
            "What a day.",
            ""
        ),
        News(
            "",
            1638704608009,
            7.toString(),
            7,
            "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
            "AAPL",
            "Internet",
            "What a day.",
            ""
        ),
        News(
            "",
            1638704608009,
            8.toString(),
            8,
            "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
            "AAPL",
            "Internet",
            "What a day.",
            ""
        ),
        News(
            "",
            1638704608009,
            9.toString(),
            9,
            "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
            "AAPL",
            "Internet",
            "What a day.",
            ""
        ),
        News(
            "",
            1638704608009,
            10.toString(),
            10,
            "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
            "AAPL",
            "Internet",
            "What a day.",
            ""
        ),
    )

    private val currentNews = news
    private val currentNewsFlow = MutableStateFlow(news)
    private var backwardsCounter = -1
    private var forwardsCounter = 11


    fun getNews() = currentNewsFlow

    suspend fun loadMore() {
        val list = mutableListOf<News>()
        for(i in 1..10){
            list.add(News(
                "",
                1638704608009,
                forwardsCounter.toString(),
                10,
                "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
                "AAPL",
                "Internet",
                "What a day.",
                ""
            ))
            forwardsCounter++
        }
        currentNews.addAll(list)
        currentNewsFlow.emit(currentNews)
    }

    suspend fun refresh() {
        currentNews.add(0,
        News(
            "",
            1638704608009,
            backwardsCounter.toString(),
            26,
            "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
            "AAPL",
            "Internet",
            "What a day.",
            ""
        )
        )
        backwardsCounter--
        currentNewsFlow.emit(currentNews)
    }

}