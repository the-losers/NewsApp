package com.losers.news.ui.home


import androidx.recyclerview.widget.LinearLayoutManager
import com.losers.news.ui.Article.view.HomeAdapter
import com.losers.news.ui.home.interactor.HomeInteractor
import com.losers.news.ui.home.interactor.HomeMVPInteractor
import com.losers.news.ui.home.presenter.HomeMVPPresenter
import com.losers.news.ui.home.presenter.HomePresenter
import com.losers.news.ui.home.view.HomeActivity
import com.losers.news.ui.home.view.HomeMVPView
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {

    @Provides
    internal fun provideHomeInteractor(interactor: HomeInteractor): HomeMVPInteractor = interactor

    @Provides
    internal fun provideHomePresenter(presenter: HomePresenter<HomeMVPView, HomeMVPInteractor>)
            : HomeMVPPresenter<HomeMVPView, HomeMVPInteractor> = presenter


    @Provides
    internal fun provideHomeAdapter(): HomeAdapter = HomeAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(activity: HomeActivity): LinearLayoutManager = LinearLayoutManager(activity)

}