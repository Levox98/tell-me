package com.tellme.feature_main.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tellme.core_domain.entity.Note
import com.tellme.feature_main.vm.MainScreenIntent
import com.tellme.feature_main.vm.MainScreenViewModel
import com.tellme.feature_main.vm.MainScreenViewState

@Composable
fun MainScreen(
    vm: MainScreenViewModel,
    onNavigateToDayNotes: () -> Unit
) {
    val state = vm.state.collectAsState()

    MainScreenRoot(state, onNavigateToDayNotes, vm::setIntent)
}

@Composable
private fun MainScreenRoot(
    currentState: State<MainScreenViewState>,
    onNavigateToDayNotes: () -> Unit,
    submitIntent: (MainScreenIntent) -> Unit,
) {
    when (currentState.value) {
        is MainScreenViewState.Loading -> {}
        is MainScreenViewState.Content -> {
            val state = currentState.value as MainScreenViewState.Content
            MainScreenContent(state.notes)
        }

        MainScreenViewState.Default -> {}
    }
}

@Composable
private fun MainScreenContent(
    notes: List<Note>
) {
    LazyColumn {
        itemsIndexed(
            items = notes,
            key = { _, item -> item.id }
        ) { index, item ->

            Row {
                Column {
                    Text(item.title)
                    Text(item.text)
                }

                if (index != notes.lastIndex) Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}