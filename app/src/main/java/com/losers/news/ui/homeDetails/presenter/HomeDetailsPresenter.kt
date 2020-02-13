package com.losers.news.ui.homeDetails.presenter

import com.losers.news.ui.base.presenter.BasePresenter
import com.losers.news.ui.homeDetails.interactor.HomeDetailsMVPInteractor
import com.losers.news.ui.homeDetails.view.HomeDetailsMVPView
import com.losers.news.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeDetailsPresenter<V : HomeDetailsMVPView, I : HomeDetailsMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), HomeDetailsMVPPresenter<V, I> {


}