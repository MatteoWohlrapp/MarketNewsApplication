package com.example.data.core.injection

import com.example.data.news.NewsRepositoryImpl
import com.example.domain.news.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
interface DataModuleBinds {

    @Binds
    fun bindNewsRepository(newsRepositoryImpl: NewsRepositoryImpl) : NewsRepository
}