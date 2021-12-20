package com.example.market_news_application.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.news.cache.NewsDao
import com.example.data.news.cache.model.NewsLocal


@Database(entities = [NewsLocal::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao() : NewsDao
}