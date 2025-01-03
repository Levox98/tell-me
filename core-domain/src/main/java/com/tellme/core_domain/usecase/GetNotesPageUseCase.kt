package com.tellme.core_domain.usecase

import com.tellme.core_domain.repository.NoteRepository

class GetNotesPageUseCase(private val repository: NoteRepository) {
    operator fun invoke(page: Int) = repository.getNotesPage(page)
}