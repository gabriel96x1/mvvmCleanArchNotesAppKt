package com.another.mvvmcleanarchnotesappkt.feature_note.data.repository

import com.another.mvvmcleanarchnotesappkt.feature_note.data.data_source.NotesDao
import com.another.mvvmcleanarchnotesappkt.feature_note.domain.model.Note
import com.another.mvvmcleanarchnotesappkt.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NotesRepositoryImpl(
    private val dao : NotesDao
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNotebyId(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}