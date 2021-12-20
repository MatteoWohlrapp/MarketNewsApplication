package com.example.market_news_application

import com.example.domain.news.model.News

object NewUseCaseDataTestUtils {

    fun getAllAppleNews() =
        listOf(
            News(
                "",
                1638704608009,
                "Car Manufacturer, Cloud",
                0,
                "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
                "AAPL",
                "Internet",
                "What a day.",
                ""
            ),
            News(
                "",
                1638704608009,
                "Cloud, Machine Learning",
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
                "Machine Learning, Cloud",
                2,
                "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
                "AAPL",
                "Internet",
                "What a day.",
                ""
            )
        )

    // filtered by keyword Cloud and Machine Learning
    fun getFilteredAppleNews() =
        listOf(
            News(
                "",
                1638704608009,
                "Cloud, Machine Learning",
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
                "Machine Learning, Cloud",
                2,
                "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
                "AAPL",
                "Internet",
                "What a day.",
                ""
            )
        )
}