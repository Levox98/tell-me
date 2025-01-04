package com.tellme.feature_note.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tellme.feature_note.vm.NewNoteScreenViewModel

@Composable
fun NewNoteScreen(
    vm: NewNoteScreenViewModel
) {
    Box(modifier = Modifier) {

        Text(modifier = Modifier.offset(y = 100.dp), text = "new note")
    }
}