package com.example.market_news_application

import com.example.data.news.remote.model.NewsRaw
import com.example.domain.news.model.News

object NewsDaoDataTestUtils {

    fun getAllRawNews() =
        listOf(
            NewsRaw(
                "",
                1638704608009,
                "",
                0,
                "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
                "AAPL",
                "Internet",
                "What a day.",
                ""
            ),
            NewsRaw(
                "",
                1638704608009,
                "",
                1,
                "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
                "AAPL",
                "Internet",
                "What a day.",
                ""
            ),
            NewsRaw(
                "",
                1638704608009,
                "",
                2,
                "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
                "AAPL",
                "Internet",
                "What a day.",
                ""
            ),
            NewsRaw(
                "",
                1638704608009,
                "",
                3,
                "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
                "V",
                "Internet",
                "What a day.",
                ""
            ),
            NewsRaw(
                "",
                1638704608009,
                "",
                4,
                "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
                "V",
                "Internet",
                "What a day.",
                ""
            )

        )

    fun getAAPLNews() =
        listOf(
            News(
                "",
                1638704608009,
                "",
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
                "",
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
                "",
                2,
                "https://play-lh.googleusercontent.com/aCyq5_tBBCKcD5f4yuiE3kaNc1HDbPLA7Tq7PoEqBk1RVODSqJQUYpB_ekCrW23qnhw",
                "AAPL",
                "Internet",
                "What a day.",
                ""
            )
        )

}