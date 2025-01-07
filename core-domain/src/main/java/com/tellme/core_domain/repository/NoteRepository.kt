package com.tellme.core_domain.repository

import com.tellme.core_domain.Either
import com.tellme.core_domain.entity.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun saveNoteToLocal(note: Note)
    fun editNote(noteId: Int) // ?
    fun deleteNote(noteId: Int) // ?

    suspend fun getNote(noteId: Int): Either<Note>
    fun getNotesByMonth(month: Int): Flow<List<Note>>
}