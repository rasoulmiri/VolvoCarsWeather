package com.volvocars.weather.base.utils.date

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateConvertorUtils {
    companion object {

        @SuppressLint("SimpleDateFormat")
        fun convertStringToCalendar(time: String, format: String): Calendar? {
            return try {
                val calendar: Calendar = Calendar.getInstance()
                val dateFormat = SimpleDateFormat(format)
                dateFormat.parse(time)?.let {
                    calendar.time
                    calendar
                } ?: kotlin.run {
                    null
                }
            } catch (e: ParseException) {
                null
            }
        }
    }
}