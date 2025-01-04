package com.tellme.feature_note.vm

import com.tellme.core_ui.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

sealed interface NewNoteScreenViewState {
    data object Default : NewNoteScreenViewState
}

sealed interface NewNoteScreenIntent {

}

sealed interface NewNoteScreenAction {
    data class SetTitle(val title: String) : NewNoteScreenAction
    data class SetText(val text: String) : NewNoteScreenAction
}

@HiltViewModel
class NewNoteScreenViewModel @Inject constructor(

) : BaseViewModel<NewNoteScreenViewState.Default, NewNoteScreenIntent>(NewNoteScreenViewState.Default) {


}