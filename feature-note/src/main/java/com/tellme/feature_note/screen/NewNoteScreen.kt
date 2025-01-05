package com.tellme.feature_note.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tellme.core_ui.theme.TellMeTheme
import com.tellme.core_utils.getDayOfMonth
import com.tellme.core_utils.getDayOfWeek
import com.tellme.core_utils.getMonthOfYear
import com.tellme.feature_note.vm.NewNoteScreenIntent
import com.tellme.feature_note.vm.NewNoteScreenViewModel
import com.tellme.feature_note.vm.NewNoteScreenViewState
import java.util.Date

@Composable
fun NewNoteScreen(
    vm: NewNoteScreenViewModel
) {
    NewNoteScreenRoot(vmState = vm.state.collectAsState(), submitIntent = vm::setIntent)
}

@Composable
fun NewNoteScreenRoot(
    vmState: State<NewNoteScreenViewState>,
    submitIntent: (NewNoteScreenIntent) -> Unit
) {
    val resources = LocalContext.current.resources

    when (vmState.value) {
        is NewNoteScreenViewState.Content -> {
            val state = vmState.value as NewNoteScreenViewState.Content
            NewNoteScreenContent(
                topDateString = "${resources.getDayOfMonth(state.date)} ${
                    resources.getMonthOfYear(
                        state.date
                    )
                }",
                bottomDateString = resources.getDayOfWeek(state.date),
                submitIntent = submitIntent
            )
        }

        NewNoteScreenViewState.Default -> {}
        NewNoteScreenViewState.Loading -> {}
    }
}

@Composable
private fun NewNoteScreenContent(
    topDateString: String,
    bottomDateString: String,
    submitIntent: (NewNoteScreenIntent) -> Unit
) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }

                Column {
                    Text(
                        text = topDateString,
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        fontSize = 14.sp
                    )
                    Text(
                        text = bottomDateString,
                        style = TextStyle(fontWeight = FontWeight.Thin),
                        fontSize = 14.sp
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
                    shape = RoundedCornerShape(24.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = TextFieldValue(""),
                    onValueChange = {

                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    minLines = 10,
                    maxLines = 10,
                    placeholder = {
                        Text("content")
                    },
                    shape = RoundedCornerShape(24.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                    )
                )

                Spacer(modifier = Modifier
                    .height(48.dp)
                    .weight(1f))

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .imePadding()
                        .padding(bottom = 16.dp)
                ) {
                    Text("click", modifier = Modifier.padding(16.dp), fontSize = 18.sp)
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
            mutableStateOf(
                NewNoteScreenViewState.Content(
                    date = Date(),
                    title = "Test",
                    text = "Lorem Ipsum and so on..."
                )
            )
        }

        NewNoteScreenRoot(state) {}
    }
}