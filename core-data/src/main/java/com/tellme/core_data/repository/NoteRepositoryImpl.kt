package com.tellme.core_data.repository

import com.tellme.core_data.db.NoteDao
import com.tellme.core_data.mapper.NoteMapper
import com.tellme.core_domain.Either
import com.tellme.core_domain.entity.Note
import com.tellme.core_domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao,
    private val noteMapper: NoteMapper
) : NoteRepository {

    override fun createNote(note: Note) {
        val noteEntity = noteMapper.mapToDb(note)
        noteDao.addNote(noteEntity)
    }

    override fun editNote(noteId: Int) {
        TODO("Not yet implemented")
    }

    override fun deleteNote(noteId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun getNote(noteId: Int): Either<Note> {
        val noteEntity = noteDao.getNoteById(noteId)
        val note = noteMapper.mapToDomain(noteEntity)

        return Either.Success(note)
    }

    override fun getNotesByMonth(month: Int): Flow<List<Note>> =
        // TODO: create logic for getting the notes for a given month
        noteDao.getNotes().map { noteMapper.mapToDomain(it) }
}