package com.tellme.feature_main.vm

import androidx.lifecycle.viewModelScope
import com.tellme.core_domain.entity.Note
import com.tellme.core_domain.usecase.GetNotesByMonthUseCase
import com.tellme.core_ui.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class MainScreenViewState {
    data object Default : MainScreenViewState()
    data object Loading : MainScreenViewState()
    data class Content(
        val notes: List<Note>
    ) : MainScreenViewState()
}

sealed interface MainScreenIntent {
    data object CreateNewNoteIntent : MainScreenIntent
    data class OpenDayNotesIntent(val day: Int) : MainScreenIntent
}

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getNotesByMonthUseCase: GetNotesByMonthUseCase
) : BaseViewModel<MainScreenViewState, MainScreenIntent>(MainScreenViewState.Default) {

    // TODO: think on this one
    private val _monthlyNotes = MutableStateFlow<List<Note>>(emptyList())
    val monthlyNotes: StateFlow<List<Note>>
        get() = _monthlyNotes.asStateFlow()

    init {
        observeIntent()
    }

    private fun observeIntent() {
        viewModelScope.launch {
            currentIntent.collect { intent ->
                when (intent) {
                    is MainScreenIntent.CreateNewNoteIntent -> { onCreateNewNote() }
                    is MainScreenIntent.OpenDayNotesIntent -> { onOpenDayNotes() }
                    else -> {}
                }
            }
        }
    }

    private fun getMonthlyNotes() {
        // get current month
        // launch use case to get notes for current month
    }

    private fun onCreateNewNote() {

    }

    private fun onOpenDayNotes() {

    }
}