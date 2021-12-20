package com.example.data.core.injection

import com.example.data.news.remote.NewsService
import com.example.data.news.remote.NewsServiceFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideNewsService() : NewsService {
        return NewsServiceFactory.makeNewsService()
    }
}