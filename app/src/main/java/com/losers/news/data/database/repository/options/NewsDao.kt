package com.losers.news.data.database.repository.options

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.losers.news.data.network.News


@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(options: List<News>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(options: News)

    @Query("SELECT * FROM news WHERE id = :id")
    fun loadOptionsByQuestionId(id: Long): List<News>

    @Query("SELECT * FROM news limit 1 ")
    fun loadAll(): News
}