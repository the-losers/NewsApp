package com.losers.news.ui.base.view

interface MVPView {

    fun showProgress()

    fun hideProgress()

    fun onError()

    fun isNetworkConnected(): Boolean
}