package com.example.market_news_application.core.injection

import androidx.navigation.compose.rememberNavController
import com.example.market_news_application.core.navigation.NavigationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NavigationModule {

    @Provides
    @Singleton
    fun provideNavigationManager() = NavigationManager()
}