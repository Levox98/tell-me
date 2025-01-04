package com.tellme.feature_note

import com.tellme.core_domain.repository.NoteRepository
import com.tellme.core_domain.usecase.CreateNoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object NoteDiModule {

    @Singleton
    @Provides
    fun bindCreateNoteUseCase(repository: NoteRepository): CreateNoteUseCase {
        return CreateNoteUseCase(repository)
    }
}