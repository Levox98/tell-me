package com.tellme

import kotlinx.serialization.Serializable

sealed class NavDestination {
    @Serializable
    data object Onboarding : NavDestination()

    @Serializable
    data object MainRoot : NavDestination()

    @Serializable
    data object MainScreen : NavDestination()

    @Serializable
    data object NewNoteScreen : NavDestination()

    @Serializable
    data class NoteDetailsScreen(val noteId: Int) : NavDestination()

    @Serializable
    data class NotesForDayScreen(val day: Int) : NavDestination()
}