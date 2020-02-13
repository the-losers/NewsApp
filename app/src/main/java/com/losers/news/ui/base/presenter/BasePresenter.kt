package com.losers.news.ui.base.presenter

import io.reactivex.disposables.CompositeDisposable


abstract class BasePresenter<V : com.losers.news.ui.base.view.MVPView, I : com.losers.news.ui.base.interactor.MVPInteractor> internal constructor(protected var interactor: I?, protected val schedulerProvider: com.losers.news.util.SchedulerProvider, protected val compositeDisposable: CompositeDisposable) : com.losers.news.ui.base.presenter.MVPPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

}