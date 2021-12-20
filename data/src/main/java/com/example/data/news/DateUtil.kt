package com.example.data.news

import android.os.Build
import androidx.annotation.RequiresApi

object DateUtil {

    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    fun mapTimestampToDate(timestamp: Long) : String{
        return android.text.format.DateFormat.format("yyyy-MM-dd", timestamp).toString()
    }
}