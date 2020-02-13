package com.losers.news.ui.home.interactor

import com.losers.news.data.network.News
import com.losers.news.ui.base.interactor.MVPInteractor
import io.reactivex.Observable
import io.reactivex.Single

interface HomeMVPInteractor : MVPInteractor {

    fun getNewsData(): Observable<News>
    fun getNews(): Observable<News>

    fun insertNews(news: News): Observable<Boolean>
}