package com.project.smonkey.domain.smonkey.utils

class Time(
    val time: Int
) {

    fun getDay(): Int {
        return time / 86400
    }

    fun getHour(day: Int): Int {
        return ((time - (day * 86400)) / 3600)
    }

    fun getMinute(day: Int, hour: Int): Int {
        return ((time - (day * 86400) - (hour * 3600)) / 60)
    }

    fun getSecond(day: Int, hour: Int, minute: Int): Int {
        return ((time - (day * 86400) - (hour * 3600) - (minute) * 60))
    }

}
