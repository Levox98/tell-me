package com.tellme.feature_note.vm

import androidx.lifecycle.viewModelScope
import com.tellme.core_ui.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

sealed interface NewNoteScreenViewState {
    data object Default : NewNoteScreenViewState
    data object Loading : NewNoteScreenViewState
    data class Content(
        val date: Date,
        val title: String,
        val text: String
    ) : NewNoteScreenViewState
}

sealed interface NewNoteScreenIntent {
    data class SetTitle(val title: String) : NewNoteScreenIntent
    data class SetText(val text: String) : NewNoteScreenIntent
}

@HiltViewModel
class NewNoteScreenViewModel @Inject constructor(

) : BaseViewModel<NewNoteScreenViewState.Default, NewNoteScreenIntent>(NewNoteScreenViewState.Default) {

    init {
        observeIntent()
    }

    private fun observeIntent() {
        viewModelScope.launch {
            currentIntent.collect { intent ->
                when (intent) {
                    is NewNoteScreenIntent.SetText -> {}
                    is NewNoteScreenIntent.SetTitle -> {}
                    null -> {}
                }
            }
        }
    }
}