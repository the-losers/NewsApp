package com.losers.news.di.builder

import com.losers.news.ui.home.HomeActivityModule
import com.losers.news.ui.home.view.HomeActivity
import com.losers.news.ui.homeDetails.HomeDetailsModule
import com.losers.news.ui.homeDetails.view.HomeDetailsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(HomeActivityModule::class)])
    abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [(HomeDetailsModule::class)])
    abstract fun bindHomeDetailsActivity(): HomeDetailsActivity


}