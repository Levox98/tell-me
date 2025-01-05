package com.tellme.core_utils

import android.content.res.Resources
import java.util.Calendar
import java.util.Date

fun Resources.getDayOfMonth(date: Date): String {
    val cal = date.asCalendar()
    return cal.get(Calendar.DAY_OF_MONTH).toString()
}

fun Resources.getMonthOfYear(date: Date, needToChangeEnd: Boolean = true): String {
    val cal = date.asCalendar()
    val month = cal.get(Calendar.MONTH)

    val result = when (month) {
        Calendar.JANUARY -> this.getString(R.string.january)
        Calendar.FEBRUARY -> this.getString(R.string.february)
        Calendar.MARCH -> this.getString(R.string.march)
        Calendar.APRIL -> this.getString(R.string.april)
        Calendar.MAY -> this.getString(R.string.may)
        Calendar.JUNE -> this.getString(R.string.june)
        Calendar.JULY -> this.getString(R.string.july)
        Calendar.AUGUST -> this.getString(R.string.august)
        Calendar.SEPTEMBER -> this.getString(R.string.september)
        Calendar.OCTOBER -> this.getString(R.string.october)
        Calendar.NOVEMBER -> this.getString(R.string.november)
        Calendar.DECEMBER -> this.getString(R.string.december)
        else -> ""
    }

    return if (needToChangeEnd) result.dropLast(1) + 'я' else result
}

fun Resources.getDayOfWeek(date: Date): String {
    val cal = date.asCalendar()
    val dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)

    return when (dayOfWeek) {
        Calendar.MONDAY -> this.getString(R.string.monday)
        Calendar.TUESDAY -> this.getString(R.string.tuesday)
        Calendar.WEDNESDAY -> this.getString(R.string.wednesday)
        Calendar.THURSDAY -> this.getString(R.string.thursday)
        Calendar.FRIDAY -> this.getString(R.string.friday)
        Calendar.SATURDAY -> this.getString(R.string.saturday)
        Calendar.SUNDAY -> this.getString(R.string.sunday)
        else -> ""
    }
}

private fun Date.asCalendar(): Calendar {
    val cal = Calendar.getInstance()
    cal.time = this

    return cal
}