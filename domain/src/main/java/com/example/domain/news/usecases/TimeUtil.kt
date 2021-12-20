package com.example.domain.news.usecases

object TimeUtil {
    fun oneDayEarlier(datetime: Long) = datetime - 86400000

    fun oneWeekEarlier(datetime: Long) = datetime - 604800000

    fun oneMonthEarlier(datetime: Long) = datetime - 2592000000
}