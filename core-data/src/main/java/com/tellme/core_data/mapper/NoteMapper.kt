package com.tellme.core_data.mapper

import com.tellme.core_data.entity.NoteDataEntity
import com.tellme.core_domain.entity.Note
import javax.inject.Singleton

@Singleton
class NoteMapper {

    fun mapToDb(note: Note) =
        NoteDataEntity(
            date = note.date,
            title = note.title,
            text = note.text
        )

    fun mapToDb(notes: List<Note>) = notes.map { mapToDb(it) }

    fun mapToDomain(noteDataEntity: NoteDataEntity) =
        Note(
            id = noteDataEntity.id,
            date = noteDataEntity.date,
            title = noteDataEntity.title,
            text = noteDataEntity.text
        )

    fun mapToDomain(noteDataEntities: List<NoteDataEntity>) =
        noteDataEntities.map { mapToDomain(it) }
}