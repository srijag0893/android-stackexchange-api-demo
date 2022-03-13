package com.example.stachexcahangeapidemo.model.util

import java.text.SimpleDateFormat
import java.util.*

class DateTimeUtil {
    companion object {
        fun getDateTimeString(timeStamp:Int):String {
            var ts = timeStamp*1000L
            val currentDate = Date(ts)
            val dateFormat = SimpleDateFormat("YYYY-MM-dd HH:mm:ss")
            return dateFormat.format(currentDate)
        }
    }
}