package com.losers.news.data.database.repository.options

import com.losers.news.data.network.News
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject


class NewsRepository @Inject constructor(private val newsDao: NewsDao) : NewsRepo {
    override fun insertOptions(options: News): Observable<Boolean> {
        newsDao.insert(options)
        return Observable.just(true)
    }

    override fun isOptionsRepoEmpty(): Observable<Boolean> = Observable.just(newsDao.loadAll().id == null)


    override fun loadOptions(questionId: Long): Single<List<News>> = Single.fromCallable { newsDao.loadOptionsByQuestionId(questionId) }


    override fun loadAll(): Observable<News> = Observable.fromCallable { newsDao.loadAll() }

}