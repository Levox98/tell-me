package com.tellme.core_domain.usecase

import com.tellme.core_domain.repository.NoteRepository

class GetNotesByMonthUseCase(private val repository: NoteRepository) {
    operator fun invoke(month: Int) = repository.getNotesByMonth(month)
}