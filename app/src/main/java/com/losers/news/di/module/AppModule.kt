package com.losers.news.di.module

import android.app.Application
import androidx.room.Room
import android.content.Context
import com.losers.news.BuildConfig
import com.losers.news.data.network.ApiHeader
import com.losers.news.data.network.ApiHelper
import com.losers.news.data.network.AppApiHelper
import com.losers.news.data.preferences.AppPreferenceHelper
import com.losers.news.data.preferences.PreferenceHelper
import com.losers.news.util.AppConstants.APP_DB_NAME
import com.losers.news.util.AppConstants.PREF_NAME

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): com.losers.news.data.database.AppDatabase =
            Room.databaseBuilder(context, com.losers.news.data.database.AppDatabase::class.java, APP_DB_NAME).allowMainThreadQueries().build()

    @Provides
    @com.losers.news.di.ApiKeyInfo
    internal fun provideApiKey(): String = BuildConfig.API_KEY

    @Provides
    @com.losers.news.di.PreferenceInfo
    internal fun provideprefFileName(): String = PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper



    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper


    @Provides
    @Singleton
    internal fun provideNewRepoHelper(appDatabase: com.losers.news.data.database.AppDatabase): com.losers.news.data.database.repository.options.NewsRepo = com.losers.news.data.database.repository.options.NewsRepository(appDatabase.newsDao())

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): com.losers.news.util.SchedulerProvider = com.losers.news.util.SchedulerProvider()


}