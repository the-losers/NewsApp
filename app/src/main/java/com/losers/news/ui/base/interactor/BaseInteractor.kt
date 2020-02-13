package com.losers.news.ui.base.interactor

import com.losers.news.data.network.ApiHelper
import com.losers.news.data.preferences.PreferenceHelper


open class BaseInteractor() : MVPInteractor {
    override fun isOfflineDataPresent(): Boolean {
        return false
    }

    protected lateinit var preferenceHelper: PreferenceHelper
    protected lateinit var apiHelper: ApiHelper

    constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : this() {
        this.preferenceHelper = preferenceHelper
        this.apiHelper = apiHelper
    }


}