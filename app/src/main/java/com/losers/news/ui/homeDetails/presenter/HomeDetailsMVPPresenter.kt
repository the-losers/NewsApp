package com.losers.news.ui.homeDetails.presenter

import com.losers.news.ui.base.presenter.MVPPresenter
import com.losers.news.ui.homeDetails.interactor.HomeDetailsMVPInteractor
import com.losers.news.ui.homeDetails.view.HomeDetailsMVPView


interface HomeDetailsMVPPresenter<V : HomeDetailsMVPView, I : HomeDetailsMVPInteractor> : MVPPresenter<V, I> {

}