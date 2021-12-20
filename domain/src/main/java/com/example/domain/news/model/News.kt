package com.example.domain.news.model

data class News(val category : String = "Not found",
                val datetime : Long = 0,
                val headline: String = "Not found",
                val id : Int = -1,
                val image: String = "Not found",
                val symbol: String = "Not found",
                val source: String = "Not found",
                val summary: String = "Not found",
                val url: String = "Not found")
