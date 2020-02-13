package com.losers.news.ui.home.interactor

import com.losers.news.data.database.repository.options.NewsRepo
import com.losers.news.data.network.ApiHelper
import com.losers.news.data.network.News
import com.losers.news.data.preferences.PreferenceHelper
import com.losers.news.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, private val newsRepo: NewsRepo, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), HomeMVPInteractor {

    override fun insertNews(news: News): Observable<Boolean> {

        return newsRepo.isOptionsRepoEmpty().concatMap { isEmpty ->
            if (isEmpty) {
                newsRepo.insertOptions(news)
            } else
                Observable.just(false)
        }
    }

    override fun getNews(): Observable<News> {
        return newsRepo.loadAll()
    }

    override fun getNewsData(): Observable<News> {
        return apiHelper.getNewsApiCall()
    }

}