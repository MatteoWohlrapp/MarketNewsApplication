package com.example.market_news_application.core.injection

import com.example.market_news_application.core.database.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DaoModule {
    @Provides
    fun provideNewsDao(db: NewsDatabase) = db.newsDao()
}