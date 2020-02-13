package com.losers.news.ui.base.presenter

interface MVPPresenter<V : com.losers.news.ui.base.view.MVPView, I : com.losers.news.ui.base.interactor.MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}