package com.losers.news.data.preferences

import android.content.Context
import javax.inject.Inject


class AppPreferenceHelper @Inject constructor(context: Context,
                                              @com.losers.news.di.PreferenceInfo private val prefFileName: String) : PreferenceHelper {


}