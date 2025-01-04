package com.tellme.core_ui.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

open class BaseViewModel<T>(
    initState: T
) : ViewModel() {

    private val _state = MutableStateFlow(initState)
    val state: StateFlow<T>
        get() = _state.asStateFlow()
}