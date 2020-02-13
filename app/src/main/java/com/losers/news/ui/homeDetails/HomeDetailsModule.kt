package com.losers.news.ui.homeDetails

import com.losers.news.ui.homeDetails.interactor.HomeDetailsInteractor
import com.losers.news.ui.homeDetails.interactor.HomeDetailsMVPInteractor
import com.losers.news.ui.homeDetails.presenter.HomeDetailsMVPPresenter
import com.losers.news.ui.homeDetails.presenter.HomeDetailsPresenter
import com.losers.news.ui.homeDetails.view.HomeDetailsMVPView
import dagger.Module
import dagger.Provides


@Module
class HomeDetailsModule {

    @Provides
    internal fun provideHomeDetailsInteractor(interactor: HomeDetailsInteractor): HomeDetailsMVPInteractor = interactor

    @Provides
    internal fun provideHomeDetailsPresenter(presenter: HomeDetailsPresenter<HomeDetailsMVPView, HomeDetailsMVPInteractor>)
            : HomeDetailsMVPPresenter<HomeDetailsMVPView, HomeDetailsMVPInteractor> = presenter


}