package com.losers.news.data.network

import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import javax.inject.Inject


class AppApiHelper @Inject constructor(private val apiHeader: ApiHeader) : ApiHelper {


    override fun getNewsApiCall(): Observable<News> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_NEWS)
                    .build()
                    .getObjectObservable(News::class.java)


}