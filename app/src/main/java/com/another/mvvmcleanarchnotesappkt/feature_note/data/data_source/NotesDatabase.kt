package com.another.mvvmcleanarchnotesappkt.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.another.mvvmcleanarchnotesappkt.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NotesDatabase : RoomDatabase(){

    abstract val notesDao : NotesDao

    companion object{
        const val DB_NAME = "notes.db"
    }

}