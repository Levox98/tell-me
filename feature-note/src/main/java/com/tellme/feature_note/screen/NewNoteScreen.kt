package com.tellme.feature_note.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tellme.core_ui.theme.TellMeTheme
import com.tellme.feature_note.vm.NewNoteScreenAction
import com.tellme.feature_note.vm.NewNoteScreenViewModel
import com.tellme.feature_note.vm.NewNoteScreenViewState

@Composable
fun NewNoteScreen(
    vm: NewNoteScreenViewModel
) {
    // TODO: NewNoteScreenRoot
}

@Composable
fun NewNoteScreenRoot(
    vmState: NewNoteScreenViewState,
    submitAction: (NewNoteScreenAction) -> Unit
) {
    Surface(
        modifier = Modifier,
    ) {
        Box(modifier = Modifier.padding(horizontal = 16.dp)) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = TextFieldValue(""),
                    onValueChange = {

                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = {
                        Text("title")
                    },
                    shape = RoundedCornerShape(16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = TextFieldValue(""),
                    onValueChange = {

                    },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    minLines = 10,
                    maxLines = 10,
                    placeholder = {
                        Text("content")
                    },
                    shape = RoundedCornerShape(16.dp)
                )

                Spacer(modifier = Modifier.height(48.dp))

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text("click")
                }
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NewNoteScreenPreview() {
    TellMeTheme {
        NewNoteScreenRoot(NewNoteScreenViewState.Default) {}
    }
}