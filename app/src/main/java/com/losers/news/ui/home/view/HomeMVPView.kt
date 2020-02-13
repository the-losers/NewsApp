package com.losers.news.ui.home.view


import com.losers.news.data.network.News
import com.losers.news.ui.base.view.MVPView

public interface HomeMVPView : MVPView {

    fun showValidationMessage(errorCode: Int)
    fun newsResponse(news: News)
}