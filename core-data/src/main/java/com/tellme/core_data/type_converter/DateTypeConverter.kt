package com.tellme.core_data.type_converter

import androidx.room.TypeConverter
import java.util.Date

object DateTypeConverter {

    @TypeConverter
    fun fromTimestamp(timestamp: Long): Date {
        return Date(timestamp)
    }

    @TypeConverter
    fun dateToTimeStamp(date: Date): Long {
        return date.time
    }
}