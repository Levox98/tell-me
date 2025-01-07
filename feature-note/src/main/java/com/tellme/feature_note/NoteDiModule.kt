package com.tellme.feature_note

import com.tellme.core_domain.repository.NoteRepository
import com.tellme.core_domain.usecase.SaveNoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteDiModule {

    @Singleton
    @Provides
    fun bindSaveNoteUseCase(repository: NoteRepository): SaveNoteUseCase {
        return SaveNoteUseCase(repository)
    }
}