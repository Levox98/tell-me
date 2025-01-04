package com.tellme.feature_note.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tellme.feature_note.vm.NewNoteScreenViewModel

@Composable
fun NewNoteScreen(
    vm: NewNoteScreenViewModel
) {
    Box(modifier = Modifier) {

        Column(
            modifier = Modifier.systemBarsPadding()
        ) {
            Text(modifier = Modifier, text = "new note")

            Icon(imageVector = Icons.Default.Home, contentDescription = null)
        }

    }
}