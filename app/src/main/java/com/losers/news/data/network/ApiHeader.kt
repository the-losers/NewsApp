package com.losers.news.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.inject.Inject


class ApiHeader @Inject constructor(internal val publicApiHeader:PublicApiHeader) {

    class PublicApiHeader @Inject constructor(@com.losers.news.di.ApiKeyInfo
                                              @Expose
                                              @SerializedName
                                              ("api_key") val apiKey: String)


}