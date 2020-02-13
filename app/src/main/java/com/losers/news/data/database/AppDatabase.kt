package com.losers.news.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.losers.news.data.database.repository.options.NewsConverter

import com.losers.news.data.database.repository.options.NewsDao
import com.losers.news.data.network.News


@Database(entities = [(News::class)], version = 1)
@TypeConverters(NewsConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao


}