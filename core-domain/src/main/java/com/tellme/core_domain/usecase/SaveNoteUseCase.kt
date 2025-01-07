package com.tellme.core_domain.usecase

import com.tellme.core_domain.entity.Note
import com.tellme.core_domain.repository.NoteRepository


class SaveNoteUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) = repository.saveNoteToLocal(note)
}