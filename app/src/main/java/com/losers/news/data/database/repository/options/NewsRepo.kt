package com.losers.news.data.database.repository.options

import com.losers.news.data.network.News
import io.reactivex.Observable
import io.reactivex.Single


interface NewsRepo {

    fun isOptionsRepoEmpty(): Observable<Boolean>

    fun insertOptions(options: News): Observable<Boolean>

    fun loadOptions(questionId: Long): Single<List<News>>

    fun loadAll() : Observable<News>

}