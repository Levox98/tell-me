package com.tellme.feature_note.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    NewNoteScreenRoot(vmState = vm.state.collectAsState(), submitAction = vm::submitAction)
}

@Composable
fun NewNoteScreenRoot(
    vmState: State<NewNoteScreenViewState>,
    submitAction: (NewNoteScreenAction) -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(top = 16.dp)
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(innerPadding)
        ) {

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

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun NewNoteScreenPreview() {
    TellMeTheme {
        val state = remember {
            mutableStateOf(NewNoteScreenViewState.Default)
        }

        NewNoteScreenRoot(state) {}
    }
}