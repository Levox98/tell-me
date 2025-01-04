package com.tellme.feature_main

import com.tellme.core_domain.repository.NoteRepository
import com.tellme.core_domain.usecase.GetNotesByMonthUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object MainDiModule {

    @Provides
    fun provideGetNotesByMonthUseCase(repository: NoteRepository): GetNotesByMonthUseCase {
        return GetNotesByMonthUseCase(repository)
    }
}