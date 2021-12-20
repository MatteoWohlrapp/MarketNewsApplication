package com.example.data.news.remote.model

import com.example.domain.news.model.News
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsRaw(
    @Json(name = "category")
    val category : String,
    @Json(name = "datetime")
    val datetime : Long,
    @Json(name = "headline")
    val headline: String,
    @Json(name = "id")
    val id : Int,
    @Json(name = "image")
    val image: String,
    @Json(name = "related")
    val related: String,
    @Json(name = "source")
    val source: String,
    @Json(name = "summary")
    val summary: String,
    @Json(name = "url")
    val url: String)

fun NewsRaw.mapToNews(symbol: String) = News(
    category, datetime*1000, headline, id, image, symbol, source, summary, url
)

fun List<NewsRaw>.mapToNews(symbol: String) = map { it.mapToNews(symbol) }