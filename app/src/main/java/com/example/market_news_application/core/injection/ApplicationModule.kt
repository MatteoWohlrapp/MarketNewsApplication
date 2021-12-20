package com.example.market_news_application.core.injection

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.data.core.injection.DataModule
import com.example.market_news_application.core.database.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module(includes = [DataModule::class])
object ApplicationModule {

    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): NewsDatabase {
        return Room.databaseBuilder(appContext,
            NewsDatabase::class.java,
            "news.db").build()
    }

}