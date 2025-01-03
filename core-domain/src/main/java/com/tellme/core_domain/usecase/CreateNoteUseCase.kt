package com.tellme.core_domain.usecase

import com.tellme.core_domain.entity.Note
import com.tellme.core_domain.repository.NoteRepository


class CreateNoteUseCase(private val repository: NoteRepository) {
    operator fun invoke(note: Note) = repository.createNote(note)
}