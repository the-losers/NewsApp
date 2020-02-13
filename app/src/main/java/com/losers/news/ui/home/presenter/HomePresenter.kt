package com.losers.news.ui.home.presenter

import com.losers.news.data.network.News
import com.losers.news.ui.base.presenter.BasePresenter
import com.losers.news.ui.home.interactor.HomeMVPInteractor
import com.losers.news.ui.home.view.HomeMVPView
import com.losers.news.util.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomePresenter<V : HomeMVPView, I : HomeMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), HomeMVPPresenter<V, I> {
    override fun onGetNewsData() {

        if (!getView()?.isNetworkConnected()!!) {
            getOfflineData()
            return
        }
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(it.getNewsData()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({ response ->
                        getView()?.hideProgress()
                        updateDataInDatabase(response)
                        getView()?.newsResponse(response)

                    }, { err ->
                        getView()?.hideProgress()
                        getView()?.onError()
                        println(err.localizedMessage)
                    }))
        }
    }

    private fun getOfflineData() {
        interactor?.let {
            compositeDisposable.add(it.getNews()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({ response ->
                        getView()?.hideProgress()
                        getView()?.newsResponse(response)

                    }, { err ->
                        getView()?.hideProgress()
                        getView()?.onError()
                        println(err.localizedMessage)
                    }))
        }
    }

    private fun updateDataInDatabase(news: News) {
        interactor?.let {
            compositeDisposable.add(it.insertNews(news)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ response ->
                    }, { err ->

                        println(err.localizedMessage)
                    }))
        }
    }

}