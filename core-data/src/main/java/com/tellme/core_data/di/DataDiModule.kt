package com.tellme.core_data.di

import android.content.Context
import androidx.room.Room
import com.tellme.core_data.db.AppDatabase
import com.tellme.core_data.db.NoteDao
import com.tellme.core_data.repository.NoteRepositoryImpl
import com.tellme.core_domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataDiModule {

    @Singleton
    @Provides
    fun provideAppDb(@ApplicationContext context: Context): AppDatabase {
        val db = Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
            .build()

        return db
    }

    /* DAOs */

    @Singleton
    @Provides
    fun provideNoteDao(db: AppDatabase): NoteDao = db.notesDao()

    /* Repositories */

    @Singleton
    @Provides
    fun provideNoteRepository(impl: NoteRepositoryImpl): NoteRepository = impl
}