package com.tellme.core_data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.tellme.core_data.type_converter.DateTypeConverter
import java.util.Date

@Entity(tableName = "user_notes")
@TypeConverters(DateTypeConverter::class)
data class NoteDataEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "date")
    val date: Date, // TODO: change to separate fields for day, month, year and time

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "text")
    val text: String,
)
