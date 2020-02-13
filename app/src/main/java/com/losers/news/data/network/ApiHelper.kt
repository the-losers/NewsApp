package com.losers.news.data.network

import io.reactivex.Observable


interface ApiHelper {


    fun getNewsApiCall(): Observable<News>




}