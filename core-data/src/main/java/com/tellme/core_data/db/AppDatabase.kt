package com.tellme.core_data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tellme.core_data.entity.NoteDataEntity

@Database(
    entities = [NoteDataEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun notesDao(): NoteDao
}