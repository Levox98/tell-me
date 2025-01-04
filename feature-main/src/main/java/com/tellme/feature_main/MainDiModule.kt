package com.tellme.feature_main

import com.tellme.core_domain.repository.NoteRepository
import com.tellme.core_domain.usecase.GetNotesByMonthUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
abstract class MainDiModule {

    @Singleton
    @Provides
    abstract fun provideGetNotesByMonthUseCase(repository: NoteRepository): GetNotesByMonthUseCase
}