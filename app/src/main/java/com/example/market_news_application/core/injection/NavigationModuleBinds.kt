package com.example.market_news_application.core.injection

import androidx.navigation.compose.rememberNavController
import com.example.market_news_application.core.navigation.NavigationManager
import com.example.market_news_application.core.navigation.NavigationManagerImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface NavigationModuleBinds {
    @Binds
    fun bindNavigationManager(navigationManagerImpl: NavigationManagerImpl) : NavigationManager
}