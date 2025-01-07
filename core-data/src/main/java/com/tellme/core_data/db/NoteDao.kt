package com.tellme.core_data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tellme.core_data.entity.NoteDataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(noteEntity: NoteDataEntity)

    @Query("SELECT * FROM user_notes WHERE id = :noteId")
    suspend fun getNoteById(noteId: Int): NoteDataEntity

    @Query("SELECT * FROM user_notes")
    fun getNotes(): Flow<List<NoteDataEntity>>
}