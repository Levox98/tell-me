package com.tellme.feature_note

import com.tellme.core_domain.repository.NoteRepository
import com.tellme.core_domain.usecase.CreateNoteUseCase
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
    fun bindCreateNoteUseCase(repository: NoteRepository): CreateNoteUseCase {
        return CreateNoteUseCase(repository)
    }
}