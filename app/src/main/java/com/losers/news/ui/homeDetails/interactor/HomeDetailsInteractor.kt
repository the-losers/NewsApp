package com.losers.news.ui.homeDetails.interactor

import com.losers.news.data.network.ApiHelper
import com.losers.news.data.preferences.PreferenceHelper
import com.losers.news.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class HomeDetailsInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), HomeDetailsMVPInteractor {

}