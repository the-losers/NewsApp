package com.losers.news.util

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import com.losers.news.R

class Misc {
    companion object{
          fun isOnline(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            if (netInfo != null && netInfo.isConnectedOrConnecting) {
                return true
            } else {
                Toast.makeText(context, R.string.no_internet_connection, Toast.LENGTH_SHORT).show()
                return false
            }
        }
    }

}