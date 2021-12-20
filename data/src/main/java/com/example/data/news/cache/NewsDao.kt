package com.example.data.news.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.news.cache.model.NewsLocal
import kotlinx.coroutines.flow.Flow

@Dao
abstract class NewsDao {
    @Query("SELECT * FROM newslocal WHERE symbol = :symbol ORDER BY datetime DESC")
    abstract fun getNewsFlow(symbol: String): Flow<List<NewsLocal>>

    @Query("SELECT * FROM newslocal WHERE id = :id")
    abstract fun getNewsById(id: Int): NewsLocal

    @Query("SELECT * FROM newslocal n1 WHERE symbol = :symbol AND NOT EXISTS(SELECT * FROM newslocal n2 WHERE n2.datetime < n1.datetime AND n2.symbol = n1.symbol)")
    abstract suspend fun requestOldestNews(symbol : String): NewsLocal?

    @Query("SELECT * FROM newslocal n1 WHERE symbol = :symbol AND NOT EXISTS(SELECT * FROM newslocal n2 WHERE n2.datetime > n1.datetime AND n2.symbol = n1.symbol)")
    abstract suspend fun requestNewestNews(symbol : String): NewsLocal?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(news: List<NewsLocal>)

}