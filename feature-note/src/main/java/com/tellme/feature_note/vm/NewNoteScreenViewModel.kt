package com.tellme.feature_note.vm

import androidx.lifecycle.viewModelScope
import com.tellme.core_domain.entity.Note
import com.tellme.core_domain.usecase.SaveNoteUseCase
import com.tellme.core_ui.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

sealed interface NewNoteScreenViewState {
    data object Default : NewNoteScreenViewState
    data object Loading : NewNoteScreenViewState
    data class Content(
        val date: Date = Date(),
        val title: String = "",
        val text: String = ""
    ) : NewNoteScreenViewState
}

sealed interface NewNoteScreenIntent {
    data class SetTitle(val title: String) : NewNoteScreenIntent
    data class SetText(val text: String) : NewNoteScreenIntent
    data object SaveNote : NewNoteScreenIntent
}

@HiltViewModel
class NewNoteScreenViewModel @Inject constructor(
    private val saveNoteUseCase: SaveNoteUseCase
) : BaseViewModel<NewNoteScreenViewState, NewNoteScreenIntent>(NewNoteScreenViewState.Content(Date(), "", "")) {

    private val _title = MutableStateFlow("")
    private val _text = MutableStateFlow("")

    init {
        observeIntent()
        observeData()
    }

    private fun observeIntent() {
        viewModelScope.launch {
            currentIntent.collect { intent ->
                when (intent) {
                    is NewNoteScreenIntent.SetTitle -> {
                        _title.value = intent.title
                    }
                    is NewNoteScreenIntent.SetText -> {
                        _text.value = intent.text
                    }
                    is NewNoteScreenIntent.SaveNote -> {
                        val note = getNoteFromState()
                        saveNoteUseCase(note)
                    }
                    null -> {}
                }
            }
        }
    }

    private fun observeData() {
        viewModelScope.launch {
            _title.collect { titleValue ->
                val initValue: NewNoteScreenViewState.Content = if (state.value is NewNoteScreenViewState.Content)
                    state.value as NewNoteScreenViewState.Content
                else
                    NewNoteScreenViewState.Content()

                updateState(initValue.copy(title = titleValue))
            }
        }

        viewModelScope.launch {
            _text.collect { textValue ->
                val initValue: NewNoteScreenViewState.Content = if (state.value is NewNoteScreenViewState.Content)
                    state.value as NewNoteScreenViewState.Content
                else
                    NewNoteScreenViewState.Content()

                updateState(initValue.copy(text = textValue))
            }
        }
    }

    private fun getNoteFromState(): Note {
        val state = if (state.value is NewNoteScreenViewState.Content)
            state.value as NewNoteScreenViewState.Content
        else
            throw Exception("current state is not \"Content\"")

        return Note(
            date = state.date,
            title = state.title,
            text = state.text
        )
    }
}