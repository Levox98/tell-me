package com.tellme.core_ui.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

open class BaseViewModel<T, I>(
    initState: T
) : ViewModel() {

    private val _state = MutableStateFlow(initState)
    val state: StateFlow<T>
        get() = _state.asStateFlow()

    private val _currentIntent = MutableStateFlow<I?>(null)
    val currentIntent: StateFlow<I?>
        get() = _currentIntent.asStateFlow()

    fun setIntent(newIntent: I) {
        _currentIntent.value = newIntent
    }
}