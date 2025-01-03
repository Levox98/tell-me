package com.tellme.core_domain.usecase

import com.tellme.core_domain.repository.NoteRepository

class GetNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(noteId: Int) = repository.getNote(noteId)
}