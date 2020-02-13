package com.losers.news.util

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import com.losers.news.R
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit


class Misc {
    companion object {
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

//        fun convertTimestampToMinute(timestamp: String) : Int{
//            val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//            // you can change format of date
//            val date = formatter.parse(timestamp)
//            val now = System.currentTimeMillis()
//            val then = date.time
//
//            return TimeUnit.MILLISECONDS.toMinutes(now - then)
//        }
    }

}