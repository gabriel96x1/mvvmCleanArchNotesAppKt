package com.another.mvvmcleanarchnotesappkt.feature_note.presentation.notes

import androidx.lifecycle.ViewModel
import com.another.mvvmcleanarchnotesappkt.feature_note.domain.use_cases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteUseCase : NoteUseCases
) : ViewModel(){



}