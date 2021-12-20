package com.example.data.news.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.news.remote.model.NewsRaw
import com.example.domain.news.model.News

@Entity
data class NewsLocal(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "category")
    val category : String,
    @ColumnInfo(name = "datetime")
    val datetime : Long,
    @ColumnInfo(name = "headline")
    val headline: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "symbol")
    val symbol: String,
    @ColumnInfo(name = "source")
    val source: String,
    @ColumnInfo(name = "summary")
    val summary: String,
    @ColumnInfo(name = "url")
    val url: String
)

fun NewsLocal.mapToNews() = News(category, datetime, headline, id, image,
    symbol, source, summary, url)

fun List<NewsLocal>.mapToNews() = map { it.mapToNews() }

fun News.mapToNewsLocal() = NewsLocal(id, category, datetime, headline, image, symbol, source, summary, url)

fun NewsRaw.mapToNewsLocal() = NewsLocal(id, category, datetime*1000, headline, image, related, source, summary, url)

fun List<NewsRaw>.mapToNewsLocal() = map {it.mapToNewsLocal() }
