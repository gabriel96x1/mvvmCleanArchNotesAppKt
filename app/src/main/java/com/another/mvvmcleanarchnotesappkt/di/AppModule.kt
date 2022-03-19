package com.another.mvvmcleanarchnotesappkt.di

import android.app.Application
import androidx.room.Room
import com.another.mvvmcleanarchnotesappkt.feature_note.data.data_source.NotesDao
import com.another.mvvmcleanarchnotesappkt.feature_note.data.data_source.NotesDatabase
import com.another.mvvmcleanarchnotesappkt.feature_note.data.repository.NotesRepositoryImpl
import com.another.mvvmcleanarchnotesappkt.feature_note.domain.repository.NoteRepository
import com.another.mvvmcleanarchnotesappkt.feature_note.domain.use_cases.DeleteNoteUseCase
import com.another.mvvmcleanarchnotesappkt.feature_note.domain.use_cases.GetNotesUseCase
import com.another.mvvmcleanarchnotesappkt.feature_note.domain.use_cases.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NotesDatabase {
        return Room.databaseBuilder(
            app,
            NotesDatabase::class.java,
            NotesDatabase.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNotesRepository(db: NotesDatabase) : NoteRepository {
        return NotesRepositoryImpl(db.notesDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases{
        return NoteUseCases(
            getNotesUseCase =  GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository)
        )
    }
}