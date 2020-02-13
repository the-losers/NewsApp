package com.losers.news.ui.home.presenter

import com.losers.news.ui.base.presenter.MVPPresenter
import com.losers.news.ui.home.interactor.HomeMVPInteractor
import com.losers.news.ui.home.view.HomeMVPView


interface HomeMVPPresenter<V : HomeMVPView, I : HomeMVPInteractor> : MVPPresenter<V, I> {


    fun onGetNewsData()


}